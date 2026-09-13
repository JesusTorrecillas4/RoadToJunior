<?php

    $conexion = new mysqli("localhost", "root", "", "tienda");

    if($conexion->connect_error){
        die("Error de conexion: " . $conexion->connection_error);
    }

    echo "Conexion correcta";
?>