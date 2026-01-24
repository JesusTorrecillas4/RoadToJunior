#include <stdio.h>

/*
    Pide 5 numeros al usuario y haz un programa que le diga si ha añadido un numero par o impar

*/



int main(){

    int num;

    
    for(int i = 0; i <= 5; i++){

        printf("Intoduce un numero para saber si es par o impar. \n");
        scanf("%d", &num);
        if(num % 2 == 0){

            printf("El numero %d es par. \n", num);
        }else{

            printf("El numero %d es impar. \n", num);
        }

    }



    return 0;

}