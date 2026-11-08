<?php
declare(strict_types=1); // Comprueba los tipos de datos que pasamos a las funciones.

/** Calcula el área de un rectángulo. @param float $base Base @param float $altura Altura @return float */
function area(float $base, float $altura): float { return $base * $altura; }
/** Comprueba si no queda stock. @param int $unitats Unidades @return bool */
function esgotat(int $unitats): bool { return $unitats === 0; }
// strict_types impide pasar texto cuando una función espera un número.
// Es mejor recibir un error que convertir datos sin darnos cuenta.

// try/catch captura el TypeError y evita que se pare toda la página.
try { area('3',4.0); $error = 'Sin error'; }
catch (TypeError $e) { $error = 'Error de tipus: ' . $e->getMessage(); }
?>
<!doctype html><html lang="es"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>Apartado 5 · Tipos de datos</title><link rel="stylesheet" href="estils.css"></head><body><header><h1>BitBazar</h1><p>Apartado 5 · Tipos de datos</p></header><main><section><h2>Área</h2>
<p>Con decimales: <?= area(3.0,4.0) ?></p>
<p>Con enteros: <?= area(3,4) ?></p>
<p>Con texto: <?= htmlspecialchars($error) ?></p>
<p>Con conversión: <?= area((float)'3',4.0) ?></p>
<p>¿Está agotado (0 unidades)? <?= esgotat(0) ? 'Sí' : 'No' ?></p></section></main></body></html>
