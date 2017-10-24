<html>
<body>

<?php
$res=0;
if($_POST["num1"]>1 ||$_POST["num1"]<10 && $_POST["num2"]>1 ||$_POST["num2"]<10 ){
    echo "error";
    
}
    if($_POST["num1"]>$_POST["num2"]){
        $res=$_POST["num1"]-$_POST["num2"];
        while($res!=0){
            $res--;
            echo "*";
        }
    }else if($_POST["num1"]<$_POST["num2"]){
        $res=$_POST["num2"]-$_POST["num1"];
        while($res!=0){
            $res--;
            echo "*";
        }
    }else{
        echo "son iguales";
    }


?>
</body>
</html>