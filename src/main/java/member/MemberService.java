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
		boolean login = dao.selectMember(member);
		
		if(login) {
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
			statusCode = HttpServletResponse.SC_OK;
		} else {
			statusCode = HttpServletResponse.SC_NOT_FOUND;
		}
		
		return statusCode;
	}
	
	// 회원가입
	public int joinMember(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("sign_id");
		String pw = request.getParameter("sign_pw");
//		String pwChk = request.getParameter("sign_pwChk"); 검증코드를 어디서 쓸지에 따라 삭제할 수도 있음
		String email = request.getParameter("sign_email");
		String name = request.getParameter("sign_name");
		String year = request.getParameter("sign_year");
		String gender = request.getParameter("sing_gender");
		String marketing_agree = request.getParameter("marketing_agree");
		String select_agree = request.getParameter("select_agree");
		
		if(marketing_agree == null) {
			marketing_agree = "N";
		} else {
			marketing_agree = "Y";
		}
		if(select_agree == null) {
			select_agree = "N";
		} else {
			select_agree = "Y";
		}
		
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		member.setName(name);
		member.setYear(year);
		member.setGender(gender);
		member.setMarketing_agree(marketing_agree);
		member.setSelect_agree(select_agree);
		
		MemberDAO dao = new MemberDAO();
		boolean signup = dao.insertMember(member);
		
		if(signup) {
			// 회원가입 성공 201
			statusCode = HttpServletResponse.SC_CREATED;
		} else {
			// 회원가입 실패
			// 근데 id 입력하면서 중복 확인하고 이메일 입력하면서 중복확인하면
			// 실패할 이유가 있을까
			// 또 이렇게 하려면 id중복확인 dao, 이메일확인 dao를 따로 만들어야 하는가
			statusCode = HttpServletResponse.SC_NOT_FOUND;
		}
		
		return statusCode;
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
