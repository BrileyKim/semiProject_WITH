package com.with.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRename implements FileRenamePolicy{

	@Override
	public File rename(File oldFile) {
		File newFile = null;
		do {
			long currentTime=System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
			int rndNum = (int)(Math.random()*1000);
			String oriName = oldFile.getName();
			String ext="";
			int dot=oriName.lastIndexOf(".");
			if(dot>-1) {
				ext=oriName.substring(dot);
			}
			String newName="with"+sdf.format(new Date(currentTime))+"_"+rndNum+ext;
			newFile = new File(oldFile.getParent(),newName);
		}while(!createNewFile(newFile));
		return newFile;
	}
	
	private boolean createNewFile(File f) {
		try {
			return f.createNewFile();
		}catch(IOException e) {
			return false;
		}
	}
		
	

}
