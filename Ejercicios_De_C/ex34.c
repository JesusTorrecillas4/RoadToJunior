#include <stdio.h>

/*
    Pide al usuario 10 numeros y que el programa nos diga 
    cual es el numero mas pequeño y mas grande de los que ha introducido el usuario
*/

int main(){

    int num;
    int min , max ;

    
    for(int i = 0; i <= 10; i++){

        printf("Introduce un numero. \n");
        scanf("%d", &num);


        if(i == 0){

            max=num;
            min=num;
            
        }

        if(num < min){
            min = num;
        }
        if(num > max){

            max=num;
        }
    }

    printf("El numero mas grande es %d y el mas peque es %d. \n", max, min);

    return 0;
}
