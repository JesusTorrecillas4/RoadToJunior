#include <stdio.h>

/*
    WHILE(mientras)
    Pedir 15 numeros al usuario y mostrar si es par o impar en cada interacion
*/

int main(){

    //Declaramos las variables
    int i = 0;
    int num;

    while( i < 15){

        printf("Intoduce el numero para saber si es par o impar: \n");
        scanf("%d", &num);

        if(num % 2 == 0){
            printf("El numero %d es PAR \n", num);
            //PAR
        }else{
            printf("El numero %d es IMPAR \n", num);
            //IMPAR
        }
        //Para que vaya incrementadno el 1 en cada interaacio y no haga un bulce infinito y te pete el pc
        i++;
    }





    return 0;
}
