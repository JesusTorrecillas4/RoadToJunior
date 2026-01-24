#include <stdio.h>

/*
    Fes un programa que demani 2 numeros
    Si so iguals, mostra que son iguals
    Si son diferents, mostra el mes gran
*/

int main(){

    int n1,n2;

    printf("Introduce el primer numero. \n");
    scanf("%d", &n1);

    printf("Introduce el segundo numero. \n");
    scanf("%d", &n2);

    if(n1 > n2){

        printf("El numero %d es mayor que %d. \n", n1, n2);

    }else{

        if( n1 == n2){

            printf("El numero %d es igual a %d, \n", n1, n2);

        }else{


            printf("El numero %d es mas grande que %d. \n", n2, n1);
        }
    }

    return 0;
}