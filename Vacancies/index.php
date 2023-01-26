<?php
$servername = "localhost";
$username = "root";
$password = "Abdel123";

$conn = mysqli_connect($servername, $username, $password,'schema');

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}



