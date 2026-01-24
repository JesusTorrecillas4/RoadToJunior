/*
    Pedir al usuario 8 letras
    Mostrar cuantas veces aparece cade letra del abecedario
    Mostrar el resultado por pantalla numero de veces que sale cada letra
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void main(){

    char letras[27] = "abcdefghijklmnopqrstuvwxyz";
    int cantidad[5] = {0, 0, 0, 0, 0};
    char palabra[9];


    for(int i = 0;i<9;i++){

    printf("Intoduce las letras \n");
    scanf(" %c", &palabra);

    }

    for(int i = 0; i<9;i++){
        
        switch(palabra[i]){

            case 'a':

                cantidad[0]++;
                break;
             case 'e':

                cantidad[1]++;
                break;
             case 'i':

                cantidad[2]++;
                break;
             case 'o':

                cantidad[3]++;
                break;
             case 'u':

                cantidad[4]++;
                break;
            default:
                break;
        }

    }

    printf("\nVocal a: %d", cantidad[0]);
    printf("\nVocal e: %d", cantidad[1]);
    printf("\nVocal i: %d", cantidad[2]);
    printf("\nVocal o: %d", cantidad[3]);
    printf("\nVocal u: %d", cantidad[4]);



}