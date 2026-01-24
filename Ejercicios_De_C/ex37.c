#include <stdio.h>

/*
    Pedir dos numeros al usuario y mostrar las siguientes opciones

    a.Calculer el mas grande
    b.Calcular el mas pequeño
    c.calcular si son iguales
    d.calcular si son diferentes
    e.salir
*/


int main(){

    int num1, num2;
    char opcion;


    do{

        printf("Intoduce un primer numero \n");
        scanf("%d", &num1);

        printf("Intoduce un segundo numero \n");
        scanf("%d", &num2);



        printf("a.Calculer el mas grande \n");
        printf("b.Calcular el mas pequenyo \n");
        printf("c.calcular si son iguales \n");
        printf("d.calcular si son diferentes \n");
        printf("e.salir \n");

        scanf(" %c", &opcion);

        switch(opcion){

        case 'a':

            if(num1 > num2){

                printf("El numero %d es mas grande que %d \n", num1,num2);
            }else{
                printf("El numero %d es mas grande que %d \n", num2,num1);
            }
         break;

         case 'b':

            if(num1 < num2){

                printf("El numero %d es mas pequenyo que %d \n", num1,num2);
            }else{
                printf("El numero %d es mas pequenyo que %d \n", num2,num1);
            } 
         break;

         case 'c':

            if(num1 == num2){

                printf("El numero %d es igual al numeor %d \n", num1, num2);
            }else{

                printf("Los numeors son diferentes \n");
            }
            break;

        case 'd':

            if(num1 != num2){

                printf("El numero %d es diferente al numeor %d \n", num1, num2);
            }else{

                printf("Los numeors son iguales \n");
            }
            break;

        case 'e':

         printf("Saliendo...");

         break;

         default:
            
         printf("Opcion no valida ERROR \n");

            break;

    }

    }while(opcion != 'a');
    


    return 0;
}