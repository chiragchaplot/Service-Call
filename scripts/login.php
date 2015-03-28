<?php
/*
 * Following code logs in a user
 */
/*
* 1. USER LOGGED IN
* 2. email/password is wrong
* 3. couldn't connet to database
* 4. values not entered
*/
// array for JSON response
$response = array();
// check for required fields
if (isset($_GET['email']) && isset($_GET['password'])) 
{
	$email = $_GET['email'];
	$password = $_GET['password'];
	// include db connect class
	require_once __DIR__ . '/db_connect.php';
	 
	// connecting to db
	$db = new DB_CONNECT();
	if ($db)
	{
		//Check if email already exists
		$email_check = mysql_query("SELECT uid FROM ecommerce_user_login WHERE user_login.email = '$email' AND user_login.password = '$password'");
		$email_rows = mysql_num_rows($email_check);
		//If details are right then get user details and send them back 	
		if ($email_rows == 1)
		{
			$response["message"] = "1";
		}
		else
		{
			$response["message"] = "2";
		}
	}
	else
	{
		$response["message"] = "3";
	}
}
else
{
	$response["message"] = "4";
}
echo json_encode($response);
