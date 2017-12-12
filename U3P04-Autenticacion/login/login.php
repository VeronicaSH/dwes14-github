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
$login=(isset($_SESSION['login']) ? $_SESSION['login']:0);
//si el login es 1 {sesion iniciada}
if($login==1){ header('Location:index.php');}
//si la sesion no esta iniciada y se ha dado a enviar en el formulario
if(isset($_POST["enviar"])){
   $resultado = $conexion->query('SELECT login,password FROM usuario WHERE login="'.$user.'" AND password="'.$pass.'"');
   //si el resultado de las columnas es 0 asignamos el valor a usuario y pass y redirigimos a index.php
   if($resultado->num_rows!=0){
       $_SESSION['usuario']=$user;
       $_SESSION['password']=$pass;
       $_SESSION['login']=1;
       header('Location:index.php');
   }else{
       $mensajeError="El usuario y contraseña son incorrectos";
   }
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
            <p>¿Aun no tienes cuenta?</p>
            <a href="alta.php">Registrate</a>
            <p><?php if($mensajeError!='')echo $mensajeError;?></p>
     </body>
</html>
