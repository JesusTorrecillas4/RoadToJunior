#include <stdio.h>
//Comenterio de una linea
/*
Comentarios de Bloque
*/

//Funcion principal es: main
//Es lo primero que se ejecuta

int main() {

    //Declaracion de las variables
    //int --> Numeros enteros
    //float --> Decimales 
    //Charm --> 1 caracter
    //Declaramos dos variables de numero entero
    int num1;
    int num2;
    int total_suma;
    int total_resta;
    int total_multi;
    float total_divi;


    char letra1;
    //printf("Introduce un caracter:  \n");
    // ente las comas y el %c dejamos un epscio para que luego pregunte y no vaya seguido
    // scanf(" %c", &letra1);
    // printf("Has añadido el caracter: %c \n", letra1);

    //printf --> Imprime un mensaje por pantalla
    //printf("Hola voy a programar mogollón.\n");
    //\n --> para que nos haga un salto de linea y no se escriba junto
    //printf("Y voy a sacar un 10 en programación.");
    printf("Dame un primer numero: \n");

    //sacnf --> funciona para "scannear" los datos que introduce el usuario por telcado.
    //1er argue¡mento --> el tipo de dato que vamos a scannear
    //%d --> integer (int)
    //&f --> flooat (decimal)
    //%c --> char (caracter)
    //2nd argumento --> dónde quiero guardar lo que hemos scanneado
     scanf("%d", &num1);

    // printf("El numero es: %d \n", num1);

    printf("Dame un segundo numero; \n");
    scanf("%d", &num2);

    total_suma = num1 + num2;
    total_resta = num1 - num2;
    total_multi = num1 * num2;
    total_divi = num1 / num2;

    printf("La suma es; %d \n", total_suma);
    printf("La suma es; %d \n", num1 + num2);
    printf("La resta es; %d \n", total_resta);
    printf("La multiplciacion es; %d \n", total_multi);
    printf("La division es; %f \n", total_divi);



     
    


    return 0;

}//Este es el Fin