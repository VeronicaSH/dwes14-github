<?php
include 'cuadrado.php';
if(!isset($_POST['enviar'])){
    ?>
<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
Lado: <input type="text" name="num">
Color: <input type="text" name="color">
<input type="submit" name="enviar">
</form>
<?php 
}else{
    $c1=new Cuadrado($_POST["color"],$_POST["num"]);
    echo "<p>Area ".$c1->calcularArea()."</p>";
    echo "<p>Perimetro ".$c1->calcularPerimetro()."</p>";
    echo "color ".$c1->getColor();
    $c1->imprimir();
    }
?>
