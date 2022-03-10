package com.example.demo.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.example.demo.bean.Admin;
import com.example.demo.bean.Book;
import com.example.demo.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	//注入UserService
	@Resource
	private AdminService adminService;
	
	@RequestMapping("/login")
	public String login()
	{
		return "adminlogin";
	}
	@RequestMapping("/logon")
	public String logon(Admin admin,HttpSession session)
	{
		boolean isLogon;
		isLogon=adminService.validate(admin);
		if(isLogon)
		{
			session.setAttribute("admin", admin);
			return "adminbook";
		}
		else
		{
			return "logonerror";
		}
	}
	@RequestMapping("/add")
	public String add(HttpSession session)
	{
		if (session.getAttribute("admin")==null)
		{
			return "adminlogin";
		}
		else
		{
			return "adminadd";
		}
	}
	@RequestMapping("/adddb")
	public String addDB(Book book,HttpSession session)
	{
		if(session.getAttribute("admin")==null)
		{
			return  "adminlogin";
		}
		if(adminService.insertBook(book)>0)
			return "adminbook";
		else
			return "error";
	}
	@RequestMapping("/find")
	public String find(HttpSession session,Model model)
	{
		if(session.getAttribute("admin")==null)
		{
			return  "adminlogin";
		}
		List<Book> listbook=adminService.findAll();
		model.addAttribute("listbook",listbook);
		return "adminfind";
	}
	
	
	
	
	
	
	
	
}
