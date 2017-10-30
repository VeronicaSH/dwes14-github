<html>
<body>

<?php
if(!isset($_POST['enviar'])){
?>
<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
radio: <input type="text" name="num1">
<input type="submit" name="enviar">
</form>
<?php
}
else{
    class Circulo{
        public $radio;
        
        function __construct($radio) {
            $this->radio=$_POST["num1"]=$radio;
            
        }
        public function calcularArea() {
            return Math.PI*(Math.pow($this->radio, 2));
        }
        public function calcularPerimetro() {
            return 2*(Math.PI)*$this->radio;  
        }
        public function imprimir() {
            echo "Area".$radio->calcularArea();
            echo "Perimetro".$radio->calcularPerimetro;
        }
    }
    $cir1=new Circulo();
    echo "Area".$radio->calcularArea();
    echo "Perimetro".$radio->calcularPerimetro;
}