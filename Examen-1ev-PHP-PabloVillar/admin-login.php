<?php
include('connection.php');
session_start();

$user="admin";
$pass="secreto";
$login=(isset($_SESSION['login']) ? $_SESSION['login']:0);
$passw=(isset($_POST['passw']) ? $_POST['passw']:'');
$userw=(isset($_POST['userw']) ? $_POST['userw']:'');
$cerrar=(isset($_REQUEST['cerrarsesion']) ? $_REQUEST['cerrarsesion']:'');


$mensajeError='';
if($cerrar==1){
    session_destroy();
    header("Location:index.php");
}

if(isset($_POST['enviar'])){
       if ($user==$userw ){
            if ($pass==$passw ) {
                $_SESSION['usuario'] = $user;
                $_SESSION['password'] = $pass;
                $_SESSION['login'] = 1;
                header('Location:admin-login.php');
            }else{
                $mensajeError = "La contraseña es erronea, intentelo de nuevo";
            }
        }
    }else {
        $mensajeError = "El usuario y contraseña son erroneos, intentelo de nuevo";
    }




?>

<html>
<head>
    <title>Pablo Villar Garcia</title>
    <link rel="shortcut icon" type="image/x-icon" href="./img/encabezado/encabezado.jpg"></head>

<link href="./css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="./css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href=".   /css/bootstrap-grid.css" type="text/css" rel="stylesheet">

</head>
<body>
<?php if($login!=1){ ?>

<div class="container">
    <form class="form-signin"action="admin-login.php" method="POST">
        <h1 class="form-signin-heading">Login</h1>
        <label class="sr-only">User:</label><input class="form-control" id="inputEmail" type="text" name="userw">
        <label class="sr-only">Password:</label><input class="form-control" id="inputPassword" type="password" name="passw">
        <input class="btn btn-lg btn-primary btn-block"type="submit" name="enviar" value="Entrar">
        <p style="text-align: center;"><?php if($mensajeError!='')echo $mensajeError;?></p>
        <a href="index.php">Volver a inicio</a>
    </form>

</div>
<?php }else{ ?>

<h1>Bienvenido Administrador</h1>


<a href="admin-baja.php">Dar de baja temas</a>
<a href="admin-login.php?cerrarsesion=1">Cerrar Sesion</a>
<?php }?>
</body>
</html>
