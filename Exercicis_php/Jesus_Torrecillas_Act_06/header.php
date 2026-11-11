
<?php
// Si no s'ha definit un títol, fem servir "Inici".
if (!isset($titolPagina)) {
    $titolPagina = 'Inici';
}
?>

<!DOCTYPE html>
<html lang="ca">
<head>
    <meta charset="UTF-8">
    <title><?= htmlspecialchars($titolPagina) ?> · <?= BOTIGA_NOM ?></title>
    <link rel="stylesheet" href="<?= FULL_ESTILS ?>">
</head>
<body>

    <header>
        <h1><?= BOTIGA_NOM ?></h1>
        <p><?= BOTIGA_LEMA ?></p>
    </header>

    <main>
