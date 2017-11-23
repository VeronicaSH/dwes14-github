<?php

class Animal{
    public $chip;
    public $nombre;
    public $tipo;
    public $imagen;   
    
    public function getChip(){
        return $this->chip;
    }
    public function getNombre(){
        return $this->nombre;
    }
    public function getTipo(){
        return $this->tipo;
    }
    public function getImagen(){
        return $this->imagen;
    }
    public function __toString(){
        return "$this->chip $this->tipo $this->nombre $this->imagen";
    }
}
