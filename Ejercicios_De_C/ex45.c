/*
    Genera 20 numeros aleatorios entre 1 y 100
    luego muestra cuantos numeros pertenecen en cada rango:
    - 1 a 25
    -26 a 50
    -51 a 75
    -76 a 100    
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>


void main(){

    int num[20];
    int contador[4] = {0,0,0,0};

 
    srand((unsigned)time(NULL));
    
    for(int i = 0;i<20;i++){

        num[i] = (rand() % 100)+1;

    }


    for(int i = 0;i<20;i++){

        if(num[i]<=25){
            contador[0]++;
        }else if(num[i]<=50){

            contador[1]++;
        }else if(num[i]<=75){

            contador[2]++;
        }else if(num[i]<=100){

            contador[3]++;
        }


    }
    
    printf("Rango %d \n", contador[0]);
    printf("Rango %d \n", contador[1]);
    printf("Rango %d \n", contador[2]);
    printf("Rango %d \n", contador[3]);

}
