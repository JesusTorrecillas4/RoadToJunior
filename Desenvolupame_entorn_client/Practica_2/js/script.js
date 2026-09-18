//Estructuras de control

//if/else

let edad = 22;

if(edad>=18){
    console.log("Es mayor de edad");
}else{
    cosnole.log("Es menor de edad");
}

//Switch
    let dia = 2;

    switch (dia) {
        case 1:
            console.log("Lunes");
            break;
        case 2:
            console.log("Martes");
            break;
         case 3:
            console.log("Miercoles");
            break;
        case 4:
            console.log("Jueves");
            break;
        case 5:
            console.log("Viernes");
            break;
        default:
            console.log("fin de demana");
            break;
    }

//Bucles
//for

for(let i=0; i<5;i++){
    console.log("Vuelta: "+i);
}

//While puede no ejecutar

let c = 0;
while(c < 5){
    console.log("Contador: "+ c);
    c++;
}

// do while - minimo 1 vez se ejecuta
// como n es mayor que tres solo se ejecutara una vez
let n = 4;
do{
    console.log("Valor de n: "+ n);
    n++;
}while(n < 3);

//Funciones

function saludar(nombre){
    console.log("Hola, "+ nombre)
}

saludar("Jesus");

function sumar(a , b){
    return a + b;
}

let total = sumar(2,3);
console.log(total);

//funciones anonimas
const suma = function(a,b){
    return a + b;
}
let resultado1 = suma(3,4);
console.log(resultado1);

// Funciones de flecha

const resta = (a,b) => a - b;
let resultadoResta = resta(3,2);
console.log(resultadoResta);

const sal = () =>{
    console.log("Hola");
};

sal();

//Pedir dos valores al suario y realizar la suma
//de los numeros internos
// 5 i 9 --> 5+6+7+8+9

/*let pedir1 = prompt("Dame un numero")*1;
let pedir2 = prompt("Dame otro numero")*1;
let total1 = 0;
let mensaje = "";

for(let i=pedir1; i<=pedir2;i++){
    total1+=i;
    if(i!=pedir2){
         mensaje+=i + " + ";
    }else{
         mensaje+=i + " + ";
    }
}
console.log(mensaje + total1);

if(pedir1 <= pedir2){
    while(pedir1 <= pedir2){
    console.log("Total: "+ pedir1);
    pedir1++;
    }
}else{

    while(pedir2 <= pedir1){
    console.log("Total: "+ pedir2);
    pedir2++;
    }
}*/

/*
    Pedir al programa numeros hasta que presione una letra
    Mostrar cuantos pares e impares hay
    Ejemplo:
    Numeros introducidos: 3 - 5 - 6 - 7 - 8
    2 pares
    3 impares
*/
let num1;
let mensaje = "";
let par = 0;
let impar = 0;
/*do{

    num1 = prompt("Instroduce un numero")*1;
    if(!isNaN(num1)){
        mensaje+= num1 + "  " ;

        if(num1%2 == 0){
            par++
        }
        if(num1%2!=0){
            impar++
        }
        }
    


}while(!isNaN(num1));

console.log(mensaje);
console.log(par + " pares");
console.log(impar + " impares");*/

/*let resultado = document.getElementById("resultado");

//resultado.textContent = "Hola, ";
//resultado.innerHTML = "Hola, <Strong> Jesus </Strong>"
resultado.innerHTML = "<p>" + mensaje + "</p>";
resultado.innerHTML = "<p>" + par + " pares</p>";
resultado.innerHTML = "<p>" + impar + " impares</p>";*/

/*document.write("<h3>" + mensaje + "</h3>");
document.write(par + " pares <br>");
document.write(impar +" impares");*/

function sumar(a,b){
    return a + b;
}
function calcular(){
        console.log("Funciona");
    document.getElementById("a");
        console.log(a.value);
    document.getElementById("b");
        console.log(b.value);
    let resultado = document.getElementById("resultado");
    resultado.textContent = sumar(a.value*1,b.value*1);

}


