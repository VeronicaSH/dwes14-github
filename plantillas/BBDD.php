<?php
//crear la clase principal en otro archivo e incluirla
//generar get de cada variable
//si en el momento del formulario ponemos una variable podemos analizarla y ordenar
$autor='';
if(isset($_REQUEST["autor"])){
    $autor=" AND autor='$_REQUEST[autor]'";
    echo "<a href='mostrarCatalogo.php'>Volver</a>";
    
}
$order='';

?>
<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
//busqueda es la caja de texto en la que introducimos la busqueda
<input type="text" name="busqueda">
<input type="submit"  name="enviar">
</form>
<table style='border:0'>
<tr style='background-color:lightblue'>
//variable order_n y order_a es para ordenar con las flechas
<th>Nombre <a href="mostrarCatalogo.php?order_n=1"> &#9650</a> 
<a href="mostrarCatalogo.php?order_n=0"> &#9660</a></th></th>
//
<th>Autor<a href="mostrarCatalogo.php?order_a=1&<?php if($autor!='') echo 'autor='.$autor; ?>"> &#9650</a> 
<a href="mostrarCatalogo.php?order_a=0&<?php if($autor!='') echo 'autor='.$autor; ?>"> &#9660</a></th></th>

</tr>
<?php

//ordenacion 
//si se ha dado a enviar
if(isset($_POST["enviar"])){
    //guardamos lo que recibimos de busqueda en una variable
    $buscar=$_REQUEST["busqueda"];
    //query para la busqueda
    $resultado= $conexion -> query("SELECT * FROM obra,autor WHERE  autor.idAutor=obra.autor AND autor.nombre='$buscar'");
}
//WHERE autor.idAutor=obra.autor igualamos el id del autor al nombre
elseif(isset($_REQUEST["order_a"]) && $_REQUEST["order_a"]==1){
    $resultado = $conexion->query("SELECT * FROM obra,autor WHERE   autor.idAutor=obra.autor $autor ORDER BY obra.Nombre ASC");
    
}elseif(isset($_REQUEST["order_a"]) && $_REQUEST["order_a"]==0){
    $resultado = $conexion->query("SELECT * FROM obra,autor WHERE  autor.idAutor=obra.autor $autor ORDER BY obra.Nombre DESC");;

    
}elseif(isset($_REQUEST["order_n"]) && $_REQUEST["order_n"]==1){
    $resultado = $conexion->query("SELECT * FROM obra,autor WHERE  autor.idAutor=obra.autor $autor ORDER BY obra.Nombre ASC");
    
    
}elseif (isset($_REQUEST["order_n"]) && $_REQUEST["order_n"]==0){
    $resultado = $conexion->query("SELECT * FROM obra,autor WHERE autor.idAutor=obra.autor $autor ORDER BY obra.Nombre DESC");;
   
    
}else{
    //creacion de la tabla y consulta principal 
    $resultado=$conexion -> query("SELECT * from obra,autor WHERE autor.idAutor=obra.autor $autor");
}
//si el resultado de las columnas es 0
if($resultado->num_rows === 0) echo "<p>No hay datos en la Base</p>";
//guardamos la tabla en un fecth_assoc
while ($obra = $resultado->fetch_assoc() ){
    echo "<tr bgcolor='lightgreen'>";
    echo "<td> <a href='mostrarObra.php?idJuego=$obra[Nombre]'> $obra[Nombre]</td>\n";
    echo "<td> <a href='mostrarCatalogo.php?autor=$obra[idAutor]' > $obra[nombre]</td>\n";
    echo "</tr>";
} 