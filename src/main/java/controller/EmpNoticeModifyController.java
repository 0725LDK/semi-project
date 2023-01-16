package controller;

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


import service.NoticeService;
import vo.Notice;
import vo.NoticeImg;



@WebServlet("/emp/empNoticeModify")
public class EmpNoticeModifyController extends HttpServlet {
	
	//이벤트 수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		NoticeService noticeService = new NoticeService();
		
		int noticeCode = 0;
		// 방어코드
		if(request.getParameter("noticeCode") != null){
			noticeCode = Integer.parseInt(request.getParameter("noticeCode"));
			System.out.println("goodsCode : " + noticeCode);
		} 
		map = noticeService.getNoticeOne(noticeCode);
		
		request.setAttribute("map", map);		
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empNoticeModify.jsp").forward(request, response);
	}

	//이벤트 수정 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 프로젝트안 upload폴더의 실제 물리적 위치를 반환
		String dir = request.getServletContext().getRealPath("/upload");
		int maxFileSize = 1024 * 1024 * 100; // 100Mbyte
		
		// 업로드 폴더내 동일한 이름이 있으면 뒤에 숫자를 추가
		DefaultFileRenamePolicy fp = new DefaultFileRenamePolicy();
		MultipartRequest mreq = new MultipartRequest(request, dir, maxFileSize, "UTF-8", fp);
		
		int noticeCode = Integer.parseInt(mreq.getParameter("noticeCode"));
		String noticeTitle = mreq.getParameter("noticeTitle");
		String noticeContent = mreq.getParameter("noticeContent");
		String empId = mreq.getParameter("empId");
		System.out.println(mreq+"<-- EmpNoticeModifyController");
		
		// 방어 코드
		String contentType = null;
		String originalFileName = null;
		String fileSystemName = null;			
		if(mreq.getContentType("noticeImg") != null) {
			// input type=file 바이너리 파일은 마임타입형태의 파일로 변환되어 upload폴더의 자동으로 저장
			contentType = mreq.getContentType("noticeImg");
			originalFileName = mreq.getOriginalFileName("noticeImg"); // 원본 파일 이름
			fileSystemName = mreq.getFilesystemName("noticeImg"); // 저장된 파일 이름
		}

		// 이미지 파일 검사

			Notice notice = new Notice();
			NoticeImg noticeImg = new NoticeImg();
			
			notice.setNoticeCode(noticeCode);
			notice.setNoticeTitle(noticeTitle);

			notice.setNoticeContent(noticeContent);
			notice.setEmpId(empId);

			noticeImg.setNoticeCode(noticeCode);
			noticeImg.setFilename(fileSystemName);
			noticeImg.setOriginName(originalFileName);
			noticeImg.setContentType(contentType);
	
			
			System.out.println(noticeCode+"<-- 이벤트번호");		
			System.out.println(noticeTitle+"<-- 이벤트제목");			
			System.out.println(noticeContent+"<-- 이벤트내용");		
			System.out.println(empId+"<-- 직원");		
		
			System.out.println(fileSystemName+"<-- 파일이름");		
			System.out.println(originalFileName+"<-- 원본파일이름");		
			System.out.println(contentType+"<-- 파일컨텐츠타입");			
			
			
			NoticeService noticeService = new NoticeService();
			int row = noticeService.modifyNotice(notice, noticeImg, dir);
			if(row == 1) {
				System.out.println("수정성공");
		    	
		    	String msg = null;
		    	msg = URLEncoder.encode("게시글을 수정하였습니다.", "utf-8");
				
				// View
				response.sendRedirect(request.getContextPath()+"/emp/empNoticeOne?noticeCode="+noticeCode+"&msg="+msg);
			} else {
				System.out.println("수정실패");
		    	
		    	String msg = null;
		    	msg = URLEncoder.encode("게시글 수정에 실패하였습니다.", "utf-8");
		    	
		    	// View
				response.sendRedirect(request.getContextPath()+"/emp/empNoticeModify?noticeCode="+noticeCode+"&msg="+msg);
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
			response.sendRedirect(request.getContextPath()+"/emp/empGoodsModify?goodsCode="+noticeCode);
			*/
		}
	}