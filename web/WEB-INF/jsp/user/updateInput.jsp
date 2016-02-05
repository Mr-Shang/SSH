<%--
  Created by IntelliJ IDEA.
  User: 东
  Date: 2016/2/5
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>更新组</h1>
<s:form action="user_update" method="POST">
  <s:hidden name="id"/>
  <s:textfield label="用户名称" name="username"/>
  <s:textfield label="用户昵称" name="nickname"/>
  <s:select list="#gs" listKey="id" listValue="name"  name="gid" label="组名"/>
  <s:submit value="更新用户" />
</s:form>
</body>
</html>
