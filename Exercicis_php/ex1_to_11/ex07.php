<?php 

$nota = 7.5;

if($nota == 9){
    $qualif = 'Exel·lent';
}elseif($nota >= 7){
    $qualif = 'Notable';
}elseif($nota >= 5){
    $qualif = 'Aprovat';
}else{
    $qualif = 'Suspes';
}
?>

$estoc = 10;

<?php if ($estoc > 0){ ?>
    <p>En estoc</p>
<?php } else { ?>
    <p>Esgotat</p>
<?php } ?>


<?php if ($estoc > 0): ?>
    <p>En estoc</p>
<?php  else: ?>
    <p>Esgotat</p>
<?php endif; ?>

<?php
/*
    if (...): endif;
    for(...): endfor;
    foreach(...): endforeach;
    while(...): endwhile;
*/

//SWTICH

$zona = 'local';
switch($zona){

    case 'local':
        $environment = 0;
        break;
    case 'peninsula':
        $environment = 4.95;
        break;
    default:
        $environment = 9.95;
}

//MATCH ES COMO EL NUEVO SWITCH
$environment = '';

$environment = match ($zona){
    'local' => 0,
    'peninsula' => 4.95,
    default => 9.95,
};

for($i = 1; $i <= 10; $i++){
    echo $i;
}

$saldo = 3;
$objectiu = 10;
$anys = 9;
while($saldo < $objectiu){
    $saldo *= 1.03;
    $anys++;
}

do{
    $n = rand(1,6);
}while($n !== 6);

?>

<table>
<?php for($i = 0; $i <= 10; $i++): ?>
    <tr>
        <td><?= $i ?> x7 </td>
        <td><?= $i * 7 ?></td>
    </tr>
<?php endfor; ?>
</table>

<?php

$colors = ['vermell', 'verd','blau'];

echo $colors[0]; //vermell
echo count($colors); //3
$colors[] = 'groc'; //affegeix al final

print_r($colors);


////////////////////////////////////////////

$producte = [

    'nom' => 'Teclat mecanic',
    'preu' => 79.90,
    'estoc' => 4,
];

echo $producte['nom'];
$producte['preu'] = 69.90;

foreach($colors as $color){
    echo "<li>$color</li>";
    
}

foreach($producte as $clau => $valor){
    echo "<td>$clau</td>";
    echo "<br>";
    echo "<td>$valor</td>";
    echo "<br>";
}

$productes = [
    ['nom' => 'Teclat mecanic','preu' => 79.90],
    ['nom' => 'Ratoli','preu' => 24.5],
    ['nom' => 'Monitor','preu' => 189],
];
?>

<?php foreach ($productes as $p): ?>
   <tr>
    <td><?= $p['nom'] ?></td>
    
    <td><?=$p['preu'] ?></td>
   </tr>
   <?php endforeach; ?>


<?php

/* 
    FUNCION                       QUE FA

    count($a)                     Quants elements te
    in_array($x , $a, true)       Si un valorhi es(el true fa la comparacio estricta)
    array_key_exists('k', $a)     Si una clau existeix
    sort / rsort / ksort          Ordena per valor o per clau
    array_sum /max /min           Suma, maxim i minim
    array_column($a, 'preu')      Treu una columna d'un array d'arrays
    implode(',', $a) / explode    Array a text i text a array
*/