package com.resBuilder.varsys;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resUtil.varsys.DbConnect;
/**
 * Servlet implementation class resServlet
 */
@WebServlet(description = "Resume Builder", urlPatterns = { "/resServlet" , "/resServlet.do"}, initParams = {@WebInitParam(name="id",value="1"),@WebInitParam(name="name",value="varSys")})
public class resServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		resModel res = new resModel();
		String name = request.getParameter("name");
		res.setName(name);
		String mail = request.getParameter("mail");
		res.setMail(mail);
		res.doSomething();
		//new DbConnect().queryDb("");
		request.setAttribute("res", res);
		if((name!=null)&&(mail!=null)) getServletContext().getRequestDispatcher("/jspView.jsp").forward(request, response);
		else getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}











//package com.resBuilder.varsys;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Date;
// 
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
///**
// * Servlet implementation class resServlet
// */
//@WebServlet(description = "Resume Builder", urlPatterns = { "/resServlet" , "/resServlet.do"}, initParams = {@WebInitParam(name="id",value="1"),@WebInitParam(name="name",value="varSys")})
//public class resServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    public static final String HTML_START="<html><body>";
//    public static final String HTML_END="</body></html>";
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public resServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        Date date = new Date();
//        out.println(HTML_START + "<h2>Hi There!</h2><br/><h3>Date="+ date +"</h3>"+HTML_END);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//}
