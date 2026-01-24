#include <stdio.h>

/*
    Procedimiento for
*/


int main(){

    int num;

    //1. Inizialicacion de la variable de control del bucle for
    //2. Condicion para que se siga ejecutando el bucle for
    //3. Incremento de la varaible de control
    for(int i = 0; i < 10; i++){

        printf("Intoduce un numero: \n");
        scanf("%d",&num);

        if(num>0){

            printf("El numero %d es positivo. \n", num);

        }else{

            printf("El numero %d es negativo. \n", num);
        }



    }









    return 0;
}