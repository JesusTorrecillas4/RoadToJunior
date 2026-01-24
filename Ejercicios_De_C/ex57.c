#include <stdio.h>


/*
    Un menu donde pida 2 numeros la usuario donde pida
    1.Sumar
    2.Restar
    3.Dividir
    4.Multipciar



*/
int suma(int a, int b){

    int resultadosuma;
    resultadosuma = a + b;
    //printf("hola\n");
    return resultadosuma;

    //la opcon facil seraia hacer
    //return a + b;
}

int resta(int a, int b){

    int resultadoresta;
    resultadoresta = a - b;
    //printf("hola\n");
    return resultadoresta;
}

int division(int a, int b){

    int resultadodivi;
    resultadodivi = a / b;
    //printf("hola\n");
    return resultadodivi;
}

int multiplicacion(int a, int b){

    int resultadomulti;
    resultadomulti = a * b;
    //printf("hola\n");
    return resultadomulti;
}

int menu(menu){

    


}




void main(){


    //Sin funciones
    int a = 2;
    int b = 3;
    int resultado;

    resultado = a + b;

    //Con funciones

    printf("Resultado: %d\n", suma(5,4));
    printf("Resultado: %d\n", suma(3,7));
    printf("Resultado: %d\n", suma(7,2));

    int opcion;

    do{

        printf("Escirbe un numero \n");
        scanf("%d", &a);

        printf("Escribe otro numero.\n");
        scanf("%d", &b);

        printf("Escoge una opcion\n");
        printf("1.Sumar\n");
        printf("2.Restar\n");
        printf("3.Dividir\n");
        printf("4.Multiplicar\n");
        printf("5.Salir...");
        scanf("%d", &opcion);

        switch(opcion){

            case 1:
                printf("La suma de %d + %d es = %d. \n",a,b,suma(a,b));
                break;

            case 2:
                printf("La resta de %d +-%d es = %d. \n",a,b,resta(a,b));
                break;
            case 3:
                printf("La division de %d / %d es = %d. \n",a,b,division(a,b));
                break;
             case 4:
                printf("La multiplicacion de %d * %d es = %d. \n",a,b,multiplicacion(a,b));
                break;
             case 5:

                printf("Saliendo...\n");
                break;
            default:

                printf("ERROR numero invalido\n");
                break;
        }


    }while(opcion != 5);



}
