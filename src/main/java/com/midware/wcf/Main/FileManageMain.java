package com.midware.wcf.Main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.midware.wcf.Bean.FileManager;
import com.midware.wcf.Config.JavaConfig;

public class FileManageMain {

	FileManager fm;
	Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
		FileManageMain main=new FileManageMain(context.getBean(FileManager.class));
		main.run();
		
	}
	
	FileManageMain(FileManager fm)
	{
		this.fm=fm;
	}
	
	void run()
	{
		fm.show();
		
		System.out.println("请选择您要执行的操作：1.新建 2.删除  3.压缩 4.查看 0.退出");
		int n=sc.nextInt();
		switch(n)
		{
		case 1:create();break;
		case 2:delete();break;
		case 3:makezip();break;
		case 4:look();break;
		default:break;
		}
	}
	void create()
	{
		System.out.println("请输入您要创建的文件名：");;
		String name=sc.next();
		fm.create(name);
		this.run();
	}
	void delete()
	{
		System.out.println("请输入您要删除的文件名");
		String name=sc.next();
		fm.delete(name);
		this.run();
	}
	void makezip()
	{
		System.out.println("请输入您要压缩的文件名");
		String name=sc.next();
		fm.makezip(name);
		this.run();
	}
	void look()
	{
		System.out.println("请输入您要查看的文件名");
		String name=sc.next();
		fm.look(name);
		this.run();
	}
	
	

}
