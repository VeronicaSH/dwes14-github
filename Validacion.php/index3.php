<?php
include ("datos.php");
if(!isset($_POST['enviar'])){
    ?>
<div id="cuerpo">

<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post" onsubmit="validar_pass()">
Nombre: <input type="text" name="nombre" value="nombre" required>
Apellidos: <input type="text" name="apellidos" value="apellidos" required>
Contraseña: <input type="password" name="pass" value="contraseña" required>
Email: <input type="text" name="email" value="email" required>
Dia: <input type="number" name="dia" value="dia" required>
Mes: <input type="number" name="mes" value="mes" required>
Año: <input type="number" name="anio" value="anio" required>
Direccion: <input type="text" name="direccion" value="direccion" required>
Telefono: <input type="text" name="telefono" value="telefono" required>
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
  if (validar_email($_POST["email"])){
      echo "MAIL OK";
  }else{
      echo "MAIL NO OK".$error_mail;
  }
  
  
  if (validar_tel($_POST["telefono"])){
      echo "TEL OK";
  }else{
      echo "TEL NO OK".$error_tel;
  }
  
  
  if (validar_pass($_POST["pass"])){
      echo "PASS OK";
  }else{
      echo "PASS NO OK".$error_pass;
  }
  
  
  if (validar_fecha($_POST["dia"],$_POST["mes"],$_POST["anio"])){
      echo " FECHA OK";
  }else{
      echo "FECHA NO OK".$error_fecha;
  }
        
    }
   
    
    


