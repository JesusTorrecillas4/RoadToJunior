<?php

// Funciones prestablecidas de php
// isset() --> permite saber si una variable exite en nuestro prgrama

// unset() --> libera espacio en memoria (destruye) de una variable

$var = '10';

if(isset($var)){
    echo "La variable $var existe";
}

unset($var);

if(isset($var)){
    echo "La variable $var existe";
}else{
    echo "La varaible $var no exixste";
}

// gettye() --> nos retoran el tipo de variabe que pasamos por parametro

// settype() -->asignamos un tipo de dato a la variable que pasamos por parametro

// empty() --> funcion que mira si una variable esta vacia, no existe o su valor es 0

// is_integer(var), is_double(var), is_array(var), is_string(var) --> para saber si una varaible
// es integer, double, string, array, etc

// Ex1: for para la tabla de multiplicar del 5
// var existe?

// Ex2: mostrar los numeros del 1 al 1000

// Ex3:  dibuja una tabla html donde salgan las tablas de multiplicar del 1 al 10


for ($i = 1; $i <= 10; $i++) {
    echo "5 x $i = " . (5 * $i) . "<br>";
    if(isset($i)){
    echo "La variable $i existe";
}
}

for ($i = 1; $i <= 1000; $i++) {
    echo $i ;
}


echo "<table border='1'>";

for ($i = 1; $i <= 10; $i++) {

    echo "<tr>";

    for ($j = 1; $j <= 10; $j++) {
        echo "<td>" . ($i * $j) . "</td>";
    }

    echo "</tr>";
}

echo "</table>";


?>