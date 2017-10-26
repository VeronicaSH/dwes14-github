<html>


<?php
if(!isset($_POST['enviar'])){
?>
<form action="ecf-cuadrado.php" method="post">
Dimensiones: <input type="text" name="num">
<input type="submit" name="enviar">
</form>

<?php
}
else{
    
    $fondo=true;
    $texto=0;
    $filas=$_POST["num"];
    
?>
<body>
<table border="1">
<?php 
    for($i=0;$i<$filas;$i++){
        echo "<tr>";
        for($j=0;$j<$filas;$j++){
            if($fondo){
                echo "<td style=padding:3px;
                background-color:#blue;>".$texto."</td>";
                $fondo=false;
                $texto++; 
            }else{
                echo "<td style=padding:3px;>".$texto."</td>";
                $grey=true;
                $texto++;
            }
       
    }
    } echo "</tr>";
    
}
?>
</table>
</body>
</html>
