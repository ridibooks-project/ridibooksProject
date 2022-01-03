package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/controller")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 정보 조회 - 로그인
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		int statusCode = service.loginMember(request, response);
		
		if(statusCode == 200) {
			// 로그인 성공했을 때
			response.sendRedirect("#");
		} else {
			// 로그인 실패했을 때(Not Found)
			response.sendRedirect("#");
		}
		
		
		
		
		
	}

	// 정보 추가 - 회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doGet(request, response);
		
	}
	
	// 정보 수정 - 회원정보 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 정보 삭제 - 회원탈퇴 ( update쓸것)
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
