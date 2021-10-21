package co.yedam.dao;

import java.sql.SQLException;

public class SignDAO extends DAO {
	
	public String sign(String id, String pw, String email, String pnum) {
		connect();
		
		String eid = id;
		
		String sql = "select * from camppy_user where user_id=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, eid);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				System.out.println("id가 존재합니다");
			} else {
				System.out.println("id 체크 통과");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		sql = "insert into camppy_user values(?,?,sysdate,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, eid);
			psmt.setString(2, pw);
			psmt.setString(3, email);
			psmt.setString(4, pnum);
			
			int a = psmt.executeUpdate();
			
			if(a==1) {
				return id;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "문제가 발생했습니다";
		} finally {
			disconnect();
		}
			
		return id;
	}

}
