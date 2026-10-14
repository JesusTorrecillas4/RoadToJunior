<?PHP

/**
 * pas 2 - Recollir les dades correctament
 */



// trim para sacar los espacios y inicializar si la varaible venia vacia
$nom = trim($_POST['nom'] ?? '');
$correu = trim($_POST['correu'] ?? '');
$dia = trim($_POST['dia'] ?? 'sense triar');


echo "<p>Hola, " .$nom. "</p>";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultat PAS 2</title>
</head>
<body>
    
    <h1>Dades recollides: </h1>

    <ul>
        <li>Nom: <?= $nom ?></li>
        <li>Correu: <?= $correu ?></li>
        <li>Dia: <?= $dia ?></li>
    </ul>


    <p>El nom te <?= strlen($nom)?> caracters</p>

</body>
</html>