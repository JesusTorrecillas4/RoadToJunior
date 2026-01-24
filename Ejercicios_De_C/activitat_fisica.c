#include <stdio.h>

/*
    Escriu un programa que permiti a un usuari registrar la seva activitat física diària 
    durant una setmana. Cada dia, l'usuari pot introduir el nombre de minuts d'exercici realitzats.
*/

void afegirMinuts(int exercici[], int dia){

    dia = 0;
    int minutos = 0;
    int i;
    for(int i=0;i<7;i++){

            printf("dia %d de 7\n", dia +1);
            printf("Introduce los minutos de hoy.\n");
            scanf("%d", &minutos);

            dia++;
            exercici[i] = minutos;
    }

    

}
 


int calcularTotal(int exercici[]) {
  
     int total = 0;
    for(int i = 0; i < 7; i++) {  
        total += exercici[i];
    }
    return total;
}


int trobarDiaMesExercici(int exercici[]) {
    int max = exercici[0];      
    int dia_max = 0;            
    

    for(int i = 1; i < 7; i++) {
        if(exercici[i] > max) {
            max = exercici[i];      
            dia_max = i;            
        }
    }
    return dia_max;  
}


float calcularMitjana(int exercici[]) {
    int total = calcularTotal(exercici);  
    return (float)total / 7;  
}


void mostrarSetmana(int exercici[]) {
    printf("Tota la setmana\n");
    for(int i = 0; i < 7; i++) {
        printf("Dia %d: %d minuts\n", i + 1, exercici[i]);
    }
}

int main() {
    int exercici[7] = {0};  
    int opcion;
    int dia;
    int minutos;
    int total_minutos;


    afegirMinuts(exercici,dia);
    
    do {
    
        
       
        
        printf("1. Mostrar el total de minuts d'exercici de la setmana\n");
        printf("2. Trobar el dia amb mes exercici\n");
        printf("3. Mostrar el temps mitja d'exercici diari\n");
        printf("4. Mostrar tota la setmana\n");
        printf("5. Sortir...\n");
        scanf("%d", &opcion);

        switch (opcion) {
            case 1:
                printf("Total de minuts d'exercici de la setmana: %d\n", calcularTotal(exercici));
                break;
            
            case 2:
                
                dia = trobarDiaMesExercici(exercici);
                printf("El dia amb mes exercici es el dia %d amb %d minuts\n", 
                       dia + 1, exercici[dia]);
                break;
            
            case 3:
                printf("Temps mitja d'exercici diari: %.2f minuts\n", calcularMitjana(exercici));
                break;
            
            case 4:
                mostrarSetmana(exercici);
                break;
            
            case 5:
                printf("Sortint...\n");
                break;
        
            default:
                printf("ERROR: Numero no valid.\n");
                break;
        }

    } while(opcion != 5);

    return 0;
}
