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
<th>Nombre</th>
<th>Id Autor</th>
</tr>
<?php
$resultado=$conexion -> query("SELECT nombre,autor FROM obra ORDER BY nombre");
if($resultado->num_rows === 0) echo "<p>No hay datos en la Base</p>";
echo "</tr>";
while ($obra = $resultado->fetch_object('Obra')) {
    
    echo "<tr bgcolor='lightgreen'>";
    echo "<td>".$obra -> getAutor()."</td>\n";
    echo "<td>".$obra->getNombre()."</td>\n";
    echo "</tr>";
}
?>