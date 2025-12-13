<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Sweet Shop</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<h2>Sweet Shop</h2>

<!-- ADMIN ONLY -->
<sec:authorize access="hasRole('ADMIN')">
    <a href="/admin">Add / Manage Sweets</a>
</sec:authorize>

<table border="1">
<tr>
  <th>Name</th>
  <th>Price</th>
  <th>Quantity</th>
  <th>Action</th>
</tr>

<c:forEach items="${sweets}" var="s">
<tr>
  <td>${s.name}</td>
  <td>${s.price}</td>
  <td>${s.quantity}</td>
  <td>
    <form method="post" action="/${s.id}/purchase">
        <button type="submit">Buy</button>
    </form>
  </td>
</tr>
</c:forEach>

</table>

<a href="/logout">Logout</a>

</body>
</html>
