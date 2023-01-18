package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.NoticeService;
import vo.Emp;
import vo.Notice;
import vo.NoticeImg;


@WebServlet("/emp/empNoticeAdd")
public class EmpNoticeAddController extends HttpServlet {
	private NoticeService noticeService;
	
	//관리자 이벤트 추가 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null && session.getAttribute("authCode") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		Emp empId = (Emp) session.getAttribute("loginEmp");
		String empIdNow = empId.getEmpId();
		System.out.println(empId.getEmpId()+"<--- empNoticeModify empId 값");
		request.setAttribute("empIdNow", empIdNow);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empNoticeAdd.jsp").forward(request, response);
	}

	//관리자 이벤트 추가 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 프로젝트안 upload폴더의 실제 물리적 위치를 반환
		String dir = request.getServletContext().getRealPath("/upload");
		int maxFileSize = 1024 * 1024 * 100; // 100Mbyte
		
		// 업로드 폴더내 동일한 이름이 있으면 뒤에 숫자를 추가
		DefaultFileRenamePolicy fp = new DefaultFileRenamePolicy();
		MultipartRequest mreq = new MultipartRequest(request, dir, maxFileSize, "UTF-8", fp);
		
		String noticeTitle = mreq.getParameter("noticeTitle");
		String noticeContent = mreq.getParameter("noticeContent");
		int goodsCategory = Integer.parseInt(mreq.getParameter("goodsCategory"));
		String empId = mreq.getParameter("empId");	
	
		// input type=file 바이너리 파일은 마임타입형태의 파일로 변환되어 upload폴더의 자동으로 저장
		String contentType = mreq.getContentType("noticeImg");
		String originalFileName = mreq.getOriginalFileName("noticeImg"); // 원본 파일 이름
		String fileSystemName = mreq.getFilesystemName("noticeImg"); // 저장된 파일 이름
		System.out.println(mreq+"<-- EmpNoticeAddController");
		
		// 이미지 파일 검사
		if(contentType.equals("image/jpeg") || contentType.equals("image/png")) {
			Notice notice = new Notice();
			NoticeImg noticeImg = new NoticeImg();	

			notice.setNoticeTitle(noticeTitle);
			notice.setNoticeContent(noticeContent);
			notice.setGoodsCategory(goodsCategory);
			notice.setEmpId(empId);
			System.out.println(notice+"<-- EmpNoticeAddController 이벤트");
			
			noticeImg.setFilename(fileSystemName);
			noticeImg.setOriginName(originalFileName);
			noticeImg.setContentType(contentType);
			System.out.println(noticeImg+"<-- EmpNoticeAddController 이벤트이미지");	
			
			NoticeService noticeService = new NoticeService();
			noticeService.addNotice(notice, noticeImg, dir);
			
			/*
			// 디버깅 코드
			System.out.println("문자열 매개값 : ");
			System.out.println("이벤트 제목 : " + noticeTitle);
			System.out.println("이벤트 내용 : " + noticeContent);
			System.out.println("카테고리 : " + goodsCategory);
			System.out.println("직원아이디 : " + empId);

			
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
		*/
			
		// View
		response.sendRedirect(request.getContextPath()+"/emp/empNoticeList");
		}
	}
}