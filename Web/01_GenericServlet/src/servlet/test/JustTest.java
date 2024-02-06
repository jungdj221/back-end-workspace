package servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JustTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int count = 0;
	
	private String name;

//    public JustTest() {
//
//    }


	public void init(ServletConfig config) throws ServletException {
		name = config.getInitParameter("name");
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<h2>name : " + name + "</h2>");
		pw.println("<h3>여기까지 온 경로 : html하고 xml에 action등록, sovlet은 controller 역할</h3>");
		pw.println();
	}


//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		doGet(request, response);
//	}

}
