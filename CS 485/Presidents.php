<!doctype>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Presidential Terms</title>
	<link rel="stylesheet" href="css/styles.css?v=1.0">
	<meta name="description" content="">
  	<meta name="author" content="">
</head>
<body>
	<?php
	$Presidents = array("George Washington","John Adams","Thomas Jefferson","James Madison","James Monroe");
	$YearsInOffice = array("1789 to 1797","1797 to 1801","1801 to 1809","1809 to 1817","1817 to 1825");
	$OutputTemplate = "<p>President [NAME] served from [TERM]</p>\n";
	foreach ($Presidents as $Sequence => $Name) 
	{
		$TempString = str_replace("[NAME]", $Name, $OutputTemplate);
		$OutputString = str_replace("[TERM]", $YearsInOffice[$Sequence], $TempString);
		echo $OutputString;
	}
	?>
</body>
</html>