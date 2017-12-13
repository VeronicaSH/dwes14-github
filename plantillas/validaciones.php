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




//comprobacion de las funciones de validacion
//primero mostramos el formulario y en el else hacemos las comprobaciones
//}else{
    if (!validar_tel($_POST["telefono"])){
        $error=true;
    }
    
    
    if (!validar_pass($_POST["pass"])){
        $error=true;
    }
    
    
    if (!validar_fecha($_POST["dia"],$_POST["mes"],$_POST["anio"])){
        $error=true;
    }
    if (!validar_email($_POST["email"])){
        $error=true;
    }
    
//}
//si hay error se vuelve a mostrar el formulario
if($error){
    
}elseif(!$error && (isset($_POST["enviar"]))) {
    echo "Formulario enviado";
}
