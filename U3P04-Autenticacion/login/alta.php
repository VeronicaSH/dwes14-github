<?php
$mensajeError="";
if(isset($_POST["enviar"])){
    if(!isset($_POST["user"])){
        $mensajeError="El campo usuario esta vacio";
    }elseif(!isset($_POST["pass"])){
        $mensajeError="el campo de contraseña esta vacio";
    }
}
