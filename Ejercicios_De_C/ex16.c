#include <stdio.h>
/*
    WHILE(mientras)
    Bucle para repetir n veces segu se cumpla la condicion
    Pedir 10 numeros al usuario y mostrar el numero intoducido poer pantalla
    
*/

int main(){
    //Variable de control para controlar cuantas veces el usuario añade un numero
    int i = 0;
    int num;
    //Mientras la i sea menor a 10, se ira ejecutando lo de dentro del while
    while(i < 10){

        printf("Intdocude un numero: \n");
        scanf("%d", &num);

        printf("Numero introducido en la posicion %d es %d \n",i, num);

        //Incrementamos el valor de i en +1 en cada interacion del bucle
        i++;
        //Esto es lo mismo que: i = i+1;
    }
   








    return 0;
}