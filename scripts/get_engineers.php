<?php

/*
1. EMP ID NOT SET	
2. USER NOT ADMIN
3. COULDN'T CONNECT TO DB
4. NUMBER OF DUDES WAS 0
5. GOT ENGINEERS

*/

$response = array();
if (isset($_GET['emp_id']))
{
	$emp_id = $_GET['emp_id'];
	if($emp_id == "admin")
	{
		// include db connect class
		require_once __DIR__ . '/db_connect.php';
		// connecting to db
		$db = new DB_CONNECT();

	 	if ($db)
		{
			$tses = mysql_query("SELECT * FROM employee");
			$num = mysql_num_rows($tses);
			
			if($num>0)
			{
				$response["engineer"] =  array();
				while($eng = mysql_fetch_array($tses))
				{
					$temp["name"] = $eng ["name"];
					$temp["phone"] = $eng ["phone"];
					$temp["email"] = $eng ["email"];
					$temp["emp_id"] = $eng ["emp_id"];

					array_push($response["engineer"],$temp);
				}

				$response["message"] = "5";
			}
			else
			{
				$response["message"] = "4";
			}
		}
		else
		{
			$response["message"]="3";
		}
	}
	else
	{
		$response["message"]="2";
	}
}
else
{
	$response["message"] = "1";
}
echo json_encode($response);

