package com.iqmsoft.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.session.SqlSession;

import com.iqmsoft.dto.Emp;
import com.iqmsoft.dto.EmpDept;



@Dependent
public class EmpDao {
    @Inject
    private SqlSession session;
    
    public List<Emp> find() throws SQLException{
        return session.getMapper(EmpMapper.class).select();
    }

    public List<EmpDept> findWithDname() throws SQLException{
        return session.getMapper(EmpMapper.class).selectWithDept();
    }
   
    public List<Map> findWithDnameByMap() throws SQLException{
        return session.getMapper(EmpMapper.class).selectWithDeptByMap();
    }

    public Emp create(Emp emp) throws SQLException {
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        mapper.create(emp);
        session.commit();
        Emp newEmp = mapper.get(emp.getEmpno());
        return newEmp;
    }

    public static interface EmpMapper {
        
        @Results(id="empResult", value = {
            @Result(property = "empno", column = "id", id=true),
        })
        @Select("SELECT * FROM emp ORDER BY id")
        List<Emp> select();

        @SelectKey(statement = "CALL IDENTITY()", keyProperty = "empno", before=false, resultType = int.class)
        @Insert("INSERT INTO emp(ename, hiredate, deptno) VALUES(#{ename}, #{hiredate}, #{deptno})")
        int create(Emp emp);

        @ResultMap("empResult") //reference to "method select @Results"
        @Select("SELECT * FROM emp WHERE id = #{empno} ORDER BY id")
        Emp get(int empno);

      
        @Results({
            @Result(property = "empno", column = "id", id=true),
        })
        @Select("SELECT e.*, d.dname FROM EMP e LEFT JOIN dept d ON e.deptno = d.id ORDER BY e.id")
        List<EmpDept> selectWithDept();


        @Select("SELECT e.*, d.dname FROM EMP e LEFT JOIN dept d ON e.deptno = d.id ORDER BY e.id")
        List<Map> selectWithDeptByMap();
    }

    
}
