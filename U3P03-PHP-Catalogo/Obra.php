<?php
class Obra{
    public $idJuego;
    public $nombre;
    public $genero;
    public $consola;
    public $autor;
    
    public function getIdJuego(){
        return $this->idJuego;
    }
    public function getNombre(){
        return $this->nombre;
    }
    public function getGenero(){
        return $this->genero;
    }
    public function getConsola(){
        return $this->consola;
    }
    public function getAutor(){
        return $this->autor;
    }
}
