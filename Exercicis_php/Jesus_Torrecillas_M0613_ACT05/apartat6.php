<?php
declare(strict_types=1); // Comprueba los tipos de datos que pasamos a las funciones.

/** Intenta leer una variable externa. @return string */
function mostra(): string { return 'Somos ' . $botiga; }
/** Recibe correctamente el nombre. @param string $nom Nombre @return string */
function mostraBe(string $nom): string { return 'Somos ' . $nom; }
/** Cuenta con variable local. @return int */
function comptaLocal(): int { $n = 0; $n++; return $n; }
/** Cuenta recordando el valor anterior. @return int */
function comptaStatic(): int { static $n = 0; $n++; return $n; }
// La variable local se reinicia (1,1,1); static conserva el valor (1,2,3).
// No usamos global: es mejor pasar los datos como parámetros.

$botiga = 'BitBazar';
// Capturamos el warning intencionado para poder mostrarlo sin dejar errores activos.
$warning = '';
set_error_handler(function (int $severity, string $message) use (&$warning): bool {
    $warning = $message;
    return true;
});
mostra();
restore_error_handler();
// Warning habitual: Undefined variable $botiga (el texto puede variar según PHP).
// Para ver el warning en el log, comenta temporalmente set_error_handler y restore_error_handler.
?>
<!doctype html><html lang="es"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>Apartado 6 · Ámbito de variables</title><link rel="stylesheet" href="estils.css"></head><body><header><h1>BitBazar</h1><p>Apartado 6 · Ámbito de variables</p></header><main><section><h2>Variables</h2><p><?= htmlspecialchars(mostraBe($botiga)) ?></p>
<p>Función incorrecta (error capturado): <?= htmlspecialchars($warning) ?></p></section>
<section><h2>Contadores</h2><p>Local: <?= comptaLocal() ?>, <?= comptaLocal() ?>, <?= comptaLocal() ?></p>
<p>Static: <?= comptaStatic() ?>, <?= comptaStatic() ?>, <?= comptaStatic() ?></p></section></main></body></html>
