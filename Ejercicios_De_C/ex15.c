#include <stdio.h>
/*
    IF-ELSE
    Pedir al usuario una nota numerica y mostrar el numero y la letra
    De 0 a 4 tienes que mostrar insuficiente (INS)
    DE 5 sufieiceinte (SUF)
    6(BE)
    7-8(NOT)
    9-10(EX)    
    
*/

int main (){

    float nota;

    printf("Intoduce tu nota: \n");
    //Ponemos %f porque es un (float) decimal
    scanf("%f", &nota);

    if(nota < 5){

            // Si entra aqui la nota es menor de 5 (PERO NO IGUAL A 5), es decir el 4,9 entra aqui en ISNSUFICIENTE
        printf("Tu nota %f es un INSUF. \n", nota);
    }else if(nota < 6){

        printf("Tu nota es %2.f es un SUF \n", nota);
    }else if(nota < 7){

        printf("Tu nota es %2.f es un BE \n", nota);
    }else if(nota < 9){

        printf("Tu nota es %2.f es un NOT \n", nota);
    }else if(nota <= 10){

        printf("Tu nota es %2.f es un EX \n", nota);
        
    }else{

        printf("ERROR 404");
    }
    







    return 0;
}