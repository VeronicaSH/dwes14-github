<html>
<body>
<?php
if(!isset($_POST['enviar'])){
    ?>
<form action="ecf-factorial.php" method="post">
Base: <input type="text" name="num1">
Exponente: <input type="text" name="num2">
<input type="submit" name="enviar">
</form>
<?php
}
else{
$base=$_POST["num1"];
$exp=$_POST["num2"];
$res=1;
$i;
for($i=1;$i<=$exp;$i++){
    $res*=$base;
}
echo "".$res."";
    
}
