<?php
//recuperar la sesion actual
session_start ();
//conexion con la BBDD
include 'conexion.php';
//inicializar $mensajeError
$mensajeError="";
//inicializar usuario, pass y login
$user=(isset($_POST['user']) ?  $_POST['user']:'');
$pass=(isset($_POST['pass']) ?  $_POST['pass']:'');

//si la sesion no esta iniciada y se ha dado a enviar en el formulario

if(isset($_POST["enviar"])){
    $resultado = $conexion->query('SELECT login,password FROM usuario WHERE login="'.$user.'" ');
    //si el resultado de las columnas es 0 asignamos el valor a usuario y pass y redirigimos a index.php
    while($resul=$resultado->fetch_assoc()){
        $encriptada=$resul['password'];
        if($resultado->num_rows!=0){
            $_SESSION['usuario']=$user;
            $_SESSION['password']=$pass;
            
        }
        else{
            $mensajeError="El usuario y contraseña son incorrectos";
        }
            
    }
    if($user==$_SESSION['usuario']){ header('Location:index.php');}
}

?>
<html>
    <head></head>
    <body> 
         <form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST">
                    <p>
                           Nombre <input type="text" name="user" />
                    </p>
                    <p>
                            Contraseña <input type="text" name="pass" />
                    </p>
                    <p>
                            <input type="submit" value="enviar" name="enviar"/>
                    </p>
            </form>
            <a href="index.php">Volver</a>
            <p><?php if($mensajeError!='')echo $mensajeError;?></p>
     </body>
</html>

