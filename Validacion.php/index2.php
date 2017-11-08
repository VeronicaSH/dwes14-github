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
        $error_tel="telefono incorrecto";
        
    }
    if (!validar_pass($_POST["pass"])){
        $error_pass="contraseña incorrecta";
        $error=true;
    }
    if (!validar_fecha($_POST["fecha"])){
        $error=true;
        $error_fecha="fecha no valida";
    }
    if (!validar_email($_POST["email"])){
        $error=true;
        $error_mail="mail incorrecto";
    }
}
if(!isset($_POST['enviar'])||$error==true){

?>
<div id="cuerpo">

<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
Nombre: <input type="text" name="nombre" value="nombre" required>
Apellidos: <input type="text" name="apellidos" value="apellidos" required> 
Contraseña: <input type="password" name="pass" value="contraseña" required> <?php echo $error_pass?>
Email: <input type="text" name="email" value="email" required><?php echo $error_mail?>

Fecha: <input type="date" name="fecha" required><?php echo $error_fecha?>
Direccion: <input type="text" name="direccion" value="direccion" required>
Telefono: <input type="text" name="telefono" value="telefono" required><?php echo $error_tel?>
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

        
    
  