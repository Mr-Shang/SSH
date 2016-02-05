<%--
  Created by IntelliJ IDEA.
  User: 东
  Date: 2016/2/4
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>
      <h1>
        整合ssh
      </h1>
    </title>
</head>
<body>
<s:iterator value="#gl">
  ${id}……<a href="group_show.action?cid=${id}">${name}</a>&nbsp;
      <a href="group_delete.action?id=${id}">删除</a> &nbsp;
  <a href="group_addInput.action">添加组</a>&nbsp;
  <a href="group_updateInput.action?id=${id}">更新组</a>
  <br>
</s:iterator>
</body>
</html>
