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
$validCorreu = '';
$dia = '';
$telefono = '';

//var de control
$enviat = false;

//Array predefinido $_SERVER nos da informacion del servidor
/*echo "<pre>";
print_r($_SERVER);
echo "</pre>";*/

// Si el request method es POST es que ya se ha
// clicado al boton de enviar del formulario
// con method=post

if($_SERVER['REQUEST_METHOD'] === 'POST'){

    $nom = trim($_POST['nom'] ?? '');
    $correu = trim($_POST['correu'] ?? '');
    $validCorreu = trim($_POST['validcorreu'] ?? '');
    $dia = trim($_POST['dia'] ?? 'sense triar');
    $telefono = trim($_POST['telefono'] ?? '');
    $enviat = true;
}


?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscripcion FESTIVAL</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    
    <h1> Inscripcion FESTIVAL</h1>

    <?php if($enviat): ?>
    <p>
        Inscripcio rebuda:
        <?= htmlspecialchars($nom, ENT_QUOTES, 'UTF-8'); ?>
        (<?= htmlspecialchars($correu, ENT_QUOTES, 'UTF-8'); ?>),
        (<?= htmlspecialchars($validCorreu, ENT_QUOTES, 'UTF-8'); ?>),
        Telefono <?= htmlspecialchars($telefono, ENT_QUOTES, 'UTF-8'); ?>,
        dia <?= htmlspecialchars($dia, ENT_QUOTES, 'UTF-8'); ?>.
    </p>
<?php endif; ?>
    <!--<form action="pas3-formularis.php" method="post">  es lo mismo qe lade abajo ya que se linka l mismo-->
    <form method="post">

        <label for="name">Nom</label>
        <input type="name" name="nom">
        <label for="correu">Correu</label>
        <input type="email" name="correu" id="correu">
        <label for="correu">Validacio de Correu</label>
        <input type="email" name="validcorreu" id="validcorreu">
        <label for="telefono">Telefono</label>
        <input type="number" name="telefono" id="telefono">
        
        <label for="dia">Dia</label>
        <select name="dia" id="dia" >
            <option value="divendres">Divendres</option>
             <option value="disabte">Disabte</option>
        </select>

        <button>Inscribirse</button>
    </form>

</body>
</html>