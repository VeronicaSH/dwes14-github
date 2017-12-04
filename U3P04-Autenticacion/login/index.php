<?php
//conexion del usuario
$resultado = $conexion->query($consulta);
$mensajeError = $conexion->error;
if (empty($mensajeError))
    header ("Location: login.php");