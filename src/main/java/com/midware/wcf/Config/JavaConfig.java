package com.midware.wcf.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.midware.wcf.Audience.Audience;
import com.midware.wcf.Bean.FileManager;
import com.midware.wcf.Bean.LogManager;
import com.midware.wcf.Imp.FileManagerImp;
import com.midware.wcf.Imp.LogManagerImp;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class JavaConfig {

	@Bean
	public LogManager logm()
	{
		return new LogManagerImp();
	}
	
	@Bean
	public FileManager fileManager()
	{
		return new FileManagerImp();
	}

	@Bean
	public Audience audience()
	{
		return  new Audience(logm());
		
	}
	


}
