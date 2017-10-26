<html>
<body>
<?php
$i;
$cont=0;
$num1=1;
$num2=1;


    for($i=1;$i<=1000;$i++){
        if($i%3==0){
           echo " ".$i." multiplo de 3 <br>"; 
        }
        if($i%5==0){
            echo " ".$i." multiplo de 5 <br>"; 
        }
    }
 ?>
 <p>20 primeros multiplos de 3 </p>
 <?php 
        while($cont<=20){
            $cont+=$cont;
            if($num1%3==0){
                $num1+=$num1;
                echo " ".$num1." multiplo de 3 <br>"; 
            }
        }
    
?>

</body>
</html>