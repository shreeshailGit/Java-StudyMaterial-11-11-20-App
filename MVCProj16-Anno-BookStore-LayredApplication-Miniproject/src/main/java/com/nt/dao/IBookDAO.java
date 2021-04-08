package com.nt.dao;

import java.util.List;

import com.nt.bo.BookBO;

public interface IBookDAO {

	public List<BookBO> getbookDetailsById();
	public int addbookDetails(BookBO bo);
	public int deleteBookById(int id);
	public BookBO getBookById(int bookid);
	public int updateBookById(BookBO bo);
}
