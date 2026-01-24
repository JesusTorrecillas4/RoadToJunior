/*
    Tirar un dado 10 veces
    Guardar los datos en un array
    Mostrar el array
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void main(){

    int dados[10];
    srand((unsigned)time(NULL));
    
    for(int i = 0;i<10;i++){

        dados[i] = (rand() % 10)+1;

    }

    for(int i=0;i<10;i++){

        printf("%d ", dados[i]);

    }







}