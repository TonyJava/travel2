<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>购物车</title>
	</head>
	<link href="${pageContext.request.contextPath }/css/common.css" type="text/css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath }/css/order.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath }/js/hide.js"></script>
	<body class="order_website">
		<div class="transport" id="transport"></div>
		<div class="top clearfix">
			<div class="top_lt"><img src="${pageContext.request.contextPath }/img/xinxin.PNG"/>收藏游啊游 </div>
			<div class="top_rt">
				您好，欢迎来到游啊游&nbsp;&nbsp;|&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/login.jsp">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/register.jsp">免费注册</a>&nbsp;&nbsp;
				<span class="top_rt_tel" id="tel">客服电话 400-888-0166</span>
				<div class="top_rt_hide " id="tel_content">
					<div class="top_rt_hide_t">
						服务时间 ：9:00 - 20:00
					</div>
					<div class="top_rt_hide_f">
						国内：400-888-0166<br>泰国：+66-76-684-996<br>越南：0084-963-694-428<br>柬埔寨：097-6023-868
					</div>
				</div>
			</div>
		</div><!--top结束-->
		<div class="logo">
			<div class="logo_pic"><a href="${pageContext.request.contextPath }/index.jsp"><img src="${pageContext.request.contextPath }/img/yay_logo.png"/></a></div>
			<div class="search">
				<input type="text"/><span>搜索</span>
			</div>
		</div><!--logo结束-->
		<div class="nav">
			<ul>
				<li><a href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
				<li><a href="#">特色餐厅</a></li>
				<li><a href="#">当地交通</a></li>
				<li><a href="#">景区门票</a></li>
				<li><a href="#">娱乐体验</a></li>
				<li><a href="#">当地玩乐</a></li>
				<li><a href="#">游啊游无线</a></li>
			</ul>
		</div><!--nav结束-->
		<div class="content">
			<div class="order">
				<div class="order_left">
					<div class="order_left_t"><span>用户名</span></div>
					<div class="order_left_f">
						<div class="order_f_tit">订单管理</div>
						<ul>
							<li><a href="${pageContext.request.contextPath }/order.jsp">我的订单</a></li>
							<li><a href="${pageContext.request.contextPath }/car.jsp">我的购物车</a></li>
						</ul>
						<div class="order_f_tit">账户设置</div>
						<ul>
							<li><a href="${pageContext.request.contextPath }/zhanghu.jsp"style="background:#A0E1D9;color: white;border-radius: 3px;">账户信息</a></li>
							
						</ul>
					</div>
				</div>
				<div class="order_right">
				<div class="order_right_content">
					<div class="headline"><h1>账户信息</h1></div>
					<ul>
						<li>昵称:<span>keyboardone</span><a href="${pageContext.request.contextPath }/javascript:;" id="a1">修改</a></li>
						<li>手机号:<span>keyboardone</span><a href="${pageContext.request.contextPath }/javascript:;" id="a2">修改</a></li>
						<li>邮箱:<span>2892075608@qq.com</span><a href="${pageContext.request.contextPath }/javascript:;" id="a3">修改</a></li>
						<li>密码:<span> *******</span><a href="${pageContext.request.contextPath }/javascript:;" id="a4">修改</a></li>
					</ul>
				</div>
			</div>
			
			<div id="tan_box1" class="tan_box">
				<h1>修改昵称</h1><span id="close1" class="close"></span>
				<div class="xiugai">新昵称&nbsp;<input type="text" placeholder="设置新的昵称"/></div>
				<div class="tijaio"><input type="button" value="确定"/>&nbsp;<input type="button" value="取消"/></div>
			</div>
			<script src="js/tan.js"></script>
			<div id="tan_box2" class="tan_box">
				<h1>修改手机号</h1><span id="close2" class="close"></span>
				<div class="xiugai">新手机号&nbsp;<input type="text" placeholder="设置新的手机号"/></div>
				<div class="tijaio"><input type="button" value="确定"/>&nbsp;<input type="button" value="取消"/></div>
			</div>
			<div id="tan_box3" class="tan_box">
				<h1>修改邮箱</h1><span id="close3"class="close"></span>
				<div class="xiugai">新邮箱&nbsp;<input type="text" placeholder="设置新的邮箱"/></div>
				<div class="tijaio"><input type="button" value="确定"/>&nbsp;<input type="button" value="取消"/></div>
			</div>
			<div id="tan_box4" class="tan_box">
				<h1>修改密码</h1><span id="close4"class="close"></span>
				<div class="xiugai">当前密码&nbsp;<input type="text" placeholder="当前的密码"/></div>
				<div class="xiugai01">新密码&nbsp;<input type="text" placeholder="设置新的密码"/></div>
				<div class="tijaio"><input type="button" value="确定"/>&nbsp;<input type="button" value="取消"/></div>
			</div>
			
			</div>
		</div><!--content结束-->
		<div class="foot">
			<img src="${pageContext.request.contextPath }/img/bg02.PNG" width="100%" height="168px"/>
			<div class="foot_content">
				<ul>
					<li><a href="#">关于我们</a>
						<ul>
							<li><a href="#">公司简介</a></li>
							<li><a href="#">加入我们</a></li>
							<li><a href="#">商务合作</a></li>
							<li><a href="#">商户后台</a></li>
							<li><a href="#">商户APP</a></li>
						</ul>
					</li>
					<li><a href="#">联系我们</a>
						<ul>
							<li><a href="#">电话客服</a></li>
							<li><a href="#">微信客服</a></li>
						</ul>
					</li>
					<li><a href="#">订购指南</a>
						<ul>
							<li><a href="#">消费券使用指南</a></li>
							<li><a href="#">在线订购保障</a></li>
							<li><a href="#">邮件订阅</a></li>
							<li><a href="#">积分说明</a></li>	
						</ul>
					</li>
					<li><a href="#">用户帮助中心</a>
						<ul>
							<li><a href="#">产品说明</a></li>
							<li><a href="#">订单取消和变更</a></li>
							<li><a href="#">退货说明</a></li>
							<li><a href="#">发票开具说明</a></li>	
						</ul>
					</li>
					<li><a href="#">服务条款</a>
						<ul>
							<li><a href="#">隐私条款</a></li>
							<li><a href="#">法律声明</a></li>
							<li><a href="#">用户协议</a></li>
							<li><a href="#">免责声明</a></li>
							<li><a href="#">产品购买协议</a></li>
						</ul>
					</li>
					<li><a href="#">常见问题</a>
						<ul>
							<li><a href="#">签证、护照常见问题</a></li>
							<li><a href="#">在线订购常见问题</a></li>
							<li><a href="#">网站使用常见问题</a></li>
							<li><a href="#">旅行途中常见问题</a></li>	
						</ul>
					</li>
				</ul>
				<div class="foot_content_pic"><img src="${pageContext.request.contextPath }/img/yay_position_29.jpg" width="86px" height="86px"><br><span>微信服务号</span></div>
			</div><!--foot_content-->
		</div><!--foot结束-->
	</body>
</html>
