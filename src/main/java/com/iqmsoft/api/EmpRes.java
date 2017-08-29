package com.iqmsoft.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iqmsoft.dto.Emp;
import com.iqmsoft.service.EmpService;

import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("emps")
@RequestScoped
public class EmpRes{

    @Inject
    private EmpService empService;

    @Inject
    private ObjectMapper mapper;
	
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ObjectNode find() throws SQLException{
        return mapper.createObjectNode()
                .putPOJO("emps", empService.getEmpList());
    }

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("with-dname")
    public ObjectNode findWithDname() throws SQLException{
        return mapper.createObjectNode()
                .putPOJO("emps", empService.getEmpDeptList());
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("with-dname-by-map")
    public ObjectNode findWithDnameByMap() throws SQLException{
        return mapper.createObjectNode()
                .putPOJO("emps", empService.getEmpDeptListByMap());
    }

  
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ObjectNode create(Emp emp) throws SQLException, JsonProcessingException{

        emp = empService.create(emp);

        return mapper.valueToTree(emp);
    } 

}
