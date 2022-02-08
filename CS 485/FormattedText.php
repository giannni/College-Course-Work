<!doctype>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Formatted Text</title>
	<link rel="stylesheet" href="css/styles.css?v=1.0">
	<meta name="description" content="">
  	<meta name="author" content="">
</head>
<body>
	<?php
	$DisplayValue=9.876;
	echo "<pre>\n";
	echo "Formatted text line 1. \r\n";
	echo "\tFormatted text line 2. \r\n";
	echo "\$DisplayValue = $DisplayValue";
	echo "</pre>\n";
	?>
</body>
</html>