#include <stdio.h>

  /*
        Pedir dos numeros al usuario 
        y vamos a mostrar un menu con las siguientes opciones
        1. + Sumar
        2. - Restar
        3. * Multiplicar
        4. / Dividir
        5. x Sortir
        Realizar el menu con switch-case
        Mostrar el resultado por pantalla
    */


int main(){

    //Variables
        int n1,n2;
        char opcion;

        printf("Introduce el primer numero. \n");
        scanf("%d", &n1);

        printf("Introduce el segundo numero, \n");
        scanf("%d", &n2);

        
        printf("+ Sumar \n");
        printf("- Restar \n");
        printf("* Multiplicar \n");
        printf("/ Dividir \n");
        printf("x Sortir \n");

        printf("Selecciona una opcion por favor. \n");
        scanf(" %c", &opcion);

        switch(opcion){

            case '+':

                printf("La suma de %d + %d es = %d. \n", n1,n2, n1 + n2);
                break;

            case '-':

                printf("La resta de %d - %d es = %d. \n", n1,n2, n1 - n2);
                break;
            
            case '*':

                printf("La multiplicacion de %d * %d es = %d. \n", n1,n2, n1 * n2);
                break;

            case '/':

                printf("La division de %d / %d es = %d. \n", n1,n2, n1 / n2);
                break;

            case 'x':

                printf("Has pulsado a salir, hasta la proxima. \n");
                break;

            default:
                printf("Opcion no valida.");

        }


    return 0;
}