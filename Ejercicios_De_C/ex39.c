#include <stdio.h>

/*
    Pedir al usuario 10 numeros 
    Mostrar Menu:
        1. Mostrar numeros pares y cantidad
        2. Mostrar numeros impares y cantidad
        3. Mostrar la su a de todos los numeros
        4. Salir
*/

void main(){



    int num[10];
    int opcion, pares = 0, impares = 0, suma = 0;

    
        for(int i=0;i<10;i++){
            printf("Introduce 10 numeros. \n");
            scanf("%d", &num[i]);  
        } 


    do{
        
        printf("1. Mostrar numeros pares y cantidad. \n");
        printf("2. Mostrar numeros impares y cantidad \n");
        printf("3. Mostrar la suma de todos los numeros \n");
        printf("4. Salir... \n");
        scanf("%d", &opcion);

        switch (opcion){
        
            case 1:

               for(int i=0; i<10;i++){

                    if(num[i] % 2 == 0){

                        pares++;
                        printf("Numero par: %d \n", num[i]);
                    
                    }
               }

               printf("%d total de pares: \n", pares);

                break;

            case 2:

               for(int i=0; i<10;i++){

                    if(num[i] % 2 != 0){

                        impares++;
                        printf("Numero impar: %d \n", num[i]);
                    
                    }
               }

               printf("%d total de impares: \n", impares);

                break;

            case 3:

               for(int i = 0; i<10; i++){

                    suma += num[i];

               }

               printf("La suma de todos los numeros es: %d \n", suma);

                break;

            case 4:

                printf("Saliendo... \n");

                break;

            default:

                printf("ERROR opcion no valida \n");

                break;





        }









    }while(opcion != 4);















}