<?php
declare(strict_types=1); // Comprueba los tipos de datos que pasamos a las funciones.

/** Imprime un precio con IVA. @param float $base Precio base @return void */
function preuAmbIvaEcho(float $base): void { echo $base * 1.21; }
/** Devuelve un precio con IVA. @param float $base Precio base @return float */
function preuAmbIva(float $base): float { return round($base * 1.21,2); }
/** Formatea un precio. @param float $preu Precio @return string */
function formatPreu(float $preu): string { return number_format($preu,2,',','.') . ' EUR'; }
// echo muestra el resultado; return lo devuelve para poder sumarlo o guardarlo.
// No se puede sumar preuAmbIvaEcho() porque devuelve void (ningún valor).

// Array con tres precios para sumar su IVA.
$preus = [19.95, 79.90, 29.50];
$total = 0.0;
foreach ($preus as $preu) { $total += preuAmbIva($preu); }
?>
<!doctype html><html lang="es"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>Apartado 3 · echo y return</title><link rel="stylesheet" href="estils.css"></head><body><header><h1>BitBazar</h1><p>Apartado 3 · echo y return</p></header><main><section><h2>Precios con IVA</h2><p>Con echo: <?php preuAmbIvaEcho(20.0); ?></p>
<p>Con return: <?= formatPreu(preuAmbIva(20.0)) ?></p></section>
<section><h2>Resumen</h2><p>Total con IVA: <?= formatPreu($total) ?></p>
<p>Precio más caro con IVA: <?= formatPreu(preuAmbIva(max($preus))) ?></p></section></main></body></html>
