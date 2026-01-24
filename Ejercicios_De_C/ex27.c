#include <stdio.h>
/*
    Pide un numero al usuario y si es positivo y par muestra
    un mensaje por pantalla
    sino, vuelvelo a pedir

    
*/

void  main(){

int num;
int i = 0;
//printf("Introduce un numero: \n");
//scanf("%d", &num);


//Si es posotivo Y par
//if((num > 0) && (num % 2 == 0)){

    //printf("Muy bien el numero es positivo y par. \n");

//}else{

    //printf("Introduce un numero: \n");
    //scanf("%d", &num);

//}
////////////////////////////////////////////////////////////////////////////
//Mientras no sea positivo ni par, pide un numero 
//while((num < 0) || (num % 2 == 1)){

    //printf("Introduce un numero otra vez: \n");
    //scanf("%d", &num);

//}

//printf("Muy bien, el numero es positivo y par. \n");


//Esto es una funcion que simpre se hara, mientras el numero no sea positivo y par va a voler al do y lo volvera a hacer
do {
    printf("Introduce un numero: \n");
    scanf("%d", &num);

}while((num < 0) || (num % 2 == 1));

printf("Muy bien, el numero es postitivo y par. \n");


}