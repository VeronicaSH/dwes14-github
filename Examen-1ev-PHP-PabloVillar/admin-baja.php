<?php
include 'connectionS.php';
session_start();
$login=(isset($_SESSION['login']) ? $_SESSION['login']:0);
$idioma=(isset($_COOKIE['idioma']) ? $_COOKIE['idioma']:'is');
$id=(isset($_POST['id']) ? $_POST['id']:'');



if($login==0){
    header('Location:admin-login.php');
}
$resultado = $conexion->query('SELECT * FROM temas ORDER BY nombre_e');
if($id!='' && isset($_POST['borrar'])){
    $resultado2 = $conexion->query('DELETE FROM temas WHERE id ='.$id);
    header('Location:admin-baja.php');
}
?>
<html>
<title>Pablo Villar Garcia</title>
<link rel="shortcut icon" type="image/x-icon" href="./img/encabezado/encabezado.jpg"></head>

<body>
<head>

</head>
<form action="./admin-baja.php" method="post">
    Temas:<br />
    <select name="id">
        <?php  while ($disco = $resultado->fetch_assoc()) : ?>
            <?php if($idioma=='is'){?>
                <option value=" <?= $disco['id']; ?>"> <?= $disco['nombre_i']; ?></option>
            <?php }?>
            <?php if($idioma=='es'){?>
                <option value=" <?= $disco['id']; ?>"> <?= $disco['nombre_e']; ?></option>
            <?php }?>
        <?php endwhile;?>
    </select>
    <input type="submit" name="borrar" value="borrar">

</form>
<a href="index.php">Volver al inicio</a></br>
<a href="admin-login.php">Volver al panel de administrador</a></br>
</body>
</html>