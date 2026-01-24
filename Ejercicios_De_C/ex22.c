/*
    Programa que pida 5 numeros pares al usuario
    Si no es par tiene que seguir pidiendo.
    Al finalizar mostrar los numeros pares

*/
#include <stdio.h>

int main(){

    int i, Cont = 0;
    int a, b, c, d, e;
    while(Cont < 5){
        printf("Introduce un numero: ");
        scanf("%d", &i);

        if(i%2 == 0){
            //Numero par
            switch(Cont){

                case 0:
                    a = i;
                    break;
                case 1:
                    b = i;
                    break;
                case 2:
                    c = i;
                    break;
                case 3:
                    d = i;
                    break;
                case 4:
                    e = i;
                    break;


            }






            Cont++;
            //print("CONTADOR: %d", Cont);
        }
       
    }

     printf("Los numeros pares son:");
        printf("%d %d %d %d %d", a, b, c, d , e);







    return 0;
}