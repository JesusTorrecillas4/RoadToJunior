#include <stdio.h>
#include <string.h>

/*
Pedimos al usuario 3 palabras de 50
scanf(%49, &cadena)
mostrar la palabra con mas caracteres
mostrar la primera palabra de las tres (orden alfaberico)
hola
coches - Mas caracteres
avion - Primera
*/

int main(){

    // Variables
    char cadena1[50];
    char cadena2[50];
    char cadena3[50];

    printf("Introduce una palabra\n");
    scanf("%49s", cadena1);

    printf("Introduce una palabra\n");
    scanf("%49s", cadena2);

    printf("Introduce una palabra\n");
    scanf("%49s", cadena3);

    printf("%s\n", cadena1);
    printf("%s\n", cadena2);
    printf("%s\n", cadena3);

    int i1 = strlen(cadena1);
    int i2 = strlen(cadena2);
    int i3 = strlen(cadena3);

    if(i1 >= i2 && i1 >= i3){

        printf("La cadena1 es mas larga\n");

    }else if(i1 >= i2 && i1 >= i3){

        printf("La cadena2 es mas larga\n");

    }else{

        printf("La cadena3 es mas larga\n");

    }

    if(strcmp(cadena1, cadena2) < 0 && strcmp(cadena1, cadena3) < 0){

        printf("La primera cadena es %s\n", cadena1);

    }else if(strcmp(cadena2, cadena1) < 0 && strcmp(cadena2, cadena3) < 0){

        printf("La primera cadena es %s\n", cadena2);

    }else{

        printf("La primera cadena es %s\n", cadena3);

    }

    return 0;
}