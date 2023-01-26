<?php
include "index.php";
GLOBAL $conn;
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    checkFields();
    $companyname = test_input($_POST["companyname"]);
    $email = test_input($_POST["email"]);
    $region = test_input($_POST["region"]);
    $industry = test_input($_POST["industry"]);
    $jobposition = test_input($_POST["jobposition"]);
    $startsalary= (int) test_input($_POST["startsalary"]);
    $endsalary = (int) test_input($_POST["endsalary"]);
    $sql = "INSERT INTO vacancies (company,Email,Region,Industry,JobPosition,StartSalary,EndSalary)
VALUES ('" . $companyname . "','" . $email . "','" . $region . "','" . $industry . "','" . $jobposition . "', " . $startsalary."," . $endsalary . ")";

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
    $formfields = array("company", "email", "region", "industry", "jobposition", "startsalary","endsalary");
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
