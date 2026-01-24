/*
    Generar 50 numeros aleatorios entre 1 y 100
    Mostrar por pantalla la media de los numeros generados
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>


void main(){

    int num[50];
    int total = 0;

 
    srand((unsigned)time(NULL));
    
    for(int i = 0;i<50;i++){

        num[i] = (rand() % 100)+1;

        total+=num[i];
    }


    printf("La media es %d \n", total/50);






}
