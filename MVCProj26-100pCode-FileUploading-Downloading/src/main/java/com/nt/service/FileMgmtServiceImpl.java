package com.nt.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service("fileService")
public class FileMgmtServiceImpl implements FileMgmtService {

	@Override
	public List<String> fetchAllFiles(String uploadStore) {
		//create File objectr represting uploadStore folder(F:/store) 
		File fileName = new File(uploadStore);
		//get All files and sub folders of uploadStore(F:/store)
		File content[] = fileName.listFiles();
		//create Object for storing files
		List<String> fileNameList = new ArrayList();
		
		//fetch each 
		for(File f:content) {
			if(f.isFile())
	           fileNameList.add(f.getName());
		}
		return fileNameList;
	}

}
