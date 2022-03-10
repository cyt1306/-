package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.bean.Book;
import com.example.demo.bean.Reader;
import com.example.demo.bean.ShoppingCart;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {
	@Autowired
	private ReaderRepository readerRepository;
	@Autowired
	private BookRepository bookRepository;
	
	public boolean validate(Reader reader)
	{
		Reader temp;
		String a=reader.getName();
		temp=readerRepository.selectByName(reader.getName());
		if(temp==null)
		{
			return false;
		}
		else if(temp.getPassword().equals(reader.getPassword()))
		{
			reader.setId(temp.getId());
			reader.setMoney(temp.getMoney());
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public int insertReader(Reader reader)
	{
		return readerRepository.insertReader(reader);
	}
	
	public List<Book> findAll()
	{
		return bookRepository.findAll();
	}
	
	public boolean addShop(int id,ShoppingCart sc)
	{
		Book book=bookRepository.findBookById(id);
		//默认每次加书本数为1，之后再修改
		if(book!=null)
		{
			book.setQuantity(1);
			sc.addCartItem(book);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Transactional
	public float pay(Reader reader,ShoppingCart sc)
	{
		//扣除读者购书款
		float money =reader.getMoney()-sc.getTotal();
		reader.setMoney(money);
		readerRepository.update(reader);
		
		//循环扣除图书数量
		List<Book> listbook=sc.getCart();
		for(Book book:listbook)
		{
			Book temp=bookRepository.findBookById(book.getId());
			temp.setQuantity(temp.getQuantity()-book.getQuantity());
			bookRepository.update(temp);
		}
		return money;
	}
	
	
}
