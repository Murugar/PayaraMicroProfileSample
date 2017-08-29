package com.iqmsoft.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.iqmsoft.jaxrs.LocalDateDeserializer;
import com.iqmsoft.jaxrs.LocalDateSerializer;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpDept{
    private int empno;
    private String ename;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate hiredate;
    private Integer deptno;
    private String dname;

}
