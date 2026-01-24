#include <stdio.h>

//Funcion principal
int main(){

    /*
    Fes un programa que ns digui si un numero (n1) es positiu o negatiu.
    Ha de mostrar els resultats per pantalla.
    El numero (n1) s'ha de demanar per teclat.
    */

    //Declaracion de las varaibles
    int n1;

    printf("Introduce un numero; \n");
    scanf("%d", &n1);

    //condicionales
    //Si n1 es mayor que 0 el numero es positivo
    //Sino es negativo

    //Esto es mayor que
    if(n1 > 0){
        printf("El numero %d introducido es positivo \n", n1);
    }
    else{

        printf("El numero %d introducido es negativo \n", n1);
    }

    //Mayor o igual
    if(n1 >= 0){
        printf("El numero %d intoducido es positivo o 0 \n", n1);
    }

    // Esto es un igual con bolble barra ==
    if(n1 == 5){

        printf("El numero introducido es un 5 \n", n1);
    }

    //Diferente
    if(n1 != 0){

        printf("Si el numero intoducido es diferente de 0 \n");
    }

return 0;
}