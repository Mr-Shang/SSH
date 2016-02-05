<%--
  Created by IntelliJ IDEA.
  User: 东
  Date: 2016/2/5
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>添加用户</h1>
<s:form action="user_add" method="POST">
  <s:textfield label="用户名称" name="username"/>
  <s:textfield label="用户密码" name="password"/>
  <s:textfield label="用户昵称" name="nickname"/>
  <s:select list="#gs" listKey="id" listValue="name"  name="gid" label="组名"/>
  <s:submit value="添加用户"/>
</s:form>
</body>
</html>
