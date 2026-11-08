<?php
declare(strict_types=1); // Comprueba los tipos de datos que pasamos a las funciones.

/** Calcula el precio con IVA. @param float $base Precio @param float $iva Tipo de IVA @return float */
function preuAmbIva(float $base, float $iva = 0.21): float { return round($base * (1 + $iva),2); }
/** Aplica un descuento. @param float $preu Precio @param int $percentatge Descuento @return float */
function aplicaDescompte(float $preu, int $percentatge = 10): float { return round($preu * (1 - $percentatge / 100),2); }
/** Devuelve un saludo. @param string $nom Nombre @param string $salutacio Saludo @return string */
function benvinguda(string $nom, string $salutacio = 'Hola'): string { return "$salutacio, $nom"; }
/** Formatea un precio. @param float $preu Precio @return string */
function formatPreu(float $preu): string { return number_format($preu,2,',','.') . ' EUR'; }
// Los parámetros opcionales van al final; ponerlos primero puede generar avisos.
// Ejemplo incorrecto: function benvinguda(string $salutacio = 'Hola', string $nom): string

?>
<!doctype html><html lang="es"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>Apartado 4 · Valores por defecto</title><link rel="stylesheet" href="estils.css"></head><body><header><h1>BitBazar</h1><p>Apartado 4 · Valores por defecto</p></header><main><section><h2>IVA</h2>
<p>IVA 21 %: <?= formatPreu(preuAmbIva(100.0)) ?></p>
<p>IVA 10 %: <?= formatPreu(preuAmbIva(100.0,0.10)) ?></p>
<p>IVA 4 %: <?= formatPreu(preuAmbIva(100.0,0.04)) ?></p></section>
<section><h2>Descuentos y saludos</h2>
<p>Descuento habitual: <?= formatPreu(aplicaDescompte(100.0)) ?></p>
<p>Descuento del 25 %: <?= formatPreu(aplicaDescompte(100.0,25)) ?></p>
<p><?= htmlspecialchars(benvinguda('Ana')) ?></p><p><?= htmlspecialchars(benvinguda('Luis','Buenas')) ?></p></section></main></body></html>
