#include <stdio.h>

/*
MENU
1. Registrarse: pedimos el nombre del usuario y guardamos en un fichero
2. Mostrar los datos: mostrar el nombre gurdado en el fichero
Todo almacenado en un fichero
*/

int main(){

    // Variables
    char nombre[50];
    int opcion;
    int contador_nombre = 0;

    // Puntero del fichero
    FILE *fichero;

    do{

        printf("\nMENU\n");
        printf("1. Registrar nombre\n");
        printf("2. Mostrar datos\n");
        printf("3. SALIR\n");
        printf("Introduce una opcion:\n");
        scanf("%d", &opcion);

        switch(opcion){

            case 1:

                printf("Introduce el nombre que quieres registrar\n");
                scanf("%s", nombre);

                fichero = fopen("ex61.txt", "a");

                if(fichero != NULL){

                        fprintf(fichero,"Nombre %d:\n", contador_nombre + 1);
                        fprintf(fichero, "%s\n", nombre);

                    fclose(fichero);

                }
                
                contador_nombre ++;

                break;

            case 2:

                fichero = fopen("ex61.txt", "r");

                if(fichero != NULL){

                        char linea[200];

                        while(fgets(linea, sizeof(linea), fichero) != NULL){

                            printf("%s", linea);

                        }
                
                }

                break;

            case 3:

                printf("SALIENDO...\n");

                break;

            default:

                printf("ERROR\n");

        }

    }while(opcion != 3);

    return 0;
}