<?php
//incluimos conexion con la BBDD e inicializamos la sesion
//si se ha dado a enviar
if(isset($_POST["enviar"])){
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
    //ENCRIPTA LA CONTRASEÃ‘A
    $encriptada=password_hash($pass, PASSWORD_DEFAULT);
    //query que inserta el nuevo usuario en la BBDD
    $resultado2=$conexion -> query("INSERT INTO usuario (login,password,nombre,descripcion)
    VALUES('$login','$encriptada','$nombre','$desc')");
    //una vez en la BBDD se redirge a login
}//si ha fallado algo
else{
    $mensajeError="usuario y contraseña incorrectos";
}
//FORMULARIO AL ACABAR EL CIERRE 
//BAJA ES IGUAL PERO CAMBIANDO LA QUERY POR DELETE?>
