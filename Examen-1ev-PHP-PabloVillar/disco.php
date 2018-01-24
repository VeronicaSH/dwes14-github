
<?php
include 'connection.php';

$idioma='is';
if(isset($_REQUEST['idioma'])){
    setcookie("idioma", $_REQUEST['idioma'], time() + 2592000, '/');
    $_COOKIE['idioma']=$_REQUEST['idioma'];
    $idioma=$_COOKIE['idioma'];

}
if(isset($_COOKIE['idioma'])){
    $idioma=$_COOKIE['idioma'];
}


$nombre=(isset($_REQUEST["idDisco"]) ?  $_REQUEST["idDisco"]:'');
$mensajeError='';
if($nombre==''){
    $mensajeError='No se a seleccionado ningun disco';
}else{

    $resultado = $conexion->query('SELECT * FROM discos WHERE id="' . $nombre . '"');
    $resultado2 = $conexion->query('SELECT * FROM temas WHERE id_disco="'.$nombre.'"');


}
?>
<html>
<head>
    <title>Pablo Villar Garcia</title>
    <link rel="shortcut icon" type="image/x-icon" href="./img/encabezado/encabezado.jpg"></head>
<body>
<a href="disco.php?idioma=es&idDisco=<?=$nombre?>"><img src="img/banderas/es.png"></a>
<a href="disco.php?idioma=is&idDisco=<?=$nombre?>"><img src="img/banderas/is.png"></a>
<?php  while ($disco = $resultado->fetch_assoc()) : ?>

        <h1>Titulo <?= $disco['nombre']; ?></h1>
        <p>Discografica <?= $disco['discografica']; ?></p>
        <p>Año <?= $disco['year']; ?></p>
        <p>Formato <?= $disco['soporte']; ?></p>
        <p><img src="img/discografia/<?= $disco['imagen']; ?>.jpg"></p>
    </tr>
<?php endwhile; ?>
<p><?= $mensajeError ?></p>

<table>
    <tr style='background-color:lightblue'>
        <th>Numero</th>
        <th>Nombre</th>
        <th>Duracion</th>


    </tr>

    <?php  while ($disco = $resultado2->fetch_assoc()) : ?>
        <tr bgcolor='lightgreen'>
            <td><?= $disco['numero']; ?></td>
            <?php if($idioma=='is'){?>
            <td><?= $disco['nombre_i']; ?></td>
            <?php }?>
            <?php if($idioma=='es'){?>
                <td><?= $disco['nombre_e']; ?></td>
            <?php }?>
            <?php if($disco['segundos']!=0 or $disco['minutos']!=0 ){?>
            <td><?= $disco['minutos']; ?>:<?= $disco['segundos']; ?></td>
            <?php }?>
            <td></td>
        </tr>
    <?php endwhile; ?>
</table>
<a href="index.php">Volver al listado de discos</a>
</body>
</html>