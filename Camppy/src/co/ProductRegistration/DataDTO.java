package co.ProductRegistration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.dao.DAO;
import co.yedam.vo.ItemVO;

public class DataDTO extends DAO {
	
	public List<ItemVO> getltemList(){
		connect();
		
		List<ItemVO> list = new ArrayList<>();
		String sql = "SELECT * FROM CAMPPY_ITEM order by 1";
		
		try {
			psmt =conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ItemVO vo = new ItemVO();
				vo.setI_num(rs.getInt("ITEM_NUM"));
				vo.setI_name(rs.getString("ITEM_NAME"));
				vo.setI_img(rs.getString("ITEM_IMAGE"));
				vo.setI_info(rs.getString("ITEM_INFORMATION"));
				vo.setCtgr(rs.getString("CATEGORI"));
				vo.setP_comp(rs.getString("PRODUCT_COMPANY"));
				vo.setP_cont(rs.getString("PRODUCT_CONTRY"));
				vo.setOri_p(rs.getString("ORIGIN_PRICE"));
				vo.setOff_p(rs.getString("OFF_PRICE"));
				vo.setStock(rs.getString("AV_STOCK"));
				list.add(vo);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ItemVO uploadFile(String i_name, String i_info, String i_img, String ctgr, 
							 String p_comp, String p_cont, String ori_p, String off_p, String stock) {

		
		connect();
		String sql = "insert into CAMPPY_ITEM values(CAMPPY_ITEM_SEQ.nextval,?,?,?,?,?,?,?,?,? )";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, i_name);
			psmt.setString(2, i_info);
			psmt.setString(3, i_img);
			psmt.setString(4, ctgr);
			psmt.setString(5, p_comp);
			psmt.setString(6, p_cont);
			psmt.setString(7, ori_p);
			psmt.setString(8, off_p);
			psmt.setString(9, stock);
			
			int r = psmt.executeUpdate();
			System.out.print(r + "건 입력완료");
			
			ItemVO vo = new ItemVO();
			vo.setI_name(i_name);
			vo.setI_info(i_info);
			vo.setI_img(i_img);
			vo.setCtgr(ctgr);
			vo.setP_comp(p_comp);
			vo.setP_cont(p_cont);
			vo.setOri_p(ori_p);
			vo.setOff_p(off_p);
			vo.setStock(stock);
			return vo;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return null;
		
	}

	
	
	
	
}
