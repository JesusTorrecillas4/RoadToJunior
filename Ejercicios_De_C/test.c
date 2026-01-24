#include <stdio.h>

int main(){

    int n1,n2;
    char opciones;

    printf("Introduce un numero. \n");
    scanf("%d", &n1);

    printf("Introduce un segundo numero. \n");
    scanf("%d", &n2);

    printf("+ elegir sumar. \n");
    printf("- elige restar. \n");
    printf("* elige multiplicar. \n");
    printf("/ elegir dividir. \n");
    printf("x elegir salir. \n");
    scanf(" %c", &opciones);

    switch(opciones){

        case '+':

            printf(" El numero %d + %d = %d", n1, n2, n1 + n2);
            break;

        case '-': 

            printf(" El numero %d - %d = %d", n1, n2, n1 - n2);
            break;
        
        case '*':

            printf(" El numero %d * %d = %d", n1, n2, n1 * n2);
            break;

        case '/':

            printf(" El numero %d / %d = %d", n1, n2, n1 / n2);
            break;

        case 'x':

            printf("Has elegido la opcion de salir, hasta la proxima");
            break;

        default:

            printf("Opcion equivocada");





    }




    return 0;

}