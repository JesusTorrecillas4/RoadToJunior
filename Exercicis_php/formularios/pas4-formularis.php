<?php
/**
 *  Pas 4 - Validar, control d'errors i escapar
 * 
 */

//Decaracion de variables
$nom ='';
$correu ='';
$dia = '';
$errors= [];
$inscrit = false;

//Si recibimos los datos
if($_SERVER['REQUEST_METHOD'] === 'POST'){

    $nom = trim($_POST['nom'] ?? '');
    $correu = trim($_POST['correu'] ?? '');
    $dia = trim($_POST['dia'] ?? '');

    //Validar los errores
    if($nom === ''){
        $errors['nom'] = 'El nom es obligatori';
    }

    if($correu === ''){
        $errors['correu'] = 'El correu es obligatori';
    }elseif(filter_var($correu, FILTER_VALIDATE_EMAIL) == false){
        //Si han añadido un formato correcto de email
        $errors['correu'] = 'Aquest correu no te un format valid.';

    }

    if($dia !== 'divendres' && $dia  !== 'disabte'){
        $errors['dia'] = 'Has de triar un dia';
    }

    //Si el count del array es 0 -- no hya errores
    if(count($errors) === 0){
        $inscrit = true;
    }
}


?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscripcio al festival</title>
</head>
<body>
    
        <h1>Inscripcio al festival</h1>

        <?php if($inscrit):?>
        <!--Escaar los datos recibidos-->
            <p class="ok">Inscripcio feta, <?=htmlspecialchars($nom)?></p>
             <p class="ok">T'esperem el , <?=htmlspecialchars($dia)?></p>
        <?php else: ?>
             
              <!--novalidate en el form para ver los errores desde el php (servidor)-->
        <form method="post" novalidate>

            <label for="name">Nom</label>
            <input type="name" name="nom" value="<?=htmlspecialchars($nom)?>">

            <?php if(isset($errors['nom'])):?>
                <p class="error"><?= $errors['nom']?></p>
            <?php endif;?>

            <label for="correu">Correu</label>
            <input type="email" name="correu" id="correu" value="<?= htmlspecialchars($correu)?>">

            <?php if(isset($errors['correu'])):?>
                <p class="error"><?= $errors['correu']?></p>
            <?php endif;?>
        
            <label for="dia">Dia</label>

            <select name="dia" id="dia" >
                <option value="divendres"<?= $dia === 'divendres' ? 'selected' : ''?>>Divendres</option>
                <option value="disabte" <?= $dia === 'disabte' ? 'selected' : ''?>>Disabte</option>
            </select>
            
            <?php if(isset($errors['dia'])):?>
                <p class="error"><?= $errors['dia']?></p>
            <?php endif;?>

            <button>Inscribirse</button>
        </form>
        <?php endif; ?>
</body>
</html>