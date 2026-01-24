/*
    Haz un programa que genere una palabra de 8 letras con las siguientes condiciones:
        -En las posiciones pares(0,2,4,6) habra consonante
        -En las posiciones impares (1,3,5,7) habra vocales

    Muestra por pantalla la palabra
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void main()
{

    char consonante[22] = "bcdfghjklmnpqrstvwxyz";
    char vocal[6] = "aeiou";
    char palabra[9];
    srand((unsigned)time(NULL));

    // Generamos la palabra
    for (int i = 0; i < 9; i++)
    {

        if (i % 2 == 0)
        {
            // Consonante
            int aleatorio = (rand() % 21);
            palabra[i] = consonante[aleatorio];
        }
        else
        {
            int aleatorio = (rand() % 5);
            palabra[i] = vocal[aleatorio];
        }
    }
    palabra[sizeof(palabra) - 1] = '\0';

    // Mostrar palabra
    // sizeof
    for (int i = 0; i < 9; i++)
    {

        printf("%c", palabra[i]);
    }
}
