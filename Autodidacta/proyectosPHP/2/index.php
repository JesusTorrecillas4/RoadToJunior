<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mi primera web PHP</title>
</head>
<body>
    
        <h1>Mi primera pagina WEB</h1>

        <?php
        

            echo "Hola desde PHP";

            $nombre = "Jesus";
            $edad = 22;
            echo "Hola " . $nombre;
        
        ?>

        <h1>Bienvenido <?php echo $nombre; ?></h1>

        <p>Tienes <?php echo $edad; ?> años</p>


        <form method="POST">
            <input type="text" name="nombre" placeholder="Tu nombre">
            <input type="email" name="email" placeholder="Tu email">
            
            <button type="submit">Enviar</button>
        </form>

        <?php
        
            if($_SERVER["REQUEST_METHOD"] === "POST"){

            $nombre = $_POST["nombre"];
            $email = $_POST["email"];

               echo "<h2>Hola $nombre</h2>";
               echo "<p>Tu email es: $email</p>";
            }

        ?>
</body>
</html>