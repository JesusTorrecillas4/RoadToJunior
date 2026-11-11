
<?php
// Carreguem la configuració i les funcions.
require_once 'config.php';
require_once 'funcions.php';

// Comprovem que s'ha arribat des del formulari.
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {

    $titolPagina = 'Accés directe';
    require 'header.php';

    echo '<h2>Aquí no s\'hi arriba directament</h2>';
    echo '<a class="tornar" href="' . PAG_FORMULARI . '">Anar al formulari</a>';

    require 'footer.php';
    exit;
}

// Recollim les dades utilitzant la funció camp().
$usuari = [
    'nom'        => camp('nom'),
    'cognoms'    => camp('cognoms'),
    'naixement'  => camp('naixement'),
    'telefon'    => camp('telefon'),
    'correu'     => camp('correu'),
    'usuari'     => camp('usuari'),
    'carrer'     => camp('carrer'),
    'poblacio'   => camp('poblacio'),
    'cp'         => camp('cp'),
    'tipus'      => camp('tipus'),
    'origen'     => camp('origen'),
    'butlleti'   => isset($_POST['butlleti']) ? 'Si' : 'No',
    'condicions' => isset($_POST['condicions']) ? 'Si' : 'No',
];

// Recollim les contrasenyes per validar-les.
$clau = $_POST['clau'] ?? '';
$clau2 = $_POST['clau2'] ?? '';

// Array per guardar els errors de validació.
$errors = [];

if ($usuari['nom'] === '') {
    $errors[] = 'El nom és obligatori.';
}

if ($usuari['cognoms'] === '') {
    $errors[] = 'Els cognoms són obligatoris.';
}

if ($usuari['correu'] === '') {
    $errors[] = 'El correu és obligatori.';
} elseif (filter_var($usuari['correu'], FILTER_VALIDATE_EMAIL) === false) {
    $errors[] = 'El correu no té un format vàlid.';
}

// Utilitzem les constants de config.php.
if (strlen($usuari['usuari']) < MIN_USUARI) {
    $errors[] = 'El nom d\'usuari ha de tenir com a mínim ' . MIN_USUARI . ' caràcters.';
}

if (strlen($clau) < MIN_CLAU) {
    $errors[] = 'La contrasenya ha de tenir com a mínim ' . MIN_CLAU . ' caràcters.';
}

if ($clau !== $clau2) {
    $errors[] = 'Les dues contrasenyes han de ser idèntiques.';
}

if ($usuari['cp'] !== '' && preg_match('/^[0-9]{5}$/', $usuari['cp']) !== 1) {
    $errors[] = 'El codi postal ha de tenir exactament 5 xifres.';
}

if ($usuari['tipus'] === '') {
    $errors[] = 'Has de triar un tipus de client.';
}

if (!isset($_POST['condicions'])) {
    $errors[] = 'Has d\'acceptar les condicions del servei.';
}

// Si no hi ha errors, generem el codi i el missatge.
$missatge = '';

if (count($errors) === 0) {

    $usuari['codi_client'] = mb_strtoupper(
        mb_substr($usuari['cognoms'], 0, 3)
    ) . random_int(100, 999);

    $missatge = match ($usuari['tipus']) {
        'particular' => 'Gràcies per confiar en nosaltres. Tens enviament gratuït a la teva primera compra.',
        'empresa' => 'Benvinguda, empresa! Pots demanar un pressupost personalitzat per a comandes grans.',
        default => 'Gràcies per registrar-te.',
    };
}

// Definim el títol segons si hi ha errors.
$titolPagina = count($errors) > 0
    ? 'No s\'ha creat el compte'
    : 'Compte creat';

// Carreguem la capçalera després de validar.
require 'header.php';
?>

<?php if (count($errors) > 0): ?>

    <h2>No s'ha pogut crear el compte</h2>

    <ul>
        <?php foreach ($errors as $error): ?>
            <li><?= htmlspecialchars($error) ?></li>
        <?php endforeach; ?>
    </ul>

    <a class="tornar" href="<?= PAG_FORMULARI ?>">Tornar al formulari</a>

<?php else: ?>

    <h2>Benvingut/da, <?= htmlspecialchars($usuari['nom']) ?></h2>

    <p>El teu correu és <?= htmlspecialchars($usuari['correu']) ?></p>

    <p><?= htmlspecialchars($missatge) ?></p>

    <!-- Mostrem les dades amb etiquetes llegibles. -->
    <table>
        <?php foreach ($usuari as $clauCamp => $valor): ?>
            <tr>
                <th><?= htmlspecialchars(etiqueta($clauCamp)) ?></th>
                <td><?= htmlspecialchars($valor) ?></td>
            </tr>
        <?php endforeach; ?>
    </table>

    <a class="tornar" href="gracies.php">Continuar</a>

<?php endif; ?>

<?php
// Carreguem el peu de pàgina.
require 'footer.php';
?>
