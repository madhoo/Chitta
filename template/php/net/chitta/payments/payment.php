<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Page</title>

<!-- this is the payment page where one can enter their cradit card details and make a payment for the selectes CDs -->

</head>

<!-- this is the link to the style of the page -->
<link rel="stylesheet" type="text/css" href="styles.css" />


<body>

<h1>This is the Payment Page!</h1>

<p>This is where you pay for your selected CDs!</p>

<?php

$qry= $_POST[$qry];


while(($record = pg_fetch_array($qry)) !=FALSE)

{

echo $record ['cdId']."   ".$record ['albumname']."   ".$record ['artistName']."  £".$record ['cdPrice'] ."<BR />";


}


?>

<form action="order.php">

<!-- this is where you enter your card details -->

<!-- name on the card -->
Full Name: <input type="text" name="fullname" /><br />  

<!--  the card type, beacause it is needed for the validateCc.php to wokrk-->
Card Type:<select>
  <option value="American">American Express</option>
  <option value="Dinners">Diner's Club</option>
  <option value="Discover">Discover</option>
  <option value="Master">Master Card</option>
  <option value="Visa">Visa</option>
</select> <br /> 

<!-- the card number -->
Card Numder: <input type="text" name="cardnumber" /> <br />

<!-- the expiry date in moth and year -->
Expiry Date: <input type="text" name="expmnth" /> / <input type="text" name="year" /> <br />

<!-- this is the button you use to pay for the CDs you want -->
<input type="submit" value="Pay" /> <br/>

</form>


</body>
</html>