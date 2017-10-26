<html>
<body>
<?php
if(!isset($_POST['enviar'])){
$acu=0;
?>
<form action="ecf-acumulador.php" method="post">
Numero: <input type="text" name="num">
<input type="hidden" name="oculto" value=<?php echo $acu; ?>>
<input type="submit" name="enviar">
</form>
<?php 
}
else{
    $acu=$_POST["num"]+$_POST["oculto"];
    if($acu<50){
    ?>
    <form action="ecf-acumulador.php" method="post">
	Numero: <input type="text" name="num">
	<?php
	$acu=$_POST["num"]+$_POST["oculto"];
	?>
	<input type="hidden" name="oculto" value=<?php echo $acu; ?>>
	<input type="submit" name="enviar">
	</form>
    
<?php 
    }else{
        echo "limite de 50 superado";
    }   
    
}


