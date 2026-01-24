#include <stdio.h>

/*
    pedir 2 numeros al usuario:
    mostrar 5 y 3
    5 + 5 + 5 = 15
*/

int main(){

    int iA, iB;

    printf("Introduce un numero: ");
    scanf("%d", &iA);
    printf("Introduce un numero: ");
    scanf("%d", &iB);

    int iCont = 0;

    while(iCont < iB){

        // printf("%d + ", iA);
        if(iCont == iB-1){

            printf("%d", iA);
        }else{

            printf("%d + \n", iA);
        }
        iCont++;

    }
    printf(" = %d", iA*iB);

    return 0;
}