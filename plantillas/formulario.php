<?php ?>
<div id="cuerpo">

<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
    Nombre: <input type="text" name="nombre" value="nombre" required>
    Apellidos: <input type="text" name="apellidos" value="apellidos" required>
    Contras�a: <input type="password" name="pass" value="contrase�a" required>
    Email: <input type="text" name="email" value="email" required>
    
    Dia: <input type="number" name="dia" value="dia" required>
    Mes: <input type="number" name="mes" value="mes" required>
    A�o: <input type="number" name="anio" value="anio" required>
    
    
    
    <input type="submit" name="enviar">
    </form>
    
    </div>