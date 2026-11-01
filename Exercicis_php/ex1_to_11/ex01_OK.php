<?php

    echo 'Hola';
    echo "<br>";
    echo 'Hola', ' ', 'mon';
    echo "<br>";
    echo '<p>Text</p>';
    echo "<br>";

    print 'Hola'; // retorna 1
    $x = 1; // 'Error solucionado' //creo la variable
    var_dump($x); //per depurar
    $dades = "dades correctes";
    print_r($dades);//llegible

    $nom = 'Aina';
    $edad = 19;
    $actiu = true;

    $nom = 'Bernat'; // es pot canviar
    $total = $edad + 1;
    echo $nom;

    $x = 5; //int
    $x = 'cinc'; //ara string

    $a = '10' + 5; // 15 (int)
    $b = '10' . 5; // '105' (string)

    var_dump($a, $b);

    echo "<br>";
    echo 'Hola $nom';

    echo "<br>";
    echo "Hola $nom";

    $punts = 8;

    echo 'Hola '. $nom . ', tens ' . $punts . ' punts'; // concenctracio amb .
    echo "Hola $nom, tens $punts punts"; // interpolacio
    echo "Hola {$nom} ,  tens {$punts} punts"; //interpretacio amb claus

    define ('IVA', 0.21);
    const BOTIGA = 'Ca la Web';

    echo BOTIGA; //sense el $
    $base = 24;
    $total = $base * (1+ IVA);
    //IVA = 0.10; -> daria error fatal

    $missatge = 'Hola'; // ambit global

    function salud($missatge){
        echo $missatge; // no la veu
        $intern = 'Adeu'; // ambit local
        echo $intern;
    }

    salud($missatge);
    

    //declare(strict_types=1); Primera linea del fitxer
    //int_set('display_errors', '1') canvia un parametre nomer per a  aquesta peticio
    //error_reporting(E_ALL); Decideix quins nivells d'error es tenem en compte 
    //setlocale() data_default_timerone_Set() IDIOMA I ZONA HORARIA PER A AQUEST SCRIPT
    
    ?>
