<html>
<body>

<?php
if(!isset($_POST['enviar'])){
?>
<form action="ecf-recorte.php" method="post">
Cadena: <input type="text" name="cad">
<input type="submit" name="enviar">
</form>
<?php
}
else{
$i;
$res=0;
$cadena=$_POST["cad"];
$long=strlen($cadena);
$total="";
    for($i=$long;$i>=0;$i--){
       for($j=0;$j<$i;$j++){
           echo "".$cadena[$j]."  ";
       } echo "<br>";
    }   
}
?>
</body>
</html>
