package com.nt.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_ALL_EMPLOYEES = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";
	private static final String INSERT_QUERY_EMPLOYEE = "INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO) VALUES(ENO_SEQ.NEXTVAL,?,?,?,?)";
	private static final String GET_ALL_DEPTNO = "SELECT DISTINCT DEPTNO FROM EMP WHERE DEPTNO IS NOT NULL";
	private static final String DELETE_EMP_BY_ID = "DELETE FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_BY_ID = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	private static final String UPDATE_EMP_BY_ID = "UPDATE EMP SET ENAME=?,JOB=?,SAL=?,DEPTNO=? WHERE EMPNO=?";
	//DELETE  FROM EMP WHERE EMPNO=?
	//select distinct deptno from emp order by coalesce (deptno,40) asc;
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<EmployeeBO> getAllEmployees() {
		List<EmployeeBO> listBO = null;
		listBO = jt.query(GET_ALL_EMPLOYEES, new ListEmployeeRowMapper());
		return listBO;
	}// getAllEmolyees

	// nested inner class
	class ListEmployeeRowMapper implements ResultSetExtractor<List<EmployeeBO>> {

		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO> listBO = new ArrayList();
			// copying rs records into listBO object
			while (rs.next()) {
				EmployeeBO bo = new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				bo.setDeptno(rs.getInt(5));
				// add bo to listBo
				listBO.add(bo);
			} // while
			return listBO;
		}// extractData

	}// nested inner class

	@Override
	public int insertEmployee(EmployeeBO bo) {
		int count = 0;
		count  = jt.update(INSERT_QUERY_EMPLOYEE,
				                     bo.getEname(),bo.getJob(),bo.getSal(),bo.getDeptno());
		return count;
	}

	@Override
	public List<Integer> getEmpdeptNos() {
		List<Map<String,Object>> listMap= null;
		List<Integer> deptNosList=new ArrayList();
		//execute query
		listMap = jt.queryForList(GET_ALL_DEPTNO);
		listMap.forEach(e->{
			deptNosList.add((Integer) ((BigDecimal)e.get("deptNo")).intValue());
		});
		return deptNosList;
	}

	@Override
	public int deleteEmployee(int id) {
		int count =0;
		count = jt.update(DELETE_EMP_BY_ID,id);
		return count;
	}

	/*@Override
	public EmployeeBO getEmpById(int id) {
		EmployeeBO bo = null;
	
		bo= jt.queryForObject(GET_EMP_BY_ID, new EmployeeRowMapper()
				, id);
		return bo;
	}
	private static class EmployeeRowMapper implements RowMapper<EmployeeBO>{	
		@Override
		public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeBO bo =null;
			bo = new EmployeeBO();
			bo.setEmpNo(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getFloat(4));
			bo.setDeptno(rs.getInt(5));
			return bo;
		}//method
	}//inner class
	*/
	/*@Override  //Using Lambda expression based anoynamous inner class for Rowmapper
	public EmployeeBO getEmpById(int id) {
		EmployeeBO bo1 = null;
		bo1= jt.queryForObject(GET_EMP_BY_ID,(rs,rowNum)->{
			EmployeeBO bo =null;
			bo = new EmployeeBO();
			bo.setEmpNo(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getFloat(4));
			bo.setDeptno(rs.getInt(5));
			return bo;
		}
				, id);
		return bo1;
	}*/
	@Override   //using  Readymade impl class of RowMapper that is  BeanPropertyRowMapper 
    //(here cols names  BO class property names must match)
	public EmployeeBO getEmpById(int id) {
		EmployeeBO bo = null;
		bo= jt.queryForObject(GET_EMP_BY_ID,new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class)
				, id);
		return bo;
	}//method

	@Override
	public int updateEmpById(EmployeeBO bo) {
		int count = 0;
		count = jt.update(UPDATE_EMP_BY_ID,bo.getEname()
				                         ,bo.getJob()
				                         ,bo.getSal()
				                         ,bo.getDeptno()
				                         ,bo.getEmpNo());
		return count;
	}
	
}// class
