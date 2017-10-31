<?php 


    class Figura{
        private $color="azul";
        
        public function __construct( $c){
            $this->color=$c;
            
        }
        public function getColor(){
            return $this->color;
        }
        public function setColor($c)
        {
            $this->color=$c;
        }
        
    }
    
    class Cuadrado extends Figura{
        public $lado;
        
       function __construct($color,$lado){
           parent::__construct($color);
           $this->lado=$lado;
       }
       public function calcularArea(){
           return $this->lado*$this->lado;
       }
       public function calcularPerimetro(){
           return 4*$this->lado;
       }
       public function imprimir(){
           foreach ($this as $clave => $valor){
               echo "$clave => $valor\n";
           }
       }
       
    }
   



?>