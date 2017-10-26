<html>
<body>
<?php
if(!isset($_POST['enviar'])){
    ?>
<form action="ecf-meses.php" method="post">
Numero: <input type="text" name="num">
Bisiesto<input type="radio" name="bisiesto" value="bisiesto" >
No Bisiesto<input type="radio" name="bisiesto" value="no bisiesto" >
<input type="submit" name="enviar">
</form>
<?php
}
else{
$mes=$_POST["num"];
$bis=$_POST["bisiesto"];
$mes31=array("1","enero","3","marzo","5","mayo","7","julio","8","agosto","10","octubre","12","diciembre");
$mes30=array("4","abril","6","junio","9","septiembre","11","noviembre");
$sw1=false;
$sw2=false;
$i;

    if((strcasecmp($bis, "bisiesto")==0 && $mes=="2") || (strcasecmp($bis, "bisiesto")==0 && mes=="febrero")){
        echo " ".$mes." tiene 29 dias";
    }else if((strcasecmp($bis, "no bisiesto")==0 && $mes=="2") || (strcasecmp($bis, "bisiesto")==0 && mes=="febrero")){
        echo " ".$mes." tiene 28 dias";
    }else{
        for($i=0;$i<sizeof($mes31)-1;$i++){
            if($mes == $mes31[$i]){
                echo " ".$mes." tiene 31 dias";
            }
        }
        for($i=0;$i<sizeof($mes30)-1;$i++){
            if($mes == $mes30[$i]){
                echo " ".$mes." tiene 30 dias";
            }
        }
    }   
}
