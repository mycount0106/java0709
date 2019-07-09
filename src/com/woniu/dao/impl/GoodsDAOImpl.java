package com.woniu.dao.impl;

import java.util.List;

import com.woniu.dao.IGoodsDAO;
import com.woniu.po.Goods;
import com.woniu.util.BaseDAO;

public class GoodsDAOImpl implements IGoodsDAO {
	BaseDAO<Goods> bd = new BaseDAO<Goods>();
	@Override
	public void save(Goods goods) {
		String sql = "insert into goods values(null,?,?,?,?,?)";
		Object[] objs = {goods.getGname(),goods.getTypeid(),goods.getGprice(),goods.getGphoto(),goods.getGdes()};
		bd.update(sql, objs);
	}

	@Override
	public void delete(int gid) {
		String sql = "delete from goods where gid=?";
		Object[] objs = {gid};
		bd.update(sql, objs);
	}

	@Override
	public void update(Goods goods) {
		String sql = "update goods set gname=?,typeid=?,gprice=?,gphoto=?,gdes=? where gid=?";
		Object[] objs = {goods.getGname(),goods.getTypeid(),goods.getGprice(),goods.getGphoto(),goods.getGdes(),goods.getGid()};
		bd.update(sql, objs);
	}

	@Override
	public Goods findOne(int gid) {
		String sql = "select * from goods where gid=?";
		Object[] objs = {gid};
		List<Goods> goodss = bd.select(sql, objs, Goods.class);
		return goodss.size()==0?null:goodss.get(0);
	}

	@Override
	public List<Goods> findAll() {
		String sql = "select * from goods";
		Object[] objs = {};
		List<Goods> goodss = bd.select(sql, objs, Goods.class);
		return goodss;
	}

}
