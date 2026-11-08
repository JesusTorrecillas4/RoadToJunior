<?php
declare(strict_types=1); // Comprueba los tipos de datos que pasamos a las funciones.

/** Calcula el IVA (21 % por defecto). @param float $base Precio @param float $iva Tipo de IVA @return float */
function preuAmbIva(float $base, float $iva = 0.21): float { return round($base * (1 + $iva),2); }
/** Da formato al precio. @param float $preu Precio @return string */
function formatPreu(float $preu): string { return number_format($preu,2,',','.') . ' EUR'; }
/** Indica la disponibilidad. @param int $estoc Unidades @return string */
function estatEstoc(int $estoc): string {
    if ($estoc === 0) { return 'Esgotat'; }
    if ($estoc <= 3) { return 'Últimes unitats'; }
    return 'Disponible';
}
/** Filtra por categoría. @param array $productes Catálogo @param string $categoria Categoría @return array */
function filtraCategoria(array $productes, string $categoria): array {
    if ($categoria === 'totes') { return $productes; }
    $resultat = [];
    foreach ($productes as $item) { if ($item['categoria'] === $categoria) { $resultat[] = $item; } }
    return $resultat;
}
/** Cuenta los productos con stock. @param array $productes Catálogo @return int */
function comptaDisponibles(array $productes): int {
    $n = 0;
    foreach ($productes as $item) { if ($item['estoc'] > 0) { $n++; } }
    return $n;
}
/** Calcula el valor total del stock. @param array $productes Catálogo @return float */
function valorEstoc(array $productes): float {
    $total = 0.0;
    foreach ($productes as $item) { $total += $item['preu'] * $item['estoc']; }
    return round($total,2);
}
/** Crea el resumen de la tienda. @param array $productes Catálogo @return array */
function resumCataleg(array $productes): array {
    $total = count($productes);
    $disponibles = comptaDisponibles($productes);
    return ['total'=>$total,'disponibles'=>$disponibles,'esgotats'=>$total-$disponibles,'valor_estoc'=>formatPreu(valorEstoc($productes))];
}
/** Muestra una tarjeta HTML. @param array $item Producto @return void */
function pintaTargeta(array $item): void {
    $nom = htmlspecialchars($item['nom']);
    $categoria = htmlspecialchars($item['categoria']);
    // Estas funciones reutilizan el cálculo del IVA y el formato del precio.
    $preu = formatPreu(preuAmbIva($item['preu']));
    $estat = htmlspecialchars(estatEstoc($item['estoc']));
    echo '<article class="targeta"><h3>' . $nom . '</h3><p>Categoría: ' . $categoria . '</p><p class="preu">' . $preu . '</p><p class="etiqueta">' . $estat . '</p><p>Unidades: ' . $item['estoc'] . '</p></article>';
}
/** Muestra todos los productos recibidos. @param array $productes Catálogo @return void */
function pintaGraella(array $productes): void {
    if ($productes === []) { echo '<p class="aviso">No hay productos en esta categoría.</p>'; return; }
    echo '<div class="graella">';
    foreach ($productes as $item) { pintaTargeta($item); }
    echo '</div>';
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
<!doctype html><html lang="es"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>Reto final · Catálogo BitBazar</title><link rel="stylesheet" href="estils.css"></head><body><header><h1>BitBazar</h1><p>Reto final · Catálogo BitBazar</p></header><main><section><h2>Resumen del catálogo</h2><div class="resum">
<?php foreach(resumCataleg($productes) as $clau=>$valor): ?>
<p><strong><?= htmlspecialchars($clau) ?>:</strong> <?= htmlspecialchars((string)$valor) ?></p>
<?php endforeach; ?></div></section>
<section><h2>Todos los productos</h2><?php pintaGraella($productes); ?></section>
<section><h2>Solo accesorios</h2><?php pintaGraella(filtraCategoria($productes,'accessoris')); ?></section>
<section><h2>Categoría que no existe</h2><?php pintaGraella(filtraCategoria($productes,'impresoras')); ?></section></main></body></html>
