#include <stdio.h>

//Funcion principal es: main
//Es lo primero que se ejecuta

int main(){

    //Declaracion de las variables
    //int --> Numeros enteros
    //float --> Decimales 
    
    float dinero_total = 1000;
    float dinero_retirar;
    float dinero_sumar;
    int opcion;
    int i = 0;

    //Do while para que el menu siempre se ejecute una vez pase lo que pase y se repita el ciclo
    do{

        //Enseño el menu al usuario
        printf("Menu \n");
        printf("1. Consultar saldo \n");
        printf("2. Retirar diners \n");
        printf("3. Ingressar diners \n");
        printf("4. Sortir \n");

        //Le pido al usuario que seleccione una opcion del menu
        printf("Seleccione una opcion. \n");
        scanf("%d", &opcion);

        //El switch es para todas las ocpiones del menu pero no entra en todas, solo en la correcta
        switch(opcion){

            //Aqui estan las opciones 
            case 1:

                printf("Tu saldo es de %.2f$. \n", dinero_total);

                //Aqui termina la opcion y se finaliza con un break;
                break;
            case 2:

                //Aqui le pido cuanto dinero quiere retirar
                printf("Cuanto dinero quieres retirar? \n");
                scanf("%f", &dinero_retirar);

               
                /*
                    Esto es el control de errores, si quieres sacar mas dinero del que tienes te saldra saldo insuficiente,
                    si quieres sacar dinero negativo te volvera a dar error. Y si sacas dinero dentro de tu saldo si te dejara.
                    Esta opcion me gusta mas ya que puedo decirle, o no tienes saldo suficiente o numero incorrecto ya que es un negativo
                    Pero para practiacar y mejorar he hecho las dos fomras
                
                */
               /////////////////////////////////////////////////////////////////////////////////////////////////
               //  if(dinero_total < 0){

                    // printf("Saldo insuficiente X \n");
                // }else if(dinero_retirar < 0){

                   //  printf("Numero incorrecto, no se puede retira un numero negativo. \n");
                // }else{

                    // dinero_total = dinero_total - dinero_retirar;
                    // printf("Has retirado %.2f$, y tu saldo actual es de %.2f$. \n", dinero_retirar, dinero_total);

               // }
               ///////////////////////////////////////////////////////////////////////////////////////////////////

               //Tengo esta logica tambien para ponerla a pruba y practicar, que hace en un if si esto O esto se cumplen haz la funcion, sino te vas al esle
                if((dinero_retirar > dinero_total) || (dinero_retirar < 0)){

                    printf("Saldo insuficiente X \n");

                }else{

                    //Si no se cumplen las condiciones del if de arriba pasara esto
                    dinero_total = dinero_total - dinero_retirar;
                    printf("Has retirado %.2f$, y tu saldo actual es de %.2f$. \n", dinero_retirar, dinero_total);

                }
                
                break;

            case 3:
                //Aqui le pido al usuario cuanto dinero quiere ingreasar
                printf("Cuanto dinero quieres ingresar? \n");
                scanf("%f", &dinero_sumar);

                /*
                    Este es el control de errores, si el usuario quiere ingresar un numero negativo le dara error,
                    solo puede ingresar numeros positivos.
                
                */
                if(dinero_sumar < 0){

                    printf("Errorn numero no valido para ingresar. \n");

                } else if(dinero_sumar > 0){

                    dinero_total = dinero_total + dinero_sumar;

                    printf("Has ingresado %.2f$, y tu saldo actual es de %.2f$. \n", dinero_sumar, dinero_total);
                }
                
                break;

            case 4:
                //Esta es la opcion que te sale del menu
                printf("Saliendo... \n");

                break;

            default:

                //Un error por si intocudes una opcion que no esta entre las 4 que tengo ene l menu
                printf("ERROR, Opcion no valida. \n");

                break;
        }

        //Este while dice que si el numero es diferente a 4 se repite el ciclo y vuelve al menu
    }while(opcion != 4);




    return 0;
}//Fin main
