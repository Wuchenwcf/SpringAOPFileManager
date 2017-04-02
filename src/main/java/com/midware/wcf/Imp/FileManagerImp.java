package com.midware.wcf.Imp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.midware.wcf.Bean.FileManager;

public class FileManagerImp implements FileManager{

	File directory=new File(System.getProperty("user.dir"));//获取当前路径
	public void create(String name) {
		// TODO Auto-generated method stub
		File f=new File(name);
		if(f.exists())
		{
			System.out.println("文件已经存在！");
		}
		else
		{
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("文件创建成功");;
		}
	}

	public void delete(String name) {
		// TODO Auto-generated method stub
		File f=new File(name);
		if(!f.exists())
		{
			System.out.println("文件不存在！");
		}
		else
		{
			f.delete();
		}
	}

	//展示当前目录的所有文件
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("当前目录下的文件有：");
		File fa[]=directory.listFiles();
		for(int i=0;i<fa.length;i++)
			if(fa[i].isDirectory())
			{
				System.out.println(fa[i].getName()+"[目录]");
			}
			else
			{
				System.out.println(fa[i].getName());
			}
	
		
	}

	public void look(String name) {
		// TODO Auto-generated method stub
		File f=new File(name);
		if(!f.exists())
		{
			System.out.println("文件不存在");
		}
		else
		{
			try {
				InputStreamReader read=new InputStreamReader(new FileInputStream(f),"GBK");
				BufferedReader buffer=new BufferedReader(read);
				String s=null;
				try {
					while((s=buffer.readLine())!=null)
						System.out.println(s);
					read.close();
					System.out.println();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
					
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}

	public void makezip(String name) {
		// TODO Auto-generated method stub
	   	try {
            File file = new File(name);
            File zipFile = new File(name+".zip");
            InputStream input = new FileInputStream(file);
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
            zipOut.putNextEntry(new ZipEntry(file.getName()));
            int temp = 0;
            while((temp = input.read()) != -1){
                zipOut.write(temp);
            }
            input.close();
            zipOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	   	System.out.println("压缩成功");
	}

	
}
