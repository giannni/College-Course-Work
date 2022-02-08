<!doctype>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Books and Authors</title>
	<link rel="stylesheet" href="css/styles.css?v=1.0">
	<meta name="description" content="">
  	<meta name="author" content="">
</head>
<body>
	<?php
	$Books = array("The Adventures of Huckleberry Finn", "Nineteen Eighty-Four", "Alice's Adventures in Wonderland","The Cat in the Hat");
	$Authors = array("Mark Twain", "George Orwell","Lewis Carroll", "Dr. Seuss");
	$RealNames = array("Samuel Clemens","Eric Blair","Charles Dodson", "Theodor Geisel");
	for ($i = 0; $i < count($Books); ++$i)
 	echo "<p>The real name of {$Authors[$i]}, "."the author of \"{$Books[$i]}\", "."is {$RealNames[$i]}.</p>";
	?>
</body>
</html>