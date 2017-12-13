<?php
//conexion con la BBDD
include 'conexion.php';
//iniciar sesion 
session_start ();
//iniciar error
$mensajeError="";
//si se ha dado a enviar 
if(isset($_POST["enviar"])){
//comprobaciones
//asignamos a la variable de $_SESSION lo que recibimos del formulario
$_SESSION["login"]=(isset($_POST['user']) ?  $_POST['user']:'');
$_SESSION["pass"]=(isset($_POST['pass']) ?  $_POST['pass']:'');
$_SESSION["nombre"]=(isset($_POST['name']) ? $_POST['name']:'');
$_SESSION["descripcion"]=(isset($_POST['descripcion']) ? $_POST['descripcion']:'');
//una vez asignado lo guardamos en una variable para procesarlo mas facil
$login=$_SESSION["login"];
$pass=$_SESSION["pass"];
$nombre=$_SESSION["nombre"];
$desc=$_SESSION["descripcion"];
//query que comprueba que no exista ya el usuario en la BBDD
$resultado = $conexion->query("SELECT login,password FROM usuario WHERE login='$login'");
//ENCRIPTA LA CONTRASEÃ‘A
$encriptada=password_hash($pass, PASSWORD_DEFAULT);
//query que inserta el nuevo usuario en la BBDD
$resultado2=$conexion -> query("INSERT INTO usuario (login,password,nombre,descripcion) 
VALUES('$login','$encriptada','$nombre','$desc')");
//una vez en la BBDD se redirge a login.php
header('location:login.php');
//si ha fallado algo 
}else{
    $mensajeError="usuario y contraseña incorrectos";
}
?>
<html>
<head></head>
<body>
	<form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST">
                    <p>
                           Login <input type="text" name="user" />
                    </p>
                    <p>
                            Nombre <input type="text" name="name" />
                    </p>
                    <p>
                            Contraseña <input type="text" name="pass" />
                    </p>
                    <p>
                            Descripcion <input type="text" name="descripcion" />
                    </p>
                    <p>
                            <input type="submit" value="enviar" name="enviar"/>
                    </p>
            </form>
</body>
</html>
<?php

?>
