<?php
declare(strict_types=1); // Comprueba los tipos de datos que pasamos a las funciones.

/** Saluda a una persona. @param string $nom Nombre @return void */
function saluda(string $nom): void { echo '<p>Bienvenido/a, ' . htmlspecialchars($nom) . '</p>'; }
/** Muestra un producto. @param string $nom Nombre @param float $preu Precio @param int $estoc Unidades @return void */
function targeta(string $nom, float $preu, int $estoc): void {
    echo '<article class="targeta"><h3>' . htmlspecialchars($nom) . '</h3><p>' . number_format($preu,2,',','.') . ' EUR</p><p>Stock: ' . $estoc . '</p></article>';
}
// Si ponemos el precio donde va el nombre, strict_types produce un TypeError.
// La llamada incorrecta se deja comentada para que la página funcione.
// targeta(79.90, 'Teclado', 4);

?>
<!doctype html><html lang="es"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>Apartado 2 · Parámetros</title><link rel="stylesheet" href="estils.css"></head><body><header><h1>BitBazar</h1><p>Apartado 2 · Parámetros</p></header><main><section><h2>Saludos</h2><?php saluda('Ana'); saluda('Luis'); saluda('Marta'); ?></section>
<section><h2>Productos</h2><div class="graella">
<?php targeta('Teclado mecánico',79.90,4); targeta('Ratón vertical',29.95,7); targeta('Monitor QHD',289.00,0); ?>
</div></section></main></body></html>
