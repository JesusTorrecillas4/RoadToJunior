<?php
/*
    Aques fitxer te 6 errors: 3 de sintaxis (PHP no arranca)
    i 3 de logica (funciona, pero el resultat no es el correcte)

    Arregla'ls d'un en un, comprovant la pagina despres de cada canvi
    Anota a error-trobats.md quin era, com te n' has adonat i com l' has resolt
*/


//nom = 'Aina'; le falta el $
$nom = 'Aina';

//$assignatura = 'Desenvolupament web' Le falta el ; final
$assignatura = 'Desenvolupament web';

$nota1 = 7;
$nota2 = 9;
//$mitjana = $nota1 + $nota2 /2; le falta la () para que haga la suma primero
$mitjana = ($nota1 + $nota2) /2;

echo '<h1>Bulleti de notes </h1>';
//echo '<p>Alumna: $nom </p>'; SI va una variable la frase tiene que ir ent re "" dobles
echo "<p>Alumna: $nom </p>";
//echo '<p>Assignatura:' + $assignatura'</p>'; el + al  de $assignatura no vale para nada y le falta las comillas dobles
echo "<p>Assignatura:  $assignatura </p>";
//echo "<h1>Mitjana: $mitjana </p>; Le dalta la comilla ultima para cerrar 
echo "<p>Mitjana: $mitjana </p>";

echo '<p>Generat el ' . date('D/M/Y'). ' </p>';

?>