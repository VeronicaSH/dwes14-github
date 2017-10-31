<html>
<body>
</body>
</html>
<?php
include 'cuadrado.php';
include 'triangulo.php';
?>
<?php
class Figura{
   public $titulo;
   public $color;
   
   public function __construct($titulo, $color){
       $this->color=$color;
       $this->titulo=$titulo;
   }
    
}
$f1=new Figura("cuadrado", "rojo");
$f2=new Figura("triangulo", "azul");

?>
