#include <stdio.h>

/*
    Ejemplo FOR
*/

int main(){

    
    //Mostrar lo numeros del 0 al 5

    for(int i= 0; i <= 5; i++){

        printf("El valor de la i es %d \n", i);
    }


    /*int i = 0;
    while(i <= 5){

         printf("El valir de la i es %d \n", i);
         i++;
    }*/


    //Mostrar los numeros pares del 1 al 10

    //i += 2;
    for(int i=0; i <= 10; i += 2){

        printf("Los numeors pares del 1 al 10 son %d. \n", i);
    }

    for(int i = 0; i <= 10; i++){

        if(i % 2 == 0){
            //Es par
            printf("La i con modal par es de %d \n", i);
        }
    }

    //Suma incremental del 1 al 10
    int suma = 0;
    for(int i=1; i <= 10; i++){
        suma += i;
    }

    printf("La suma incremental del 1 al 10 es: %d \n", suma);


    //Mostrar los numeros del 10 al 1 

    for( int i=10; i>= 1; i--){

        printf("Los numeros del 10 al 1 son %d \n", i);
    }







    return 0;
}