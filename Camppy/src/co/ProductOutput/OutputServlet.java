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
		//여기서는 넘겨받을 정보에 따라서 값이 다르기 떄문에 넘겨받아질 부모값을 정한다. 그값은 'check'
		String check = request.getParameter("check");
		OutputDAO dao = OutputDAO.getInstance();
		Gson gson = new GsonBuilder().create();
		
		//OutputDAO 안에 있는 필요한 변수 를 호출해와서 위에 선언된 넘겨받을부모값을 변수로 집어넣어서 그값을 listvo 안에 집어 넣었다.
		List<ItemVO> listvo = dao.getThingList(check);
		out.println(gson.toJson(listvo));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
