package com.example.demo.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.demo.bean.Book;
public interface BookRepository {
	@Insert("insert into book(name,price,quantity)"+"value(#{name},#{price},#{quantity})")
	public int insertBook(Book book);
	
	@Select("select * from book")
	public List<Book> findAll();
	
	@Select("select * from book where id=#{id}")
	public Book findBookById(int id);
	@Update("update book set quantity=#{quantity} where id=#{id}")
	public void update(Book book);
}
