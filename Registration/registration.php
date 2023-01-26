<?php
include 'index.php';
if ($_SERVER["REQUEST_METHOD"] == "POST") {
checkFields();
    $firstName= test_input($_POST["firstName"]);
    $email = test_input($_POST["email"]);
    $region = test_input($_POST["region"]);
    $industry = test_input($_POST["industry"]);
    $jobposition = test_input($_POST["jobposition"]);
    $desiredsalary = (int) test_input($_POST["desiredsalary"]);

    $sql = "INSERT INTO registrations (firstName,Email,Region,Industry,JobPosition,DesiredSalary)
VALUES ('" . $firstName . "','" . $email . "','" . $region . "','" . $industry . "','" . $jobposition . "',$desiredsalary)";

    if (mysqli_query($conn, $sql)) {
        echo "New record created successfully";
    } else {
        echo "Error: " . $sql . "<br>" . mysqli_error($conn);
    }

    mysqli_close($conn);
}
else{
    header("Location:http://localhost/vacancies/vacancies.html");
    die();
}
function test_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}

function checkFields()
{
    $formfields = array("firstName", "email", "region", "industry", "jobposition", "desiredsalary");
    $error = false;
    foreach ($formfields as $field) {
        if (isset($_POST[$field]) && empty($_POST[$field])) {
            $error = true;
        }

        if ($error) {
            echo "alle velden zijn verplicht.";
        } else {
            echo "Dankjewel.";
        }
    }
}
