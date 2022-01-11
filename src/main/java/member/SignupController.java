package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 회원가입 컨트롤러
@WebServlet("/signup/controller")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		MemberService service = new MemberService();
		int statusCode = service.joinMember(request, response);
		
		System.out.println(statusCode);
		
		if(statusCode == 201) {
			// 회원가입 성공했을 때
			response.sendRedirect("/ridibooksProject/html/index.html");
		} else if(statusCode == 400) {
			// 회원가입 실패했을 때
			response.sendRedirect("/ridibooksProject/account/signup.jsp");
		} else {
			// 회원가입 실패했을 때 - 404
			response.sendRedirect("/ridibooksProject/account/signup.jsp");
		}
	}
}
