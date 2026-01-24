#include <stdio.h>

/*
FICHEROS
Ficheros de texto: .txt
Los modos de trabajar con el fichero:
fopen --> abrir ficheros
2 Parametros:
- Nombre del fichero
- Modo de apertura:
    - r --> Read --> Leer fichero
    - w --> Write --> Crear fichero nuevo
    - a --> add --> Añadir
    - r+ --> Lee y escribe fichero existente
    - w+ --> Crea un fichero nuevo y escribe
    - a+ --> Lee y añade datos a un fichero existente
*/

int main(){

    // Puntero de tipo file
    FILE *fichero;

    // Creamos un fichero llamado nombres.txt en modo "w"
    fichero = fopen("nombres.txt", "w");

    // Escribir en un fichero
    // Control de errores
    if(fichero != NULL){

        // Funcion para escribir en un fichero
        // fprintf
        fprintf(fichero, "Hola\n");
        fprintf(fichero, "Esto es una prueba.\n");

        // Cerrar el fichero
        fclose(fichero);

    }

    // Leer de un fichero
    fichero = fopen("nombres.txt", "r");

    // Control de errores
    if(fichero != NULL){

        // fscanf() --> Lectura caracter a caracter
        // fgets() --> Lectura de linea completa
        //      Parametros:
        //          - Variable donde se almacena la linea
        //          - Calculamos el tamaño de la linea
        //          - Fichero
        
        char linea[100];

        // Mientras haya lineas para leer del fichero ira mostrando las lineas
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