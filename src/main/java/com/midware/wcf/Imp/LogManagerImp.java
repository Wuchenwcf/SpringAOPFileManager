package com.midware.wcf.Imp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.midware.wcf.Bean.*;
public class LogManagerImp implements LogManager {

	
	File log=new File("Log.txt");
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	public LogManagerImp()
	{
		if(!this.log.exists())
		{
			try {
				this.log.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void createLog(String name) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw=new FileWriter(this.log,true);
			fw.write(df.format(new Date())+"    用户创建了文件"+name+"\r\n");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void delectlog(String name) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw=new FileWriter(this.log,true);
			fw.write(df.format(new Date())+"    用户删除了文件"+name+"\r\n");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void makeziplog(String name) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw=new FileWriter(this.log,true);
			fw.write(df.format(new Date())+"    用户压缩了文件"+name+"\r\n");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void looklog(String name) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw=new FileWriter(this.log,true);
			fw.write(df.format(new Date())+"    用户查看了文件"+name+"\r\n");;
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
