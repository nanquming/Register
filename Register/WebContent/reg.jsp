<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery.js"></script>
    <script src="js/function.js"></script>
    <style>
    	.reg p .error {
    		display:inline-block;
    		border:1px solid #fff;
    		background-color:#ffe8e0;
    		height:25px;
    		line-height:25px;
    		padding:0px 20px;
    		margin-left:20px;
    	}  
    </style>
</head>
<body>
<div class="reg">
    <form action="register" method="post" onsubmit="return checkForm(this)">
        <h1 style="padding:0px;magin:0px;font-size:30px;background:#3344AA;text-align:center;line-height:60px;color:#FFF">员工注册</h1>
        <p ><input type="text" name="number" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入员工工号"><span></span></p> 
        <p ><input type="text" name="password"  onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入密码"><span></span></p>
        <p ><input type="text" name="repassword"  onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输确认密码"><span></span></p>
        <p ><input type="text" name="desk"  onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入负责餐桌"><span></span></p>
        <p >
        	<input style="width:20px;height:20px" type="radio" name="sex" value="男" checked="checked">男 &nbsp;&nbsp;&nbsp;
        	<input style="width:20px;height:20px" type="radio" name="sex" value="女" >女
        </p>
        <p><input type="text" name="mobile" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入手机号码"><span></span></p>
        <p><input class="code" type="text" name="veryCode" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="验证码">
        <img height="25" src="getcode" alt="看不清，换一张" onclick="change(this)">看不清?点击换一张<span></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意<a href="#"><使用条款和隐私策略>
        </a>
        </p>
        <p class="txtL txt"><a href="#"><span></span>已有账号登录</a></p>
     </form>
</div>
</body>
</html>