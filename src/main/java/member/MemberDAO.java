package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
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
	public String selectMember(MemberDTO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String member_pw = "";
		
		try {
			conn = getConnection();
			
			String sql = "SELECT member_pw FROM memberinfo WHERE member_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member_pw = rs.getString("member_pw");
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
		
		return member_pw;
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
