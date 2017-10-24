<html>
<body>
<form action="ecf-diferencia.php" method="post">
Numero 1: <input type="text" name="num1">
Numero 2: <input type="text" name="num2">
<input type="submit" name="enviar">
</form>
<?php
$num1;
$num2;
$res;
while($num1<=10 && $num2<=10){
    if($num1>$num2){
        $res=$num1-$num2;
        while($res!=0){
            $res-=$res;
            echo "*";
        }
    }else if($num1<$num2){
        $res=$num2-$num1;
        while($res!=0){
            $res-=$res;
            echo "*";
        }
    }else{
        echo "son iguales";
    }
}

?>
</body>
</html>