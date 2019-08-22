package com.alonepmk.Domain;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.springframework.web.servlet.DispatcherServlet;

import com.alonepmk.Socket.ChatServer;

public class ApplicationServlet extends DispatcherServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		
	}
}
