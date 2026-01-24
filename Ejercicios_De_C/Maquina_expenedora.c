#include <stdio.h>

//Funcion principal es: main
//Es lo primero que se ejecuta

int main(){

    //Declaracion de las variables
    //int --> Numeros enteros
    //float --> Decimales 

    float saldo_total = 5;
    float saldo_gastado;
    int opcion;
    float Aigua = 1.00, Refresc = 1.50, Cafe = 2.00;

    do{

        //printf --> Imprime un mensaje por pantalla

        printf("1. Aigua 1.00$ \n"); 
        printf("2. Refresc 1.50$ \n");
        printf("3. Cafe 2.00$ \n");
        printf("4. Sortir \n");

        printf("Tu saldo total es de %.2f$ \n", saldo_total);
        printf("Selecciona una opcion. \n");

        //sacnf --> funciona para "scannear" los datos que introduce el usuario por telcado.
        scanf("%d", &opcion);

        
        //Switch es para hacer un menu i que cada opcion sea un case
        switch(opcion){


            //Estas son las opciones, depende del numero que escirba el usuario entrara en una casilla o en otra.
            case 1:
               
                //Este if es para decir si tienes mas saldo que lo que cuesta un agua la puedes comprar
                if(saldo_total > Aigua){

                    saldo_total-=Aigua;
                    printf("Has comprat 1 Aigua. \n");

                    //Este esle siginfica que si tu saldo es menor al precio del agua no te dejara comprarla por dinero insuficeinte
                }else{

                    printf("Saldo insucicient. \n");

                }
 

                //El break es para cuando termina la opcion que tenga un fin y no continue con la de abajo
                break;

            case 2:


                //Este if es para decir si tienes mas saldo que lo que cuesta un refresc lo puedes comprar
                 if(saldo_total > Refresc){

                    saldo_total-=Refresc;
                    printf("Has comprat 1 Refresc. \n");

                    //Este esle siginfica que si tu saldo es menor al precio del refresc no te dejara comprarla por dinero insuficeinte
                }else{

                    printf("Saldo insucicient. \n");

                }

                break;


            case 3:

                //Este if es para decir si tienes mas saldo que lo que cuesta un cafe lo puedes comprar
                 if(saldo_total > Cafe){

                    saldo_total-=Cafe;
                    printf("Has comprat 1 Cafe. \n");

                    //Este esle siginfica que si tu saldo es menor al precio del cafe no te dejara comprarla por dinero insuficeinte
                }else{

                    printf("Saldo insucicient. \n");

                }

                break;

            case 4:

                //Este print hace que salgas del menu
                printf("Sortint... \n");

                break;

            //Este default es para que si el usuario introduce un numero que no estra en los Case, entrara aqui
            default:

                //Este es el mensaje de error por si intoduce un numero icorrecto que no este en las opciones
                printf("ERROR, Codi no valid. \n");

                break;







        }





        //Este while dice que si el numero es diferente a 4 se repite el ciclo y vuelve al menu
    }while(opcion != 4);














    return 0; 
}//Fin del main