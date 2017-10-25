<html>
<body>

<?php
if(!isset($_POST['enviar'])){
?>
<form action="ecf-diferencia.php" method="post">
Numero 1: <input type="text" name="num1">
Numero 2: <input type="text" name="num2">
<input type="submit" name="enviar">
</form>
<?php
}
else{

$res=0;
$i;

if(($_POST["num1"]>0) && ($_POST["num1"]<=10) && ($_POST["num2"]>0) && ($_POST["num2"]<=10)){
    

    if($_POST["num1"]>$_POST["num2"]){
        $res=$_POST["num1"]-$_POST["num2"];
        for($i=0;$i<$res;$i++){
            echo "#";
        }
        /*while($res!=0){
            $res--;
            echo "#";
        }*/
    }else if($_POST["num1"]<$_POST["num2"]){
        $res=$_POST["num2"]-$_POST["num1"];
        for($i=0;$i<$res;$i++){
            echo "#";
        }
        /*while($res!=0){
            $res--;
            echo "#";
        }*/
    }else{
        echo "error";
    }
   

}
}
?>
</body>
</html>