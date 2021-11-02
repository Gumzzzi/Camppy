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

import co.yedam.dao.SignDAO;
import co.yedam.vo.UserVO;

/**
 * Servlet implementation class SignServlet
 */
@WebServlet("/SignServlet")
public class SignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().create();
		SignDAO dao = new SignDAO();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		String email = request.getParameter("email");
		String pnum = request.getParameter("pnum");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setEmail(email);
		vo.setPn(pnum);
		
		System.out.println(id+", "+pw+", "+email+", "+pnum);

		String result = dao.sign(vo.getId(),vo.getPw(),vo.getEmail(),vo.getPn());
		
		System.out.println(result+" dao.sign 결과");
		
		if(result.equals(id)) {
			out.println(gson.toJson(vo.getId()));
		}
		else {
			out.println("중북된 id가 존재합니다");
		}
	
		
		
		
		
//		if(result.equals(id)) {
//			Cookie c = new Cookie("loginUser", URLEncoder.encode(result,"UTF-8"));
//			c.setMaxAge(3*60*60);
//			c.setPath("path=/");
//			response.addCookie(c);
//			response.sendRedirect("http://localhost/Camppy/index.html");
//		} else {
//			response.sendRedirect("http://localhost/Camppy/login.html");
//		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
