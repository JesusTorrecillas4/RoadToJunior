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

// Ex1: for para la tabla de multiplicar del 5, var existe?
$num = 5;
if(isset($num)){
    for($i = 1; $i <= 10; $i++){
        echo "$num x $i = " . $num * $i;
        echo "<br>";
    }
}else{
    echo "La variable no existe";
}

// Ex2: mostrar los numeros pares del 1 al 1000
    for($i = 1; $i <= 100; $i++){
        if($i %2 == 0){
            echo "$i <br>";
        }
    }

// Ex3: dibuja una tabla html donde salgan las tablas de multiplicar del 1 al 10


?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        table, tr, td{
            border: 1px solid black;
        }
    </style>
</head>
<body>

    <!-- Ex3 -->
    <table>
    <?php for($i = 1; $i <= 10; $i++): ?>
        <tr>
        <?php for($j = 1; $j <= 10; $j++): ?>
                <td><?= $i ?> x <?= $j ?> = <?= $i * $j ?></td>
        <?php endfor; ?>
        </tr>
    <?php endfor; ?>
    </table>

</body>
</html>