#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
Crear un programa que tiene la cadena hola y muestra por pantalla
*/

int main(){

    // Variables
    // Para las palabras tiene que tener un caracter mas para el fin de palabra
    char palabra[5] = "hola";

    for(int i = 0; i < 5; i++){

        printf("%c", palabra[i]);

    }

    printf("\n");

    for(int i = 4; i >= 0; i--){

        printf("%c", palabra[i]);

    }

    return 0;
}