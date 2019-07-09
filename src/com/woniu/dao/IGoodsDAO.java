package com.woniu.dao;

import java.util.List;

import com.woniu.po.Goods;

public interface IGoodsDAO {
	void save(Goods goods);
	void delete(int gid);
	void update(Goods goods);
	Goods findOne(int gid);
	List<Goods> findAll();
}
