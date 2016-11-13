package cn.itcast.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.service.BusinessService;
import cn.itcast.service.impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		BusinessService service = new BusinessServiceImpl();
		User user = service.loginUser(username, password);
		if(user!=null){
			//�˴��ǳ���Ҫ��һ����¼�����û���Ϣ���ص�session�У�֮�����ֱ����EL���ʽȡֵ
			request.getSession().setAttribute("user", user);
			//���û���½�ɹ�����ת��ҳ 
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		
		request.setAttribute("error_login", "�û������������!!!");   
		request.getRequestDispatcher("/client/login.jsp").forward(request, response);
		return;
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
