<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test PHP + HTML</title>
</head>
<body>
    
    <?php 

        $name = 'Jesus';
        $age = 22;
        $city = 'Barcelona';

    ?>

    <h1>Hola Bienvenido </h1>

    <p>Hoy es <?php echo date('d/m/Y')  ?></p>

    <p>Estoy usano la version:  <?php echo PHP_VERSION ?></p>
    <P>En el sistema operativo: <?php echo PHP_OS ?></P>
    

    <p>Me llamo <?php echo $name?></p>
    <p>Tengo <?php echo $age?></p>
    <p>Y vivo en la ciudad de <?php echo $city?></p>


    
</body>
</html>