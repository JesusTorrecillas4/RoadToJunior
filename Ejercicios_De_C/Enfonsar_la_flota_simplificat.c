#include <stdio.h>
#include <stdlib.h>




void inicialitzar(char tauler[5][5]) {
    
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            tauler[i][j] = '~';
        }
    }
}
void graella(char tauler[5][5]) {

    char letras[5] = {'A','B','C','D','E'};

    printf("   ");  
    for (int i = 1; i <= 5; i++) {
        printf("%d ", i);
    }
    printf("\n");

    for (int i = 0; i < 5; i++) {
        printf("%c  ", letras[i]);

        for (int j = 0; j < 5; j++) {
            printf("~ ");
        }
         printf("\n");
    }
}




int main() {


    char tauler[5][5];

    inicialitzar(tauler);  
    graella(tauler);       

    return 0;
}