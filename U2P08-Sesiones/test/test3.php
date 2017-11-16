<?php
session_name("idsesion");
session_start();
if (!isset($_SESSION["name"])){
    header('Location: registro.php');
}else if (!isset($_SESSION["variable1"])){
    header('Location: test2.php');
}else{
    if(isset($_POST["libro"])){
        if($_POST["libro"]=="correcta"){
            $_SESSION["variable2"]=1;
            
        }else{
            $_SESSION["variable2"]=0;
        }
        header('Location: resultados.php');
    }
    
    ?>
	 <html>
    <head></head>
    <body>
     <p> ¿Libro mas vendido de la historia? </p>
     <form action="<?php echo $_SERVER['PHP_SELF']?>" method="post">
  		<input type="radio" name="libro" value="correcta"> Biblia<br>
  		<input type="radio" name="libro" value="incorrecto"> Harry Potter (Saga)<br>
  		<input type="radio" name="libro" value="incorrecto2"> Señor de los anillos (Saga) <br>
  		<input type="submit" value="enviar">
	</form>
    </body>
    </html>
<?php   
}
?>
