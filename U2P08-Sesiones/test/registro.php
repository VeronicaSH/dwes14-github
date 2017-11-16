<?php
if (session_status () == PHP_SESSION_NONE){
    session_name("idsesion");
    session_start ();
}
if(isset($_SESSION["name"])){
    header('Location: index.php');
}
  
    if(isset($_POST["nombre"])) {
        $_SESSION['name']=$_POST["nombre"];
        header('Location: index.php');
    }else{
        echo "Introduce nombre";
        
        ?>
<html>
    <head>
    </head>
 
    <body>
           
            <form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST">
                    <p>
                            <input type="text" name="nombre" />
                    </p>
                    <p>
                            <input type="submit" value="enviar" />
                    </p>
            </form>
    </body>
</html>
<?php

}

    

