<!DOCTYPE html>
<html lang="ca">
<head>
    <meta charset="UTF-8">
    <title>M0613 ACT02 - Apartat 4</title>
    <style>
        table { border-collapse: collapse; }
        th, td { border: 1px solid #444; padding: 4px 10px; }
    </style>
</head>
<body>
<h1>Apartat 4 · Arrays multidimensionals</h1>

<?php
$concerts = [
    ['nom' => 'Oques Grasses', 'escenari' => 'Gran', 'hora' => '22:30', 'assistents' => 4200, 'preu' => 28.0],
    ['nom' => 'Mushkaa', 'escenari' => 'Petit', 'hora' => '20:00', 'assistents' => 1850, 'preu' => 18.0],
    ['nom' => 'Figa Flawas', 'escenari' => 'Gran', 'hora' => '00:30', 'assistents' => 3600, 'preu' => 24.0],
    ['nom' => 'Julieta', 'escenari' => 'Petit', 'hora' => '21:15', 'assistents' => 2100, 'preu' => 20.0],
    ['nom' => 'Txarango', 'escenari' => 'Gran', 'hora' => '23:30', 'assistents' => 5100, 'preu' => 32.0],
    ['nom' => 'La Ludwig Band', 'escenari' => 'Petit', 'hora' => '18:45', 'assistents' => 900, 'preu' => 15.0],
];

$escenaris = [
    'Gran' => [
        'capacitat' => 6000,
        'coberta' => 'no',
        'ubicacio' => 'Pista central',
    ],
    'Petit' => [
        'capacitat' => 2500,
        'coberta' => 'sí',
        'ubicacio' => 'Pavelló',
    ],
];
?>

<h2>Exercici 1: Taula de concerts</h2>
<table>
    <tr>
        <th>Nom</th><th>Escenari</th><th>Hora</th><th>Assistents</th><th>Preu</th>
    </tr>
    <?php foreach ($concerts as $c): ?>
        <tr>
            <td><?= $c['nom'] ?></td>
            <td><?= $c['escenari'] ?></td>
            <td><?= $c['hora'] ?></td>
            <td><?= $c['assistents'] ?></td>
            <td><?= number_format($c['preu'], 2, ',', '.') ?> €</td>
        </tr>
    <?php endforeach; ?>
</table>

<p>Tercer concert (accés directe): <strong><?= $concerts[2]['nom'] ?></strong></p>

<h2>Exercici 2: Escenaris (associatiu als dos nivells)</h2>

<p>Capacitat de l'escenari Gran: <?= $escenaris['Gran']['capacitat'] ?> persones</p>

<?php foreach ($escenaris as $nomEscenari => $dades): ?>
    <h3>Escenari <?= $nomEscenari ?></h3>
    <ul>
        <?php foreach ($dades as $camp => $valor): ?>
            <li><?= ucfirst($camp) ?>: <?= $valor ?></li>
        <?php endforeach; ?>
    </ul>
<?php endforeach; ?>

</body>
</html>
