/*
    A partir del ejercic añadir:
 
    -Menu:
        1. Mostrar suma columnas
        2. Mostrar suma filas
        3. Pedir al usuario un numero y mostrar cuantas veces aparece y en que posicion
        4. Mostrar el numero mas grande
        5. Mostar el numeor mas pequeño
        6. Pedir fila y columna, mostrar el valor
        7. Calcular y mostrar la suma de la daigonal principal.
        8. Calcular y mostra la suma de ladiagonal secundaria.
        9. Salir...
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void main(){

    srand ((unsigned)time(NULL));
    int matriz[10][10];
    int columna;
    int fila;
    int suma_fila = 0,suma_columna = 0;
    int opcion,num;

    do{

        for(int i = 0; i<10;i++){

        for(int j = 0;j<10;j++){

            matriz [i][j] = (rand() %100);
        }

        }
        for(int i = 0; i<10;i++){

        for(int j = 0;j<10;j++){

            printf(" %d ", matriz [i][j]);
        }
        printf("\n");
        }

        printf("DAME UN NUMERO ENTRE EL 0 Y EL 9. \n");
        scanf("%d", &fila);

        for(int j = 0; j<10;j++){
        suma_fila += matriz[j][fila];
        }

        printf("DAME UN NUMERO ENTRE EL 0 Y EL 9. \n");
        scanf("%d", &columna);

        for(int i = 0;i<10;i++){

        suma_columna += matriz[columna][i];
        }

        printf("*******MENU********\n");

        printf("1. Mostrar suma columnas\n");
        printf("2. Mostrar suma filas\n");
        printf("3. Pedir al usuario un numero y mostrar cuantas veces aparece y en que posicion\n");
        printf("4.Mostrar el numero mas grande\n");
        printf("5. Mostar el numeor mas pequenyo\n");
        printf("6. Pedir fila y columna, mostrar el valor \n");
        printf("7. Pedir fila y columna, mostrar el valor \n");
        printf("8. Calcular y mostra la suma de ladiagonal secundaria\n");
        printf("9. Salir...\n");
        printf("Elije una opcion \n");
        scanf("%d", &opcion);

        switch(opcion){

            case 1:

                printf("La suma de la columa es %d \n", suma_columna);
                break;

            case 2:

                printf("La suma de la fila es %d \n", suma_fila);
                break;

            case 3:

                printf("Introduce un numero. \n");
                scanf("%d", &num);

                

                break;




        }



        
    }while(opcion != 9);
    







}