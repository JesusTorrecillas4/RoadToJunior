<?php
declare(strict_types=1); // Comprueba los tipos de datos que pasamos a las funciones.

/** Suma el valor de todas las unidades. @param array $productes Catálogo @return float */
function valorEstoc(array $productes): float {
    $total = 0.0;
    foreach ($productes as $item) { $total += $item['preu'] * $item['estoc']; }
    return round($total,2);
}
/** Cuenta los agotados. @param array $productes Catálogo @return int */
function quantsEsgotats(array $productes): int {
    $n = 0;
    foreach ($productes as $item) { if ($item['estoc'] === 0) { $n++; } }
    return $n;
}
/** Calcula el precio medio. @param array $productes Catálogo @return float */
function preuMitja(array $productes): float {
    if (count($productes) === 0) { return 0.0; } // Evita dividir entre cero.
    $total = 0.0;
    foreach ($productes as $item) { $total += $item['preu']; }
    return round($total / count($productes),2);
}
/** Filtra productos con stock. @param array $productes Catálogo @return array */
function nomesDisponibles(array $productes): array {
    $res = [];
    foreach ($productes as $item) { if ($item['estoc'] > 0) { $res[] = $item; } }
    return $res;
}
/** Busca el producto más caro. @param array $productes Catálogo @return array */
function elMesCar(array $productes): array {
    if ($productes === []) { return []; }
    $car = $productes[0];
    foreach ($productes as $item) { if ($item['preu'] > $car['preu']) { $car = $item; } }
    return $car;
}
/** Resume el catálogo. @param array $productes Catálogo @return array */
function resumCataleg(array $productes): array {
    return ['total'=>count($productes),'disponibles'=>count(nomesDisponibles($productes)), 'mes_car'=>elMesCar($productes)];
}

// Array con el catálogo de productos del enunciado.
$productes = [
 ['nom'=>'Teclat mecanic RGB','categoria'=>'teclats','preu'=>79.90,'estoc'=>4],
 ['nom'=>'Ratoli vertical','categoria'=>'ratolins','preu'=>29.95,'estoc'=>7],
 ['nom'=>'Monitor 27" QHD','categoria'=>'monitors','preu'=>289.00,'estoc'=>0],
 ['nom'=>'Auriculars ANC','categoria'=>'audio','preu'=>129.00,'estoc'=>2],
 ['nom'=>'Hub USB-C 7 en 1','categoria'=>'accessoris','preu'=>34.90,'estoc'=>20],
 ['nom'=>'Suport per a portatil','categoria'=>'accessoris','preu'=>24.50,'estoc'=>0],
];
?>
<!doctype html><html lang="es"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>Apartado 7 · Arrays</title><link rel="stylesheet" href="estils.css"></head><body><header><h1>BitBazar</h1><p>Apartado 7 · Arrays</p></header><main><section><h2>Cálculos</h2>
<p>Valor del stock: <?= number_format(valorEstoc($productes),2,',','.') ?> EUR</p>
<p>Productos agotados: <?= quantsEsgotats($productes) ?></p>
<p>Precio medio: <?= number_format(preuMitja($productes),2,',','.') ?> EUR</p>
<p>Media de un array vacío: <?= preuMitja([]) ?></p></section>
<section><h2>Productos disponibles</h2><?php foreach(nomesDisponibles($productes) as $item): ?>
<p><?= htmlspecialchars($item['nom']) ?></p><?php endforeach; ?></section>
<section><h2>Producto más caro</h2><p><?= htmlspecialchars(elMesCar($productes)['nom']) ?></p></section>
<section><h2>Resumen con foreach</h2>
<?php foreach(resumCataleg($productes) as $clau=>$valor): ?>
<p><strong><?= htmlspecialchars($clau) ?>:</strong> <?= is_array($valor) ? htmlspecialchars($valor['nom'] ?? 'Ninguno') : $valor ?></p>
<?php endforeach; ?></section></main></body></html>
