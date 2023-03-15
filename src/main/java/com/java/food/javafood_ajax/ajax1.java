package com.java.food.javafood_ajax;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ajax1
 */
@WebServlet("/aj1")
public class ajax1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHand(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHand(request, response);
	}
	protected void doHand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("fileName : "+request.getParameter("fileName"));
		String file_repo = "C:\\javafood";
		String fileName = (String) request.getParameter("fileName");
		String downFile = file_repo + System.getProperty("file.separator") + fileName;
		System.out.println("폴더 구분자 1 : "+ System.getProperty("file.separator"));
		System.out.println("폴더 구분자 2 : "+ File.separator);
		//	지정한 파일 그 자체
		File f = new File(downFile);
		//	파일을 읽을 흐름을 열어서 준비
		//	java가 해당 파일을 사용 중
		try {
			System.out.println("이미지를 불러옵니다.");
			FileInputStream in = new FileInputStream( f );
			//	브라우저가 cache를 사용하지 않도록
			response.setHeader("Cache-Control", "no-cache");
			//	전달 받은 내용을 파일로 인식하도록
			response.addHeader("Content-disposition", "attachment; fileName="+fileName);
			//	파일을 내보낼 수 있는 흐름을 열어서 준비
			OutputStream out = response.getOutputStream();
			byte[] buf = new byte[1024 * 8];		//byte 배열; 8kB
			while(true) {
				//배열의 크기만큼 읽기
				int count = in.read(buf);
				System.out.println("읽은 크기 : count : "+ count);
				//읽은 내용이 더이상 없으면 -1을 반환
				if(count == -1) {
					break;
				}
				//응답의 흐름에 읽은 만큼 보내기
				out.write(buf, 0, count);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			System.out.println("이미지 가 비어있습니다.");
		}
	}
}
