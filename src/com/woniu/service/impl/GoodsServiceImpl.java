package com.woniu.service.impl;

import java.util.List;

import com.woniu.dao.IGoodsDAO;
import com.woniu.dao.impl.GoodsDAOImpl;
import com.woniu.po.Goods;
import com.woniu.service.IGoodsService;

public class GoodsServiceImpl implements IGoodsService {
	IGoodsDAO gd = new GoodsDAOImpl();
	@Override
	public List<Goods> findAllGoods() {
		// TODO Auto-generated method stub
		return gd.findAll();
	}
	@Override
	public void AddGoods(Goods goods) {
		// TODO Auto-generated method stub
		gd.save(goods);
	}
	@Override
	public Goods getGoodsByGid(int gid) {
		// TODO Auto-generated method stub
		return gd.findOne(gid);
	}
	@Override
	public void GoodsEdit(Goods goods) {
		// TODO Auto-generated method stub
		gd.update(goods);
	}
	@Override
	public void delGoods(int gid) {
		// TODO Auto-generated method stub
		gd.delete(gid);
	}

}
