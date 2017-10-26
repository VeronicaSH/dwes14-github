<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
   <?php
   if(!isset($_POST['Enviar'])){
   ?>
       <form action="ecf-cuadrado.php" method="post">
           Numero: <input type="number" name="numero">
           <input type="submit" name="Enviar">
       </form>
    <?php
   }else{
    $num=$_POST["numero"];
    ?>
    <table border="1">
    <?php     for($i=1;$i<=$num;$i++){
        echo "<tr>";
        if($i%2==0){
        
        for($j=1;$j<=$num;$j++){
            echo "<td style=padding:3px;background-color:lightblue>".$i*$j."</td>";
        }
        }
        if($i%2!=0){
            for($j=1;$j<=$num;$j++){
                echo "<td style=padding:3px;>".$i*$j."</td>";
            }
        }
        echo "</tr>";
    }
   }
    ?>
    </table>
    <a href="index.php">VOLVER</a>    
</body>
</html>