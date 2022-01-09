package member;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberService {
	
	// 리턴할 http 응답코드 - 기본값으로 입력 값이 없거나, 패턴가 맞지 않을 때의 응답코드로 지정
	int statusCode = 400;
	
	// 로그인
	public int loginMember(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("login_id");
		String pw = request.getParameter("login_pw");
		String stay_login = request.getParameter("stay_login");
		
		// 아이디 또는 비밀번호가 null일 경우
		if(id == null || pw == null) {
			
			statusCode = HttpServletResponse.SC_BAD_REQUEST;
			
			return statusCode;
		}
		
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
		String gender = request.getParameter("sign_gender");
		String marketing_agree = request.getParameter("marketing_agree");
		String select_agree = request.getParameter("select_agree");
		
		// 이럴 필요 없이 html에서 value값을 넣으면 체크 시 value값이 넘어오지 않을까 - 추후 확인 후 변경해볼 것
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
		
		LocalDateTime ldt = LocalDateTime.now();
		
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		member.setName(name);
		member.setYear(year);
		member.setGender(gender);
		member.setMarketing_agree(marketing_agree);
		member.setSelect_agree(select_agree);
		member.setSignup_date(ldt);
		
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
		
		// 어차피 로그인을 해야 마이리디 페이지에 접속 가능하니 로그인 상태를 확인하는 코드는 필요 없을 듯
		// 그럼 회원상태가 정상이 아니면 로그인도 안되게 할 거니 회원상태 확인하는 코드도 필요 없을지도
//		HttpSession session = request.getSession();
//		
//		boolean isLogin = (boolean) session.getAttribute("isLogin");
//		
//		if(isLogin) {
//			
//		}
		
		HttpSession session = request.getSession();
		
		// 로그인할 때 id 값을 세션에 저장했으니 불러와서 저장
		String loginId = (String) session.getAttribute("id");
		
		String delete_pwChk = request.getParameter("delete_pwChk");
		
		MemberDTO member = new MemberDTO();
		member.setId(loginId);
		member.setPwChk(delete_pwChk);
		
		MemberDAO dao = new MemberDAO();
		boolean delete = dao.deleteMember(member);
			
		if(delete) {
			statusCode = HttpServletResponse.SC_OK;
				
			// 회원탈퇴하면 로그아웃 되게 만들기 - 세션 제거 뭐가 좋을지 찾아보기
			// 해당 세션의 값 삭제
			session.removeAttribute("isLogin");
			session.removeAttribute("id");
				
			// 세션 전체 제거
//			session.invalidate();
		}
		return statusCode;
	}

}
