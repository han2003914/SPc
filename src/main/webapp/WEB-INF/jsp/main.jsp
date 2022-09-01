<%--
  Created by IntelliJ IDEA.
  User: 涵
  Date: 2022-08-10
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>账号id</th>
        <th>账号姓名</th>
        <th>账号类型</th>
        <th>账号余额</th>
        <th>创建时间</th>
    </tr>
    <c:forEach items="${pageinfo.list}" var="account">
        <tr>
            <td>${account.accountId}</td>
            <td>${account.accountName}</td>
            <td>${account.accountType}</td>
            <td>${account.money}</td>
            <td><fmt:formatDate value="${account.createTime}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
        </tr>
    </c:forEach>

</table>
<a href="findall?startPage=1&pageSize=4">首页</a>

<a href="findall?startPage=${pageinfo.nextPage}&pageSize=4">下一页</a>
<a href="findall?startPage=${pageinfo.prePage}&pageSize=4">上一页</a>
<a href="findall?startPage=${pageinfo.pages}&pageSize=4">末页</a>

</body>
</html>
