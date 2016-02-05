<%--
  Created by IntelliJ IDEA.
  User: 东
  Date: 2016/2/5
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<pg:pager maxPageItems="15" items="${param.values()}" export="curPage=pageNumber" url="${param.url}">--%>
<pg:pager maxPageItems="15" items="${param.items }" export="curPage=pageNumber" url="${param.url }">
<c:forEach items="${param.params}" var="p">
  <pg:param name="${p}"/>
</c:forEach>
<pg:last>
  共${items}记录，共${pageNumber}页，
</pg:last>
当前第${curPage}页
<pg:first>
  <a href="${pageUrl}">首页</a>
</pg:first>
<pg:prev>
  <a href="${pageUrl}">上一页</a>
</pg:prev>

<pg:pages>
  <c:if test="${curPage eq pageNumber}">
    [${pageNumber}]
  </c:if>
  <c:if test="${curPage ne pageNumber}">
    [${pageNumber}]
  </c:if>
</pg:pages>

<pg:next>
  <a href="${pageUrl}">下一页</a>
</pg:next>
<pg:last>
  <a href="${pageUrl}">尾页</a>
</pg:last>
</pg:pager>
<html>
<head>
    <title></title>
</head>
<body>

</body>
</html>
