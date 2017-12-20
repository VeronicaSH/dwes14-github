<?php
//recuperar la sesion actual
session_start ();
//conexion con la BBDD
include 'conexion.php';
//inicializar usuario, pass y login
$resultado=$conexion -> query("SELECT nombre_e FROM temas");
while($obra = $resultado->fetch_assoc()){
    echo "<tr bgcolor='lightgreen'>";
    echo "<td> $obra[nombre_e]</td>\n";
    echo "</tr>";
}
if(isset($_POST["enviar"])){
    $titulo=$_POST["titulo"];
    
    $resultado2 = $conexion->query("SELECT nombre_e FROM temas='$titulo'");
    //elimina la cancion
    $resultado3=$conexion -> query("DELETE FROM temas WHERE nombre_e='$titulo'");

}

?>
<html>
    <head></head>
    <body> 
         <form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST">
                    <p>
                           Titulo <input type="text" name="titulo" />
                    </p>
                    <p>
                            <input type="submit" value="enviar" name="enviar"/>
                    </p>
            </form>
            <a href="admin-login.php">Volver</a>
            
     </body>
</html>
