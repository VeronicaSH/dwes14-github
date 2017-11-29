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
<th>Id Juego</th>
<th>Nombre</th>
<th>Genero</th>
<th>Consola</th>
<th>Autor</th>
<th>Imagen</th>
</tr>
<?php
//recoger el nombre del juego del REQUEST
if(!isset($_REQUEST["idJuego"]))die ("<h3>ERROR en la petición</h3>");
$id = $_REQUEST["idJuego"];
//variable para la imagen
$imagen="img/";
//obtener la obra en especifico de cada nombre
$resultado=$conexion -> query("SELECT * from obra,autor WHERE (autor.idAutor=obra.autor) AND (obra.Nombre= '$id')");
$obra = $resultado->fetch_assoc(); 
    //datos de la tabla completos
    echo "<tr bgcolor='lightgreen'>";
    echo "<td> $obra[idJuego]</td>\n";
    echo "<td> $obra[Nombre]</td>\n";
    echo "<td> $obra[genero]</td>\n";
    echo "<td> $obra[consola]</td>\n";
    echo "<td> $obra[nombre]</td>\n";
    echo "<td> <img src='$imagen$obra[Imagen]'</td>\n";
    echo "</tr>";
    

?>
<a href='mostrarCatalogo.php'>Volver</a>