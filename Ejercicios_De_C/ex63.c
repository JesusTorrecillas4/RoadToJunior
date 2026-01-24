#include <stdio.h>

/*
    Crear una funcion que calcule
    el doble y el triple de un numero
    y deveulva el resultado medaiante
    paso por referencia
*/


calculardobletriple(int num, int *doble, int *triple){

    *doble = num * 2;
    *triple = num * 3;

};

int main(){

    int num, doble, triple;

    printf("Introduce un numero: \n");
    scanf("%d", &num);

    calculardobletriple(num, &doble, &triple);

    printf("El doble es %d \n", doble);
    printf("El triple es %d \n", triple);


    return;
}

