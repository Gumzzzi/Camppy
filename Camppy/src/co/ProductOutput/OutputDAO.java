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
	
	//텐트만 불러오고 싶음
	public List<ItemVO> getTentList(){
		connect();
			List<ItemVO> list = new ArrayList<>();
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select * from CAMPPY_ITEM where CATEGORI = '텐트'");
				while(rs.next()){
					ItemVO vo = new ItemVO();
					vo.setI_img(rs.getString("ITEM_IMAGE"));
					vo.setI_name(rs.getString("ITEM_NAME"));
					vo.setOri_p(rs.getString("ORIGIN_PRICE"));
					list.add(vo);
					
					
				}
				
				System.out.println("DAO" +list);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return list;
			
	}
	
	//침낭만 불러오고 싶음
		public List<ItemVO> getSleepingBagList(){
			connect();
				List<ItemVO> list = new ArrayList<>();
				try {
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select * from CAMPPY_ITEM where CATEGORI = '침낭'");
					while(rs.next()){
						ItemVO vo = new ItemVO();
						vo.setI_img(rs.getString("i_img"));
						vo.setI_name(rs.getString("i_name"));
						vo.setOri_p(rs.getString("ori_p"));
						list.add(vo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					disconnect();
				}
				return list;
				
		}

}
