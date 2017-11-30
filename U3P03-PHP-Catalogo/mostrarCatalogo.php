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
<th>Nombre <a href="mostrarCatalogo.php?order=1&<?php if($autor!='') echo 'autor='.$autor; ?>"> &#9650</a> 
<a href="mostrarCatalogo.php?order=0&<?php if($autor!='')echo 'autor='.$autor ;?>"> &#9660</a></th></th>
<th>Autor<a href="mostrarCatalogo.php?order=1&<?php if($autor!='') echo 'autor='.$autor; ?>"> &#9650</a> 
<a href="mostrarCatalogo.php?order=0&<?php if($autor!='')echo 'autor='.$autor ;?>"> &#9660</a></th></th>
</tr>
<?php
$order='';
$numero='';
if(isset($_REQUEST["order"]) && $_REQUEST["order"]==1){
    $order='ASC';
    $numero=1;
}else{
    $order='DESC';
    $numero=0;
}
$autor='';
if(isset($_REQUEST["autor"])){
    $autor=$_REQUEST["autor"];
    if (isset($_SESSION['autor'])){
        $autor=$_SESSION["autor"];}
        $resultado = $conexion->query('SELECT * FROM obra,autor WHERE obra.autor=autor.idAutor AND autor.Nombre="'.$autor.'" ORDER BY obra.Nombre '. $order);
}else{
    $resultado = $conexion->query('SELECT * FROM obra,autor WHERE obra.autor=autor.idAutor ORDER BY autor.Nombre '. $order);
}
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
