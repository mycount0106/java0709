package com.woniu.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.woniu.po.Goods;
import com.woniu.service.IGoodsService;
import com.woniu.service.impl.GoodsServiceImpl;


@WebServlet("/goods.action")
public class GoodsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IGoodsService gs = new GoodsServiceImpl();
    public GoodsAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method==null){
			findAll(request,response);
		}else if(method.equals("goodsAdd")){
			goodsAdd(request,response);
		}else if(method.equals("getGoods")){
			getGoods(request,response);
		}else if(method.equals("goodsEdit")){
			goodsEdit(request,response);
		}else if(method.equals("delGoods")){
			delGoods(request,response);
		}
	}

	private void delGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int gid = Integer.parseInt(request.getParameter("gid"));
		gs.delGoods(gid);
		response.sendRedirect("goods.action");
	}

	private void goodsEdit(HttpServletRequest request, HttpServletResponse response) {
		Goods goods = new Goods();
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				if(item.isFormField()){
					if(item.getFieldName().equals("gid")){
						goods.setGid(Integer.parseInt(item.getString()));
					}else if(item.getFieldName().equals("gname")){
						goods.setGname(item.getString());
					}else if(item.getFieldName().equals("typeid")){
						goods.setTypeid(Integer.parseInt(item.getString()));
					}else if(item.getFieldName().equals("gprice")){
						goods.setGprice(Double.parseDouble(item.getString()));
					}else if(item.getFieldName().equals("gdes")){
						goods.setGdes(item.getString());
					}
				}else{
					String oldName = item.getName();
					String hz = oldName.substring(oldName.lastIndexOf("."));
					String newName = UUID.randomUUID().toString()+hz;
					String path = request.getRealPath("/imgs");
					File imgsDir = new File(path);
					if(imgsDir.exists()){
						imgsDir.mkdirs();
					}
					item.write(new File(path, newName));
					goods.setGphoto(newName);
				}
			}
			gs.GoodsEdit(goods);
			response.sendRedirect("goods.action");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void getGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gid = Integer.parseInt(request.getParameter("gid"));
		Goods goods = gs.getGoodsByGid(gid);
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("goodsEdit.jsp").forward(request, response);
	}

	private void goodsAdd(HttpServletRequest request, HttpServletResponse response) {
		Goods goods = new Goods();
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem item:items){
				if(item.isFormField()){
					if(item.getFieldName().equals("gname")){
						goods.setGname(item.getString());
					}else if(item.getFieldName().equals("typeid")){
						goods.setTypeid(Integer.parseInt(item.getString()));
					}else if(item.getFieldName().equals("gprice")){
						goods.setGprice(Double.parseDouble(item.getString()));
					}else if(item.getFieldName().equals("gdes")){
						goods.setGdes(item.getString());
					}
				}else{
					String oldName = item.getName();
					String hz = oldName.substring(oldName.lastIndexOf("."));
					String newName = UUID.randomUUID().toString()+hz;
					String path = request.getRealPath("/imgs");
					File imgsDir = new File(path);
					if(imgsDir.exists()){
						imgsDir.mkdirs();
					}
					item.write(new File(path, newName));
					goods.setGphoto(newName);
				}
				
			}
			gs.AddGoods(goods);
			response.sendRedirect("goods.action");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Goods> goodss = gs.findAllGoods();
		request.setAttribute("goodsList",goodss);
		request.getRequestDispatcher("goodsList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
