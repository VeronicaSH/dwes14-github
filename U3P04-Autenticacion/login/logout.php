<?php
//recuperamos la sesion
session_start();
$_SESSION['login']=0;
//redirigir a login.php
header('Location:login.php');
?>
