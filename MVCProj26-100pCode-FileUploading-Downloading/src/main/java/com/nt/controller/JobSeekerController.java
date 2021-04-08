package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.JobSeekerInfo;
import com.nt.service.FileMgmtService;

@Controller
public class JobSeekerController {
    @Autowired
	private ServletContext sc;
	@Autowired
	private FileMgmtService service;
	@GetMapping("/upload")
	public String showUploadForm(@ModelAttribute("jsFrm") JobSeekerInfo info) {		
		return "jobseeker_form";
	}
		
	@PostMapping("/upload.htm")
	public String getUploadeddata(Map<String,Object> map,@ModelAttribute("jsFrm") JobSeekerInfo info) throws Exception {
		  //get upload folder Location from web.xml  file
		String folderLocation = sc.getInitParameter("uploadStore");
		//create file
		File file = new File(folderLocation);
		if(!file.exists())
			 file.mkdir();
		//get uploadedfile Names
		String resumeFileName = info.getResume().getOriginalFilename();
		String photoFileName  = info.getPhoto().getOriginalFilename();
		
		/*File resumeFile = new File(resumeFileName);
		   if(resumeFile.length() > 5*1024)
		     throw new IllegalStateException("invalid filesize");
		   if(resumeFileName.endsWith(".pdf") || resumeFileName.endsWith(".dat"))
			   throw new IllegalStateException("invalid file type");*/
		   
		//create IO stream pointing uploaded file content
		InputStream resumeIs = info.getResume().getInputStream();
		InputStream photoIs = info.getPhoto().getInputStream();
		//create OutputStream pointing to empty destination file
		OutputStream resmueOs = new FileOutputStream(folderLocation+ "/" +resumeFileName);
		OutputStream photoOs = new FileOutputStream(folderLocation+ "/" +photoFileName);
		//copy uploaded file content to destiation file
		IOUtils.copy(resumeIs, resmueOs);
		IOUtils.copy(photoIs, photoOs);
		//keep the names of the model attribute in model attribute
		map.put("resumeFileName", resumeFileName);
		map.put("photoFileName", photoFileName);
		   
		//close streams
		resmueOs.close();
		resumeIs.close();
		photoOs.close();
		photoIs.close();
		//return lvn 
		return "upload_success";
	}
	
	@GetMapping("/list_files.htm")
	public String fetchFiles(Map<String,Object> map) {
		//get uploadStore folder name from web.xml file as context param value
		String uploadStore = sc.getInitParameter("uploadStore");
		File file = new File("uploadFolder");
		//use service
		List<String> fileNameList = service.fetchAllFiles(uploadStore);
		//keeps fileNameList in model attribute
		map.put("filesList", fileNameList);
		return "show_files";
	}
	
	@GetMapping("/download.htm")
	public String downloadFile(@RequestParam("fname") String fileName1,HttpServletResponse res) throws Exception {
		//get path of downloadable file folderLocation 
		String filePath = sc.getInitParameter("uploadStore")+"/"+fileName1;  //gives F:/store/abc.txt
		//create File object for pointing to the file to be downloaded 
		File file =  new File(filePath);
		//set file length as response content length
		res.setContentLengthLong(file.length());
		//get MIME type of the file and make it as response content type
		String mimeType = sc.getMimeType(filePath);
		res.setContentType(mimeType==null?"application/octet-stream":mimeType);
		//create InputStream pointing to the file to be downloaded
		InputStream io = new FileInputStream(filePath);
		//create  OutputStream pointing response obj 
		OutputStream os = res.getOutputStream();
		//Gives instruction to browser to makereceived content as  downloadable
		res.setHeader("Content-Disposition","attachment;fileName="+fileName1);//makes browser to display download
		//copy file content to response obj
	    IOUtils.copy(io, os);
		//takes lvn as null
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
}//class
