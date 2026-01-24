#include <stdio.h>

/*
    Punteros
    Definicion: un puntero es un varaible que guarda la direccion de memoria en otra varaible

*/

/*
Paso de parametros por valor
Paso de parametros por referncias

*/

//Funcion para recibir por parametros
//un puntero
//Cambiaremos su valor

void mofificarvalor(int * p){

*p = 20;


};

int main(){

    int num = 10;
    //Decelaramos un puntero p con la direccion
    //en memoria de num
    //Los punteros siempre van con *
    //Referencia a la varaiable con &

    int *p = &num;

    //Valor de num
    printf("Valor de num: %d \n", num);

    //Direccion de num
    printf("Direccion de num: %p \n",&num);

    //Valor del puntero
    printf("Valor de p: %p \n", p);

    //Valor apuntado por p
    printf("Valor apuntando por p: %d\n", *p);

    mofificarvalor(&num);

    printf("Despuesd de la llamada a la funcion %d \n", num);

    return 0;


}