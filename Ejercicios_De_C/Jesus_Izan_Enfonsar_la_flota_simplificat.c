#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
Juego hundir el barco
5x5 de tablero
Solo un barco
El jugador tiene que poner las coordenadas
Si acierta muestra X, si falla O
El juego continua hasta que se hunda el barco
*/

// Funciones
// Funcion 1 (Jesus)
//Esto crea un mar de 5x5 de agua solo lo inicia
void inicialitzar(char tauler[5][5]) {
    
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            tauler[i][j] = '~';
        }
    }
}

// Funcion 2 (Izan)
// Crea la graella poniendo los numeros y las letras
void graella(char tauler[5][5]){

    // Declaro las letras para la parte de la izquierda
    char letras[5] = {'A','B','C','D','E'};

    // Un pequeño espacio para que los numeros de la parte de arriba no esten pegados
    printf("   ");  

    // Imprime los numeros de la parte superior
    for (int i = 1; i < 6; i++) {
        
        printf("%d ", i);
    
    }
    
    // Espacio para pasar a las letras y el mar
    printf("\n");

    // Aqui imprimira las letras primero y despues le fila de mar de esa letra hasta hacer todo el mar y letras
    for (int i = 0; i < 5; i++) {
        
        printf("%c  ", letras[i]);

        for (int j = 0; j < 5; j++) {
            
            printf("%c ", tauler[i][j]);   
        
        }
        
        printf("\n");
    
    }

}

// Funcion 3 (Jesus)
// Esta funcion crea un barco random, hace un random de fila y columna 
void randomvaixell(char tauler[5][5]){
    
    int fila = rand() % 5;    
    int columna = rand() % 5;

    // Marca el barco
    tauler[fila][columna] = 'A';  

}

// Funcion 4 (Izan)
// Funcion para disparar (pide numero y letra y da el resultado)
int disparar(char tauler[5][5], char tauler_r[5][5]){
   
    // Variables para esta funcion
    int numero;
    char letra;
    int letra_num;
    int contador;

    // Pide el numero, si introduce uno que no sea entre 1 y 5 dice que esta mal y lo vuelve a pedir hasta que ponga uno valido
    do{

        printf("Selecciona un numero:\n");
        scanf("%d", &numero);

        if(numero < 1 || numero > 5){

            printf("Muy mal, has seleccionado un numero incorrecto\n");

        }

    }while(numero < 1 || numero > 5);

    // Dice el numero introducido
    printf("Numero seleccionado: %d\n", numero);
    
    // Le resta 1 al numero introducido porque el array es de 0 a 4, si pongo 3 se iria a la columna 4 si no se restara
    numero --;

    // Pide una letra, si introduce una que no sea entre A y E dice que esta mal y la vuelve a pedir hasta que ponga una valida 
    do{

        printf("Selecciona una letra:\n");
        scanf(" %c", &letra);

        if(letra != 'A' && letra != 'B' &&letra != 'C' && letra != 'D' && letra != 'E'){

            printf("Muy mal, has seleccionado una letra incorrecta\n");

        }

    }while(letra != 'A' && letra != 'B' &&letra != 'C' && letra != 'D' && letra != 'E');

    // Dice la letra introducida
    printf("Letra seleccionada: %c\n", letra);
    
    // Cambia la letra a numero para el array
    if(letra == 'A'){

        letra_num = 0;

    }else if(letra == 'B'){

        letra_num = 1;

    }else if(letra == 'C'){

        letra_num = 2;

    }else if(letra == 'D'){

        letra_num = 3;

    }else{

        letra_num = 4;

    }

    // Detecta si le a atinado gracias al tablero_r que se podria decir que esta resuelto
    if(tauler_r[letra_num][numero] == 'A'){

        printf("Felicidades le has atinado!\n");

        // Cambia a la X del tablero del jugador
        tauler[letra_num][numero] = 'X';

        // Devuelve 1 para que la funcion contador del main pare en caso de ser 1 (osea que esta resuelto)
        return 1;

    }else{

        printf("Vaya... Has fallado\n");

        // Cambia a la O del tablero del jugador
        tauler[letra_num][numero] = 'O';

        // Devuelve 0 para que la funcion contador no pare ya que tiene que ser 1
        return 0;

    }

}

int main(){

    srand((unsigned)time(NULL));

    // Variables
    char tauler[5][5];
    char tauler_r[5][5];
    int contador;
    int intentos = 0;

    // Inicializamos los tableros, tauler es el del jugador y tauler_r es un tablero "resuelto" el cual usaremos para verificar donde esta el barco
    inicialitzar(tauler);
    inicialitzar(tauler_r);
    // Ponemos el barco en el tablero resuelto
    randomvaixell(tauler_r);

    do{
       
        // Muestra el tablero del jugador
        graella(tauler);

        // Suma 1 a la cantidad de intentos
        intentos ++;

        // El contador recibe si es 1 (El jugador a ancerdado) o 0 (El jugador ha fallado) para continuar el juego o pararlo 
        contador = disparar(tauler, tauler_r);

    }while(contador == 0);

    // Al parar el juego muestra la cantidad de intentos y el resultado final del tablero
    printf("Numero de intentos %d\n", intentos);
    printf("Resultado del tablero:\n");

    graella(tauler);

    return 0;
}