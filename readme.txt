1.�����
	1.1��������
		mysql����
		dbutils��ܣ���jdbc���룩
		c3p0���ӳأ�������ݿ�ķ������ܣ�
		beanutils����������ݷ�װ��javabean�У�
		log4j����beanutils���ʹ�ã�
		commons fileupload������ͼƬ�ϴ���
		commons io������ͼƬ�ϴ���
		jstl��������el���ʽ��
		
	1.2������֯����İ�
		cn.itcast.domain
		cn.itcast.dao
		cn.itcast.dao.impl
		cn.itcast.service
		cn.itcast.service.impl
		cn.itcast.web.client
		cn.itcast.web.manager
		cn.itcast.utils
		cn.itcast.filter
		cn.itcast.factory
		junit.test
		
		������֯jsp��Ŀ¼(��Ϊǰ̨�ͺ�̨��������jsp):
		��WebContent���½�managerĿ¼�������̨��ص�jsp
		1.��WebContent���½�manager.jspҳ�棬���ҳ������̨��ҳ�����ҳ���Ǹ�����ҳ�棬�������£�
		<frameset rows="18%,*">
		 	<frame src="${pageContext.request.contextPath }/manager/head.jsp">
		 	<frameset  cols="15%,*">
		  		<frame src="${pageContext.request.contextPath }/manager/left.jsp" name="left">
		 		<frame src="#" name="right">
			</frameset>
		 </frameset>
		
		2.��WebContent���½�clientĿ¼������ǰ̨��ص�jsp
		
		3.������������Ŀ�
		create database travelstore;
		use travelstore;
		
		4.����һЩȫ�ֵĹ�����͹�����
		JdbcUtils���������ݿ⣩
		WebUtils����ǰ̨��ȡ�������ݷ�װ��bean����ȥ��
		CharacterEncodingFilter����������������⣩
		HtmlFilter��html����ת�壩
		TransActionFilter����д�����������ͳһ��������
		DaoFactory������dao������dao�ӿ�ʵ��ʱ��
		
		�ڹ��������д���JdbcUtils��,�������ݿ�����Ӱ󶨵���ǰ�߳�,�ύ������ر�����
		�ڹ��������д���WebUtils���������д���request2Bean(HttpServletRequest request,Class<T> beanClass){}����������ǰ̨��ȡ�������ݷ�װ��bean��
		public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass){
			try{
				
				T bean = beanClass.newInstance();
				Map map = request.getParameterMap();
				BeanUtils.populate(bean, map);
				return bean;
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		�ڹ��������д���CharacterEncodingFilter���������������������������������
		public class CharacterEncodingFilter implements Filter {
			public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException {
				//�϶��ͻ���������post������
				HttpServletRequest request = (HttpServletRequest) req;
				HttpServletResponse response = (HttpServletResponse) resp;
				request.setCharacterEncoding("UTF-8");
				chain.doFilter(request, response);
				//���ˣ������ȫվ��������
			}
			public void destroy() {
				// TODO Auto-generated method stub
			}
			public void init(FilterConfig filterConfig) throws ServletException {
				// TODO Auto-generated method stub
			}
		}
		��web.xml�ļ������ù�����
		<filter>
	    	<filter-name>CharacterEncodingFilter</filter-name>
	    	<filter-class>cn.itcast.filter.CharacterEncodingFilter</filter-class>
	  	</filter>
		<filter-mapping>
			<filter-name>CharacterEncodingFilter</filter-name>
		   	<url-pattern>/*</url-pattern>
		</filter-mapping>
		
		�ڹ��������д���HtmlFilter���������������html����ת��
		�����ԡ�����
		��web.xml�ļ������ù�����
		<filter>
		    <filter-name>HtmlFilter</filter-name>
		    <filter-class>cn.itcast.filter.HtmlFilter</filter-class>
		</filter>
		<filter-mapping>
		    <filter-name>HtmlFilter</filter-name>
		    <url-pattern>/*</url-pattern>
		</filter-mapping>
		
		�ڹ��������д���TransActionFilter������������������ˣ�ͳһ��������
		��web.xml�ļ������ù�����
		<filter>
		    <filter-name>TransActionFilter</filter-name>
		    <filter-class>cn.itcast.filter.TransActionFilter</filter-class>
		</filter>
		<filter-mapping>
		    <filter-name>TransActionFilter</filter-name>
		    <url-pattern>/*</url-pattern>
		</filter-mapping>
		
		ȥJdbcUtils��д��Ӧ�ķ����������߳�
		
		����ڹ��������½������࣬����dao������dao�ӿ�ʵ��ʱ����
		�ڹ��������½�dao.properties�����ļ�,����д�ӿڰ��������𱻽ӿڵ���
		
		��������ǵػ��Թ�������ʵ��ͱ��޹أ��������ľ������ʵ�壬���dao�����service�����web
2.���ʵ��
	Category	�����࣬���㣬�Ƶ꣬��ʳ�ȣ�
		private String id;
		private String name;
		private String description;
		
	Product	�����㣬�Ƶ꣬��ʳ����ɾ
		private String id;
		private String name;
		private double price;
		private String image;	//��ס��Ʒ��ͼƬ��λ��
		private String description;
		private Category category;	//�������
		
	Order	��������
		private String id;
		private Date ordertime;	//�µ�ʱ��
		private boolean state;	//����״̬
		private double price;	//�����ܼ�
		private User user;		//��ס�µ���	�������
		private Set orderitems;	//��ס�������ж�����		�������
	
	OrderItem	�������
		private String id;
		private Product product;	//��ס�������������ļ���Ʒ
		private int quantity;	//��ס�������еĲ�Ʒ�����˼���
		private double price;	//��¼��Ʒ���ܼ�
		
	User	���������ڵ��û���
		private String id;
		private String username;
		private String password;
		private String cellphone;
		private String email;
		private String address;
		
3.��Ʊ�
	create table category
	(
		id varchar(40) primary key,
		name varchar(40) not null unique,
		description varchar(255)
	);
	
	create table product
	(
		id varchar(40) primary key,
		name varchar(40) not null unique,
		price decimal(8,2) not null,
		image varchar(255) not null,
		description varchar(255),
		category_id varchar(40),
		constraint category_id_FK foreign key(category_id) references category(id)
	);	
	
	create table user
	(
		id varchar(40) primary key,
		username varchar(40) not null unique,
		password varchar(20) not null,
		cellphone varchar(20) not null,
		email varchar(40) not null,
		address varchar(255) not null
	);	
	
	create table orders
	(
		id varchar(40) primary key,
		ordertime datetime not null,
		state boolean not null,
		price decimal(8,2) not null,
		user_id varchar(40),
		constraint user_id_FK foreign key(user_id) references user(id)
	);
		
	create table orderitem
	(
		id varchar(40) primary key,
		quantity int not null,
		price decimal(8,2) not null,
		product_id varchar(40),
		constraint product_id_FK foreign key(product_id) references product(id),
		order_id varchar(40),
		constraint order_id_FK foreign key(order_id) references orders(id)
	);	
			

4.дdao
	��Ӧ����domain�����½�Categoryʵ���࣬Productʵ���࣬Orderʵ���࣬Userʵ����
	�½�CategoryDaoImplʵ���࣬����add,find,getAll����������ȡ�ӿ�
	�½�ProductDaoImplʵ���࣬����add,find,getAll�����������ҳ��ط���
	��domain�����½�QueryResult��ʱ�࣬�����ҳ������ݵ����������
	�½�UserDaoImplʵ���࣬����add,find����������ȡ�ӿ�
	�½�OrderDaoImplʵ���࣬������ӣ���Ӷ�����Ҫ���Ƕ����
	���½�OrderItem��ʱ��
	
	���ԣ�
	�½�ProductDaoTest�����Է�ҳ�����ݿ����ֶ����product,category�����Գ��������⣬c3p0û�����ã�
	�½�OrderDaoTest�����Զ��������ݿ����ֶ����orders,user,orderitem
	dao��������
5.дservice
	��service����Ȩ�����ط���
	�ڹ�����dao.properties�м���ӿ���Ϣ
	��ɷ�����ط������ӣ���ѯ����ѯ����
	��ɲ�Ʒ��ط������ӣ���ѯ
	����������󣬷��ط�ҳ���ݵ�pagebean��
	��domain�������һ��PageBean��ʱ��
	��domain�������һ��QueryInfo��ʱ��
	����û���ط������ӣ���ѯ	
	��ɶ�����ط���,���鷳
	��Ӷ���������������ݹ��ﳵ�����ɣ������ṩ���涩�����������ܹ��ﳵ������û�����
	�½�Cart��ʱ�࣬�����ﳵ
	�½�CartItem����
	���������Ǵӹ��ﳵ��ȡ�õ�
	
	���ܽ����
	����ǰҪɾ����¼��
	��ɾ��������
	��ɾ����Ʒ
	��ɾ������
	��ɾ������
	��ɾ���û�
	����CategoryDaoʱ���ִ���ԭ��dao.properties��bookû�иģ���������find��getAll����
	����Product,add,find����
	����PageQuery()����
	����AddUser()����
	����SaveOrder()����
	����FindOrder����
	
	service��������
6.��web��		
	��manager�ļ������½�left.jsp��̨��ർ��,��book
	�½�addcategory.jsp
	��manager�����½�CategoryServlet
	��Ŀ¼���½�ȫ����Ϣ��ʾҳ��message.jsp
	��manager�ļ������½�listcategroy.jsp
	��manager�ļ������½�head.jsp
	
	��manager�����½�ProductServlet
	��WebUtils�д���upload�����������ļ��ϴ�,���ˣ�WebUtils��ȫ�������
	��manager�ļ������½�listproduct.jsp
	��manager�ļ������½�addproduct.jsp
	����ProductServlet

	����Ͳ�Ʒģ�鿪����ɣ���ʼ��ǰ̨չʾ
	
	����ǰ��ҳ�棬�޸Ĳ���
	�ڸ�Ŀ¼������ǰ̨��һ��ҳ�棬index.jsp,login.jsp,register.jsp,xiangqin.jsp
	
	Ԥ������ȡ��ҳ��servlet��indexServlet������client���£���װ��categories��pagebean����
	
	��ǰ̨��Ƶ������

	
	�����û�ģ�飨������order֮ǰ������
	�ϲ�������֮ǰ���û�ģ��
	
	�����쳣��,�����û��쳣��dao�쳣
	�û�ģ����Ҫ��дfind2(String username,String password)��������formbean���ж�boolean������ӿڱ�̣�Ȼ����service���dao����д����(ע����Ҫ��д��Ӧ������������ӿڱ��)
	���ע�Ṧ�ܣ�formbean��֤
	��ɵ�¼���ܣ�formbean��֤
	���ע�����ܣ�ֻ������session����
	�޸Ĺ��ܻ�û����������д�û��ֻ�����ַ��Ϣʱ��д
	���ڿ������ɶ���ģ��
	
	��client�����½�OrderServlet�������û����أ��ж��û��Ƿ��¼���˴�Ӧ�õ���
	Ȼ���session����ȡ��cart���ԣ����ɶ�������
	�½��û���Ϣҳ�棬��ǰ�û�������ڣ������ܲ鿴���ﳵ�Ͷ���
	
	��manager�����½�OrderManagerServlet����Ϊ����Աģ��Ķ���������
	��Manager�ļ������½�listorder.jsp������ʾ�����û�����
	��Manager�ļ������½�orderdetail.jsp������ʾ��������
	
	���ˣ�ȫվ�������ܿ�����ϣ���һ��������Ŀ��ܶ�
	
7.����
	1.����ҳ���ֶ�,�ļ۸�
	2.�����������أ����е�¼��֤
	3.�˻���Ϣҳ������û�����EL���ʽ
	4.�����ﳵ���û���Ϣ��������һ���û���Ӧһ���Լ��Ĺ��ﳵ�����ܹ����ﳵ������о��е��ѣ��ƺ�Ӧ�ðѹ��ﳵ������Ƴɱ��Ժ���˵
	5.����ǰ��username���ã���Ӧ����������������������Ҫ�����ֶ� nickname,��ʱ������֤,ʵ���ǳƣ��ֻ��ţ���ַ�������޸Ĺ���
	6.ʵ��ɾ����������,����ʵ����ʱ������������ʹ���˷��棬ɾ����ɺ��޷���ת��Ԥ����ʽ
	7.ʵ���û���ѯ�Լ��Ķ����Ĺ���ģ��
	8.������һ�����⣬�û�����ҳ�棬�����δ��������ˢ�º���ظ�������ʱ�޷����
	9.������ƺ�̨ҳ�����ۣ������ĵ�
	10.�����û��Լ��Ķ�������ҳ
	11.�û�һ���ύ����������չ��ﳵ
	12.����ɾ����Ʒ����
	13.���ӷ���ɾ������
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	