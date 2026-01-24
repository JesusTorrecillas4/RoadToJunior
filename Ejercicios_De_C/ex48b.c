#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
A partir del ejercicio añadir:
- Menu:
1. Mostrar suma columnas (antiguo)
2. Mostrar suma filas (antiguo)
3. Pedir al usuario un numero y mostrar cuantas veces aparece y en que posiciones
4. Mostrar el numero mas grande
5. Mostrar el numero mas pequeño
6. Pedir fila y columna, mostrar el valor
7. Calcular y mostrar la suma de la diagonal principal
8. Calcular y mostrar la suma de la diagonal secundaria
9. SALIR...
*/

int main(){

    // Variables
    int num[10][10];
    int seleccion;
    int fila;
    int columna;
    int suma_fila = 0;
    int suma_columna = 0;
    int n;
    int suma_repetidos = 0;
    int max;
    int min;
    int peticion_fila;
    int peticion_columna;
    int suma_diagona_principal = 0;
    int suma_diagona_secundaria = 0;

    srand((unsigned)time(NULL));

    for(int i = 0; i < 10; i++){

        for(int j = 0; j < 10; j++){

            num[i][j] = rand() % 50;

        }

    }

    do{

        for(int i = 0; i < 10; i++){

            for(int j = 0; j < 10; j++){

                printf("%d  ", num[i][j]);

            }

            printf("\n");

        }

        printf("MENU:\n");
        printf("1. Mostrar suma columnas\n");
        printf("2. Mostrar suma filas\n");
        printf("3. Mostrar cuantas veces aparece un numero y posiciones\n");
        printf("4. Mostrar el numero mas grande\n");
        printf("5. Mostrar el numero mas pequeño\n");
        printf("6. Pedir fila y columna, mostrar el valor\n");
        printf("7. Calcular y mostrar la suma de la diagonal principal\n");
        printf("8. Calcular y mostrar la suma de la diagonal secundaria\n");
        printf("9. SALIR\n");

        printf("Elige una opcion:\n");
        scanf("%d", &seleccion);

        switch(seleccion){

            case 1:

                printf("Introduce el numero de columna para sumar (0 - 9): \n");
                scanf("%d", &columna);

                for(int i = 0; i < 10; i++){

                    suma_columna += num[columna][i];

                }

                printf("La suma de columna es: %d \n", suma_columna);

                break;
            
            case 2:

                printf("Introduce el numero de fila para sumar (0 - 9): \n");
                scanf("%d", &fila);

                for(int i = 0; i < 10; i++){

                    suma_fila += num[i][fila];

                }

                printf("La suma de fila es: %d \n", suma_fila);

                break;
            
            case 3:

                printf("Elige un numero: \n");
                scanf("%d", &n);

                printf("El numero %d aparece en las posiciones:\n", n);
                
                for(int i = 0; i < 10; i++){

                    for(int j = 0; j < 10; j++){

                        if(num[i][j] == n){

                            suma_repetidos ++;

                            printf("Posicion i=%d j=%d   ", i, j);

                        }

                    }

                }

                printf("\nEl numero total de veces que se repite es: %d\n", suma_repetidos);

                break;
            
            case 4:

                max = num[0][0];
                
                for(int i = 0; i < 10; i++){

                    for(int j = 0; j < 10; j++){

                        if(num[i][j] > max){

                            max = num[i][j];

                        }

                    }

                }

                printf("El numero mas grande es: %d \n", max);

                break;
            
            case 5:

                min = num[0][0];
                
                for(int i = 0; i < 10; i++){

                    for(int j = 0; j < 10; j++){

                        if(num[i][j] < min){

                            min = num[i][j];

                        }

                    }

                }

                printf("El numero mas pequeño es: %d \n", min);

                break;
            
            case 6:

                printf("Elige una posicion de fila (0-9) \n");
                scanf("%d", &peticion_fila);

                printf("Elige una posicion de columna (0-9) \n");
                scanf("%d", &peticion_columna);

                printf("El numero es: %d \n", num[peticion_fila][peticion_columna]);

                break;
            
            case 7:

                suma_diagona_principal = 0;

                for(int i = 0; i < 10; i++){

                    suma_diagona_principal += num[i][i];

                }

                printf("La suma de la diagonal principal es: %d\n", suma_diagona_principal);

                break;
            
            case 8:

                suma_diagona_secundaria = 0;

                int j = 9;

                for(int i = 0; i < 10; i++){

                    suma_diagona_secundaria += num[i][j];
                    
                    j --;

                }

                printf("La suma de la diagonal secundaria es: %d\n", suma_diagona_secundaria);

                break;
            
            case 9:

                printf("SALIENDO... \n");

                break;
            
            default:

                printf("ERROR\n");

        }

    } while (seleccion != 9);

    return 0;
}