package com.nt.service;

import java.util.List;

import com.nt.dto.BookDTO;

public interface IBookMgmtService {

	public List<BookDTO> fetchBookDetailById();
	public String insertBook(BookDTO dto);
	public String removeBookById(int id);
	public BookDTO getBookById(int bookId);
	public String modifyBookById(BookDTO dto);
}
