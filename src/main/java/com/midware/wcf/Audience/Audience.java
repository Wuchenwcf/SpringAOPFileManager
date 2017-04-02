package com.midware.wcf.Audience;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.midware.wcf.Bean.LogManager;
import com.midware.wcf.Imp.LogManagerImp;

@Component
@Aspect
public class Audience {
	private LogManager logimp;

	@Autowired
	public Audience(LogManager lm)
	{
		this.logimp=lm;
	}
	public void setLogManager(LogManager lm)
	{
		this.logimp=lm;
	}

	@AfterReturning("execution(* com.midware.wcf.Bean.FileManager.create(String)) "+"&& args(name)")
	public void createLog(String name)
	{
		logimp.createLog(name);
	}

	@AfterReturning("execution(* com.midware.wcf.Bean.FileManager.delete(String)) "+"&& args(name)")
	public void deleteLog(String name)
	{
		this.logimp.delectlog(name);
	}

	@AfterReturning("execution(* com.midware.wcf.Bean.FileManager.makezip(String)) "+"&& args(name)")
	public void makezipLog(String name)
	{
		this.logimp.makeziplog(name);
	}

	@Pointcut("execution(** com.midware.wcf.Bean.FileManager.delete(..)) ")
	public void dodelete()
	{	}

	@Around("dodelete()")
	public void comfirm(ProceedingJoinPoint jp)
	{
		System.out.println("确认要删除吗？yes/no");
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		if(s.equals("yes"))
			try {
				jp.proceed();
				System.out.println("文件删除成功！");
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@AfterReturning("execution(* com.midware.wcf.Bean.FileManager.look(String)) "+"&& args(name)")
	public void search(String name)
	{
		this.logimp.looklog(name);
		File f=new File(name);
		InputStreamReader read;
		try {
			read = new InputStreamReader(new FileInputStream(f),"GBK");
			BufferedReader buffer=new BufferedReader(read);
			String s=null;
			while((s=buffer.readLine())!=null)
			{
				String[] sn=s.split(" ");
				for(int i=0;i<sn.length;i++)
				{
					if(sn[i].endsWith("MiddleWare"))

					System.out.println("文件中含有Middleware");
				else
					if(sn[i].equals("JAVA"))
						System.out.println("文件中含有JAVA");
				}}
			read.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();
	}

}





