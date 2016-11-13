package cn.itcast.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.service.BusinessService;
import cn.itcast.service.impl.BusinessServiceImpl;
import cn.itcast.utils.ServiceUtils;
public class UpdateUserServlet extends HttpServlet {
	BusinessService service = new BusinessServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String cellphone = request.getParameter("cellphone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String address = request.getParameter("address");
		User user = service.findUser(id);
		if(nickname != null){
			user.setNickname(nickname);
		}
		if(cellphone != null){
			user.setCellphone(cellphone);
		}
		if(address != null){
			user.setAddress(address);
		}
		if(username != null){
			user.setUsername(username);
		}
		if(password != null){
			password = ServiceUtils.md5(password);
			user.setPassword(password);
		}
		service.updateUser(user);
		//���ظ��º���û���Ϣ��session��
		request.getSession().setAttribute("user", user);	//����ʡ����һ�䣬session�����������ڣ����session����user���򲻻����´����ݿ���ȡֵ
		response.sendRedirect(request.getContextPath() + "/client/account.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
