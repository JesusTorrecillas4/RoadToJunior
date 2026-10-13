<?php
// EXERCICI 1: Les tres maneres

echo "<h2>Exercici 1: Les tres maneres</h2>";

// 1
$grups[0] = 'Txarango';
$grups[] = 'Mushkaa';        
$grups[] = 'Oques Grasses';  
$grups[8] = 'Julieta';      
$grups[] = 'Figa Flawas';    

// 2
$estils = array('Mestissatge', 'Pop urbà', 'Rumba');

// 3
$edicions = range(2019, 2026);
$paraules = explode(' ', 'El festival torna aquest estiu');

echo "<h3>\$grups</h3><pre>";
print_r($grups);
echo "</pre>";

echo "<h3>\$estils</h3><pre>";
print_r($estils);
echo "</pre>";

echo "<h3>\$edicions</h3><pre>";
print_r($edicions);
echo "</pre>";

echo "<h3>\$paraules</h3><pre>";
print_r($paraules);
echo "</pre>";


echo "<h3>print_r(\$estils)</h3><pre>";
print_r($estils);
echo "</pre>";

echo "<h3>var_dump(\$estils)</h3><pre>";
var_dump($estils);
echo "</pre>";

echo "<h3>var_export(\$estils)</h3><pre>";
var_export($estils);
echo "</pre>";

// EXERCICI 2: L'array associatiu

echo "<h2>Exercici 2: L'array associatiu</h2>";


$estils = [];                         
$estils['Txarango'] = 'Mestissatge';   
$estils['Mushkaa'] = 'Pop';           


$estils += array('Oques Grasses' => 'Rock', 'Figa Flawas' => 'Pop urbà');


echo "<p>L'estil de Txarango és: " . $estils['Txarango'] . "</p>";


$estils['Julieta'] = 'Pop alternatiu';
echo "<pre>";
print_r($estils);
echo "</pre>";


echo "<p>Nombre de grups: " . count($estils) . "</p>";

// EXERCICI 3: Esborrar una casella

echo "<h2>Exercici 3: Esborrar una casella</h2>";

$cartell = array('Txarango', 'Mushkaa', 'Oques Grasses', 'Julieta', 'Figa Flawas');
echo "<p>Abans d'esborrar (count = " . count($cartell) . "):</p><pre>";
print_r($cartell);
echo "</pre>";

unset($cartell[2]); 
echo "<p>Després de unset (count = " . count($cartell) . "):</p><pre>";
print_r($cartell);
echo "</pre>";

$cartell[] = 'La Ludwig Band';
echo "<p>Després d'afegir amb [] (count = " . count($cartell) . "):</p><pre>";
print_r($cartell);
echo "</pre>";

?>