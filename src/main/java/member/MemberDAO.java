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
	// ���� ����
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/maria/rdbooks");
			
			conn = ds.getConnection();
			
			return conn;
		} catch(NamingException e) {
//			e.printStackTrace();
			System.out.println("Connection Pool ���� ���� �߻�");
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("Conncetion ���� �߻�");
		}
		return null;
	}
	
	// db ���� ��ȸ
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
				// �α��� ������ ���
				HttpSession session = request.getSession();
				
				session.setAttribute("isLogin", true);
				session.setAttribute("id", id);
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				
			}
			rs.close();
			
		} catch(SQLException e) {
//			e.printStackTrace();
			System.out.println("SQL ����");
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
	
	// db ���� �߰�
	public boolean insertMember(MemberDTO member) {
		return false;
	}
	
	// db ���� ����
	public boolean updateMember(MemberDTO member) {
		return false;
	}
	
	// db ���� ����
	public boolean deleteMember(MemberDTO member) {
		return false;
	}

}
