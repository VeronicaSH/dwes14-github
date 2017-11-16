<?php
session_name("idsesion");
session_start();
if (isset($_REQUEST["cerrarSesion"])){
    $_SESSION=array();
}
//si no hay sesion iniciada
if (!isset($_SESSION["name"])){
    header('Location: registro.php');
}//si no se ha respondido alguna pregunta
else if (!isset($_SESSION["variable"])){
    header('Location: test1.php');
}else if (!isset($_SESSION["variable1"])){
    header('Location: test2.php');
}else if (!isset($_SESSION["variable2"])){
    header('Location: test3.php');
}//respuestas acertadas
else{
    $suma= $_SESSION["variable"]+ $_SESSION["variable1"] +  $_SESSION["variable2"];
    echo "respuestas acertadas ".$suma;
    echo "<br>";
    echo "<a href='".$_SERVER['PHP_SELF']."?cerrarSesion=true'>Reiniciar Juego</a></p>";
}


?>
