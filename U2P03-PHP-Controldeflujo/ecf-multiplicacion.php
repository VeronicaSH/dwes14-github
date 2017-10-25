<html>
<body>
<?php
if(!isset($_POST['enviar'])){
    ?>
<form action="ecf-multiplicacion.php" method="post">
Numero: <input type="text" name="num">
<input type="submit" name="enviar">
</form>
<?php
}
else{
$i;
$res=0;
      for($i=0;$i<=10;$i++){
            $res=$_POST["num"]*$i;
            echo " ".$res." ";
        }
        
        
    }

?>
</body>
</html>
