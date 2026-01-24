/*
    Cambiar vocales por numeros

    casa
    c4s4

    a - 4
    e - 3
    i - 1
    o - 0
    u - 7

*/


#include <stdio.h>

void main() {
    char palabra[15];
    

    printf("Escribe una palabra: ");
    scanf(" %s",palabra); 

    for (int i = 0; palabra[i] != '\0'; i++) {
       
        switch (palabra[i]) {
            case 'a':
            case 'A':
                palabra[i] = '4';
                break;
            case 'e':
            case 'E':
                palabra[i] = '3';
                break;
            case 'i':
            case 'I':
                palabra[i] = '1';
                break;
            case 'o':
            case 'O':
                palabra[i] = '0';
                break;
            case 'u':
            case 'U':
                palabra[i] = '7';
                break;
        }
    }

    printf("Resultado: %s\n", palabra);
}