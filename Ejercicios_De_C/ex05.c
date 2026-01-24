#include <stdio.h>

int main(){

    /*
        Vamos a hacer un programa para validar si un numero es par o impar.
        Muestra por pantalla el rsultado.
    
    */


    //Declaracion de las variables
    //Declaramos una variable de tipo entero (int) y la inicializamos a 0
    int num = 0;
    int num2;


    //printf("Valor de num es: %d \n", num);
    //printf("Valor de num2 es: %d \n", num2);
    //printf("EL valor de num es: %d y el valor de num2 es %d. \n", num, num2);

    printf("Introduce un numero por favor. \n");
    scanf("%d", &num);

    //Vamos a validar si num es par o impar

    if(num % 2 == 0){

        // Si etnra aqui significa que es PAR pq el residu es 0
        printf("El numero %d e Par. \n", num);
    }else{

        //Si etnra aqui singinfica que es IMPAR
        printf("El numero %d es IMPAR. \n", num);
    }



    return 0;
}