<?php
$response = array();
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
		