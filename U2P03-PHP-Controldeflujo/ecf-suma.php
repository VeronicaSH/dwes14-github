<html>
<body>

<?php
if(!isset($_POST['enviar'])){
?>
<form action="ecf-suma.php" method="post">
Numero 1: <input type="text" name="num">
<input type="submit" name="enviar">
</form>
<?php
}
else{
$i;
$res=0;
    for($i=1;$i<=$_POST["num"];$i++){
       $res+=$i;
    }
    echo "".$res."";
    
}