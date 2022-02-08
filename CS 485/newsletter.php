<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Number Form</title>
  <meta name="description" content="">
  <meta name="author" content="">
</head>
<body>
  <?php
  if(isset($_GET['msg']) && $_GET['msg'] == "thankyou")
  {
    //if GET lastid
    if(isset($_GET['lastid']) && !empty($_GET['lastid']))
    {
      $host = "localhost";
      $username = "root";
      $password = "";
      $dbname = "cryptoTracker";
      $conn = new mysqli($host,$username,$password,$dbname);

      if($conn->connect_error)
      {
        die("Connection error." . $conn->connect_error);
      }
      else
      {
        $id = $_GET['lastid'];
        $query = "SELECT * FROM newsletter WHERE id LIKE '$id'";
        $result = mysqli_query($conn,$query); 
        //get values from the query
        while($row = mysqli_fetch_array($result))
        {
          $firstName = $row['firstName'];
          $lastName = $row['lastName'];
          $email = $row['email'];
        }
      }
    }
    echo "<p>Thank you for subscribing to the Everything Crypto newsletter, $firstName $lastName.</p>";
    echo "<p> You will recieve emails at $email.</p>";
    echo "<p><a href='newsletter.php'>Enter another subscription.</a></p>";
  }else
  {?>
          <form name = "InfoForm" action = "process_newsletter.php" method = "POST">
          <h1>The American Resturant Newsletter</h1>
          <p>Welcome to our Newsletter. Please your information and you will be automatically entered to receive the latest news from our restaurant.</p>
          <p>First name: <input type = "text" name = "firstName"/></p>
          <p>Last name: <input type = "text" name = "lastName"/></p>
          <p>Email: <input type = "email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" name = "email"/></p>
          <p> <input type = "reset" value = "Clear Form"/>&nbsp;&nbsp; </p>
          <p> <input type = "submit" name = "Submit" value = "Submit"/></p>
  <?php
  }
  ?>

</body>
</html>
