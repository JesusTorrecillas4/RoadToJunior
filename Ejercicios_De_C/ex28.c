#include <stdio.h>

/*
    Pedir un numero al usuario que este entre uno y 10
    si no esta entre 1 y 10, vuelve a pedirlo
    al finalizar mostrar el numero y el numero de intentos
*/


void main(){

    int num;
    int i = 0;
    do {
        printf("Introduce un numero: \n");
        scanf("%d", &num);

        i++;
    }while((num > 10) || (num < 0));

    printf("El numero introducido es %d y lo has intentado %d veces: \n", num, i);
}