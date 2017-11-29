<html>
<head>
	<title>Conexión a BBDD Catalogo14</title>
	<meta charset="UTF-8"/>
</head>
<body>
<h2>Pruebas con la base de datos de catalogo14</h2>
<?php
include 'Obra.php';
//conexion con la BBDD
$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";
$conexion = new mysqli($servidor,$usuario,$clave,"catalogo14");
$conexion->query("SET NAMES 'UTF8'");
if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>Nombre &#9650; &#9660;</th>
<th>Autor &#9650; &#9660; </th>
</tr>
<?php
//creacion de la tabla
$resultado=$conexion -> query("SELECT * from obra,autor WHERE autor.idAutor=obra.autor");
if($resultado->num_rows === 0) echo "<p>No hay datos en la Base</p>";
while ($obra = $resultado->fetch_assoc() ){
    echo "<tr bgcolor='lightgreen'>";
    echo "<td> <a href='mostrarObra.php?idJuego=$obra[Nombre]'> $obra[Nombre]</td>\n";
    echo "<td> $obra[nombre]</td>\n";
    echo "</tr>";
    
}
?>
