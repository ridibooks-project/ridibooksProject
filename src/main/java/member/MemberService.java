package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberService {
	int statusCode;
	
	// 로그인
	public int loginMember(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("login_id");
		String pw = request.getParameter("login_pw");
		String stay_login = request.getParameter("stay_login");
		
		// 검증코드 자바스크립트로? 여기서 구현?
		// 로그인할 때 검증할 것
		// 1. id, pw 값이 null 또는 공백인지
		// 패턴 확인은 로그인이니 할 필요 없음
		
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setPw(pw);
		
		MemberDAO dao = new MemberDAO();
		String db_Pw = dao.selectMember(member);
		
		if(db_Pw.equals(member.getPw())) {
			HttpSession session = request.getSession();
			
			session.setAttribute("isLogin", true);
			session.setAttribute("id", id);
			
			if(stay_login == null) {
				// 로그인상태유지 체크가 안되어 있었다면
				session.setMaxInactiveInterval(3600);	// 1시간
			} else {
				// 체크 되었다면
				session.setMaxInactiveInterval(3600 * 24 * 3);	// 3일
			}
			statusCode = HttpServletResponse.SC_CREATED;
		} else {
			statusCode = HttpServletResponse.SC_NOT_FOUND;
		}
		
		return statusCode;
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
