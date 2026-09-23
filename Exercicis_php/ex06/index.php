<?php
const botiga = 'TGCNew';
const IVA = 0.21;
const descuento = 0.15 ;
$preu = 1289;
$total = round($preu * (1+ IVA), 2);
$totalDescuento = round($preu * (1 - descuento));


$producto = 'Carta de Luffy';
$descripcion = 'Cartra de Luffy en 5 marcha (edicion especial)';
$estoc = 2;
?>




<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TGCNew</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <h1>Tradin Card Game NEW</h1>
        <p>Esto es una tienda de cartas de one piece</p>
    </header>
    <main>
        <div class="carta1">
            <article class="producte">
                <h2><?=$producto?></h2>
                <p class="descripcio"><?=$descripcion?></p>
                <p class="preu">IVA (21%): <?= $total?></p>
                <p class="total">Total: <?= $preu?></p>

                <p>Precio con descuento <?= $totalDescuento?></p>
                <p class="estoc">Unidades disponibles: <?=$estoc?></p>
                <p class="ref">CAM-132414</p>
            </article>
            <img class="cartaImg" src="img/foto1.jpg" alt="Cartas de One Piece">
        </div>
    </main>

    <footer>
        <p>Footer de la tienda <?= botiga?></p>
    </footer>
</body>
</html>