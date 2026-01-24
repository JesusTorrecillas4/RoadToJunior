#include <stdio.h>

    /*
        Fes un programa que , demanant 3 numeros(n1,n2,n3) ens digui quin es el mes gran i al mes petit
        Els tres numeros s'han de demanar per tecalt
        Ha de mostrar els resultats per pantalla
         8 3 5
         El nuermo mes gran es: 8
         El numero mes petit es 3  
    */
int main(){

    
    //Declaramos las variables
    int n1, n2, n3;
    //Variables que necesitaremos para ir validando durante la ejecucuion del programa los maximos y minimos
    int max;
    int min;

    // Pedimos el primer numero
    printf("Introduce el primer numero. \n");
    scanf("%d", &n1);

    //Guardamos el valor de n1 a max y a min porque justo en este instante min y max es n1 porque no hya ningun numero mas
    max = n1;
    min = n1;

    // Pedimos el segudno numero
    printf("Intoduce el segudno numero, \n");
    scanf("%d", &n2);

    //Max
    if(n2 > max){

        //Si entra aqui significa que n2 es mayor que lo que tiene max
        //Tenemos que actualizar el valor de max
        max = n2;

    }

    //Min
    if(n2 < min){

        //Si etnra aqui significa que el n2 es menor que los que tiene min
        //Tenemso que actuazlizar el valor de min

        min = n2;
    }

    //Pedimos el tercer numero

printf("Introduce el tercer numero. \n");
scanf("%d", &n3);

if(n3 > max){

         max = n3;
}

if( n3 < min){

    min = n3;
}

printf("Los numeros intdocudios son, %d, %d, %d. \n", n1, n2, n3);

printf("El numero mas alto es %d. \n", max);
printf("El numero mas pequeño es %d. \n", min);

    return 0;
}