package co.ProductRegistration;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.vo.ItemVO;


@WebServlet("/AddFileServlet")
public class AddFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddFileServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ServletContext context = getServletContext();
		
		//저장폴더
		String saveDir = context.getRealPath("save");
		int maxSize = 1024*1024*30;
		String encoding =  "UTF-8";
		
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
				new DefaultFileRenamePolicy()); // 1. 요청정보 2. 저장할 폴더 위치 3.업로드할때 최대 파일사이즈 4.인코딩방식 5.re

		String i_name = multi.getParameter("i_name");
		String i_info = multi.getParameter("i_info");
		String i_img = multi.getFilesystemName("i_img");
		String ctgr = multi.getParameter("ctgr");
		String p_comp = multi.getParameter("p_comp");
		String p_cont = multi.getParameter("p_cont");
		String ori_p = multi.getParameter("ori_p");
		String off_p = multi.getParameter("off_p");
		String stock = multi.getParameter("stock");
		

		DataDTO dto = new DataDTO();
		ItemVO lv = dto.uploadFile(i_name, i_info, i_img, ctgr, p_comp, p_cont, ori_p, off_p, stock);
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().println(gson.toJson(lv));

		System.out.println(saveDir);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
