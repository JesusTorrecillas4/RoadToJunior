#include <stdio.h>

void main(){

    /*
        Pedir al usuario 10 numeros
        Indicar cual es el numero mas grande y el mas pequeño
    
    */
    int iA, iCont = 0, iMax, iMin;

    while(iCont < 10){

        printf("Intoduce un numero: ");
        scanf("%d", &iA);
       

        if(iCont==0){
            iMax = iA;
            iMin = iA;
        }
        if(iA>iMax){

            iMax = iA;
        }
        if(iA<iMin){

            iMin = iA;
        }
         iCont++;
    }
   
        printf("El numero max es %d\n", iMax);
        printf("El numero min es %d\n", iMin);












}