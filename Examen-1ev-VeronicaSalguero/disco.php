<?php
include 'conexion.php';
include 'clase.php';
session_start();
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>Id</th>
<th>Titulo</th>
<th>Discografica</th>
<th>Año</th>
<th>Formato</th>
<th>Imagen</th>
</tr>
<?php 
//recoger el nombre del juego del REQUEST
if(!isset($_REQUEST["tipo"]))die ("<h3>ERROR en la petición</h3>");
$tipo = $_REQUEST["tipo"];
$imagen="img/discografia";
$resultado=$conexion -> query("SELECT * FROM discos WHERE tipo= '$tipo' ");
while($obra = $resultado->fetch_assoc()){
//datos de la tabla completos
echo "<tr bgcolor='lightgreen'>";
echo "<td> $obra[id]</td>\n";
echo "<td> $obra[nombre]</td>\n";
echo "<td> $obra[discografica]</td>\n";
echo "<td> $obra[year]</td>\n";
echo "<td> $obra[tipo]</td>\n";
echo "<td> <img src='$imagen$obra[imagen]'</td>\n";

echo "</tr>";
}


