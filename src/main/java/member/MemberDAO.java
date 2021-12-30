package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class MemberDAO {
	// 서버 접속
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/maria/rdbooks");
			
			conn = ds.getConnection();
			
			return conn;
		} catch(NamingException e) {
//			e.printStackTrace();
			System.out.println("Connection Pool 관련 예외 발생");
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("Conncetion 예외 발생");
		}
		return null;
	}
	
	// db 정보 조회
	public MemberDTO selectMember(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT * FROM memberinfo WHERE member_id = ? AND member_pw = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			ResultSet rs = pstmt.executeQuery();
			
			boolean isLogin = rs.next();
			
			if(isLogin) {
				// 로그인 성공한 경우
				HttpSession session = request.getSession();
				
				session.setAttribute("isLogin", true);
				session.setAttribute("id", id);
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				
			}
			rs.close();
			
		} catch(SQLException e) {
//			e.printStackTrace();
			System.out.println("SQL 예외");
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return ;
	}
	
	// db 정보 추가
	public boolean insertMember(MemberDTO member) {
		return false;
	}
	
	// db 정보 수정
	public boolean updateMember(MemberDTO member) {
		return false;
	}
	
	// db 정보 삭제
	public boolean deleteMember(MemberDTO member) {
		return false;
	}

}
