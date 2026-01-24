#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
Crear un programa que genere palabras aleatorias de 10 caracteres
Letras[27] = "abcdefghijklmnopqrstuvwxyz"
palabra[10]
tu palabra es: ghebwfhdae
Opciones:
- No se pueden repetir letras
- Añadir mayusculas y numeros
- Como minimos 2 de cada (letras, letras M, numeros)
*/

int main(){

    //Variables
    char letras[27] = "abcdefghijklmnopqrstuvwxyz";
    int num[10];
    char palabra[11];

    srand((unsigned) time(NULL));

    for(int i = 0; i < 11; i++){

        num[i] = rand() % 27;

        for(int j = 0; j < i; j++){

            if(num[i] == num[j]){

                num[i] = rand() % 27;

                j--;

            }

        }
    }

    for(int i = 0; i < 11; i++){

        palabra[i] = letras[num[i]];

    }

    for(int i = 0; i < 11; i++){

        
        printf("%c", palabra[i]);

    }

    return 0;
}