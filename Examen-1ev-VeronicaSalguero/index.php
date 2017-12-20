<?php
include 'clase.php';
include 'conexion.php';
$order="";
session_start();
?>
<a href="admin-login.php">Registrarse</a>
<?php 
$user=(isset($_SESSION['usuario']) ? $_SESSION['usuario']:'');
$resultado= $conexion->query('SELECT * from usuario WHERE login="'.$user.'"');
while ($usuario = $resultado->fetch_assoc()) {
    echo "<h1>Bienvenido  $usuario[login] </h1>";
    ?>
    <a href="admin-baja.php">Eliminar cancion</a>
    <?php
}
if($user=""){
    ?>
	<a href="admin-login.php">Registrarse</a>
	<?php 
    
    header('Location: admin-login.php');
}else{
    ?>
	<a href="admin-login.php"></a>
	<?php 
 
}
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th><a href="disco.php?tipo=Álbumes">Albumes </th>
<th><a href="disco.php?tipo=Sencillos">Sencillos </th>
<th> <a href="disco.php?tipo=DVD">DVD</th>
<th><a href="disco.php?tipo=Varios">Varios </th>
</tr>
<?php 
if(isset($_REQUEST["tipo"]) && $_REQUEST["tipo"]==1){
    $resultado = $conexion->query("SELECT * FROM discos WHERE tipo= '$order'");   
}elseif (isset($_REQUEST["tipo"]) && $_REQUEST["tipo"]==2){
    $resultado = $conexion->query("SELECT * FROM discos WHERE tipo='$order'");
}elseif (isset($_REQUEST["tipo"]) && $_REQUEST["tipo"]==3){
    $resultado = $conexion->query("SELECT * FROM discos WHERE tipo='$order'");
}elseif (isset($_REQUEST["tipo"]) && $_REQUEST["tipo"]==4){
    $resultado = $conexion->query("SELECT * FROM discos WHERE tipo='$order'");
}
?>

