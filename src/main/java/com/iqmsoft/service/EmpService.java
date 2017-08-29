package com.iqmsoft.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.iqmsoft.dao.EmpDao;
import com.iqmsoft.dto.Emp;
import com.iqmsoft.dto.EmpDept;


@Dependent
public class EmpService {
    @Inject
    private EmpDao empDao;

    public List<Emp> getEmpList() throws SQLException {
        List<Emp> emps = empDao.find();
        return emps;
    }
    public List<EmpDept> getEmpDeptList() throws SQLException {
        List<EmpDept> emps = empDao.findWithDname();
        return emps;
    }
    public List<Map<String, Object>> getEmpDeptListByMap() throws SQLException {
        List<Map<String, Object>> emps = new ArrayList<>();

    
        empDao.findWithDnameByMap().stream().forEach((row) -> {
            Map<String, Object> newRow = new LinkedHashMap<>();
            newRow.put("empno", row.get("ID"));
            newRow.put("ename", row.get("ENAME"));
            newRow.put("hiredate", row.get("HIREDATE"));
            newRow.put("deptno",row.get("DEPTNO"));
            newRow.put("dname",row.get("DNAME"));
            emps.add(newRow);
        });
        return emps;

    }

    public Emp create(Emp emp) throws SQLException {

        return empDao.create(emp);
    }

}
