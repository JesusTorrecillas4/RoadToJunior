<?php
$alumnes = [

    ['nom' =>'Jesus','curs' => 'DAW2', 'edat' => 22, 'nota_media' => 8],
    ['nom' =>'Pedro','curs' => 'DAW2', 'edat' => 19, 'nota_media' => 7],
    ['nom' =>'Juan','curs' => 'DAW1', 'edat' => 21, 'nota_media' => 8.8],
    ['nom' =>'Izan','curs' => 'DAW1', 'edat' => 21, 'nota_media' => 6.7],
    ['nom' =>'Oriol','curs' => 'ASIR2', 'edat' => 22, 'nota_media' => 8.5],
    ['nom' =>'Maria','curs' => 'DAW2', 'edat' => 20, 'nota_media' => 6.5],
    ['nom' =>'Alejandra','curs' => 'ASIR2', 'edat' => 20, 'nota_media' => 7.6],
    ['nom' =>'Nuria','curs' => 'ASIR1', 'edat' => 19, 'nota_media' => 9.5],
    ['nom' =>'Marc','curs' => 'ASIR2', 'edat' => 19, 'nota_media' => 5.7],
    ['nom' =>'Carmen','curs' => 'DAW2', 'edat' => 24, 'nota_media' => 6],

];

?>
<table border=1px solid black>
    <td>Nom</td>
    <td>Curs</td>
    <td>Edat</td>
    <td>Nota_mitja</td>
<?php foreach ($alumnes as $a): ?>

   <tr>
    <td><?= $a['nom'] ?></td>
    
    <td><?=$a['curs'] ?></td>
    
    <td><?=$a['edat'] ?></td>
   
    <td>Nota_media: <?=$a['nota_media'] ?></td>
    <br>
   </tr>
   <?php endforeach; ?>
</table>