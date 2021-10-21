package co.ProductOutput;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.vo.ItemVO;

@WebServlet("/OutputServlet")
public class OutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OutputServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		String check = request.getParameter("check");
		
		System.out.println("check"+check);
		
		OutputDAO dao = OutputDAO.getInstance();
		Gson gson = new GsonBuilder().create();

		if (check.equals("Tent")) {
			System.out.println(check);
			System.out.println("현재 텐트 페이지 입니다");
			List<ItemVO> listvo = dao.getTentList();
			System.out.println(listvo);
			System.out.println("gson" + (gson.toJson(listvo)) );
			out.println(gson.toJson(listvo));
			

			
			
			
		} else if (check.equals("SleepingBag")) {
			System.out.println("침낭 페이지 입니다");
			List<ItemVO> listvo = dao.getSleepingBagList();
			out.println(gson.toJson(listvo));

		} else if (check == null) {
			out.println("Null 값이 넘어왔습니다.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
