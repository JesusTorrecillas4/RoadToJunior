#include <stdio.h>

/*
    Pedir al usuario una nota numerica y mostrar el numero y la letra
    De 0 a 4 tienes que mostrar insuficiente (INS)
    DE 5 sufieiceinte (SUF)
    6(BE)
    7-8(NOT)
    9-10(EX)    
    
*/



int main(){

    int nota;

    printf("Introduce tu nota. \n");
    scanf("%d", &nota);

    switch(nota){

        case 0:
        case 1:
        case 2:
        case 3:
        case 4:

            printf("Tu nota %d es INS \n", nota);
            break;
        case 5:
            printf("Tu nota %d es SUF \n", nota);
            break;
        case 6:
            printf("Tu nota %d es BE \n", nota);
            break;
        case 7:
        case 8:
        printf("Tu nota %d es NOT \n", nota);
            break;
        case 9:
        case 10:
            printf("Tu nota %d es EX \n", nota);

            break;

        default: 
            printf("Numeor incorrecto, por favor intenralo de nuevo \n");
        



    }














    return 0;
}