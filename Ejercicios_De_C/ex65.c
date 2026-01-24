#include <stdio.h>
#include <stdlib.h>

/* FICHEROS */
/* Ficheros de texto: .txt*/
/* Los modos de trabajar con el fichero*/
/* Para abrir los ficheros la funcion fopen(File Opne)*/
/* 2 parametros:*/
/* - El nombre del fichero*/
/*- El modo de apertura*/
/*  r: read --> Lee el fichero existente
    w: write --> Crear un fichero nuevo (sobreescribe)
    a: add --> Añade datos al final de un fichero existente
    r+: Lee y escribe en un fichero existente
    w+: Crea un fichero nuevo y escribe
    a+: Lee y añade datos a un fichero existente
*/

int main(){

    //Puntero de tipo file
    FILE *fichero;
    // Creamos un fihcero llamado nombres.txt en modo "w"
    fichero = fopen("nombres.txt", "w");

    //Escribe en un fichero
    //Control de errores

    if(fichero != NULL){

        //Funcion para escribir en un fichero
        //fprintf
        fprintf(fichero,"Hola \n");
        fprintf(fichero, "Esto es una prueba. \n");

        //Cerrar el fichero
        fclose(fichero);

    }

    //Leer de un fichero --> "r" (read)
    fichero = fopen("nombres.txt", "r");

    if(fichero != NULL){

        //fsacnf() --> Lectura caracter a caracter
        //fgets() --> Lectura de  linea completa
        // Parametros:
            // -Varaiable donde sealmacena la linea
            // -Calculamos el tamaño de la linea
            // -Fichero

        char linea[100];

        //Con fgets()
        //Mientras haya lineas para leer del fichero, ira mostrando las lineas
        while(fgets(linea, sizeof(linea), fichero) != NULL){

            printf("%s", linea);
        }

         // Con fscanf()
        char caracter;

        do{

            fscanf(fichero, "%c", &caracter);
            printf("El archivo tiene: %c", caracter);

        // Mientras no sea el fin del fichero
        }while(!feof(fichero));

        // Cerrar fichero
        fclose(fichero);


    }


    return 0;
}