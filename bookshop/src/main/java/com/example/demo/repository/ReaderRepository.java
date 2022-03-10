package com.example.demo.repository;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;

import com.example.demo.bean.Reader;

public interface ReaderRepository {
	@Select("select * from reader where name=#{name}")
	public Reader selectByName(String name);
	@Update("update reader set money=#{money} where id=#{id}")
	public void update(Reader reader);
	@Insert("insert into reader(name,password,money)"+"value(#{name},#{password},#{money})")
	public int insertReader(Reader reader);
}
