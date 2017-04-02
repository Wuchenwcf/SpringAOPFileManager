package com.midware.wcf.Bean;

public interface FileManager 
{
	public void create(String name);
	public void delete(String name);
	public void show();
	public void look(String name);
	public void makezip(String name);
}
