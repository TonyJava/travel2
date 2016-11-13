package cn.itcast.web.formbean;

import java.util.HashMap;
import java.util.Map;

public class RegisterForm {
	
	private String username;
	private String password;
	private String password2;
	private Map errors = new HashMap();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	
	//�û����������䣬����Ϊ�գ�����Ҫ��һ����ʽ�Ϸ�������
	//���벻��Ϊ�գ�������3-8λ����
	//ȷ�����벻��Ϊ�գ�����Ҫ��һ��һ��
	public boolean validate(){
		boolean isOK = true;
		
		//�������䲻��Ϊ�գ�����Ҫ��һ����ʽ�Ϸ�������
		if(this.username==null || this.username.trim().equals("")){
			isOK = false;
			errors.put("username", "�û�������Ϊ�գ���");
		}else{
			// aaa@sina.com  aaa@sina.com.cn   aa_bb.cc@sina.com.cn
			//  \\w+@\\w+(\\.\\w+)+
			if(!this.username.matches("\\w+@\\w+(\\.\\w+)+")){
				isOK = false;
				errors.put("username", "�����ʽ���ԣ�����");
			}
		}
		
		//���벻��Ϊ�գ�������3-8λ����
		if(this.password==null || this.password.trim().equals("")){
			isOK = false;
			errors.put("password", "���벻��Ϊ�գ���");
		}else{
			if(!this.password.matches("\\d{3,8}")){
				isOK = false;
				errors.put("password", "�������Ҫ��3-8λ���֣���");
			}
		}
		
		//ȷ�����벻��Ϊ�գ�����Ҫ��һ��һ��
		if(this.password2==null || this.password2.trim().equals("")){
			isOK = false;
			errors.put("password2", "ȷ�����벻��Ϊ�գ���");
		}else{
			if(!this.password.equals(this.password2)){
				isOK = false;
				errors.put("password2", "��������Ҫһ�£���");
			}
		}
		
		
		return isOK;
	}
	
}
