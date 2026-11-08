<?php
declare(strict_types=1); // Comprueba los tipos de datos que pasamos a las funciones.

/** Muestra la cabecera de la tienda. @return void */
function capcalera(): void {
    echo '<header><h1>BitBazar</h1><p>Tu tienda de informática</p></header>';
}
/** Muestra el pie con el año actual. @return void */
function peu(): void {
    echo '<footer>BitBazar · ' . date('Y') . '</footer>';
}
/** Función de prueba que no se ejecuta. @return void */
function prova(): void {
    echo 'No debería aparecer';
}
// Declarar una función no la ejecuta; hay que llamarla.
?>
<!doctype html><html lang="es"><head><meta charset="UTF-8"><title>Apartado 1</title><link rel="stylesheet" href="estils.css"></head><body>
<?php capcalera(); ?>
<main><section><h2>Apartado 1</h2><p>El pie de página aparece tres veces.</p></section></main>
<?php peu(); peu(); peu(); ?>
</body></html>
