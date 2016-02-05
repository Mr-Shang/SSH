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
<s:iterator value="#us.datas">
  ${id}……<a href="user_show.action?cid=${id}"></a>
    ${username}……${password}……${nickname}……${group.name}&nbsp;
      <a href="user_delete.action?id=${id}">删除</a> &nbsp;
  <a href="user_addInput.action">添加用户</a>&nbsp;
  <a href="user_updateInput.action?id=${id}">更新用户</a>
  <br>
</s:iterator>

<jsp:include page="/inc/pager.jsp">
  <jsp:param value="user_list.action" name="url"/>
  <jsp:param value="${us.totalRecord }" name="items"/>
</jsp:include>
</body>
</html>
