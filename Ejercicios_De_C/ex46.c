/*
    Crea un juego que genere un numero entre 1 y 100
    -Pedir al usuario que lo asivine
    -Tendras un maximo de 7 intentos
    -Despues de cada intento indicara si el numero es mas grande o mas pequeño que el introducido
    -Si lo acierta se acaba el juego (WIN)
    -Si se acaban los intenros finaliza el juego
    GAME OVER y mostrar el numero
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>


void main(){

    srand((unsigned)time(NULL));
    int aleatorio = (rand() % 100)+1;
    int veces = 7;
    int num = 0;

    printf("EMPEZAMOS EL JUEGO \n");

    do{

        printf("Tienes %d de intentos. \n", veces);
        printf("Intrdoduce un numero. \n");
        scanf("%d", &num);
        
        veces--;

        if(num == aleatorio){
            break; // ¡Ganaste! Sal del bucle inmediatamente
        
        }else if(num >= aleatorio){

            printf("El numero es mas pequenyo te has pasado \n");
        }else if(num <= aleatorio){

            printf("El numero es mas grande te has pasado \n");
        }

    }while(veces > 0);
    
    if(veces == 0){

        printf("GAME OVER. El numero era el %d \n", aleatorio);
    }else{

        printf("WIN. El numero era el %d \n", aleatorio);
    }
    

}