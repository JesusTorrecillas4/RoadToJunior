
<?php
/**
 * Recull un camp de text del formulari ja net d'espais.
 *
 * @param string $camp Nom del camp del formulari
 * @param string $defecte Valor si el camp no ha arribat
 * @return string El valor net
 */
function camp(string $camp, string $defecte = ''): string
{
    return trim($_POST[$camp] ?? $defecte);
}

/**
 * Converteix la clau de l'array en una etiqueta llegible.
 *
 * @param string $clau Clau de l'array
 * @return string Etiqueta per mostrar a la taula
 */
function etiqueta(string $clau): string
{
    $noms = [
        'nom' => 'Nom',
        'cognoms' => 'Cognoms',
        'naixement' => 'Data de naixement',
        'telefon' => 'Telèfon',
        'correu' => 'Correu',
        'usuari' => 'Nom d\'usuari',
        'carrer' => 'Carrer i número',
        'poblacio' => 'Població',
        'cp' => 'Codi postal',
        'tipus' => 'Tipus de client',
        'origen' => 'Com ens has conegut?',
        'butlleti' => 'Butlletí',
        'condicions' => 'Condicions',
        'codi_client' => 'Codi de client'
    ];

    return $noms[$clau] ?? ucfirst($clau);
}
