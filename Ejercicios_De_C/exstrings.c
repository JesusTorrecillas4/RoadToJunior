

#include <stdio.h>
#include <string.h>

int main (){

    char nombres[5][51];

    //Asignar nombres
    //strcpy para asignar valors a un array de caracteres
    strcpy(nombres[0], "Juan");
    strcpy(nombres[1], "Miguel");
    strcpy(nombres[2], "Pedro");
    strcpy(nombres[3], "Juanito");
    strcpy(nombres[4], "Ana");


    //Mostraremos los resultadis por pantalla
    for(int i=0; i<5; i++){

        printf("NOmbre %d: %s \n", i, nombres[i]);
        i+1;
    }

 //---------------------------------------------------

    char nombre[15] = "Pol";
    char apellido [15] = " Perez";

    //Concatenar: juntar dos variables en una
    //de derecha a izquierda
    //el resultado de la concatenacon se guarda en la variable
    //que esta en la izquierda

    strcat(nombre,apellido);

    printf("El nombre completo es %s\n", nombre);

    //------------------------------------------------
    /*strcmp*/

    char nombre1[15] = "Ana";
    char nombre2[15] = "Ana";

    int resultado = strcmp(nombre1,nombre2);

    if(resultado == 0){

        printf("Los nombres son iguales. \n");

    }else if(resultado < 0){

        printf("Nombre 1 es menor que nombre 2 (ASCII) \n");

    }else{

        printf("EL monbre 1 en mayor que el nombre 2 (ASCII) \n");
    }

    if(strcmp(nombre1,nombre2) == 0){

        //iguales
    }


    //-----------------------------------------------------------
    /*strcat*/


    char nombres2[5][51] = {"Lluis","Maria","Valeria","Ana","Pol"};

    //Añadir el "Martinez a todos los nombres"

    for(int i=0; i<5;i++){

        strcat(nombres2[i]," Martinez");
        printf("El nombre completo es: %s \n", nombres2[i]);

    }

    //-----------------------------------------

    char nombres3[5][51] = {"Lluis","Maria","Valeria","Ana","Pol"};
    char buscar[51] = "Maria";
    int contador = 0;

    //Mirar si Maria esta dentro del array, si es que si que salga
    //un mensaje por pantalla infomativo y sino, tambien

    for(int i=0; i<5;i++){

        if(strcmp(nombres3[i], buscar) == 0){

            //Encontrado
            printf("El nombre: %s ha aparecido \n", nombres3[i]);
            contador++;
        }

    }
    if(contador == 0){
        printf("El nombre %s no se ha encontrado. \n", buscar);
    }else{

        printf("Se ha encontrado un total de %d \n", contador);
    }
    contador = 0;

    //------------------------------------

    //Pedir al usuario la contraseña y la validacion de la contraeña
    //verificar que son iguales

    char contra1[51];
    char contra2[51];

    int resultado1;

    do{

        printf("1.Escribe una contrasenya: \n");
        scanf("%s", &contra1);

        printf("2.Escribe tu contrasenya otra vez: \n");
        scanf("%s", &contra2);

        resultado1 = strcmp(contra1,contra2);

        if(resultado1 == 0){

            printf("Contrasenya correcta adelante...\n");
        }else{

            printf("ERROR contrasenays diferentes por favor veulve a inentarlo \n");
        }


    }while(resultado1 != 0);
    





    return 0;

}