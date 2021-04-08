package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserBO;
@Repository("loginDAO")
public class LoginDAOImpl implements ILoginDAO {
	@Autowired
	private SimpleJdbcCall sjc;
	
	@Override
	public String authenticateUser(UserBO bo) {
		//set procedure name
		sjc.setProcedureName("P_AUTHENTICATION");
		//prepare Map object having IN param names and values
       // Map<String,Object> inParams =Map.of("USERNAME",bo.getUname(),"PASSWORD",bo.getPwd());//get Immutable Map obj
		 Map<String,Object> inParams = new HashMap<String, Object>();
		 inParams.put("USERNAME",bo.getUname());
		 inParams.put("PASSWORD",bo.getPwd());
		//call PL/SQL procedure 
        Map<String,Object> outParams = sjc.execute(inParams);
        //get result from OUT param
        return (String) outParams.get("RESULT");
	}

}
