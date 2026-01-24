#include <stdio.h>
#include <stdlib.h>


    struct bibliotecas{

    char Titulo[25];
    char Autor[50];
    int fecha_publicacion;
    int ISBN;
    };


    int menu(){

    int opcion;

     
    
    printf("---MENU---\n");
    printf("1. Anyade un nuevo libro al sistema\n");
    printf("2. Muestra todos los libros disponibles\n"); 
    printf("3.Buscar un libro por el codigo ISBN \n");
    printf("4. Salir...\n");
    printf("Escoge una opcion\n");
    scanf("%d", &opcion);


    return opcion;
    };


    void addlibro(){

        struct bibliotecas biblioteca;
    FILE *fichero = fopen("biblioteca.txt", "a");

    if(fichero == NULL){
        printf("Error al abrir el fichero.\n");
        return;
    }

    
    printf("Inserta el Titulo\n");
    scanf("%s",biblioteca.Titulo); 
    printf("Inserta el Autor \n");
    scanf("%s",biblioteca.Autor); 
    printf("Inserta la fecha de publicacion\n");
    scanf("%d",&biblioteca.fecha_publicacion); 
    printf("Inserta el codigo ISBN\n");
    scanf("%d",&biblioteca.ISBN); 

    fprintf(fichero, "%s %s %d %d\n",biblioteca.Titulo,biblioteca.Autor,biblioteca.fecha_publicacion,biblioteca.ISBN);

    fclose(fichero);

    printf("Libro guardado exitosamente \n");
    
    };


    void muestralibros(){


        
        struct bibliotecas biblioteca;
        FILE *fichero;

        fichero = fopen("biblioteca.txt", "r");

        if(fichero == NULL){
        printf("No existe biblioteca.txt o esta vacio.\n");
        return;
        }

        
       while (fscanf(fichero, "%s %s %d %d",
                  biblioteca.Titulo, biblioteca.Autor, &biblioteca.fecha_publicacion, &biblioteca.ISBN) == 4) {

        printf("Titulo: %s | Autor: %s | Anyo: %d | ISBN: %d\n",
               biblioteca.Titulo, biblioteca.Autor, biblioteca.fecha_publicacion, biblioteca.ISBN);

               
    }

        fclose(fichero);
    }


int main(){

    int opcion;
    int isbnBuscado;
    int encontrado = 0;

    struct bibliotecas biblioteca;
     FILE *fichero;

    do{
        
        opcion = menu();


        switch(opcion){

            case 1:

                addlibro();

                break;
            
            case 2:

                muestralibros();
                break;

            case 3:

        
                

                printf("Introduce el ISBN del libro que buscas:\n");
                scanf("%d", &isbnBuscado);

                fichero = fopen("biblioteca.txt", "r");
                if (fichero == NULL) {
                    printf("No existe biblioteca.txt o no se pudo abrir.\n");
                    break;
                }

                while (fscanf(fichero, "%s %s %d %d",biblioteca.Titulo,biblioteca.Autor,&biblioteca.fecha_publicacion,&biblioteca.ISBN) == 4) {

                    if (biblioteca.ISBN == isbnBuscado) {
                        encontrado = 1;
                        printf("Libro encontrado:\n");
                        printf("El titulo es: %s\n", biblioteca.Titulo);
                        printf("El autor es: %s\n", biblioteca.Autor);
                        printf("El año es: %d\n", biblioteca.fecha_publicacion);
                        printf("El ISBN es: %d\n\n", biblioteca.ISBN);
                        break; 
                    }
                }

                fclose(fichero);

                if (!encontrado) {
                    printf("Libro no encontrado o ISBN incorrecto\n");
                }

                break;

            case 4:
                 printf("Saliedno...");
            break;
            default:

                printf("ERROR numero no valido \n");

                    break;

        

        }
    }while(opcion != 4);

    return 0;
}