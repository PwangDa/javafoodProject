package com.java.food.ajax;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.food.dao.JavafoodDAO;
import com.java.food.dto.login_DTO;


@WebServlet("/aj")
public class ajax extends HttpServlet {
	@Autowired
	JavafoodDAO javaDAO;
	
	@Autowired
	login_DTO dto;
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("아자스 doget 실행");
		doHand(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("이미지를 업로드 합니다.");
		try {
			File cur = new File("C:\\javafood");
			if(!cur.exists()) {
				try {
					cur.mkdir();
					System.out.println("폴더생성 성공");
				} catch (Exception e) {
					System.out.println("폴더생성 실패");
					e.printStackTrace();
				}
			}else {
				System.out.println("이미 지정된 폴더가 있습니다.");
			}
			
			DiskFileItemFactory disk = new DiskFileItemFactory();
			disk.setRepository(cur);
			disk.setSizeThreshold(1024*1024);
			ServletFileUpload serf = new ServletFileUpload(disk);
			serf.setFileSizeMax(1024*1024*100);
			List items = serf.parseRequest((RequestContext) request);
			System.out.println("items.size : "+items.size());
			for(int i = 0; i<items.size(); i++) {
				FileItem fitem = (FileItem) items.get(i);
				if(fitem.isFormField()) {
					System.out.println(fitem.getFieldName()+"="+fitem.getString("utf-8"));
				}else {
					System.out.println("param : "+fitem.getFieldName());
					System.out.println("file name :  "+fitem.getName());
					System.out.println("file size :  "+fitem.getSize());
					if(fitem.getSize()>0) {
						//파일명 추출1
						int idx = fitem.getName().lastIndexOf("\\");
						if(idx == -1) {
							idx = fitem.getName().lastIndexOf("/");
						}
						String filname = fitem.getName().substring(idx+1);
						//파일명 중복방지
//						long timestamp = System.currentTimeMillis();
						String finame = "new";
						filname = finame+"_javafood.JPG";
						
						File up = new File(cur+"\\"+filname);
						fitem.write(up);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("이미지 업로드 실패");
			e.printStackTrace();
		}
		
	}
	
	protected void doHand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("do hand 실행");
		if(request.getParameter("id")!=null) {
			String id = request.getParameter("id");
			String nic = request.getParameter("nic");
			String email = request.getParameter("email");
			String pn = request.getParameter("pn");
			String phone = request.getParameter("phone");
			int a = 0;
			
			List<login_DTO> vo = javaDAO.listID();
			for(int i=0; i<vo.size();i++) {
				if(id!=null) {
					if(id.equals(vo.get(i).getID())) {
						a=1;
					}
				}
				if(nic!=null) {
					if(nic.equals(vo.get(i).getNIC())) {
						a=1;
					}
				}
				if(email!=null) {
					if(email.equals(vo.get(i).getEMAIL())) {
						a=1;
					}
				}
				if(pn!=null) {
					if(pn.equals(vo.get(i).getPN())) {
						a=1;
					}
				}
				if(phone!=null) {
					if(phone.equals(vo.get(i).getPHONE())) {
						a=1;
					}
				}
			}
			response.getWriter().println(a);
		}
//		if(request.getParameter("id1")!=null) {
//			String id = request.getParameter("id1");
//			String num = request.getParameter("num");
//			javaDAO.addhit(id, num);
//			javaDAO.song1addhit(num);
//			System.out.println("ajax 조회수증가 성공");
//		}
//		if(request.getParameter("good")!=null) {
//			String i = request.getParameter("good");
//			javaDAO.like_music(i);
//			System.out.println(i+"번 노래 좋아요!");
//		}
		
	}
	
	
	
	
	
}
