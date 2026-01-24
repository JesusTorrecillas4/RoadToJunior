#include <stdio.h>

/*
    Pedir 5 numeros al usuario
        -Almacenar en un array los 5 numeros
        -Copiar los numeros en otro array
        -Crear un array con el resultado de la multiplicacion de cada posicion

        Array 1 --> 3 2 4 1 5
        Array 2 --> 3 2 4 1 5
        Array 3 --> 9 4 16 1 25
*/

void main(){

    int num1[5],num2[5],num3[5];

     for(int i=0;i<5;i++){
            printf("Introduce 5 numeros \n");
            scanf("%d",&num1[i]) ; 
        } 

    for(int i=0; i<5; i++){

        num2[i] = num1[i];

    }

    for(int i =0; i<5; i++){

        num3[i]= num1[i]*num2[i];

        
    }

    printf("Resultado num: \n");
    for(int i=0; i<5; i++){

        printf("Total: %d\n", num3[i]);

    }

}