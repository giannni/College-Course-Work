<?php
$host = "localhost";
  $username = "root";
  $password = "";
  $dbname = "cs485";

  //create our connection
  $conn = new mysqli("$host","$username","$password","$dbname");

  if($conn->connect_error)
  {
    die("Connection error." . $conn->connect_error);
  }
  else
  {
    $email = $_POST['email'];
    $firstName = $_POST['firstName'];
    $lastName = $_POST['lastName'];
    $query = "INSERT INTO newsletter (firstName,lastName,email) VALUES ('$firstName','$lastName','$email')";
    $result = mysqli_query($conn,$query);  
    $last_id = mysqli_insert_id($conn);
    $conn->close();
  }
  header('Location: newsletter.php?msg=thankyou&lastid=' . $last_id);
  exit();
 ?>

