<!DOCTYPE html>
<html><head><meta charset='UTF-8'/></head>
<body>
<?php
$rutaArchivo = "files/modulos.txt";
$nuevo = "files/nuevo.txt";
//lectura de archivos
//readfile("files/modulos.txt");
//lectura archivos array
//$lineasArchivo = file($rutaArchivo);
//print_r($lineasArchivo);
//detecta fin de linea
/*$archivo = fopen($rutaArchivo, "r") or die("Imposible abrir el archivo");
while(!feof($archivo)) {
    $c = fgetc($archivo);
    if (($c == "\n") or ($c == "\r\n")) echo "<br/>";
    else echo $c;
}
fclose($archivo);*/
//escritura de archivos
$archivo = fopen($nuevo, "a") or die("Imposible  abrir el archivo para escritura");
fwrite($archivo,"Desarrollo Web en Entorno Cliente\n");
fwrite($archivo,"Diseño de interfaces Web\n");
fwrite($archivo,"Desarrollo Web en Entorno Servidor\n");
fwrite($archivo,"Despliegue de Aplicaciones Web\n");
fwrite($archivo,"Ingles Tecnico\n");

fclose($archivo);
//muestra todas las lineas del archivo
$archivo = fopen($nuevo, "r") or die("Imposible abrir el archivo");
while(!feof($archivo)) {
    echo fgets($archivo) . "<br/>";
}
fclose($archivo);

?>
</body></html>