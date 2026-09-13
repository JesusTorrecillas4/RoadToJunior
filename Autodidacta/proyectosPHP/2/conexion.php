<?php

$conexion = new mysqli("localhost", "root", "", "tienda");

if($conexion->connect_error){
    die("Error de conexion: " . $conexion->connect_error);
}

echo "Conectado correctamente";


?>

<form method="POST">

    <input type="text" name="nombre" placeholder="Producto">

    <input type="number" name="precio" placeholder="Precio">

    <input type="text" name="categoria" placeholder="Categoría">

    <button type="submit">Añadir producto</button>

</form>

<?php

if ($_SERVER["REQUEST_METHOD"] === "POST") {

    $nombre = $_POST["nombre"];
    $precio = $_POST["precio"];
    $categoria = $_POST["categoria"];

    $sql = "INSERT INTO productos (nombre, precio, categoria)
            VALUES ('$nombre', '$precio', '$categoria')";

    $conexion->query($sql);

    echo "Producto añadido correctamente";
}

?>