#include <stdio.h>

/*
    Pedir 3 numeros al usuario
    guardar en un array
    mostrar los 3 numeros por pantalla


*/


void main(){

    int num[3];

    for(int i=0; i<3;i++){

        printf("Introduce un numero: \n");
        scanf("%d",&num[i]);
    }


    for(int i=0; i<3;i++){

       printf("Los numeros introducidos son %d \n",num[i]);
    }
    

















}