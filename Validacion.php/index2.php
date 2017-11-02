<?php
include ("datos.php");
$error=false;
$pass=false;
if(!isset($_POST['enviar'])){
    ?>
<div id="cuerpo">

<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
Nombre: <input type="text" name="nombre" value="nombre" required>
Apellidos: <input type="text" name="apellidos" value="apellidos" required> 
Contraseña: <input type="password" name="pass" value="contraseña" required>
Email: <input type="text" name="email" value="email" required>

Fecha: <input type="date" name="fecha" required>
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
    if (!validar_tel($_POST["telefono"])){
        $error=true;
    }
    
    
    if (!validar_pass($_POST["pass"])){
      
        $error=true;
    }else{
       
       
    }
    
    
    if (!validar_fecha($_POST["fecha"])){
        $error=true;
    }
    if (!validar_email($_POST["email"])){
        $error=true;
}

}
if($error ){
   ?> <div id="cuerpo">
    
    <form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
        Nombre: <input type="text" name="nombre" value="nombre" required>
        Apellidos: <input type="text" name="apellidos" value="apellidos" required>
        Contraseña: <input type="password" name="pass" value="contraseña" required>
        <?php  if($pass){echo"la contraseña debe tener entre 7 y 15 caracteres alfanumericos,
        incluyendo una mayuscula";}  ?>
        Email: <input type="text" name="email" value="email" required>
        <?php  echo"Ese campo no corresponde con un email";  ?>
       	Fecha: <input type="date" name="fecha" required>
         <?php  echo"No corresponde a una fecha";  ?>
        Direccion: <input type="text" name="direccion" value="direccion" required>
        Telefono: <input type="text" name="telefono" value="telefono" required>
         <?php  echo"No corresponde con un telefono";  ?>
        Ciclo: <select id="ciclos">
        	<option value="ASIR" selected="selected">ASIR </option>
        	<option value="DAW"> DAW </option>
        	<option value="DAM"> DAM </option>
        </select> 
        <input type="submit" name="enviar">
        </form>
        
        </div>
          
   <?php  
        }elseif(!$error && (isset($_POST["enviar"]))) {
            echo "Formulario enviado";
        }
       
       
       ?>

        
    
  