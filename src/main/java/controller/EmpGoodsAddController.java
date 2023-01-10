package controller;

import java.io.File;
import java.io.IOException;
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


@WebServlet("/emp/empGoodsAdd")
public class EmpGoodsAddController extends HttpServlet {
	private GoodsService empGoodsService;
	
	//상품등록 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 
		 * 로그인 넣기
		 */
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empGoodsAdd.jsp").forward(request, response);
	}

	//상품등록 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 프로젝트안 upload폴더의 실제 물리적 위치를 반환
		String dir = request.getServletContext().getRealPath("/upload");
		int maxFileSize = 1024 * 1024 * 100; // 100Mbyte
		
		// 업로드 폴더내 동일한 이름이 있으면 뒤에 숫자를 추가
		DefaultFileRenamePolicy fp = new DefaultFileRenamePolicy();
		MultipartRequest mreq = new MultipartRequest(request, dir, maxFileSize, "UTF-8", fp);
		
		String goodsCategory = mreq.getParameter("goodsCategory");
		String goodsName = mreq.getParameter("goodsName");
		int goodsPrice = Integer.parseInt(mreq.getParameter("goodsPrice"));
		String goodsContent = mreq.getParameter("goodsContent");
		String empId = mreq.getParameter("empId");
		int  hit = Integer.parseInt(mreq.getParameter("hit"));
		
		// input type=file 바이너리 파일은 마임타입형태의 파일로 변환되어 upload폴더의 자동으로 저장
		String contentType = mreq.getContentType("goodsImg");
		String originalFileName = mreq.getOriginalFileName("goodsImg"); // 원본 파일 이름
		String fileSystemName = mreq.getFilesystemName("goodsImg"); // 저장된 파일 이름
		
		// 이미지 파일 검사
		if(contentType.equals("image/jpeg") || contentType.equals("image/png")) {
			Goods goods = new Goods();
			GoodsImg goodsImg = new GoodsImg();
			
			goods.setGoodsCategory(goodsCategory);
			goods.setGoodsName(goodsName);
			goods.setGoodsPrice(goodsPrice);
			goods.setGoodsContent(goodsContent);
			goods.setEmpId(empId);
			goods.setHit(hit);
			
			goodsImg.setFilename(fileSystemName);
			goodsImg.setOriginName(originalFileName);
			goodsImg.setContentType(contentType);
			
			GoodsService goodsService = new GoodsService();
			goodsService.addGodds(goods, goodsImg, dir);
			
			// 디버깅 코드
			System.out.println("문자열 매개값 : ");
			System.out.println("상품 종류 : " + goodsCategory);
			System.out.println("상품 이름 : " + goodsName);
			System.out.println("상품 가격 : " + goodsPrice);
			System.out.println("상품 내용 : " + goodsContent);
			System.out.println("직원 아이디 : " + empId);
			System.out.println("히트 : " + hit);
			
			System.out.println("파일 매개값 : ");
			System.out.println("파일이름 : " + fileSystemName);
			System.out.println("원본 파일 이름 : " + originalFileName);
			System.out.println("파일 컨텐츠 타입 : " + contentType);
		} else {
			System.out.println("*.jpg, *.png파일만 업로드 가능");
			File f = new File(dir+"\\"+mreq.getFilesystemName("itemImg"));
			if(f.exists()) {
				f.delete(); // 이미지가 아닌 파일이 업로드 되었기때문에 삭제
			}
		}
		
		// View
		response.sendRedirect(request.getContextPath()+"/emp/empGoodsList");
	}

}