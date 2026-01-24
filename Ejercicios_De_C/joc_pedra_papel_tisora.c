#include <stdio.h>
#include <stdlib.h> 
#include <time.h>  

int main(void) {
    int jugador, ordinador;
    char repetir;

    do{
        

        printf("JOC DE PEDRA, PAPER O TISORA\n");
        printf("1. Pedra\n");
        printf("2. Paper\n");
        printf("3. Tisora\n");
        printf("Tria la teva opcio:\n");
        scanf("%d", &jugador);

        ordinador = rand() % 3 + 1;

        printf("L'ordinador ha triat:\n");
        switch (ordinador) {
            case 1:
                printf("Pedra\n");
                break;
            case 2:
                printf("Paper\n");
                break;
            case 3:
                printf("Tisora\n");
                break;
        }

        
        if (jugador == ordinador) {
            printf("Empat\n");
        } 
        else if ((jugador == 1 && ordinador == 3) || (jugador == 2 && ordinador == 1) || (jugador == 3 && ordinador == 2)) {
            printf("Has guanyat\n");
        } 
        else if (jugador >= 1 && jugador <= 3) {
            printf("Has perdut \n");
        } 
        else {
            printf("Opcio invalida! Si us plau, tria 1, 2 o 3.\n");
        }

        
        printf("Vols tornar a jugar? (s/n): \n");
        scanf(" %c", &repetir);

    } while (repetir == 's' || repetir == 'S');

    printf("Gracies per jugar\n");

    return 0;
}
