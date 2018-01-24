<?php
include 'connection.php';



$categoria=(isset($_REQUEST["categoria"]) ?  $_REQUEST["categoria"]:'Álbumes');
$titulo=(isset($_POST["titulo"]) ?  $_POST["titulo"]:'');

if(isset($_REQUEST["order"]) && $_REQUEST["order"]==1){
    $order='ASC';

}else {
    $order = 'DESC';
}
if(isset($_REQUEST["orderY"]) && $_REQUEST["orderY"]==1){
    $orderY='ASC';

}else{
    $orderY='DESC';

}
$resultado = $conexion->query('SELECT * FROM discos WHERE tipo="' . $categoria . '" ORDER BY nombre ' . $order);

if(isset($_REQUEST["order"])) {
    $resultado = $conexion->query('SELECT * FROM discos WHERE tipo="' . $categoria . '" ORDER BY nombre ' . $order);
}
if(isset($_REQUEST["orderY"])) {
    $resultado = $conexion->query('SELECT * FROM discos WHERE tipo="' . $categoria . '" ORDER BY year ' . $orderY);
}
if(isset($_POST["titulo"])) {
    $resultado = $conexion->query('SELECT * FROM discos WHERE tipo="' . $categoria . '" AND nombre="'.$titulo.'"');
}
$resultado2 = $conexion->query('SELECT DISTINCT tipo FROM discos');




?>
<html>
<head>
    <title>Pablo Villar Garcia</title>
    <link rel="shortcut icon" type="image/x-icon" href="./img/encabezado/encabezado.jpg"></head>

</head>
<body>
<?php  while ($cat = $resultado2->fetch_assoc()) : ?>
    <a href="index.php?categoria=<?=$cat['tipo'];?>"><?=$cat['tipo'];?></a>
<?php endwhile; ?>
<h1><?=$categoria;?></h1>
<form action="./index.php" method="POST">
    Buscar obra:<input type="text" name="titulo">
    <input type="submit" name="Buscar">
</form>
<table>
    <tr style='background-color:lightblue'>
        <th>Nombre <a href="index.php?order=1&categoria=<?=$categoria?>"> &#9650</a>
            <a href="index.php?order=0&categoria=<?=$categoria?>"> &#9660</a></th>
        <th>Discografica</th>
        <th>Año<a href="index.php?orderY=1&categoria=<?=$categoria?>"> &#9650</a>
            <a href="index.php?orderY=0&categoria=<?=$categoria?>"> &#9660</a></th>
        <th>Soporte</th>
        <th>Imagen</th>
    </tr>

<?php  while ($disco = $resultado->fetch_assoc()) : ?>
    <tr bgcolor='lightgreen'>
        <td><?= $disco['nombre']; ?></td>
        <td><?= $disco['discografica']; ?></td>
        <td><?= $disco['year']; ?></td>
        <td><?= $disco['soporte']; ?></td>
        <td><a href="disco.php?idDisco=<?= $disco['id']; ?>"><img src="img/discografia/<?= $disco['imagen']; ?>.jpg"></a></td>
    </tr>
<?php endwhile; ?>
</table>
<a href="admin-login.php">Administración</a>
</body>
</html>
