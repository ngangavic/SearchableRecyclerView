<?php
//connection to mysql database
$host="localhost";
$db="android";
$password="";
$username="root";

$connection=mysqli_connect($host,$username,$password,$db);

	//sql statement
		$sql = "SELECT * from animals ";

		//Getting result 
		$result = mysqli_query($connection,$sql); 
		
		//Adding results to an array 
		$res = array(); 

		while($row = mysqli_fetch_array($result)){
			array_push($res, array(
				"name"=>$row['name'],
				"location"=>$row['location'],
				"img"=>$row['img']));
		}
		//Displaying the array in json format 
		echo json_encode($res);

?>
