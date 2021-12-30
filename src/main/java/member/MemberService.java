package member;

import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberService {
	
	// 로그인
	public int getMemberById(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("login_id");
		String pw = request.getParameter("login_pw");
		String stay_login = request.getParameter("stay_login");
		
		
		// 검증코드 자바스크립트로?
		
		
		return 0;
	}
	
	// 회원가입
	public int joinMember(HttpServletRequest request, HttpServletResponse response) {
//		String id = request.getParameter("sign_id");
//		String pw = request.getParameter("sign_pw");
//		String pwChk = request.getParameter("sign_pwChk");
//		String email = request.getParameter("sign_email");
//		String name = request.getParameter("sign_name");
//		String year = request.getParameter("sign_year");
//		String gender = request.getParameter("sing_gender");
//		String marketing = request.getParameter("marketing_agree");
//		String select_agree = request.getParameter("select_agree");
		
		return 0;
	}
	
	// 정보 수정
	public int updateMember(HttpServletRequest request, HttpServletResponse response) {
		
		return 0;
	}
	
	// 회원 탈퇴
	public int deleteMember(HttpServletRequest request, HttpServletResponse response) {
		
		return 0;
	}

}
