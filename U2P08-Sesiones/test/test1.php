<?php
session_name("idsesion");
session_start();

if (!isset($_SESSION["name"])){
    header('Location: registro.php');
}else{
    if(isset($_POST["pelicula"])){
        if($_POST["pelicula"]=="correcta"){
            $_SESSION["variable"]=1;
          
        }else{
            $_SESSION["variable"]=0;
        }
        header('Location: test2.php');
    }
    ?>
    <html>
    <head></head>
    <body>
     <p> ¿Cuando se estreno el Señor de los Anillos? </p>
     <form action="<?php echo $_SERVER['PHP_SELF']?>" method="post">
  		<input type="radio" name="pelicula" value="correcta"> 19 de diciembre de 2001<br>
  		<input type="radio" name="pelicula" value="incorrecto"> 20 de agosto de 2005<br>
  		<input type="radio" name="pelicula" value="incorrecto2"> 21 de julio de 2003 <br>
  		<input type="submit" value="enviar">
	</form>
    </body>
    </html>
<?php 
}

?>