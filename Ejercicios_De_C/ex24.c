#include <stdio.h>

/*
    Pedir un numero al usuario y hacer su factorial
    Factorial de 5 por ejemplo es:
    5 x 4 x 3 x 2 x 1
*/

int main(){

//Sera el control del buvle
int i = 0;
//El numero al que queremos hacer el catorail
int num1;
//Total del factorial
int total = 1;

printf("Intodcude un numero para hacer su factorial: \n");
scanf("%d", &num1);

i = num1;

while(i > 1){

    //total = total * i;
    total *= i;
    //printf("%d *", i);
    i--;
}

printf("El numero factorial es: %d \n", total);

    return 0;
}




