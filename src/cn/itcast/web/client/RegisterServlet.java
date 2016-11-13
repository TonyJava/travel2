package cn.itcast.web.client;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.BusinessService;
import cn.itcast.service.impl.BusinessServiceImpl;
import cn.itcast.utils.WebUtils;
import cn.itcast.web.formbean.RegisterForm;

public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.���ύ�����ֶν��кϷ���У�飨�ѱ����ݷ�װ��formbean��
		RegisterForm form =  WebUtils.request2Bean(request, RegisterForm.class);
		boolean b = form.validate();
		
		//2.���У��ʧ�ܣ����ص���ҳ�棬����У��ʧ����Ϣ
		if(!b){
			request.setAttribute("form", form);   
			request.getRequestDispatcher("/client/register.jsp").forward(request, response);
			return;
		}
		
		//3.���У��ɹ��������service����ע������
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setId(UUID.randomUUID().toString());
		
		BusinessService service = new BusinessServiceImpl();
		try {
			service.registerUser(user);
			//6.���serivce����ɹ�����ת����վ��ȫ����Ϣ��ʾҳ�棬Ϊ�û�ע��ɹ�����Ϣ
			//�˴���������
			request.setAttribute("message", "ע��ɹ�,���������3�����ת����½ҳ�棬�������µ�¼<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/client/login.jsp'>");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (UserExistException e) {
			//�ؼ���������ͬ��ɵ�������֤Ψһ��
			
			//4.���serivce�����ɹ�,���Ҳ��ɹ���ԭ������Ϊע���û��Ѵ��ڵĻ��������ص�ע��ҳ�棬��ʾע���û��Ѵ��ڵ���Ϣ
			form.getErrors().put("username", "ע����û����Ѵ��ڣ���");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/client/register.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			//5.���serivce�����ɹ�,���Ҳ��ɹ���ԭ������������Ļ�����ת����վ��ȫ����Ϣ��ʾҳ�棬Ϊ�û���ʾ�Ѻô�����Ϣ
			e.printStackTrace();
			request.setAttribute("message", "����������δ֪���󣡣���");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
