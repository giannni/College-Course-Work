<!doctype>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Word Play</title>
	<link rel="stylesheet" href="css/styles.css?v=1.0">
	<meta name="description" content="">
  	<meta name="author" content="">
</head>
<body>
	<?php
	$StartingText = "mAdAm, i'M aDaM.";
	$UppercaseText = strtoupper($StartingText);
	$LowercaseText = strtolower($StartingText);
	echo "<p>$UppercaseText</p>\n";
	echo "<p>$LowercaseText</p>\n";
	echo "<p>" . ucfirst($LowercaseText) . "</p>\n";
	echo "<p>" . lcfirst($UppercaseText) . "</p>\n";
	$WorkingText = ucwords($LowercaseText);
	echo "<p>$WorkingText</p>\n";
	echo "<p>" . md5($WorkingText) . "</p>\n";
	echo "<p>" . substr($WorkingText,0,6) . "</p>\n";
	echo "<p>" . substr($WorkingText,7) . "</p>\n";
	echo "<p>" . strrev($WorkingText) . "</p>\n";
	echo "<p>" . str_shuffle($WorkingText) . "</p>\n";
	?>
</body>
</html>