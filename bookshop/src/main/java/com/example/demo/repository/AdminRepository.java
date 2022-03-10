package com.example.demo.repository;

import java.util.List;
import com.example.demo.bean.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminRepository {
	@Select("select * from manager where name=#{name}")
	public Admin selectByName(String name);
}