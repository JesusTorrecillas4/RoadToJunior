#include <stdio.h>

int main(){

    /*
        Fes un programa que demanan 2 numeros (n1,n2) nes sigui quin es el mes gran
        els dos numeros s'han de demanar per pantalla
        Has de demostar el resultat per pantalla
    */

    int n1;
    int n2;

    printf("Intoducede el numero por favor");
    scanf("%d", &n1);

    printf("Intoduce el segundo numero");
    scanf("%d", &n2);

    if(n1 > n2){

        printf("El numero %d es mayor que el numero %d. \n", n1, n2);

    } else {

        if(n1 == n2){

            printf("El numero %d es igual a %d. \n", n1,n2);
        }else{

             printf("EL numero %d es mayor que el numero %d. \n", n2, n1);
        }

        

    }
    
    




    return 0;
}