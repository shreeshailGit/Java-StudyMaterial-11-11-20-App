package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.dto.BookDTO;
import com.nt.model.Book;
import com.nt.service.IBookMgmtService;

@Controller
public class Book_StoreController  {
   @Autowired
	private IBookMgmtService service;
	
   @GetMapping("/welcome.htm")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/list_books.htm")
	public String showStorePage(Map<String,Object> map) {
		List<BookDTO> listDTO =null;
		//use service
		listDTO = service.fetchBookDetailById();
		//add listDTO to model attribute
	    map.put("booksInfo",listDTO);
		return "show_report";	
	}
	
	@GetMapping("/add.htm")//for initial phase req
	public String showregisterBook(@ModelAttribute("bid") Book bk) {
	    return "register_books";
	}
	
	@PostMapping("/add.htm")//for post back req
	public String registerBook(RedirectAttributes redirect,@ModelAttribute Book bk) {
	  String result = null;
		//convert model class to dto class obj
		BookDTO dto = new BookDTO();
		BeanUtils.copyProperties(bk, dto);
		//use service
		result = service.insertBook(dto);
		//keeps result in Flashattribute obj
		redirect.addFlashAttribute("resultMsg",result);
		return "redirect:list_books.htm";
	}
	
	//for delete opera
    @GetMapping("/deleteBook.htm") 
	public String deleteById(RedirectAttributes redirect,@RequestParam("bookId") int id) {
	    String result =null;
    	//use service
    	result = service.removeBookById(id);
    	//add result to flash attribute
        redirect.addFlashAttribute("resultMsg", result);
    	return "redirect:list_books.htm";
	}
    
    
    //for edit opera
    @GetMapping("/editBook.htm")
    public String editBookbyid(@ModelAttribute("bid") Book bk ,@RequestParam int bookId) {
		BookDTO dto = null;
    	//use service
		dto = service.getBookById(bookId);
		//convert dto to  model
		
		BeanUtils.copyProperties(dto, bk);
		//return lvn
    	return "edit_books";
    }
    
    @PostMapping("/editBook.htm")
    public String updateBookById(RedirectAttributes redirect
    		                         ,@ModelAttribute("bid") Book bk ) {
    	  String result = null;
          //convert model obj to dto 
    	 BookDTO dto = new BookDTO();
    	 BeanUtils.copyProperties(bk, dto);
    	 //use service
    	 result = service.modifyBookById(dto);
    	 //add to FlashAttribute
    	 redirect.addFlashAttribute("resultMsg", result);
    	 return "redirect:list_books.htm";
    }
    
    
    
}//class
