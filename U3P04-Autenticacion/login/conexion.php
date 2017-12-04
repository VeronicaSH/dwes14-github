<?php
//conexion con la BBDD
$servidor = "localhost";
$usuario = "vsalguero";
$clave = "vsalguero";
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo14");
$conexion->query("SET NAMES 'UTF8'");
if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}