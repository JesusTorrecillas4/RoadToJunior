
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Apartat 2</title>
    <style>
        table { border: none; }
        th, td { border: 1px solid #444; padding: 4px 10px; }
    </style>
</head>
<body>
<h1>Apartat 2 · Recórrer arrays</h1>


<?php
    $grups = array('Txarango', 'Mushkaa', 'Oques Grasses', 'Julieta', 'Figa Flawas');
    $grupsEstils = array(
        'Txarango'      => 'Mestissatge',
        'Mushkaa'       => 'Pop',
        'Oques Grasses' => 'Rock',
        'Julieta'       => 'Pop alternatiu',
        'Figa Flawas'   => 'Pop urbà',
    );
?>

    <h2>Exercici 1: Foreach bàsic</h2>

    <h3>Versió 1: llista de grups</h3>
        <ul>
            <?php foreach ($grups as $grup): ?>
                <li><?= $grup ?></li>
            <?php endforeach; ?>
        </ul>

    <h3>Versió 2: amb la posició</h3>
        <ul>
            <?php foreach ($grups as $posicio => $grup): ?>
                <li>Posició <?= $posicio ?>: <?= $grup ?></li>
            <?php endforeach; ?>
        </ul>

    <h2>Exercici 2: Foreach sobre un associatiu</h2>
        <table>
            <tr><th>Grup</th><th>Estil</th></tr>
            <?php foreach ($grupsEstils as $grup => $estil): ?>
                <tr>
                    <td><?= $grup ?></td>
                    <td><?= $estil ?></td>
                </tr>
            <?php endforeach; ?>
            <tr>
                <td><strong>Total de grups</strong></td>
                <td><strong><?= count($grupsEstils) ?></strong></td>
            </tr>
        </table>

    <h2>Exercici 3: El mateix sense foreach</h2>
    <table>
        <tr><th>Grup</th><th>Estil</th></tr>
        <?php
        reset($grupsEstils);
        do {
            $grup = key($grupsEstils);     
            $estil = current($grupsEstils); 
            echo "<tr><td>$grup</td><td>$estil</td></tr>";
        } while (next($grupsEstils));      
        ?>
        <tr>
            <td><strong>Total de grups</strong></td>
            <td><strong><?= count($grupsEstils) ?></strong></td>
        </tr>
    </table>



    <h2>Exercici 4: A l'inrevés, dins d'una funció</h2>

        <?php
        function recorrerInvers(array $llista)
        {
            end($llista); 
            do {
                $clau = key($llista);
                $valor = current($llista);
                echo "$clau: $valor<br>";
            } while (prev($llista)); 
        }

        echo "<h3>Recorregut invers</h3>";
        recorrerInvers($grupsEstils);

        echo "<h3>Array original amb foreach (no s'ha vist afectat)</h3>";
        foreach ($grupsEstils as $grup => $estil) {
            echo "$grup: $estil<br>";
        }
       
        ?>
    </body>
</html>