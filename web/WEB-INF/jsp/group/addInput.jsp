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
<h1>添加组</h1>
<s:form action="group_add" method="POST">
  <s:textfield label="组名称" name="name"></s:textfield>
  <s:submit label="添加组" ></s:submit>
</s:form>
</body>
</html>
