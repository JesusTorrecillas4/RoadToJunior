#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
Crear una matriz de 10 x 10 con numeros aleatorios
Pedir al usuario un numero entre 0 y 9
Sumar los numeros de la fila seleccionada
Pedir otro numero entre 0 y 9
Sumar todos los numeros de la columna seleccionada
*/

int main(){

    // Variables
    int num[10][10];
    int seleccion;
    int suma_fila = 0;
    int suma_columna = 0;

    srand((unsigned)time(NULL));

    for(int i = 0; i < 10; i++){

        for(int j = 0; j < 10; j++){

            num[i][j] = rand() % 50;

        }

    }

    printf("\nNUMEROS \n");

    for(int i = 0; i < 10; i++){

        for(int j = 0; j < 10; j++){

            printf("%d  ", num[i][j]);

        }

        printf("\n");

    }

    printf("Introduce el numero de fila para sumar (0 - 9): \n");
    scanf("%d", &seleccion);

    for(int i = 0; i < 10; i++){

        suma_fila += num[i][seleccion];

    }

    printf("\nNUMEROS \n");

    for(int i = 0; i < 10; i++){

        for(int j = 0; j < 10; j++){

            printf("%d  ", num[i][j]);

        }

        printf("\n");

    }

    printf("Introduce el numero de columna para sumar (0 - 9): \n");
    scanf("%d", &seleccion);

    for(int i = 0; i < 10; i++){

        suma_columna += num[seleccion][i];

    }

    printf("La suma total de fila es: %d La de columna es: %d \n", suma_fila, suma_columna);

    return 0;
}