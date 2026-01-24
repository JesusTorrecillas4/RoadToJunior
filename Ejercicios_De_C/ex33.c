#include <stdio.h>

/*
    Pide al usuario 10 numeros y qeu el programa calcule la suma incremental
*/
int main(){

    int num;
    int suma_total = 0;

   
    for(int i = 1;i <= 10; i++){

        printf("Intoduce un numero un numero que se  sumara con el siguinete. \n");
        scanf("%d", &num);

        suma_total += num;

         printf("La suma total es %d \n", suma_total);
    }

    printf("La suma total es %d \n", suma_total);



    return 0;

}
