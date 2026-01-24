#include <stdio.h>

/*
    WHILE(mientras)
    Pedir 10 numeros al usuario y mostrar por pantalla el numero introducido multiplicado por si mismo
    5x5=25
*/

int main(){

    //Declaramos las variables
    int i = 0;
    int num;

    while(i < 10){

        printf("Intoduce un numero: \n");
        scanf("%d", &num);

        printf("La multiplicacion de %d x %d = %d \n", num, num, num * num);


        i++;
    }











    return 0;
}