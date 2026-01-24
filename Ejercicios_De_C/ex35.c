#include <stdio.h>

/*
    Realizar un programa que calcule y muestre las tablas de multiplicar del 1 al 10


*/

int main(){

    

    for(int i = 1; i <= 10; i++){

        for(int j = 1; j <=10; j++){

            printf("%d x %d = %d \n",i, j, i*j);
        }

        printf("\n");
    }
    
    return 0;
}