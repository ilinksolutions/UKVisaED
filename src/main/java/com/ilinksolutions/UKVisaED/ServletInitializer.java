package com.ilinksolutions.UKVisaED;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.ilinksolutions.UKVisaED.UKVisaEmailApplication;

public class ServletInitializer extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(UKVisaEmailApplication.class);
	}
}
