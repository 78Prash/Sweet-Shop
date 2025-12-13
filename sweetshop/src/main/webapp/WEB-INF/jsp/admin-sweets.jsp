<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

<h2>Admin - Manage Sweets</h2>

<h3>Add Sweet</h3>
<form method="post" action="/admin/sweets/add">
    Name: <input name="name" required /><br/>

    Category: <input name="category" /><br/>

    Price:
    <input name="price" type="number" step="0.01" required /><br/>

    Quantity:
    <input name="quantity" type="number" required /><br/>

    <button type="submit">Add</button>
    
    <button class="btn-edit">Edit</button>
<button class="btn-delete">Delete</button>
    

</form>
<hr/>

<h3>All Sweets</h3>
<table border="1">
<tr>
    <th>Name</th>
    <th>Category</th>
    <th>Price</th>
    <th>Qty</th>
    <th>Actions</th>
</tr>

<c:forEach items="${sweets}" var="s">
<tr>
    <td>${s.name}</td>
    <td>${s.category}</td>
    <td>${s.price}</td>
    <td>${s.quantity}</td>
    <td>
        <a href="/admin/sweets/edit/${s.id}">Edit</a>
        |
        <a href="/admin/sweets/delete/${s.id}"
           onclick="return confirm('Delete this sweet?')">Delete</a>
    </td>
</tr>
</c:forEach>

</table>

<br/>
<a href="/sweets">Back to Shop</a> |
<a href="/logout">Logout</a>

</body>
</html>
