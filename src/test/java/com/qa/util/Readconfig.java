package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {


	Properties pro;

	public Readconfig()   {

		File src=new File("./Configur/config.properties");	
		try{
			pro=new Properties();

			FileInputStream ip=new FileInputStream(src);

			pro.load(ip);
		}
		catch(Exception e) {
			System.out.println("Exception occured"+e.getMessage());


		}
		
		



	}

	public String getBrowsername() {
		String br=pro.getProperty("browser");
		return br;

	}
	public String geturl() {
		String url=pro.getProperty("url");
		return url;

	}

	public String getusername() {
		String uname=pro.getProperty("username");
		return uname;

	}

	public String getpasword() {
		String pass=pro.getProperty("password");
		return pass;

	}




}
