package com.woniu.po;

public class Goods {
	private int gid;
	private String gname;
	private int typeid;
	private double gprice;
	private String gphoto;
	private String gdes;
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public double getGprice() {
		return gprice;
	}
	public void setGprice(double gprice) {
		this.gprice = gprice;
	}
	public String getGphoto() {
		return gphoto;
	}
	public void setGphoto(String gphoto) {
		this.gphoto = gphoto;
	}
	public String getGdes() {
		return gdes;
	}
	public void setGdes(String gdes) {
		this.gdes = gdes;
	}
	public Goods(int gid, String gname, int typeid, double gprice, String gphoto, String gdes) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.typeid = typeid;
		this.gprice = gprice;
		this.gphoto = gphoto;
		this.gdes = gdes;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
