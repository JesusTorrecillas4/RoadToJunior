#include <stdio.h>


/*
    Realizar un programa que pida un numero al usuario
    y que realize su tabla de multiplicacion


*/

int main(){

    int num;

    printf("Introduce un numero que quieres sabr su tabla de multipliar. \n");
    scanf("%d",&num);


    for(int i = 1; i <=10; i++){

        printf( "%d x %d = %d \n",num, i, num * i);
    }


    return 0;
}