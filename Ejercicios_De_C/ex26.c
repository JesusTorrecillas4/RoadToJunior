#include <stdio.h>
/*
    Pedir numeros positivos al usuario
    cuadno intrdoduzca uno negativo, finaliza el programa
    muestra el promedio de los numeros
*/

int main(){

    int i = 1;
    int num;
    int total = 0;
    float total_promedio;
    //Mientras los numeros sean positivos, vamos guardadno la suma
    //para luego poder calcular el promedio
    
    printf("Intoduce un numero positivo por favor. \n");
    scanf("%d", &num);
    
    while(i > 0){

     printf("Intoduce un numero. \n");
     scanf("%d", &num);

    //Si es negativo
    if(num < 0){
        // Con este break acabamos con el programa
        break;
    
    }else{
        //Nos tenemos que ir guardanod la suma incremental para luego poder
        //hacer el promedio

        total += num;
    }
         i++;
    }
    
    total_promedio = total / i;
    // .2f para que salgan los decimales
    printf("El promedio es %.2f y el toal es : %d y la i: %d \n", total_promedio, total, i);



    






    return 0;
}