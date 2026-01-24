#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
Escribe una funcion ue canvie el signo de todos los elementos de un array utilizando paso por referencia (positivo a negativo)
Escribe una funcion que intercanvie dos elementos de un array utilizando paso por referencia (cambiar posicion de dos numeros en un array)
Escribe una funcion que sume un valor a todos los elementos del array utilizando paso por referencia (sumar un valor a todos los del array)
*/

void mostrarArray(int *arr, int arrLen){

    printf("[");

    for(int i = 0; i < arrLen; i++){

        if(i == arrLen -1){

            printf("%d", arr[i]);

        }else{

            printf("%d, ", arr[i]);

        }

    }

    printf("]");

}

void cambiarSignos(int *arr, int arrLen){

    for(int i = 0; i < arrLen; i++){

        arr[i] *= -1;

    }

}

sumarValorATodo(int *arr, int iElementoUno, int iElementoDos){

    int elementoUno = iElementoDos;
    int elementoDos = iElementoUno;

    iElementoUno = elementoDos;
    iElementoDos = elementoUno;

}

int main(){

    int arrLen = 0; // Array Leigth

    srand((unsigned)time(NULL));

    printf("De cuantos elementos quieres el array?\n");
    scanf("%d", &arrLen);

    int arr[arrLen];

    for(int i = 0; i < arrLen; i++){

        arr[i] = ((rand() % 20) + 1) - 10;

    }

    mostrarArray(arr, arrLen);

    cambiarSignos(arr, arrLen);

    printf("Signos cambiados\n");

    mostrarArray(arr, arrLen);









    // Variables
    int num[5];
    int posiciones[2];

    // Pedir numeros
    for(int i = 0; i < 5; i++){

        printf("Introduce el numero de la posicion %d\n", i);
        scanf("%d", &num[i]);

    }

    // Cambia positivos a negativos y negativos a positivos
    for(int i = 0; i < 5; i++){
        
        cambio(&num[i]);

    }



    // Muestra numeros
    for(int i = 0; i < 5; i++){

        printf("%d ", num[i]);

    }










    return 0;
}