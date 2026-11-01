<?php

// Definicion de una funcion
// function nomFuncion($arg1, $arg2){
//      codigo de la funcion
//      return valor o no;
// }

function funcionTest(){
    $var = 10;
    return $var;
}
// como la funcion funcionTest tiene un return tengo que igualarla a una variabla para recoger el valor del return
$var_fun = funcionTest();
echo "La variable igualada a la funcion vale: $var_fun <br>";

// funcion sin return
function funcionTestSin(){
    $var = 20;
    echo "La variable dentro de la funcion vale: $var <br>";
}
funcionTestSin();

// Como podemos utilizar dentro de las funciones variables globales
$var2 = 50;
function funcionConGlobar(){
    // Para poder utilizar una variable de fuera del ambito de la funcion se utiliza la palabra reservada global
    global $var2;
    echo "La variable var2 de fuera de la funcion vale: $var2 <br>";
}
funcionConGlobar();

// Recursividad --> una funcion se puede llamar a si misma 
function factorial($numero){
    // Factorial de 5 es 5*4*3*2*1
    if($numero == 1){
        return $numero;
    }else{
        return $numero * factorial($numero - 1);
    }
}
echo "El factorial de 7 es: " . factorial(7) . "<br>";

?>