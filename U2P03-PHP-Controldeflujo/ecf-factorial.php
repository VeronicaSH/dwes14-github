<html>
<body>
<?php
if(!isset($_POST['enviar'])){
    ?>
<form action="ecf-factorial.php" method="post">
Numero: <input type="text" name="num">
<input type="submit" name="enviar">
</form>
<?php
}
else{
$fact=1;
$i;
    for($i=1;$i<=$_POST["num"];$i++){
        $fact*=$i;
    }
echo "".$fact."";
    
    
}
?>
</body>
</html>