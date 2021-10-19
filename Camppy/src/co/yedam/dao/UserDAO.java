package co.yedam.dao;

import java.sql.SQLException;
import java.util.List;

import co.yedam.vo.UserVO;

public class UserDAO extends DAO {

	private static UserDAO singleton = new UserDAO();

	private UserDAO() {
	}

	public static UserDAO getInstance() {
		return singleton;
	}

	public String login(String id, String pw) {
		connect();

		String sql = "select * from camppy_user where user_id=?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);

			rs = psmt.executeQuery();

			while (rs.next()) {
				if (id.equals(rs.getString("user_id"))) {
					if (pw.equals(rs.getObject("user_password"))) {
						return	id;
					}
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			disconnect();
		}
		return "해당 ID가 존재하지 않습니다";
	}

}