<!doctype>

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
	function displayMessage($FirstMessage)
	{

		echo"<p>$FirstMessage<p>";
	}
	function returnMessage() 
	{
 		return "<p>This message was returned from a function.</p>";
	}
	displayMessage("This message was displayed from a function.");
	$ReturnValue = returnMessage();
	echo $ReturnValue;
	?>
</body>
</html>