<!doctype>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Password Fields</title>
	<link rel="stylesheet" href="css/styles.css?v=1.0">
	<meta name="description" content="">
  	<meta name="author" content="">
</head>
<body>
	<?php
	$Record = "jdoe:8W4dS03a39Yk2:1463:24:JohnDoe:/home/jdoe:/bin/bash";
	$PasswordFields = array("login name","optional encrypted password","numerical user ID","numerical group ID","user name or comment field","user home directory","optional user command interpreter");
	$FieldIndex = 0;
	$ExtraFields = 0;
	$CurrField = strtok($Record, ":");
	$Fields = explode(":",$Record);
	foreach ($Fields as $FieldIndex => $FieldValue) {
		if ($FieldIndex < count($PasswordFields))
			echo "<p>The
		{$PasswordFields[$FieldIndex]} is
		<em>$FieldValue</em></p>\n";
		else {
			++$ExtraFields;
			echo "<p>Extra field # $ExtraFields is
			<em>$FieldValue</em></p>\n";
		}
	}
	?>
</body>
</html>