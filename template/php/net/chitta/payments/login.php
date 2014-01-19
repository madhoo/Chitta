<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In Page</title>
</head>

<link rel="stylesheet" type="text/css" href="styles.css" />


<body>

<h1>Welcome!</h1>

<h2>This is the Log In Page!</h2>

<p>In order to view and purchase our CDs you must be logged in!</p>


<form action="verify_Login.php" method="post">


Username: <input type="text" name="username" /><br />
Password: <input type="password" name="password" />

<input type="submit" value="Log In" />


</form>
<?php


?>


</body>
</html>