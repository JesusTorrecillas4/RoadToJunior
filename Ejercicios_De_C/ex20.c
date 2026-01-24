#include <stdio.h>
/*
    Mostrar un menu con las siguientes opciones
    que puede escoger el usuario
    1. Mostrar por pantalla los numeros del 1 al 20
    2. Mostrar los numeros por pantalla del 20 al 1
    3. Mostrar por pantalla del 1 al 20 pero solo los pares
    4. Mostrar por pantalla del 1 al 20 pero solo los impares
    5. Mostrar por pantalla del 20 al 1 (pares)
    6. Mostrar por pantalla del 20 al 1 (impares)
    7. Sortir

*/

int main(){

    int i = 0;
    int num, opcion;

    printf("Elige una opcion de estas 7: \n");
    printf("1. Mostrar por pantalla los numeros del 1 al 20 \n");
    printf("2. Mostrar los numeros por pantalla del 20 al 1 \n");
    printf("3. Mostrar por pantalla del 1 al 20 pero solo los pares \n");
    printf("4. Mostrar por pantalla del 1 al 20 pero solo los impares \n");
    printf("5. Mostrar por pantalla del 20 al 1 (pares) \n");
    printf("6. Mostrar por pantalla del 20 al 1 (impares) \n");
    printf("7. Sortir \n");

    printf("Escoge una opcion \n");
    scanf("%d", &opcion);

    switch(opcion){
        
        case 1:
        //Mostrar por pantalla del 1 al 20
        i = 1;
        while( i < 20){
            printf("%d\n", i);
            i++; 
            
        }
             break;
        case 2:
        //Mostrar por pantalla de 20 a 1
        i = 20;
        while( i > 0){
            printf("%d\n", i);
            i--;
        }
            break;
        case 3:
        //Mostrar por pantalla del 1 al 20 pero solo los pares
        //i = 1;
        //while(i <= 20){

           // if(i % 2==0){
             //   printf("%d\n", i);
            //}
            //i++; i = i + 1
        //}

        i = 2;
        while(i <= 20){
            printf("%d\n", i);
            i = i+2;
        }
            break;
        case 4:
        // Mostrar por pantalla del 1 al 20 pero solo los impares

        i = 1;
        while(i <= 20){

            printf("%d\n", i);
            i = i+2;
        }
            break;
        case 5:
        //Mostrar por pantalla del 20 al 1 (pares)
        i = 20;
        while(i >= 0){

            printf("%d\n", i);
            i = i-2;
        }
        break;
        
        case 6:
        //Mostrar por pantalla del 20 al 1 (impares)
        i = 19;
        while(i >= 0){
            printf("%d\n", i);
          i = i - 2;
        }
        break;
        case 7:

        pritnf("Ha escogido salir, hasta la proxima");
        break;

        default:
        printf("Opcion equivocado error 404");
        

    }













    return 0;
}