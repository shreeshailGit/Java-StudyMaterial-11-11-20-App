package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.BookBO;
@Repository("bookDAO")
public class BookDAOImpl implements IBookDAO {
  private static final String GET_BOOK_DETAILS = "SELECT BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLISHER,CATEGORY FROM BOOK_STORE";
  private static final String INSERT_BOOK_DETAIL="INSERT INTO BOOK_STORE(BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLISHER,CATEGORY) VALUES (BOOKID_SEQ.NEXTVAL,?,?,?,?,?)";	
  private static final String DELETE_BOOK_DETAIL="DELETE FROM BOOK_STORE WHERE BOOKID=?";	
  private static final String GET_BOOK_BY_ID="SELECT BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLISHER,CATEGORY FROM BOOK_STORE WHERE BOOKID=?";
  private static final String UPDATE_BOOK_BY_ID="UPDATE BOOK_STORE SET BOOKNAME=?,AUTHOR=?,PRICE=?,PUBLISHER=?,CATEGORY=? WHERE BOOKID=?";
  
  @Autowired
	private JdbcTemplate jt;
   
	@Override
	public List<BookBO> getbookDetailsById() {
	   List<BookBO> listBO = null;
	   //execute the query
	   listBO = jt.query(GET_BOOK_DETAILS, new ResultSetExtractor<List<BookBO>>() {

		@Override
		public List<BookBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<BookBO> listBO = new ArrayList();
			  while(rs.next()){
			BookBO bo =new BookBO();
			bo.setBookId(rs.getInt(1));
			bo.setBookName(rs.getString(2));
			bo.setAuthor(rs.getString(3));
			bo.setPrice(rs.getFloat(4));
			bo.setPublisher(rs.getString(5));
			bo.setCategory(rs.getString(6));
			//add to listBO
			listBO.add(bo);
			  }
			return listBO;
		}
		   
	   }); 
		return listBO;
	}

  
	/*public class BookRowMapper implements ResultSetExtractor<List<BookBO>>{
		@Override
		public List<BookBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<BookBO> listBO = new ArrayList();
			  while(rs.next()){
			BookBO bo =new BookBO();
			bo.setBookId(rs.getInt(1));
			bo.setBookName(rs.getString(2));
			bo.setAuthor(rs.getString(3));
			bo.setPrice(rs.getFloat(4));
			bo.setPublisher(rs.getString(5));
			bo.setCategory(rs.getString(6));
			//add to listBO
			listBO.add(bo);
			  }
			return listBO;
		}//method
	}//inner class
	*/
  //==============================================================================================
	@Override
	public int addbookDetails(BookBO bo) {
		int count = 0;
		count = jt.update(INSERT_BOOK_DETAIL,bo.getBookName()
				                             ,bo.getAuthor()
				                             ,bo.getPrice()
				                             ,bo.getPublisher()
				                             ,bo.getCategory());
		return count;
	}


	@Override
	public int deleteBookById(int id) {
		int count = 0;
		count = jt.update(DELETE_BOOK_DETAIL,id);
		return count;
	}


	@Override
	public BookBO getBookById(int bookId) {
		BookBO bo =null;
		bo = jt.queryForObject(GET_BOOK_BY_ID, new BookMapper(),bookId);
		return bo;
	}
	//inner clas
	  private class BookMapper implements RowMapper<BookBO>{
	
		@Override
		public BookBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookBO bo = new BookBO();
			bo.setBookId(rs.getInt(1));;
			bo.setBookName(rs.getString(2));
			bo.setAuthor(rs.getString(3));
			bo.setPrice(rs.getFloat(4));
			bo.setPublisher(rs.getString(5));
			bo.setCategory(rs.getString(6));
			return bo;
		}//mapRow(-)
		  
	  }//inner class
	
	/*@Override  //Using Lambda expression based anoynamous inner class for Rowmapper
	public BookBO getBookById(int bookId) {
	   BookBO bo1 =null;
	   bo1 = jt.queryForObject(GET_BOOK_BY_ID, (rs,rowNum)->{
		       BookBO bo =new BookBO();
		       bo.setBookId(rs.getInt(1));
		       bo.setBookName(rs.getString(2));
		       bo.setAuthor(rs.getString(3));
		       bo.setPrice(rs.getFloat(4));
		       bo.setPublisher(rs.getString(5));
		       bo.setCategory(rs.getString(6));
		       return bo;
	   }
	        ,bookId);
	   return bo1;
	}*/
	
	/*@Override   //using  Readymade impl class of RowMapper that is  BeanPropertyRowMapper 
	public BookBO getBookById(int bookId) {
	     BookBO  bo =null;
	      bo = jt.queryForObject(GET_BOOK_BY_ID, new BeanPropertyRowMapper<BookBO>(BookBO.class),bookId);
	      return bo;
	}*/


	@Override
	public int updateBookById(BookBO bo) {
		int count = 0;
		count =jt.update(UPDATE_BOOK_BY_ID, bo.getBookName()
				                           ,bo.getAuthor()
				                         ,bo.getPrice()
				                         ,bo.getPublisher()
				                         ,bo.getCategory()
				                        ,bo.getBookId());
		return count;
	}		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
	
}//class
