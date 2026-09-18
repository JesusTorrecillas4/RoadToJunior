//alert("Hola desde JavaScript");

/*
    Tipos de datos:
      Numeros: 3 , 3.5
      Cadena de texto: "Hola" , 'Hola'
      Boleanos: True o False
      Objetos: Estructura de datos
      Arrays: Colecciones de elementos ordenados


    Declaracion de variables:
      -var nombre = "jesus";
       nombre = "Miguel"
      var nombre = "Raquel"

      -let (de bloc)
       let edad = 15;

      -const(constante)
       const pi = 3,14

       Operadores:
        Aritmeticos
            + sumer
            - restar
            * multiplicar
            / dividir
            % calcular el residuo
            ++ SUMAR 1
            -- restar 1
        Asignacion:
            =
            +=
            -=
            *=
            /=
            %=
        Comparacion:
            ==
            ===
            !=
            !===

        Operadores Logicos:
         && AND
         || OR
         ! NOT
        Concatenar
         +

        Ternaris
         ?
*/ 

var nom = "Juan";
if(true){
    var nom = "Jesus";
}
//alert(nom);
console.log(nom);
//Ejemplo de let
let edad = 30;
if (edad >= 18){
    let mensaje = "Eres mayor de edad";
    //alert(mensaje); 
    console.log(mensaje);
}
//alert(mensaje); //Error porque no exsite fuera del if 

const PI = 3.1416;
//alert(PI);
console.log(PI);
//Operadores aritemeticos
let a = 3;
let b = 2;
let total = a + b;
console.log("El total de " + a + " + " + b  +" es igual a " + total);
//Operaciones asignacion
let c = 3;

c += 2;
console.log(c);

//Comparaciones
3 == "3"; //Da true
3 === "3" //Da false
3 != "3" //Da false
3 !== "3" //Da true

//Concatenacion

let n = "Jesus";
console.log("Hola " + n);

//Ternari
let age = 20;
const majorEdad = age >= 18 ? "Si" : "No" ;
console.log("Es mayor de edad?" + majorEdad);

//Interactivo
//let n2 = prompt("Instroduce un valor");
//console.log("Valor introducido: " + n2);

/*Pedir dos numeros al usuario y una
operacion y dar el total 5 + 2 Total 7*/

//let pedir1 = prompt("Introduce un numero")*1;
//let pedir2 = prompt("Introduce otro numero")*1;
//let oper = prompt("Introduce la operacion");
/*let total2 = "error";
if(oper == "+"){
    total2 = pedir1 + pedir2;
}if(oper == "-"){
    total2 = pedir1 - pedir2;
}if(oper == "*"){
    total2 = pedir1 * pedir2;
}if(oper == "/"){
    total2 = pedir1 / pedir2;
}*/


//console.log("El total es : " + total2);

/*

    Pedir tres numeros al usuario
    mas granda y mas pequeño

    Ejemplo:
    8 3 6
    mas grande: 8
    mas pequeño: 3

*/ 
/*let pedir3 = prompt("Introduce un numero")*1;
let pedir4 = prompt("Introduce otro numero")*1;
let pedir5 = prompt("Introduce un numero")*1;

let grande = pedir3;
let peque = pedir3;
if(pedir3 < pedir4){
    grande = pedir4;
}if(grande < pedir5){
    grande = pedir5;
}if(pedir4 < peque){
    peque = pedir4;

}

console.log("El mas grande es:"+ grande);
console.log("El mas pequeño es:"+ peque);
*/ 

/*
    un valor del 0 al 10 
    Introducir nota: 4
    nota INS (4)
*/

let nota = prompt("Instroduce una nota")*1;

switch (nota) {
    case 1:
        console.log("La nota " + nota + " es Insuficiente");
        break;
    case 2:
        console.log("La nota " + nota + " es Insuficiente");
        break;
    case 3:
        console.log("La nota " + nota + " es Insuficiente");
        break;
    case 4:
        console.log("La nota " + nota + " es Insuficiente");
        break;
    case 5:
        console.log("La nota " + nota + " es Suficiente");
        break;
    case 6:
        console.log("La nota " + nota + " es Suficiente");
        break;
    case 7:
        console.log("La nota " + nota + " es Bien");
        break;
    case 8:
        console.log("La nota " + nota + " es Vale bien");
        break;
    case 9:
        console.log("La nota " + nota + " es Muy bien");
        break;
    case 9:
        console.log("La nota " + nota + " es Super bien");
        break;

    default:
        //console.log("Error");
        break;
}