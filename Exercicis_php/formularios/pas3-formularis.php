<?php

/**
 * 
 * PAS 3 - Una soa pagina
 * Fins ara teniem de fitxers, el formukari i el resultat
 * Mira com es fa la peticio i axi fara una cosa o altre
 *  La primera vistia es amb GET i quan es prem el boto d'enviar
 * es amb POST
 */


$nom = '';
$correu = '';
$dioa = '';

//var de control
$enviat = false;

//Array predefinido $_SERVER nos da informacion del servidor
echo "<pre>";
print_r($_SERVER);
echo "</pre>";

?>