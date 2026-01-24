#include <stdio.h>

/*
Programa que crea una estructura de tipo agendas, pide por pantalla los datos para rellenar la estructura y añadir los datos al archivo agendas.txt
Con la funcion fwrite
Una vez añadido los datos al archivo leemos los datos con fread
*/

int main(){

    struct agendas{

        char nombre[50];
        char apellido[50];
        int telefono;

    }agenda; // Es lo mismo que hacer struct agendas agenda;

    char seguir;

    FILE *archivo;

    archivo = fopen("agendas.txt", "w");

    if(archivo != NULL){

        do{

            printf("Introduce los datos:\n");

            printf("Nombre:\n");
            scanf("%s", &agenda.nombre);

            printf("Apellido:\n");
            scanf("%s", &agenda.apellido);

            printf("Telefono:\n");
            scanf("%d", &agenda.telefono);

            // fwrite: Estritura de estructuras
            // en ficheros
            // 1er parametro: la variable tipo estructura que queremos gurdar en el archivo
            // 2n parametro: sizeof para calcular el tamaño de estrucuta
            // 3er parametro: numeros de elementos que se van a escribir en el archivo
            // 4rt parametro: la variable con el puntero al archivo
            fwrite(&agenda, sizeof(struct agendas), 1, archivo);

            printf("\nQuieres añadir otro contacto? S/N\n");
            scanf(" %c", &seguir);

        }while(seguir != 'N' && seguir != 'n');

    }

    fclose(archivo);

    // Lectura de la estructura desde el fichero
    archivo = fopen("agenda.txt", "r");

    if(archivo != NULL){

        // Leer del archivo la estructura de ç tipo agendas y mientras haya para leer (==1) lo va añadiendo en la estructura agenda

        while(fread(&agenda, sizeof(struct agendas), 1, archivo) == 1){

            printf("El nombre es: %s\n", agenda.nombre);
            printf("El apellido es: %s\n", agenda.apellido);
            printf("El telefono es: %d\n\n", agenda.telefono);

        }

        fclose(archivo);

    }

    return 0;
}