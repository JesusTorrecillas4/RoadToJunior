<?php

    // Funciones con cadenas de texto (string)

    $cadena = "Hola";
    
    $cadena[0] = "C";

    echo "Ahora cadena es: ". $cadena . "<br>"; //saldra Cola (H por C)

    //Funciones  preestablecidas de PHP

    //strlen --> medir la longitud de la cadena
    $cadena = "Aquesta cadena te moltes lletres";
    $num_caracters = strlen($cadena);

    echo "El total de caracteres es: " .$num_caracters. "<br>";

    // strpos --> retorna la casella on troba la subcadena
    // dins de la cadena pasada
    // Sempre retrona la primera ocurrencia

    $email = "hola@jviladoms.cat";
    echo "Posicio @: " .strpos($email, "@"). "<br>";

    // strcmp --> string compare, compara dos cadenas
    // si retorna 0 es igual

    // strcmp($cadena1, $cadena2)
    // si retorna <0 la primera cadena es mas pequeña
    // si retorna >0 la primera cadena es mas grande

    $cadena1 = "Jesus";
    $cadena2 = "Torrecillas";
    echo "Utilizamos strcmp: " .strcmp($cadena1, $cadena2). "<br>";
    echo "Utilizamos strcmp: " .strcmp($cadena2, $cadena1). "<br>";

    // substr: retorna una subcadena de caracteres d'una
    // cadena a partir d'una posicio especificada fins
    // al final o del tamany especificat.
    // La cadena original no pateix cap modificat

    $cadena3 = "PHP es un llegnuatge facil";
    echo "El substr de 0 a 3 es: " .substr($cadena3, 0, 3). "<br>"; //Saldra PHP
    echo "El substr de 21 " .substr($cadena3,21). "<br>";

    // trim: elminar los espacios en blanco y saltos de
    // linea que hay al principio y al final de una cadena

    echo "Ejemplo con trim: " .trim("            Hola que tal
                    ") . "<br>";

    //ltrim: elimina los esacios blancos que hay en blanco al pricipio de la cadena

    echo "Ejemplo de ltim: " .ltrim("      Hola prime"). "<br>";

    // str_replace($antiga, $nova, $cadena): substotueix
    // la cadena $anotga per la cadena $nova dins de $cadena

    $cadena4 = "PHP ed facil";
    $antiga = "es facil";
    $nova = "no es dificil";

    echo "Ejemplo str_replace: " . str_replace($antiga,$nova,$cadena4). "<br>";

    // ereg_replace / eregi_repalce()

    // strtolower($cadena): passa la cadena a minuscules

    // strtoupper($cadena): passa la cadena a mayusculas

    // explode: permet dividir una cadena segons un caracter o patro

    // Exercici 1: Busca en php.net la funcion:
        //str_word_count() y pon un ejemplo
    
    // Exercici 2: busca en php.net la funcion:
        //levenshtein() y pon un ejemplo

    // Ecercici 3: buscaque es el operador ternario y pon un ejemplo

    

?>