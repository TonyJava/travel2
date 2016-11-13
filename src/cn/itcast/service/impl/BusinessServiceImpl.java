package cn.itcast.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import cn.itcast.dao.CategoryDao;
import cn.itcast.dao.OrderDao;
import cn.itcast.dao.ProductDao;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.Cart;
import cn.itcast.domain.CartItem;
import cn.itcast.domain.Category;
import cn.itcast.domain.Order;
import cn.itcast.domain.OrderItem;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.Product;
import cn.itcast.domain.QueryInfo;
import cn.itcast.domain.QueryResult;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.factory.DaoFactory;
import cn.itcast.service.BusinessService;
import cn.itcast.utils.ServiceUtils;

public class BusinessServiceImpl implements BusinessService{

	private CategoryDao cdao = DaoFactory.getInstance().createDao(CategoryDao.class);
	private ProductDao pdao = DaoFactory.getInstance().createDao(ProductDao.class);
	private OrderDao odao = DaoFactory.getInstance().createDao(OrderDao.class);
	private UserDao udao = DaoFactory.getInstance().createDao(UserDao.class);
	
	/**************************************
	 * 
	 * ������صķ���
	 * 
	 **************************************/
	public void addCategory(Category c){
		cdao.add(c);
	}
	
	public Category findCategory(String id){
		return cdao.find(id);
	}
	
	public List getAllCategory(){
		return cdao.getAll();
	}
	
	public void deleteCategory(String id){
		cdao.delete(id);
	}
	/**************************************
	 * 
	 * ��Ʒ��صķ���
	 * 
	 **************************************/
	public void addProduct(Product product){
		pdao.add(product);
	}
	public Product findProduct(String id){
		return pdao.find(id);
	}
	public void deleteProduct(String id){
		pdao.delete(id);
	}
	
	public PageBean productPageQuery(QueryInfo info){
		QueryResult result = pdao.pageQuery(info.getStartindex(), info.getPagesize(), info.getWhere(), info.getQueryvalue());
		
		//��QueryResult��QueryInfo����һ��ҳ����ʾ��Ҫ��PageBean
		PageBean bean = new PageBean();
		bean.setCurrentpage(info.getCurrentpage());
		bean.setList(result.getList());
		bean.setPagesize(info.getPagesize());
		bean.setTotalrecord(result.getTotalrecord());
		
		return bean;
	}
	
	public List getAllProduct(){
		return pdao.getAll();
	}
	
	/**************************************
	 * 
	 * �û���صķ���
	 * 
	 **************************************/
	public void addUser(User user){
		udao.add(user);
	}
	
	public User findUser(String username,String password){
		return udao.find(username, password);
	}
	
	public User findUser(String id){
		return udao.find(id);
	}
	
	//Ϊweb���ṩע�����,�˷������ܻ����
	public void registerUser(User user) throws UserExistException{
		boolean b = udao.find2(user.getUsername());
		if(b){
			throw new UserExistException();
		}else{
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			udao.add(user);
		}
	}
	//Ϊweb���ṩ��½����,�˷������ܻ����
	public User loginUser(String username, String password){
		password = ServiceUtils.md5(password);
		return udao.find(username, password);
	}
	
	public void updateUser(User user){
		udao.update(user);
	}
	/**************************************
	 * 
	 * ������صķ���
	 * 
	 **************************************/
	//�����Ǹ����û��Ĺ��ﳵ�����ɵģ�����������ܵ��ǹ��ﳵ������û�����
	public void saveOrder(Cart cart,User user){
		Order order = new Order();
		order.setId(UUID.randomUUID().toString());
		order.setOrdertime(new Date());
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setUser(user);
		
		//����һ�����ϣ����ڱ������ж�����
		Set oitems = new HashSet();
		//�ù��ﳵ�еĹ��������ɶ�����
		Set<Map.Entry<String, CartItem>> set = cart.getMap().entrySet();
		for(Map.Entry<String, CartItem> entry : set){
			CartItem citem = entry.getValue();		//�õ�ÿһ��������
			OrderItem oitem = new OrderItem();		//��Ӧ������ÿһ��������
			//�ù��ﳵ�еĹ��������ɶ�����
			oitem.setProduct(citem.getProduct());
			oitem.setId(UUID.randomUUID().toString());
			oitem.setPrice(citem.getPrice());
			oitem.setQuantity(citem.getQuantity());
			
			oitems.add(oitem);
		}
		
		//��oitems���ϸ�order����
		order.setOrderitems(oitems);
		odao.add(order);
	}
	
	//��ѯ����
	public Order findOrder(String id){
		return odao.find(id);
	}
	
	//�õ����ж���
	public List getOrderByState(boolean state){
		return odao.getAll(state);
	}
	
	//�õ��û��Լ��Ķ���
	public List getOrderByUser(String id){
		return odao.orderByUser(id);
	}
	
	//���¶���
	public void updateOrder(String id,boolean state){
		odao.update(id, state);
	}
	//ɾ������
	public void deleteOrder(String id){
		odao.delete(id);
	}
}















