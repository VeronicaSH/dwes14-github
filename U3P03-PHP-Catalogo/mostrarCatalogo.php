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
$autor='';
if(isset($_REQUEST["autor"])){
    $autor=" AND autor='$_REQUEST[autor]'";
    echo "<a href='mostrarCatalogo.php'>Volver</a>";
    
}
$order='';

?>
<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
<input type="text" name="busqueda">
<input type="submit"  name="enviar">
</form>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>Nombre <a href="mostrarCatalogo.php?order_n=1"> &#9650</a> 
<a href="mostrarCatalogo.php?order_n=0"> &#9660</a></th></th>
<th>Autor<a href="mostrarCatalogo.php?order_a=1&<?php if($autor!='') echo 'autor='.$autor; ?>"> &#9650</a> 
<a href="mostrarCatalogo.php?order_a=0&<?php if($autor!='') echo 'autor='.$autor; ?>"> &#9660</a></th></th>

</tr>
<?php

//ordenacion 
if(isset($_POST["enviar"])){
    $buscar=$_REQUEST["busqueda"];
    $resultado= $conexion -> query("SELECT * FROM obra,autor WHERE  autor.idAutor=obra.autor AND autor.nombre='$buscar'");
}
elseif(isset($_REQUEST["order_a"]) && $_REQUEST["order_a"]==1){
    $resultado = $conexion->query("SELECT * FROM obra,autor WHERE   autor.idAutor=obra.autor $autor ORDER BY obra.Nombre ASC");
    
    
}elseif(isset($_REQUEST["order_a"]) && $_REQUEST["order_a"]==0){
    $resultado = $conexion->query("SELECT * FROM obra,autor WHERE  autor.idAutor=obra.autor $autor ORDER BY obra.Nombre DESC");;

    
}elseif(isset($_REQUEST["order_n"]) && $_REQUEST["order_n"]==1){
    $resultado = $conexion->query("SELECT * FROM obra,autor WHERE  autor.idAutor=obra.autor $autor ORDER BY obra.Nombre ASC");
    
    
}elseif (isset($_REQUEST["order_n"]) && $_REQUEST["order_n"]==0){
    $resultado = $conexion->query("SELECT * FROM obra,autor WHERE autor.idAutor=obra.autor $autor ORDER BY obra.Nombre DESC");;
   
    
}else{
//creacion de la tabla
$resultado=$conexion -> query("SELECT * from obra,autor WHERE autor.idAutor=obra.autor $autor");
}

if($resultado->num_rows === 0) echo "<p>No hay datos en la Base</p>";
while ($obra = $resultado->fetch_assoc() ){
    echo "<tr bgcolor='lightgreen'>";
    echo "<td> <a href='mostrarObra.php?idJuego=$obra[Nombre]'> $obra[Nombre]</td>\n";
    echo "<td> <a href='mostrarCatalogo.php?autor=$obra[idAutor]' > $obra[nombre]</td>\n";
    echo "</tr>";
    
}

?>
</table>
<a href="mostrarCatalogo.php">Eliminar filtros</a>


