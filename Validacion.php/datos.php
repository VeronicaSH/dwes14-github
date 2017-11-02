<html>
<head>
<title>Formulario</title>
</head>
<body>
<?php
function validar_email($valor){
    if(filter_var($valor, FILTER_VALIDATE_EMAIL) === FALSE){
        return false;
        
    }else{
        return true;
    }
}
function validar_tel($valor){
    if(preg_match("/^[9|6|7][0-9]{8}/", $valor)){
        return true;
    }else{
        return false;
       
    }
}
function validar_pass($valor){
    
    if($valor>6 && $valor<16 && preg_match("[0-9a-zA-Z]",$valor)){
        $pass=true;
        return true;
    }else{
        $pass=false;
        return false;
       
    }
    

}
function validar_fecha($valor) {
    if(preg_match("/^\d{4}\/\d{2}\/\d{2}$/", $valor)){
        return true;
    }else {
        return false;
    }
}


?>
</body>
</html>
