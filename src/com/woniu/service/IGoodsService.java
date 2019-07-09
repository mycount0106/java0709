package com.woniu.service;

import java.util.List;

import com.woniu.po.Goods;

public interface IGoodsService {

	List<Goods> findAllGoods();

	void AddGoods(Goods goods);

	Goods getGoodsByGid(int gid);

	void GoodsEdit(Goods goods);

	void delGoods(int gid);

}
