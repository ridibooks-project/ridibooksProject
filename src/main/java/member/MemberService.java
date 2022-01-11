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
		
		// 아이디 또는 비밀번호가 null이거나 공백일경우
		if( (id.isEmpty() || id == null) || (pw.isEmpty() || pw == null) ) {
			
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
		String pwChk = request.getParameter("sign_pwChk"); // 검증코드를 어디서 쓸지에 따라 삭제할 수도 있음
		String email = request.getParameter("sign_email");
		String name = request.getParameter("sign_name");
		String year = request.getParameter("sign_year");
		String gender = request.getParameter("sign_gender");
		String marketing_agree = request.getParameter("marketing_agree");
		String select_agree = request.getParameter("select_agree");

		
		// ----- 아이디 패턴 확인
		// 5~20자 영문/숫자 입력
		String idPattern = "^.*(?=.*[0-9])(?=.*[a-zA-Z])(?=^.{5,20}$).*$";
		if(!id.matches(idPattern)) {
			return statusCode = HttpServletResponse.SC_BAD_REQUEST;
		}
		// ----- 아이디 패턴 확인
		
		
		// ----- 비밀번호 패턴확인
		// 비닐번호 패턴 - 8자 이상, 영문/숫자/특수문자 중 2가지 이상 포함
		// 패턴1 - 숫자/영문/특수문자 모두 포함 8자 이상
		String pwPattern1 = "^.*(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!?@#$%^&*])(?=^.{8,}$).*$";	
		// 패턴2 - 숫자/영문 포함 8자 이상
		String pwPattern2 = "^.*(?=.*[0-9])(?=.*[a-zA-Z])(?=^.{8,}$).*$";
		// 패턴3 - 숫자/특수문자 포함 8자 이상
		String pwPattern3 = "^.*(?=.*[0-9])(?=.*[!?@#$%^&*])(?=^.{8,}$).*$";
		// 패턴4 - 영문/특수문자 포함 8자 이상
		String pwPattern4 = "^.*(?=.*[a-zA-Z])(?=.*[!?@#$%^&*])(?=^.{8,}$).*$";
		
		// 패턴 1~4 모두 아닐경우 리턴 (4중 하나라도 맞으면 통과)
		if(!pw.matches(pwPattern1) && !pw.matches(pwPattern2) && !pw.matches(pwPattern3) && !pw.matches(pwPattern4) ) {
			return statusCode = HttpServletResponse.SC_BAD_REQUEST;
		}
		// ----- 비밀번호 패턴확인
		
		
		// ----- 비밀번호 입력 확인
		if(!pw.equals(pwChk)) {
			return statusCode = HttpServletResponse.SC_BAD_REQUEST;
		}
		// ----- 비밀번호 입력 확인
		
		
		// ----- 이메일 패턴 확인
		// 나중에 좀더 정확하게 확인가능한 패턴으로 변경할 것
		String emailPattern = "^[a-zA-Z0-9]*@[a-zA-Z]*+.[a-zA-Z]([.a-zA-Z]).*$";
		if(!email.matches(emailPattern)) {
			return statusCode = HttpServletResponse.SC_BAD_REQUEST;
		}
		// ----- 이메일 패턴 확인
		
		
		// ----- 이름 패턴 확인
		// 2글자 이상의 한글,영어
		String namePattern = "^.*(?=.*[가-힣a-zA-Z])(?=^.{2,}$).*$";
		if(!name.matches(namePattern)) {
			return statusCode = HttpServletResponse.SC_BAD_REQUEST;
		}
		// ----- 이름 패턴 확인
		
		
		// ----- 생년월일 확인 -> 공백 입력 시 null 처리
		year.replaceAll(" ", "");
		if(year.isEmpty() || year == null) {
			year = "0000";
		}
		// ----- 생년월일 확인
		
		
		// ----- 성별 확인
		gender.replaceAll(" ", "");
		if(!gender.equals("M") || !gender.equals("F")) {
			gender = "None";
		}
		
		// ----- 성별 확인
		
		
		// ----- 선택동의 값 설정
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
		// ----- 선택동의 값 설정
		
		
		// 가입날짜 입력을 위해 현재시간 불러오기
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
	
	// 아이디 찾기
	public int findId(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("find_email");
		
		// 받은 이메일이 비어있거나 null일 경우
		if(email.isEmpty() || email == null) {
			
			statusCode = HttpServletResponse.SC_BAD_REQUEST;
			
			return statusCode;
		}
		
		MemberDTO member = new MemberDTO();
		member.setEmail(email);
		
		MemberDAO dao = new MemberDAO();
		String findId = dao.findId(member);
		
		if(findId.isEmpty() || findId == null) {
			// 찾아온 아이디가 없을 때
			statusCode = HttpServletResponse.SC_NOT_FOUND;
		} else {
			// 있을 때
			statusCode = HttpServletResponse.SC_OK;
			
			HttpSession session = request.getSession();
			
			session.setAttribute("findId", findId);
		}
		
		return statusCode;
	}
	
	// 비밀번호 찾기
	public int findPw(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("find_id");
		String email = request.getParameter("find_email");
		
		// 전달 받은 값이 공백이거나 null일 경우
		if( (id.isEmpty() || id == null) || (email.isEmpty() || email == null) ) {
			statusCode = HttpServletResponse.SC_BAD_REQUEST;
			
			return statusCode;
		}
		
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setEmail(email);
		
		MemberDAO dao = new MemberDAO();
		boolean findPw = dao.findPw(member);
		
		
	
		return 0;
	}

}
