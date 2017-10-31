<html>
<body>

<?php
if(!isset($_POST['enviar'])){
?>
<form action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
Lado: <input type="text" name="num">
<input type="submit" name="enviar">
</form>
<?php
}
else{
    class Cuadrado{
        public $lado;
        
       function __construct($a){
           $this->lado=$a;
       }
       public function calcularArea(){
           return $this->lado*$this->lado;
       }
       public function calcularPerimetro(){
           return 4*$this->lado;
       }
       
    }
    $c1=new Cuadrado($_POST["num"]);
    echo "<p>Area ".$c1->calcularArea()."</p>";
    echo "<p>Perimetro ".$c1->calcularPerimetro()."</p>";

}
?>