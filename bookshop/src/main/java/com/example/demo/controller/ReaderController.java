package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.example.demo.bean.Book;
import com.example.demo.bean.Reader;
import com.example.demo.bean.ShoppingCart;
import com.example.demo.service.ReaderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reader")
public class ReaderController {
	//注入UserService
	@Resource
	private ReaderService readerService;
	
	@RequestMapping("/shouye")
	public String shouye()
	{
		return "welcome";
	}
	
	@RequestMapping("/register")
	public String register()
	{
		return "readerregister";
	}
	
	@RequestMapping("/add")
	public String addnew(Reader reader)
	{
		
		if(readerService.insertReader(reader)>0)
			return "readerlogin";
		else
			return "error";
	}
	
	
	@RequestMapping("/login")
	public String login()
	{
		return "readerlogin";
	}
	
	@RequestMapping("/logon")
	public String logon(Reader reader,HttpSession session )
	{
		boolean islogon;
		islogon=readerService.validate(reader);
		if(islogon)
		{
			session.setAttribute("reader", reader);
			return "forward:/reader/index";
		}
		else
		{
			return "logonerror";
		}
	}
	
	@RequestMapping("/index")
	public String index(HttpSession session,Model model)
	{
		if(session.getAttribute("reader")==null)
		{
			return "readerlogin";
		}
		else
		{
			List<Book> listbook=readerService.findAll();
			model.addAttribute("listbook",listbook);
		}
		return "readerindex";
	}
	
	@RequestMapping("/addshopcart")
	public String addShopCart(HttpSession session,int id)
	{
		ShoppingCart sc=null;
		sc=(ShoppingCart)session.getAttribute("shopcart");
		if(session.getAttribute("reader")==null)
		{
			return "readerlogin";
		}
		if(sc==null)
		{
			sc=new ShoppingCart();
			session.setAttribute("shopcart", sc);
		}
		boolean addsuccess=readerService.addShop(id,sc);
		if(addsuccess)
			return "readershop";
		else
			return "addfalse";
	}
	@RequestMapping("/pay")
	public String pay(HttpSession session,Model model)
	{
		if(session.getAttribute("reader")==null)
			return "readerlogin";
		ShoppingCart sc=null;
		sc=(ShoppingCart)session.getAttribute("shopcart");
		if(sc==null)
		{
			return "error";
		}
		Reader reader=(Reader)session.getAttribute("reader");
		float money=readerService.pay(reader, sc);
		
		model.addAttribute("money", money);
		session.removeAttribute("shopcart");
		return "readerend";
	}


}
