<?php

session_name("idsesion");
session_start();

if (!isset($_SESSION["name"])){
    header('Location: registro.php');
}else{
    
    
    echo "Damos la bienvenida a ".$_SESSION['name']; echo "<br>";
    $test1="<a href=\"test1.php\">Test</a>";  
    echo $test1;
}
   

