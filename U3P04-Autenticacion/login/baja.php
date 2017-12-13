<?php
//conexion con la BBDD
include 'conexion.php';
//iniciar sesion
session_start ();
$mensajeError="";
if(isset($_POST["enviar"])){
        $_SESSION["login"]=(isset($_POST['user']) ?  $_POST['user']:'');
        $_SESSION["pass"]=(isset($_POST['pass']) ?  $_POST['pass']:'');
        $_SESSION["nombre"]=(isset($_POST['name']) ? $_POST['name']:'');
        $_SESSION["descripcion"]=(isset($_POST['descripcion']) ? $_POST['descripcion']:'');
        
        $login=$_SESSION["login"];
        $pass=$_SESSION["pass"];
        $nombre=$_SESSION["nombre"];
        $desc=$_SESSION["descripcion"];
        $resultado = $conexion->query("SELECT login,password FROM usuario WHERE login='$login'");
        
        $resultado2=$conexion -> query("DELETE FROM usuario WHERE login='$login'");
        header('location:logout.php');
        
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
        