package com.duochuan.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");       
        String password = request.getParameter("password");          
            
        //服务器端打印信息    
        System.out.println("username=" + username);    
        System.out.println("password=" + password);    
        if(username!=null&&password!=null && username.equals("duochuan")&&password.equals("1234")){  
            //将数据存储在request对象中，传递给下一个servlet使用  
            request.setAttribute("username", username);  
            //进行数据的转发  
            RequestDispatcher dispatcher=request.getRequestDispatcher("Welcome");  
            dispatcher.forward(request, response);  
         
        }  
        else {  
            response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE,"用户名或密码错误");  
        } 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
