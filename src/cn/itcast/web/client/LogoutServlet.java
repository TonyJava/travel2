package cn.itcast.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if(session!=null){
			session.removeAttribute("user");
		}
		//���ԣ��汾����
		//ע���ɹ�������ȫ����Ϣ��ʾҳ�棬��ʾע���ɹ���Ϣ����������Ϣ��ʾҳ���3�����ת����ҳ
		request.setAttribute("message", "ע���ɹ�,���������3�����ת����ҳ������<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/index.jsp'>");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
