/*
    Un programa que guarde 10 numeros aleatorios entre 0 a 100 en un array

    Mostrar los numeros que inician a fin y luego de fin a inicio
*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>



void main(){

    int num[10];

 
    srand((unsigned)time(NULL));
    
    for(int i = 0;i<10;i++){

        num[i] = (rand() % 100)+1;
    }

    

    printf("Numeros del ARRAY 9 a 0: \n");
    for(int i=0;i<10;i++){

        printf("%d ", num[i]);
    }

     printf("\n Numeros del ARRAY 0 a 9: \n");
    for(int i=9;i >= 0;i--){

        printf("%d ", num[i]);
    }


}
    