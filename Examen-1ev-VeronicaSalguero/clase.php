<?php
class clase{
    public $id;
    public $nombre;
    public $discografica;
    public $year;
    public $tipo;
    public function getId(){
        return $this->id;
    }
    public function getNombre(){
        return $this->nombre;
    }
    public function getDiscografica(){
        return $this->discografica;
    }
    public function getYear(){
        return $this->year;
    }
    public function getTipo(){
        return $this->tipo;
    }
}