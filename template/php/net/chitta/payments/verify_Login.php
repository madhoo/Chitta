<?php

$uname = $_POST['username'];
$pwd = $_POST['password'];

$count=0;
if (($handle = fopen("users.csv","r" )) !=FALSE)
{
	while(($record = fgetcsv($handle,1000,",")) !=FALSE)
	{
		echo $uname.$pwd.$record[1].$record[2];
		$count++;
		if ($uname == $record[1]) {
			if ($pwd == $record[2]) {
				$_SESSION['UNAME'] = $uname;
				$_SESSION['LOGIN'] = TRUE;
				//$_SESSION['Time'] =  $time;
				
				header("location: home.php");
				exit();
			}
			echo "password invalid";
			//exit();
		}
		
	}
	echo "user not found".$record[1].$record[2];
	//exit();


} 


?>