<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/css/style.css">
    
</head>
<body>

<h2>Login</h2>

<form method="post" action="${pageContext.request.contextPath}/login">

    <input type="text" name="username" placeholder="Username" required />

    <input type="password" name="password" placeholder="Password" required />

    <button type="submit">Login</button>

</form>

<c:if test="${param.error != null}">
    <p style="color:red">Invalid username or password</p>
</c:if>

<c:if test="${param.logout != null}">
    <p style="color:green">Logged out successfully</p>
</c:if>

</body>
</html>
