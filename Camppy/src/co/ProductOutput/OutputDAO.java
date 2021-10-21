package co.ProductOutput;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.dao.DAO;
import co.yedam.vo.ItemVO;

public class OutputDAO extends DAO {
	private static OutputDAO singleton = new OutputDAO();

	private OutputDAO() {

	}

	public static OutputDAO getInstance() {
		return singleton;
	}

	//List<ItemlVO> 에서 getTingList 함수를 선언해서
	//( Strung select 파라미터 변수값을 선언)
	public List<ItemVO> getThingList(String select) {
		
		//카테고리 라는 변수를 선언하고 값은 넣지 않는다.
		String category = "";
		
		//화면 주소 값이 Tent 라고 뜨면 "텐트" 가 포함된 DB에 담긴 값을 가져오고 그게 아니면 "침낭" 이 포함된값을 가지고 온다.
		//Tent 만 쓴 이유는 현재 프로젝트에서는 선택지가2가지라서 둘중하나이기 떄문에가 월래는 else if 를 써서 또 다른 선택지를 줘야한다.
		if (select.equals("Tent")) {
			category = "'텐트'"; //카테고리 안에 텐트 라는 단어를 넣는다("" 안에 '' 를 넣어줘야 텐트라는 글자를 가지고 쿼리문에 들어가서 작동이 된다.
		} else {
			category = "'침낭'";
		}
		connect();
		List<ItemVO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			//일반적인 쿼리문에서 조건을 넣었다 CATEGORI 란에서 category 에 들어있는값을 찾겠다~
			rs = stmt.executeQuery("select * from CAMPPY_ITEM where CATEGORI = " + category);
			while (rs.next()) {
				ItemVO vo = new ItemVO();
				//여기서는 화면출력 DAO 라서 필요한 "이미지","이름","가격" 만 호출한다.
				vo.setI_info(rs.getString("ITEM_INFORMATION"));
				vo.setI_name(rs.getString("ITEM_NAME"));
				vo.setOri_p(rs.getString("ORIGIN_PRICE"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;

	}

	

}
