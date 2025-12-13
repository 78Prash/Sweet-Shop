<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

<h2>Register</h2>

<form action="/register" method="post">
    <input type="text" name="username" placeholder="Username" required />
    <br><br>
    <input type="password" name="password" placeholder="Password" required />
    <br><br>
    <button type="submit">Register</button>
</form>

</body>
</html>
