package com.testfan.file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.testfan.db.ReadDB;
import com.testfan.db.User;

public class FileUtilsTest {
	
	public void testCopyFile() {
		String path = System.getProperty("user.dir")+File.separator+"data"+File.separator;	
		String source = path +"person.xml";
		String dest = path + "person2.xml";
		try {
			FileUtils.copyFile(new File(source) , new File(dest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testWriteFile() {
		List<User> users = ReadDB.query();
		String path = System.getProperty("user.dir")+File.separator+"data"+File.separator + "DB.csv";	
		for (User user: users) {
			try {
				FileUtils.writeLines(new File(path), "utf-8", users, true);
				//FileUtils.write(new File(path), user.toString(), "utf-8", true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		testWriteFile();
	}
}
