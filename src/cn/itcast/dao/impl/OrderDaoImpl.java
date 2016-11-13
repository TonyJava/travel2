package cn.itcast.dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.OrderDao;
import cn.itcast.domain.Order;
import cn.itcast.domain.OrderItem;
import cn.itcast.domain.Product;
import cn.itcast.domain.User;
import cn.itcast.utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao{

	public void add(Order o){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into orders(id,ordertime,state,price,user_id) values(?,?,?,?,?)";
			Object params[] = {o.getId(),o.getOrdertime(),o.isState(),o.getPrice(),o.getUser().getId()};
			runner.update(conn, sql, params);
			
			//Set�����б���OrderItem����
			Set<OrderItem> set = o.getOrderitems();
			for(OrderItem item : set){
				sql = "insert into orderitem(id,quantity,price,product_id,order_id) values(?,?,?,?,?)";
				params = new Object[]{item.getId(),item.getQuantity(),item.getPrice(),item.getProduct().getId(),o.getId()};
				runner.update(conn, sql, params);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Order find(String id){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			//�ҳ���������Ϣ
			String sql = "select * from orders where id=?";
			//new ��װ��Order������ȥ
			Order order = (Order) runner.query(conn, sql, id, new BeanHandler(Order.class));
			
			//�ҳ�order�е�ÿһ��������
			sql = "select * from orderitem where order_id=?";
			//�����ǲ�ѯ��������������BeanListHandler��ÿһ�����ݽ���OrderItem
			//����һ��list���ϣ����list���ϱ����˶�������һ������orderitem������
			List<OrderItem> list = (List) runner.query(conn, sql, id, new BeanListHandler(OrderItem.class));
			//˼��������������ı��飬����Ҫ�������Ϣ�ҳ���
			for(OrderItem item : list){
				//һ�Զ�Ķ�����飬�ҳ�ÿһ���������������
				sql = "select * from orderitem oi,product p where oi.id=? and p.id=oi.product_id";
				//���ﴫ�ݵ��Ƕ������idֵ��һ���������Ӧһ����Ʒ�������ݷ�װ��Product�����У�
				//����һ��product���󣬱�ʾ��ѯ�����˶������Ӧ�Ĳ�Ʒ
				Product product = (Product) runner.query(conn, sql, item.getId(), new BeanHandler(Product.class));
				//�������Ϣ��item
				item.setProduct(product);
			}
			//��list�����а����������Ϣ��װ��Order������
			order.getOrderitems().addAll(list);
			
			
			//�ҳ��ջ��˵���Ϣ
			sql = "select * from orders o,user u where o.id=? and u.id=o.user_id";
			User user = (User) runner.query(conn, sql, id, new BeanHandler(User.class));
			//���û���Ϣ��װ����������Order��
			order.setUser(user);
			
			return order;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//����orderByUser����,����һ���û�id���õ�һ��order�����û�����ֻ�ܲ�ѯ���Լ��Ķ���
	public List<Order> orderByUser(String id){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			//�����û�id�����û���Ӧ�Ķ�����Ϣ
			String sql = "select * from orders where user_id=?";
			//��������Ϣ��װ��һ��list������
			List<Order> list = (List<Order>) runner.query(conn, sql, id, new BeanListHandler(Order.class));
			//�ҳ�ÿ�������Ķ�����
			return list;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * state:true: �ѷ���
	 * state:false: δ����
	 */
	public List<Order> getAll(boolean state){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from orders where state=?";
			List<Order> list = (List<Order>) runner.query(conn, sql, state, new BeanListHandler(Order.class));
			//�ҳ�ÿ�������Ķ�����
			for(Order o : list){
				sql = "select * from orders o,user u where o.id=? and u.id=o.user_id";
				User user = (User) runner.query(conn, sql, o.getId(), new BeanHandler(User.class));
				o.setUser(user);
			}
			
			return list;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(String id,boolean state){
		try{
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "update orders set state=? where id=?";
			Object params[] = {state,id};
			runner.update(conn,sql,params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(String id){
		try{
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "delete from orders where id=?";
			runner.update(conn, sql, id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}