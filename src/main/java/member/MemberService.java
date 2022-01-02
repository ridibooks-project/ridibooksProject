package member;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberService {
	int statusCode;
	
	// �α���
	public int loginMember(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("login_id");
		String pw = request.getParameter("login_pw");
		String stay_login = request.getParameter("stay_login");
		
		// �����ڵ� �ڹٽ�ũ��Ʈ��? ���⼭ ����?
		// �α����� �� ������ ��
		// 1. id, pw ���� null �Ǵ� ��������
		// ���� Ȯ���� �α����̴� �� �ʿ� ����
		
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
				// �α��λ������� üũ�� �ȵǾ� �־��ٸ�
				session.setMaxInactiveInterval(3600);	// 1�ð�
			} else {
				// üũ �Ǿ��ٸ�
				session.setMaxInactiveInterval(3600 * 24 * 3);	// 3��
			}
			statusCode = HttpServletResponse.SC_CREATED;
		} else {
			statusCode = HttpServletResponse.SC_NOT_FOUND;
		}
		
		return statusCode;
	}
	
	// ȸ������
	public int joinMember(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("sign_id");
		String pw = request.getParameter("sign_pw");
//		String pwChk = request.getParameter("sign_pwChk"); �����ڵ带 ��� ������ ���� ������ ���� ����
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
		
		return 0;
	}
	
	// ���� ����
	public int updateMember(HttpServletRequest request, HttpServletResponse response) {
		
		return 0;
	}
	
	// ȸ�� Ż��
	public int deleteMember(HttpServletRequest request, HttpServletResponse response) {
		
		return 0;
	}

}
