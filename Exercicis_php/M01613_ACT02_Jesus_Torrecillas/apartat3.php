<!DOCTYPE html>
<html lang="ca">
<head>
    <meta charset="UTF-8">
    <title>M0613 ACT02 - Apartat 3</title>
</head>
<body>
    <h1>Apartat 3 · Funcions per tractar arrays</h1>

    <?php
    $cartell = array('Txarango', 'Mushkaa', 'Oques Grasses', 'Julieta', 'Figa Flawas');

   
    // EXERCICI 1: Buscar un grup
   
    echo "<h2>Exercici 1: Buscar un grup</h2>";

    
    foreach (array('Julieta', 'Els Pets') as $grup) {
        if (in_array($grup, $cartell, true)) {
            echo "<p>$grup és al cartell.</p>";
        } else {
            echo "<p>$grup NO és al cartell.</p>";
        }
    }

    
    function buscaGrup(array $llista, string $grup)
    {
        foreach ($llista as $posicio => $valor) {
            if ($valor === $grup) {
                return $posicio; 
            }
        }
        return -1;
    }

    echo "<p>buscaGrup('Mushkaa') = " . buscaGrup($cartell, 'Mushkaa') . "</p>";
    echo "<p>buscaGrup('Els Pets') = " . buscaGrup($cartell, 'Els Pets') . "</p>";

    
    // EXERCICI 2: Les quatre ordenacions
    
    echo "<h2>Exercici 2: Les quatre ordenacions</h2>";

    $assistents = array(
        'Txarango'      => 5100,
        'Mushkaa'       => 1850,
        'Oques Grasses' => 4200,
        'Julieta'       => 2100,
        'Figa Flawas'   => 3600,
    );

    
    $c1 = $assistents;
    $c2 = $assistents;
    $c3 = $assistents;
    $c4 = $assistents;

    asort($c1); 
    arsort($c2); 
    ksort($c3); 
    krsort($c4); 

    echo "<h3>asort(): per valor, ascendent</h3><pre>";
    print_r($c1);
    echo "</pre>";
    echo "<h3>arsort(): per valor, descendent</h3><pre>";
    print_r($c2);
    echo "</pre>";
    echo "<h3>ksort(): per clau, ascendent</h3><pre>";
    print_r($c3);
    echo "</pre>";
    echo "<h3>krsort(): per clau, descendent</h3><pre>";
    print_r($c4);
    echo "</pre>";


    // EXERCICI 3: Barrejar el cartell

    echo "<h2>Exercici 3: Barrejar el cartell</h2>";

    $barrejat = $assistents;
    shuffle($barrejat);
    echo "<h3>shuffle() sobre l'associatiu</h3><pre>";
    print_r($barrejat);
    echo "</pre>";

    $sorteig = array_keys($assistents); 
    shuffle($sorteig);

    echo "<h3>Ordre del sorteig</h3><ol>";
    foreach ($sorteig as $grup) {
        echo "<li>$grup</li>";
    }
    echo "</ol>";
    ?>
</body>
</html>