package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Cart;
import cn.itcast.domain.Category;
import cn.itcast.domain.Order;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.Product;
import cn.itcast.domain.QueryInfo;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;

public interface BusinessService {

	/**************************************
	 * 
	 * ������صķ���
	 * 
	 **************************************/
	void addCategory(Category c);

	Category findCategory(String id);

	List getAllCategory();

	void deleteCategory(String id);
	/**************************************
	 * 
	 * ������صķ���
	 * 
	 **************************************/
	void addProduct(Product product);

	Product findProduct(String id);

	PageBean productPageQuery(QueryInfo info);

	List getAllProduct();

	void deleteProduct(String id);
	/**************************************
	 * 
	 * �û���صķ���
	 * 
	 **************************************/
	void addUser(User user);

	User findUser(String username, String password);

	User findUser(String id);
	void registerUser(User user) throws UserExistException;
	User loginUser(String username, String password);
	void updateUser(User user);
	/**************************************
	 * 
	 * ������صķ���
	 * 
	 **************************************/
	//�����Ǹ����û��Ĺ��ﳵ�����ɵģ�����������ܵ��ǹ��ﳵ������û�����
	void saveOrder(Cart cart, User user);

	//��ѯ����
	Order findOrder(String id);

	//�õ����ж���
	List getOrderByState(boolean state);
	//�õ��û��Լ������ж���
	List getOrderByUser(String id);
	//���¶���װ��
	void updateOrder(String id, boolean state);
	//ɾ������
	void deleteOrder(String id);
}