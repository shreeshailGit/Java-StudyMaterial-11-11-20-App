package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserBO;
@Repository("loginDAO")
public class LoginDAOImpl implements ILoginDAO {
private static final String INSERT_QUERY = "INSERT INTO USERLIST1(FIRSTNAME,LASTNAME,EMAIL,ADDRESS,PHONENO,UNAME,PASSWORD) VALUES (SRNO_SEQ,?,?,?,?,?,?,?)";                                                    	
	@Autowired
	private SimpleJdbcCall sjc;
	@Autowired
	private JdbcTemplate jt;
	
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

	@Override
	public int insert(UserBO bo) {
		int count =0;
		//count = jt.update(INSERT_QUERY,bo.getFirstName(),bo.getLastName(),bo.getEmail(),bo.getAddress(),bo.getPhoneNo() bo.getUname(),bo.getPwd());
		return count;
	}

}
