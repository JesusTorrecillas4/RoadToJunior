/*
    Pedimos al usuario 3 palabras de [50]
    scanf(%49,cadean)

    mostrar lapalabra con mas caracteres
    mostrar la primera palabra de las tres (orden alfabetico)

    hola
    coches <--- Mas caracteres
    avion <--- La primera

*/

#include <stdio.h>
#include <string.h>

int main(void) {
    char palabra1[50], palabra2[50], palabra3[50];
    char mayor[50];   // para guardar la palabra más larga
    char primera[50]; // para guardar la primera en orden alfabético

    // Pedimos las 3 palabras al usuario
    printf("Introduce la primera palabra: ");
    scanf("%49s", palabra1);

    printf("Introduce la segunda palabra: ");
    scanf("%49s", palabra2);

    printf("Introduce la tercera palabra: ");
    scanf("%49s", palabra3);

    // --------------------------
    // PALABRA CON MÁS CARACTERES
    // --------------------------
    strcpy(mayor, palabra1); // asumimos que la primera es la mayor

    if (strlen(palabra2) > strlen(mayor))
        strcpy(mayor, palabra2);

    if (strlen(palabra3) > strlen(mayor))
        strcpy(mayor, palabra3);

    // --------------------------
    // PRIMERA EN ORDEN ALFABÉTICO
    // --------------------------
    strcpy(primera, palabra1); // asumimos que la primera es la menor

    if (strcmp(palabra2, primera) < 0)
        strcpy(primera, palabra2);

    if (strcmp(palabra3, primera) < 0)
        strcpy(primera, palabra3);

    // --------------------------
    // MOSTRAMOS RESULTADOS
    // --------------------------
    printf("\nPalabra con más caracteres: %s\n", mayor);
    printf("Primera palabra en orden alfabético: %s\n", primera);

    return 0;



    
}
