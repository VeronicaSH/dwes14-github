<?php
//recuperar la sesion actual

    session_name("idsesion");
    session_start ();

//inicializar $mensajeError
$mensajeError="";
//conexion con la BBDD
include 'conexion.php';
//si la sesion esta iniciada redirigir a index.php
if (isset($_SESSION["name"])) {
    $_SESSION['name']=$_POST["nombre"];
    header('Location: index.php');
//si la sesion no esta iniciada y se ha dado a enviar en el formulario
}elseif(!isset($_POST["enviar"])){
    ?>
<html>
    <head></head>
    <body> 
         <form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST">
                    <p>
                           Nombre <input type="text" name="nombre" />
                    </p>
                    <p>
                            Contraseña <input type="text" name="contraseña" />
                    </p>
                    <p>
                            <input type="submit" value="enviar" />
                    </p>
            </form>
            <p>¿Aun no tienes cuenta?</p>
            <a href="alta.php">Registrate</a>
     </body>
</html>
<?php
}elseif(isset($_POST["enviar"])){
    //comprobar que el usuario existe en la BBDD
    $resultado=$conexion -> query("SELECT * from usuario WHERE login='$usuario'");
    if($resultado->num_rows === 0){
        echo $mensajeError="no hay usuario en la BBDD";
    //comprobar que la contraseña es correcta
    }elseif(!isset($clave::$contraseña)){
        $mensajeError="la contraseña no coincide";//le damos valor a la $nombre con el nombre de $usuario de la BBDD
    }else{
        $usuario=$_POST["nombre"];
        header('Location: index.php');
    }

}    



   
//llave del formulario



