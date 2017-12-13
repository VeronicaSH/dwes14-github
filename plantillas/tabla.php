//creacion de la tabla HTML
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
//$_REQUEST y el nombre de la variable de la BBDD es una variable super global lo recoge de cualquier parte del documento
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

