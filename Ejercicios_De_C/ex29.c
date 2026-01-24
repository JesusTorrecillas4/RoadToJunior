#include <stdio.h>

/*
    Ejemplo menu switch- case con do - while
    El menu se muestre mientras el usuario no seleccione la opcion salir

*/

int main(){

    int opcion;


    do{

        printf("Menu \n");
        printf("1. Opcion 1 \n");
        printf("2. opcion 2 \n");
        printf("3. opcion 3 \n");
        printf("4. opcion 4 \n");
        printf("5. SALIR \n");

        printf("Selecciona una opcion: \n");
        scanf("%d", &opcion);

        switch(opcion){

            case 1:
                printf("Has seleccionado opcion 1. \n");
            break;

             case 2:
                printf("Has seleccionado opcion 2. \n");
            break;

             case 3:
                printf("Has seleccionado opcion 3. \n");
            break;

             case 4:
                printf("Has seleccionado opcion 4. \n");
            break;
             case 5:
                printf("Saliendo... \n");
            break;

            default:

            printf("ERROR VUELV A SELECCIONAR UNA OPCION QUE SEA VALIDA. \n");
            break;

        }//fin switch

    }while(opcion != 5);//Cierre del do

   

    return 0;
}