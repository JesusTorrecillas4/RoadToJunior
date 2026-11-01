<?php
//Declaramos una constante IVA(no m¡cambia de valor)
const IVA = 0.21;

$producte = 'Teclat';
$base = 79.90;
$estoc = 4;
//Funcion predefinida para redondear 2 decimales round
$total = round($base * (1+ IVA), 2);

$nom = 'Jesus';
$cognom = 'Torrecillas';
$edad = 22;
$direccion = 'Carrer Ponts';
?>

<h2><?php echo $producte?></h2>

<p>Preu amb IVA: <?= $total;?> EUR</p>

<p>Disponibilitat: <?= $estoc ?></p>

<h2><?php echo $nom?></h2>

<p>Cognom: <?= $cognom;?></p>

<p>Edad: <?= $edad;?></p>

<p>Direccio: <?= $direccion ?></p>

