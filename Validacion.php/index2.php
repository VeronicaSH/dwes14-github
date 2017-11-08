<?php
include ("datos.php");
$error_tel="";
$error_mail="";
$error_pass="";
$error_fecha="";
if(isset($_POST['enviar'])){
    $error=false;
    
    if (!validar_tel($_POST["telefono"])){
        $error=true;
        $error_tel;
        
    }
    if (!validar_pass($_POST["pass"])){
        $error_pass;
        $error=true;
    }
    if (!validar_fecha($_POST["fecha"])){
        $error=true;
        $error_mail;
    }
    if (!validar_email($_POST["email"])){
        $error=true;
        $error_mail;
    }
}
if(!isset($_POST['enviar'])||$error==true){

?>
<div id="cuerpo">

<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
Nombre: <input type="text" name="nombre" value="nombre" required>
Apellidos: <input type="text" name="apellidos" value="apellidos" required> 
Contraseña: <input type="password" name="pass" value="contraseña" required> <?php $error_pass="contraseña incorrecta"?>
Email: <input type="text" name="email" value="email" required><?php $error_mail="mail incorrecto"?>

Fecha: <input type="date" name="fecha" required><?php $error_fecha="fecha no valida"?>
Direccion: <input type="text" name="direccion" value="direccion" required>
Telefono: <input type="text" name="telefono" value="telefono" required><?php $error_tel="telefono incorrecto"?>
Ciclo: <select id="ciclos">
	<option value="ASIR" selected="selected">ASIR </option>
	<option value="DAW"> DAW </option>
	<option value="DAM"> DAM </option>
</select> 
<input type="submit" name="enviar">
</form>

</div>

<?php 


}else{
    echo "Formulario enviado";
}
       ?>

        
    
  