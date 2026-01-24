#include <stdio.h>
#include <string.h>

int main(){

    // Variables
    char nombres [5][51];

    /*STRCPY*/

    // asignar nombres
    // strcpy para asignar valores a un array de caracteres
    strcpy(nombres[0], "Juanito");
    strcpy(nombres[1], "Ana Martinez");
    strcpy(nombres[2], "Juanito");
    strcpy(nombres[3], "Ana Martinez");
    strcpy(nombres[4], "Ana Martinez");

    // mostraremos los resultados por pantalla
    for(int i = 0; i < 5; i++){

        printf("Nombre %d: %s\n", i, nombres[i]);

    }

    /*STRCAT*/

    char nombre[15] = "Pol ";
    char apellido[15] = "Perez";

    // concatenar: juntar dos variables en una
    // de derecha a izquierda
    // el resultado de la concatenacion se guarda en la variable que esta en la izquierda

    strcat(nombre, apellido);

    printf("El nombre completo es: %s \n", nombre);

    /*STRCAT 2*/

    char nombres2[5][51] = {"Luis", "Maria", "Carlos", "Ana", "Pol"};

    // Añadir martinez a todos los nombres
    for(int i = 0; i < 5; i++){

        strcat(nombres2[i], " Martinez");

        printf("%s\n", nombres2[i]);

    }

    /*STRCMP*/

    char nombre1[15] = "Ana";
    char nombre2[15] = "Ana";

    int resultado = strcmp(nombre1, nombre2);

    if(resultado == 0){

        printf("Los nombres son iguales\n");

    }else if(resultado < 0){

        printf("Nombre1 es menor que nombre2 (ASCII)\n");

    }else{

        printf("Nombre2 es menor que nombre1 (ASCII)\n");

    }

    if(strcmp(nombre1, nombre2) == 0){

        // Iguales

    }else{

        // Diferentes

    }

    // Mirar si maria esta dentro del array, si es que si, que salga mensajito por pantalla informativo, sino tambien

    char nombres3[5][51] = {"Luis", "Maria", "Carlos", "Ana", "Pol"};
    char buscar[51] = "Maria";

    for(int i = 0; i < 5; i++){

        if(strcmp(nombres3[i], buscar) == 0){

            printf("En la posicion %d si existe\n", i);

        }else{

            printf("En la posicion %d no existe\n", i);

        }

    }

    //Pedir al usuario la contrasela y la validacion de la contraseña
    // Verificar que son iguales

    char contrasena1[30];
    char contrasena2[30];

    printf("Introduce la contraseña\n");
    scanf("%s", contrasena1);
    
    do{

        printf("Vuelve a introducir la contraseña\n");
        scanf("%s", contrasena2);

        if(strcmp(contrasena1, contrasena2) == 0){

            printf("Las contraseñas son iguales\n");

        }else{

            printf("La contraseña es incorrecta\n");

        }

    }while(strcmp(contrasena1, contrasena2) != 0);


    return 0;
}