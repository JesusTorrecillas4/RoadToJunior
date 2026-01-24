#include <stdio.h>

int main( ){

    /*
        Vamos a hacer un programa que pedira la edad al usuario y tiene que verificar si es mayor de edad
        Control de errores: si el usuario añade un numero menor de 0 saldra un mensaje por pantalla indicando el error
    */

    int edad;

    printf("Intoduce tu edad \n");
    //Escaneamos la edad que el usuario ha introducido por tecaldo y lo guardamos en la variable edad

    //IMPORANTE: 
    //1er argumento: %d --> pq es un entero (int)
    //2nd argumento: &edad --> no dejarse nunca el &
    scanf("%d", &edad);

    //Aqui verificamos si la edad es mayor a 0
    if(edad > 0){

        //Si entra aqui significa que es mayor de 0

        if(edad >= 18){

            //Si entra aqui significa que es mayor de 18
            printf("Felicidades , ya eres amyor de edad, tines %d! \n", edad);
        }else{

            printf("Ohhhh aun no eres mayor de edad, tienes %d \n", edad);

        }

    }else{

        //Si entra aqui significa que edad es menor de 0

        printf("Has añadido un numero negativo, my mal has añadodo un %d \n", edad);


    }



   
   
   
   
   
   
   
   
   
   
   
   
   
    return 0;

} // Este es el fin