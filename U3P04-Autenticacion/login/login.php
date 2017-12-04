<?php
//recuperar la sesion actual
session_name("idsesion");
session_start();
//inicializar $mensajeError
$mensajeError="";
//si la sesion esta iniciada redirigir a index.php
if (isset($_SESSION["name"])){
    header('Location: index.php');
//si la sesion no esta iniciada y se ha dado a enviar en el formulario
}elseif(isset($_POST["enviar"])){
//conexion con la BBDD
include 'conexion.php';
//comprobar que el usuario existe en la BBDD
if(!isset($usuario)){
    $mensajeError="no hay usuario en la BBDD";
//comprobar que la contraseña es correcta
}elseif(!isset($clave::$contraseña)){
    $mensajeError="la contraseña no coincide";
}else{
    header('Location: index.php');
    
}

?>
<html>
<head>Registro</head>
<body>
<form action=""></form>
</body>
</html>


<?php   
//llave del formulario
}
