#include <stdio.h>

int main(){

    /*
        Fes un programa que demenant dos numeros (n1 i n2), ens ddigui
        si n1 es divisible per n2
        Els dos numeros s'han de demanar per teclat.
        Has de mostrar els resultats per pantalla.
    */


    //Declaracion de variables
    int n1, n2;

    printf("Introduce el primer numero: \n");
    scanf("%d", &n1);

    printf("Introduce el segundo numero: \n");
    scanf("%d", &n2);

    //Si n1 es divisible entre n2
    //que el residu tiene que dar 0

    if(n1 % n2 ==0){
        //Significa que n1 es divisible entre n2,
        //es decir, que el residu a dado 0
        printf("n1 es dvisible entre n2. \n");

    }else{
        printf("n1 NO es divisible entre n2. \n");
    }









    return 0;
}