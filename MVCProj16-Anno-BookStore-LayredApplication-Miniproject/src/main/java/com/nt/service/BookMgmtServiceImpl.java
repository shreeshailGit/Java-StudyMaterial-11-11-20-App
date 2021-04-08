package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.BookBO;
import com.nt.dao.IBookDAO;
import com.nt.dto.BookDTO;
@Service("bookService")
public class BookMgmtServiceImpl implements IBookMgmtService {
   @Autowired
	private IBookDAO dao;
	
   @Override
	public List<BookDTO> fetchBookDetailById() {
		List<BookDTO> listDTO = new ArrayList();
		List<BookBO> listBO = null;
	
		//use dao
	    listBO = dao.getbookDetailsById();
		//convert bo to dto
		listBO.forEach(bo->{
			BookDTO dto = new BookDTO();
			BeanUtils.copyProperties(bo, dto);
		//add dto to listDTO
			listDTO.add(dto);
		});
		return listDTO;
	}//method

     @Override
    public String insertBook(BookDTO dto) {
        int count = 0;
    	
        //convert dto to bo object
        BookBO bo =new BookBO();
        BeanUtils.copyProperties(dto, bo);
        
        //use dao
        count = dao.addbookDetails(bo);
    	 
        return count!=0?dto.getBookName()+" Book is inserted ":" Book is not inserted";
    }

	@Override
	public String removeBookById(int id) {
		int count =0;
		//use dao
		count = dao.deleteBookById(id);
		return count!=0?id+" Book is found & deleted":" Book is not found for deletion";
	}

	@Override  //for select query for edit oper
	public BookDTO getBookById(int bookId) {
		BookBO bo =null;
		//use dao
		bo = dao.getBookById(bookId);
		//convert bo to dto
		BookDTO dto = new BookDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public String modifyBookById(BookDTO dto) { 
		System.out.println(dto);
		int count =0;
		//convert dto to bo
		BookBO bo  =new BookBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count= dao.updateBookById(bo);
		
		return count!=0?dto.getBookId()+" Book found and  updated":dto.getBookId()+" Book is not updated";
	}

}//class
