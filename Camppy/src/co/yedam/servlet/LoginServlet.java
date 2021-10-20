package co.yedam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.dao.UserDAO;
import co.yedam.vo.UserVO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().create();
		UserDAO dao = UserDAO.getInstance();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_password");
		
		/*
		 * System.out.println(nx); System.out.println(id); System.out.println(pw);
		 */
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		
		System.out.println(id);
		System.out.println(pw);
		
		String result = dao.login(vo.getId(), vo.getPw());

		System.out.println(result+" dao.login 결과");
		
		//System.out.println(dao.login(id, pw));
		if(result.equals(id)){
			Cookie c = new Cookie("loginUser", URLEncoder.encode(result,"UTF-8"));
			c.setMaxAge(24*60*60);
			c.setPath("path=/");
			response.addCookie(c);
			response.sendRedirect("http://localhost/Camppy/index.html");
		} else {
			response.sendRedirect("http://localhost/Camppy/login.html");
		}
		
//		out.println(result);
//		System.out.println(result);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
