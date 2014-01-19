<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Page</title>

<!-- this is the oder page where one can view thier order and total cost of the CDs they have puchased -->

</head>

<!-- this is the link to the style of the page -->
<link rel="stylesheet" type="text/css" href="styles.css" />


<body>

<h1>This is the Order Page!</h1>

<?php
include 'validateCC.php';
$check = validateCC($_Post[$cardnumber], $_Post[$cardtype]);
echo $check;
exit();

?>

<!--  a message follows and states the order is complete -->
<p>This is where you can view your order and total price of your selected CDs!</p>


<h2> Congratulations!</h2>

<p>You have purcahed:</p>


<!-- this is where the total amount of the customers payment is shown -->
<b> Total: </b>

</body>
</html>