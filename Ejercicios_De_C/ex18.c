#include <stdio.h>

/*
    WHILE(mientras)
    Pedir 10 numeros al usuario y hacer su tabla de multiplicar
    5
    5 x 0 = 0
    5 x 10 = 50
*/

int main(){

    //Declaracion de variables
    int i = 0;
    int num;

    printf("Que numero hacer la tabla del 10? \n");
    scanf("%d", &num);

    while(i <= 10){

        printf("El resultado es: %d x %d = %d \n", num, i, num * i);



        i++;
    }





    return 0;
}