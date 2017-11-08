<html>
<head>
<title>Cookies</title>
<meta charset="UTF-8"/>
</head>
<body>
<?php
if(isset($_REQUEST["eliminarCookie"])){
    setcookie("visitante",null, time() -1, "/U2P06-PHP-Cookies/cookies/");
}
if(isset($_POST["enviar"])) {
    setcookie("visitante", $_POST["nombre"], time() + (15), "/U2P06-PHP-Cookies/cookies/"); // 86400 = segundos en 1 día
    if(count($_COOKIE) ==0) echo "<h3>Advertencia: tu navegador tiene las cookies deshabilitadas. Esta aplicación no funcionará</h3>";
	header("Location: ".$_SERVER['PHP_SELF']);
	
}
if(isset($_COOKIE["visitante"])) {
	echo "<h2>Damos la bienvenida a $_COOKIE[visitante]</h2>";
}
else
{ // solicitar nombre al usuario
?>
<form action="<?php echo $_SERVER['PHP_SELF']?>" method="post">
    <label>Escribe tu nombre para dirigirnos a ti:</label>
    <input type="text" name="nombre"><br/>
    <input type="submit" value="Enviar" name="enviar">
</form>
<?php
}
?>
<p><a href="<?php echo $_SERVER['PHP_SELF']?>">Enlace a esta misma página</a></p>
<p><a href="<?php echo $_SERVER['PHP_SELF'];?>?eliminarCookie=true">Eliminar cookie</a></p>
</body></html>
