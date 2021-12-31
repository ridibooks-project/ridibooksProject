package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
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
		
		return member_pw;
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
