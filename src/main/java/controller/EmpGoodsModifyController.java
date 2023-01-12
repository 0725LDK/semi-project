package controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.GoodsService;
import vo.Goods;
import vo.GoodsImg;

@WebServlet("/emp/empGoodsModify")
public class EmpGoodsModifyController extends HttpServlet {
	
	//상품 수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		GoodsService goodsService = new GoodsService();
		
		int goodsCode = 0;
		// 방어코드
		if(request.getParameter("goodsCode") != null){
			goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
			System.out.println("goodsCode : " + goodsCode);
		} 
		map = goodsService.getGoodsOne(goodsCode);
		
		request.setAttribute("map", map);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empGoodsModify.jsp").forward(request, response);

	}

	//상품 수정 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 프로젝트안 upload폴더의 실제 물리적 위치를 반환
		String dir = request.getServletContext().getRealPath("/upload");
		int maxFileSize = 1024 * 1024 * 100; // 100Mbyte
		
		// 업로드 폴더내 동일한 이름이 있으면 뒤에 숫자를 추가
		DefaultFileRenamePolicy fp = new DefaultFileRenamePolicy();
		MultipartRequest mreq = new MultipartRequest(request, dir, maxFileSize, "UTF-8", fp);
		
		int goodsCode = Integer.parseInt(mreq.getParameter("goodsCode"));
		String goodsName = mreq.getParameter("goodsName");
		int goodsPrice = Integer.parseInt(mreq.getParameter("goodsPrice"));
		String goodsCategory = mreq.getParameter("goodsCategory");
		String goodsContent = mreq.getParameter("goodsContent");
		Double goodsAlcohol = Double.parseDouble(mreq.getParameter("goodsAlcohol"));
		int goodsLiter = Integer.parseInt(mreq.getParameter("goodsLiter"));
		String soldout = mreq.getParameter("soldout");
		String empId = mreq.getParameter("empId");
		int hit = Integer.parseInt(mreq.getParameter("hit"));
		
		System.out.println(mreq+"<-- EmpGoodsModifyController");
		
		// 방어 코드
		String contentType = null;
		String originalFileName = null;
		String fileSystemName = null;			
		if(mreq.getContentType("goodsImg") != null) {
			// input type=file 바이너리 파일은 마임타입형태의 파일로 변환되어 upload폴더의 자동으로 저장
			contentType = mreq.getContentType("goodsImg");
			originalFileName = mreq.getOriginalFileName("goodsImg"); // 원본 파일 이름
			fileSystemName = mreq.getFilesystemName("goodsImg"); // 저장된 파일 이름
		}

		// 이미지 파일 검사

			Goods goods = new Goods();
			GoodsImg goodsImg = new GoodsImg();
			
			goods.setGoodsCode(goodsCode);
			goods.setGoodsName(goodsName);
			goods.setGoodsPrice(goodsPrice);
			goods.setGoodsCategory(goodsCategory);
			goods.setGoodsContent(goodsContent);
			goods.setGoodsAlcohol(goodsAlcohol);
			goods.setGoodsLiter(goodsLiter);
			goods.setSoldout(soldout);
			goods.setEmpId(empId);
			goods.setHit(hit);

			goodsImg.setGoodsCode(goodsCode);
			goodsImg.setFilename(fileSystemName);
			goodsImg.setOriginName(originalFileName);
			goodsImg.setContentType(contentType);
	
			/*
			System.out.println(goodsCode+"<-- 상품번호");		
			System.out.println(goodsName+"<-- 상품이름");		
			System.out.println(goodsPrice+"<-- 상품가격");		
			System.out.println(goodsCategory+"<-- 상품카테고리");		
			System.out.println(goodsContent+"<-- 상품설명");		
			System.out.println(goodsAlcohol+"<-- 상품도수");		
			System.out.println(goodsLiter+"<-- 상품용량");		
			System.out.println(soldout+"<-- 재고");
			
			System.out.println(fileSystemName+"<-- 파일이름");		
			System.out.println(originalFileName+"<-- 원본파일이름");		
			System.out.println(contentType+"<-- 파일컨텐츠타입");			
			*/
			
			GoodsService goodsService = new GoodsService();
			int row = goodsService.modifyGoods(goods, goodsImg, dir);
			if(row == 1) {
				System.out.println("수정성공");
		    	
		    	String msg = null;
		    	msg = URLEncoder.encode("게시글을 수정하였습니다.", "utf-8");
				
				// View
				response.sendRedirect(request.getContextPath()+"/emp/empGoodsOne?goodsCode="+goodsCode+"&msg="+msg);
			} else {
				System.out.println("수정실패");
		    	
		    	String msg = null;
		    	msg = URLEncoder.encode("게시글 수정에 실패하였습니다.", "utf-8");
		    	
		    	// View
				response.sendRedirect(request.getContextPath()+"/emp/empGoodsModify?goodsCode="+goodsCode+"&msg="+msg);
			}
		/*	
		} else {
			System.out.println("*.jpg, *.png파일만 업로드 가능");
			String msg = null;
	    	msg = URLEncoder.encode("jpg, png파일만 업로드 가능합니다.", "utf-8");
			File f = new File(dir+"\\"+mreq.getFilesystemName("itemImg"));
			if(f.exists()) {
				f.delete(); // 이미지가 아닌 파일이 업로드 되었기때문에 삭제
			}
			// View
			response.sendRedirect(request.getContextPath()+"/emp/empGoodsModify?goodsCode="+goodsCode);
			*/
		}
	}

