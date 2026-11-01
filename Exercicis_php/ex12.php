<?php
//Teoria funciones

function peu(): void{
    echo '<footer>...</footer>';
}

//Llamamos a la funcion 3 veces
peu();
peu();
peu();


function targeta(string $nom, float $preu, int $estoc){
    echo "<h3>$nom</h3><p>$preu EUR · $estoc unitats</p>";
}

targeta('Teclado mecanico', 79.90, 4);

//----------------------------------------------------------------------------------

//Que prevalece en una funcion??
//IVA = 0.21 es el valor por defecto en el caso de que no se pase nada por parametros
function preuAmbIva(float $base, float $iva = 0.21) : float {
    return round($base * (1 + $iva), 2);
}

//Hacemos dos llamadas a la funcion
echo preuAmbIva(100);
echo '<br>'; //Aqui no le pasamos el IVA: resultado = 121
echo preuAmbIva(100, 0.10);
echo '<br>'; //Aqui si le pasamos el IVA: resultado = 110

//----------------------------------------------------------------------------------

//Para que un archivo PHP sea restrictivo hay que declarar esto en la segunda linea
//declare(strict_types=1);

//----------------------------------------------------------------------------------

//Las variables declaradas fuera, no son globales, siempre hay que pasarlas
//por parametros
$botiga = 'BitBizar';

function mostra($b): string {
    return 'Som a ' . $b . '<br>';
}

echo mostra($botiga);

//--------------------------------------------------------------------------------

//static hace que la variable sobrescriba entre llamadas, es util para
//contar cosas, pero no hay que abusar
function contar1(): int {
    static $n = 0;
    $n++;
    return $n;
}

echo contar1() . " "; // Imprime 1
echo contar1() . " "; // Imprime 2
echo contar1() . " "; // Imprime 3

function contar2(): int {
    $n = 0;
    $n++;
    return $n;
}

echo contar2() . " "; // Imprime 1
echo contar2() . " "; // Imprime 1
echo contar2() . " "; // Imprime 1

//---------------------------------------------------------------------------------

//Con lo que mas trabajaremos es con arrays
//le pasamos un array hacemos los calculos
//y devolvemos el array con las modificaciones
function valorEstoc(array $p): float{
    $total = 0.0;
    foreach($p as $item){
        $total += $item['preu'];
    }
    return $total;
}
