#include <stdio.h>

/*
    Pedimos 10 numeros
    se almacenan en un array

    Le pedimos al usuario un numero y nos dice si esta almacenado o no
*/

void main(){

    int num[10], numu, encontrado = 0;


    for(int i=0;i<10;i++){

        printf("Intoduce un numero \n");
        scanf("%d", &num[i]);
    }


    printf("Introduce un numero para ver si se ha introducido antes \n");
    scanf("%d", &numu);

    for(int i=0; i<10; i++){

        if(numu == num[i]){

            encontrado = 1;
            break;
        }
    }

    if(encontrado==1){

        printf("El numero %d existe. \n", numu);
    }else{

        printf("El numer %d no existe. \n", numu);
    }
    
}