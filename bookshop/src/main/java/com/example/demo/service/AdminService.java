package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Admin;
import com.example.demo.bean.Book;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private BookRepository bookRepository;
	
	public boolean validate(Admin admin)
	{
		Admin temp;
		String a=admin.getName();
		temp=adminRepository.selectByName(admin.getName());
		if(temp==null)
		{
			return false;
		}
		else if(temp.getPassword().equals(admin.getPassword()))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public int insertBook(Book book)
	{
		return bookRepository.insertBook(book);
	}
	public List<Book> findAll()
	{
		return bookRepository.findAll();
	}
}
