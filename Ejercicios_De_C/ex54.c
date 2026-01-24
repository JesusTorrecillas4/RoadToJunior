/*
    strlen(cadena)---> Cuantos caracteres tiene

    strcmp(cadena1, cadena2) == 0 iguales
                                > 0 cadena1 mas grande
                                < 0 cadena2 mas pequeña

    strcat(cadena1,cadena2) Conectar las dos cadenas osea juntarlas

    strcpy(cadena3,cadena1) -- copia lo de la cadena1 en la cadena3

    Tenemos 3 arrays de caracteres:
    cadena1[50] = 'aaaa'
    cadena2[50] = 'bbbb'
    cadena3[50];

    1. Contar numeros de caracteres de cadean 1
    2. Copiar de cadena 1 a cadena 3
    3. Comparador de cadena 1 y 2
    4. Conectar cdeana 2 en cadena 1
    5. Salir

*/


#include <stdio.h>
#include <string.h>
void main(){

    char  cadena1[50] = "aaaa";
    char  cadena2[50] = "bbbb";
    char  cadena3[50];
    int opcion;

    do{

        printf("%s \n", cadena1);
        printf("%s \n", cadena2);

        printf("1. Contar numeros de caracteres de cadean 1 \n");
        printf("2. Copiar de cadena 1 a cadena 3 \n");
        printf("3. Comparador de cadena 1 y 2 \n");
        printf("4. Conectar cadena 2 en cadena 1 \n");
        printf("5. Salir...");
        printf("Introduce una opcion \n");
        scanf("%d",&opcion);



        switch (opcion)
        {
        case 1:
            
            
            printf("La cadena %s tiene una longitud de: %d\n", cadena1,strlen(cadena1));
            break;
         case 2:
            
            strcpy(cadena3, cadena1);
            printf("Cadena 3 ahora es: %d\n", cadena3);
            break;
         case 3:
            
            if (strcmp(cadena1, cadena2) == 0)
                printf("Las cadenas son iguales.\n");
            else if (strcmp(cadena1, cadena2) > 0)
                printf("Cadena 1 es mayor que cadena 2.\n");
            else
                printf("Cadena 2 es mayor que cadena 1.\n");
            break;
         case 4:
            
            strcat(cadena1, cadena2);
            printf("Cadena 1 concatenada: %s\n", cadena1);
            break;
         case 5:
            
            printf("Saliendo del programa...\n");
            break;
        
        default:

            printf("ERROR, numero incorrecto \n");
            break;
        }




    }while(opcion != 5);





}