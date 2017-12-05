<?php
//conexion del usuario
//conexion con la BBDD
include 'conexion.php';

    session_name("idsesion");
    session_start ();

//inicializar $mensajeError
$mensajeError="";
//si la variable $SESION no tiene valor,redirigir a login.php
if (!isset($_SESSION["name"])){
    header('Location: login.php');
}else{
?>
	<html>
	<head></head>
	<body>CONTENIDO</body>
	</html>
    
<?php 
    $resultado=$conexion -> query("SELECT * from usuario WHERE login='$usuario'");
    if($resultado->num_rows === 0){
        header('Location: logout.php');
    }else{
        echo "Damos la bienvenida a ".$usuario; echo "<br>";
       
        
    }
}
