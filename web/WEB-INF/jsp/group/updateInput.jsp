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
<s:form action="group_update" method="POST">
  <s:hidden name="id"></s:hidden>
  <s:textfield label="组名称" name="group.name"></s:textfield>
  <s:submit label="更新组" ></s:submit>
</s:form>
</body>
</html>
