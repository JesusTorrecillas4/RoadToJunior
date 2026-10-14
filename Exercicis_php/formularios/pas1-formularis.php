<?php
/**
 * 
 * PHPDoc:
 * PAS 1:lES DADES ARRIBEN PER get
 * Mirar la url si van les dades
 */
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultat Pas 1</title>
    <link rel=stylesheet href="style.css">
</head>
<body>
    
        <h1>Que ha arribat al servidor?</h1>
        
        <h2>$_GET</h2>
        <pre><?php print_r($_GET); ?></pre>

        <h2>$_POST</h2>
        <pre><?php print_r($_POST); ?></pre>

        <P> <a href="pas1-formularis.html">Tornar</a></P>
</body>
</html>