<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

<h2>Edit Sweet</h2>

<form method="post" action="/admin/sweets/update">
    <input type="hidden" name="id" value="${sweet.id}" />

    Name: <input name="name" value="${sweet.name}" /><br/>
    Category: <input name="category" value="${sweet.category}" /><br/>
    Price: <input name="price" value="${sweet.price}" /><br/>
    Quantity: <input name="quantity" value="${sweet.quantity}" /><br/>

    <button>Update</button>
</form>

<br/>
<a href="/admin/sweets">Back</a>

</body>
</html>
