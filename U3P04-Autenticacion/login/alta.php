<?php
//conexion con la BBDD
include 'conexion.php';
$mensajeError="";
$nombre="";
$login="";
$pass="";
$desc="";
$resultado = $conexion->query('SELECT login,password FROM usuario WHERE login="'.$user.'"');
if(isset($_POST["enviar"])){
    $nombre=$_POST['name'];
    $login=$_POST['user'];
    $pass=$_POST['pass'];
    $desc=$_POST['descripcion'];
    if(isset($_POST["user"])){
        
        $mensajeError="El campo usuario esta vacio";
    }elseif(!isset($_POST["pass"])){
        $mensajeError="el campo de contraseÃ±a esta vacio";
    }elseif($resultado->num_rows!=0){
        $mensajeError="ya existe ese usuario en la Base de Datos";
    }else{
        $resultado2=$conexion -> query('INSERT INTO usuarios (login,password,nombre,descripcion) 
        VALUES("'.$login.'","'.$pass.'","'.$nombre.'","'.$desc.'")');
    }
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
