<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title></title>
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="stylesheet" href="css/styles.css?v=1.0">
</head>
<body>
<?php
	$DaysOfWeek = array("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
	foreach ($DaysOfWeek as $DayNumber => $Day) 
	{
		echo "<p>Day $DayNumber is $Day</p>";
	}
?>
</body>
</html>