<?php
session_name("idsesion");
session_start();
if (!isset($_SESSION["name"])){
    header('Location: registro.php');
}else if (!isset($_SESSION["variable"])){
    header('Location: test1.php');
}else{
    if(isset($_POST["musica"])){
        if($_POST["musica"]=="correcta"){
            $_SESSION["variable1"]=1;
            
        }else{
            $_SESSION["variable1"]=0;
        }
        header('Location: test3.php');
    }
        
?> 
	 <html>
    <head></head>
    <body>
     <p> ¿Primer Concierto de Queen? </p>
     <form action="<?php echo $_SERVER['PHP_SELF']?>" method="post">
  		<input type="radio" name="musica" value="correcta"> 27 de junio de 1970<br>
  		<input type="radio" name="musica" value="incorrecto"> 20 de mayo de 1975<br>
  		<input type="radio" name="musica" value="incorrecto2"> 26 de julio de 1970 <br>
  		<input type="submit" value="enviar">
	</form>
    </body>
    </html>
<?php   
}
?>