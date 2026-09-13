<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mi tienda</title>
</head>
<body>
    
        <h1>Mi tienda</h1>

        <?php

        $conexion = new mysqli("localhost", "root", "", "tienda2");

        if ($conexion->connect_error) {
            die("Error de conexión");
        }

        $sql = "SELECT * FROM productos";

        $resultado = $conexion->query($sql);

        while($productos = $resultado->fetch_assoc()){

              echo "<p>";
              echo $productos["nombre"] . " - ";
              echo $productos["precio"] . " € - ";
              echo $productos["categoria"];
              echo "</p>";
        }

        ?>

        <h2>Añadir productos</h2>

        <form method="POST">

         
        <input type="text" name="nombre" placeholder="Nombre">

        <input type="number" name="precio" placeholder="Precio">

        <input type="text" name="categoria" placeholder="Categoría">

        <button type="submit">Añadir producto</button>

        </form>
</body>
</html>