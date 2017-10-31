<html>
<body>

<?php
if(!isset($_POST['enviar'])){
?>
<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
Base: <input type="text" name="num1">
Altura: <input type="text" name="num2">
<input type="submit" name="enviar">
</form>
<?php
}
else{
    class Figura{
        public $titulo;
        public $color;
        
        public function __construct($titulo, $color){
            $this->color=$color;
            $this->titulo=$titulo;
        
    class Triangulo extends Figura{
        public $base;
        public $altura;
        
        public function __construct($titulo,$color,$base,$altura){
            parent::__construct($titulo, $color);
            $this->base=$base;
            $this->altura=$altura;
        }
        public function calcularArea(){
            return $this->base * $this->altura;
        }
    }
}
}
