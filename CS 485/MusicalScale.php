<!doctype>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Musical Scale</title>
	<link rel="stylesheet" href="css/styles.css?v=1.0">
	<meta name="description" content="">
  	<meta name="author" content="">
</head>
<body>
	<?php
	$MusicalScale = array("do", "re", "mi", "fa", "so", "la", "ti");
	$OutputString="The notes of the musical scale are: ";
	foreach ($MusicalScale as $CurrentNote)
 	$OutputString .= " " . $CurrentNote;
 	echo "<p>$OutputString</p>";
	?>
</body>
</html>