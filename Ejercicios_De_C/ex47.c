#include <stdio.h>
#include <stdlib.h>
#include <time.h>
/*
    Crea una matriz de 3 x 3
    de numeros aleatorios.

    Mostrar el contenido
*/


void main(){

    int matriz[3][3];
    srand((unsigned)time(NULL));
    int aleatorio = (rand() % 50);


    //Crear matriz con numero aleatorio
    for(int i=0; i<3;i++){

        for(int j=0;j<3;j++){

            matriz[i][j] = (rand() % 50); 
        }
    }

    //Mostrar por pantalla

    for(int i=0; i<3;i++){

        for(int j=0;j<3;j++){

            printf("%d ",matriz[i][j]); 
        }
        printf("\n");
    }

}