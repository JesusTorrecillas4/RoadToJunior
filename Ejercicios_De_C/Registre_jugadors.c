#include <stdio.h>

int main(void) {

    char noms[5][50];  
    int nivell[5];    
    int i;

    printf("Registre de jugadors\n");

    
    for (i = 0; i < 5; i++) {
        printf("Introdueix el nom del jugador %d: \n", i + 1);
        scanf("%s", noms[i]);

        printf("Introdueix el nivell del jugador: \n");
        printf("1. Principiant \n");
        printf("2. Intermedi \n");
        printf("3. Expert \n");
        scanf("%d", &nivell[i]);

        if (nivell[i] < 1 || nivell[i] > 3) {
            printf("Error! Nivell invalid, posa un numero del 1 al 3: \n");
            scanf("%d", &nivell[i]);
        }
    }

    
    printf("Llista de jugadors\n");

    printf("Principiants:\n");
    for (i = 0; i < 5; i++) {
        if (nivell[i] == 1) {
            printf(" %s\n", noms[i]);
        }
    }

    printf("Intermedis:\n");
    for (i = 0; i < 5; i++) {
        if (nivell[i] == 2) {
            printf(" %s\n", noms[i]);
        }
    }

    printf("Experts:\n");
    for (i = 0; i < 5; i++) {
        if (nivell[i] == 3) {
            printf(" %s\n", noms[i]);
        }
    }

    

    return 0;
}