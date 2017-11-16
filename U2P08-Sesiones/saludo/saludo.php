
<?php
//https://www.codejobs.biz/es/blog/2013/01/29/crear-una-sesion-en-php-session
if (isset($_REQUEST["cerrarSesion"])){
    $_SESSION=array();
}
if (session_status () == PHP_SESSION_NONE){
    session_name("idsesion");
    session_start ();  
}
if(isset($_POST["nombre"])) {
    $_SESSION['name']=$_POST["nombre"];
    echo "Damos la bienvenida a ".$_SESSION['name']; echo "<br>";
    echo "<a href='".$_SERVER['PHP_SELF']."?cerrarSesion=true'>Cerrar sesión</a></p>";
}else{
    echo "Sesion no iniciada";
    
?>
<html>
    <head>
    </head>
 
    <body>
           
            <form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST">
                    <p>
                            <input type="text" name="nombre" />
                    </p>
                    <p>
                            <input type="submit" value="enviar" />
                    </p>
            </form>
    </body>
</html>
<?php
}

?>