<?php
$response = array();
/*
emp_id=EMP100001&latitude=123&longitude=123&date=3132015&time1223
*/
// check for required fields
if (isset($_GET['emp_id']) && isset($_GET['latitude'])&& isset($_GET['longitude'])&& isset($_GET['date'])&& isset($_GET['time'])) 
{
	$emp_id	= $_GET['emp_id'];
	$latitude = $_GET['latitude'];
	$longitude = $_GET['longitude'];
	$date = $_GET['date'];
	$time = $_GET['time'];
	// include db connect class
	require_once __DIR__ . '/db_connect.php';
	 
	// connecting to db
	$db = new DB_CONNECT();
	if ($db)
	{
		$get_id = mysql_query("SELECT id FROM employee WHERE employee.emp_id = '$emp_id'");

		//if only 1 id is received
		$num_id = mysql_num_rows($get_id);
		if($num_id == 1)
		{
			//Get ID
			$id = mysql_fetch_array($get_id);

			//Enter ID into table employee
			$enter = mysql_query("INSERT INTO employee (id,latitude, longitude,date,time) VALUES ('$id','$latitude','$longitude','$date','$time')");
			$response["message"] = "1";
		}
		else
		{
			$response["message"] = "2";
		}
	}
	else
	{
		$response["message"]="3";
	}

	
}
else
{
	$response["message"]="4";
}
echo json_encode($response);
