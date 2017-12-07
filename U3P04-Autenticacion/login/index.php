<?php
//conexion con la BBDD
include 'conexion.php';
//recuperar la sesion
session_start ();

//inicializar $mensajeError
$mensajeError="";
//inicializar el login y el usuario
$login=(isset($_SESSION['login']) ? $_SESSION['login']:'');
$user=(isset($_SESSION['usuario']) ? $_SESSION['usuario']:'');
//si el login es distinto de 1 redirigir a login.php
if($login!=1){ header('Location:login.php');}
//query para coger el usuario
$resultado= $conexion->query('SELECT * from usuario WHERE login="'.$user.'"');
//comprobar que existe el usuario
if($resultado->num_rows==0) header('Location:logout.php');
?>
	<html>
	<head></head>
	<body>CONTENIDO
	
    
<?php 
while ($usuario = $resultado->fetch_assoc()) { 
        echo "<h1>Bienvenido  $usuario[nombre] </h1>";
        echo "Descripcion: $usuario[descripcion]</p>";
        echo "<p>Login: $usuario[login] </p>";
}
?>
<a href="logout.php">Cerrar Sesion</a>
<a href="baja.php">Eliminar cuenta</a>
</body>
</html>