package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

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
	
	// db 정보 조회 - 로그인
	
	// 코드 수정 필요
	// 1. MemberService 로 가서 비밀번호를 체크하지 말고 여기서 체크하고
	//    체크 후 맞는지 아닌지 결과 값을 return
	// 2. 만약 비밀번호가 맞으면 db에서 해당 id의 login_date 값을 수정하는 코드 추가
	public boolean selectMember(MemberDTO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean login = false;
		
		String db_pw = "";
		String db_status = "";
		
		try {
			conn = getConnection();
			
			String sql = "SELECT member_pw, status FROM memberinfo WHERE member_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				db_pw = rs.getString("member_pw");
				db_status = rs.getString("status");
				
				if(db_status.equals("1")) {
					// db_status가 1 일 때 (회원상태가 정상 일 때)
					if(db_pw.equals(member.getPw())) {
						
						login = true;
						
						sql = "UPDATE memberinfo SET login_date = ?";
						
						PreparedStatement pstmt2 = conn.prepareStatement(sql);
						pstmt2.setTimestamp(1, Timestamp.valueOf(member.getLogin_date()));
						
						pstmt2.close();
					}
				}
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
		
		return login;
	}
	
	// db 정보 추가 - 회원가입
	public boolean insertMember(MemberDTO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean signup = false;
		
		try {
			conn = getConnection();
			
			String sql = "INSERT INTO memberinfo(member_id, member_pw, member_email, member_name, year, gender, marketing_agree, select_agree, signup_date) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getName());
			pstmt.setString(5, member.getYear());
			pstmt.setString(6, member.getGender());
			pstmt.setString(7, member.getMarketing_agree());
			pstmt.setString(8, member.getSelect_agree());
			pstmt.setTimestamp(9, Timestamp.valueOf(member.getSignup_date()));
			
			int count = pstmt.executeUpdate();
			
			signup = count == 1;
			
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
		
		return signup;
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
