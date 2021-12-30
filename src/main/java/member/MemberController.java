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

	// ��ȸ - �α��� ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		int statusCode = service.getMemberById(request, response);
		
		response.setStatus(statusCode);
	}

	// ���� - ȸ������
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// ������Ʈ - ���� ��
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// ���� - ȸ��Ż��
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
