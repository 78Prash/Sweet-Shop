<html>
<head>
    <title>Add Sweet</title>
    <link rel="stylesheet" href="/css/style.css">
    
</head>
<body>

<h2>Add Sweet</h2>

<form action="/sweets/add" method="post">
    Name: <input type="text" name="name" required /><br/><br/>
    Category: <input type="text" name="category" required /><br/><br/>
    Price: <input type="number" step="0.01" name="price" required /><br/><br/>
    Quantity: <input type="number" name="quantity" required /><br/><br/>

    <button type="submit">Save</button>
</form>

<br/>
<a href="/sweets">⬅ Back</a>

</body>
</html>
