#include <stdio.h>

/*
    Nombre de dies en l'hospital
    Cost de consulta
    Preu dels medicaments
    Costos diversos extra
    Preu per dia hospitalitzat
    Deducció́ per l’assegurança

    El resultat dels següents costos s'ha de calcular fent servir funcions (no s’han d’utilitzar punters):
    Cost total: serà̀ la suma del cost de la consulta, del preu del medicament, costos diversos i el preu de cada dia a l'hospital.
    Cost assegurança: serà̀ el cost total menys la deducció́ de l’assegurança, s'ha de fer servir la funció́ de Cost total.
    Cost reduït: Ha de ser el cost d'assegurança menys el preu dels medicaments.
*/

int total(int a,int b,int c,int d){

    return a + b + c + d;
}


int deduccion(int a, int b){

    return a - b;


}


int cost_reduccion(int a, int b){

    return a - b;
}

int main(){

    int dies_hospita;
    int cost_cosluta;
    int preu_medicament;
    int cost_diversos_extra;
    int preu_dia_hospitalitzat;
    int deduccio_asseguranca;

    printf("Nombre de dies en l'hospital\n");
    scanf("%d", &dies_hospita);

    printf("Cost de consulta\n");
    scanf("%d", &cost_cosluta);

    printf("Preu dels medicaments\n");
    scanf("%d", &preu_medicament);

    printf("Costos diversos extra\n");
    scanf("%d", &cost_diversos_extra);

    printf("Preu per dia hospitalitzat\n");
    scanf("%d", &preu_dia_hospitalitzat);

    printf("Deduccio per l_asseguranca\n");
    scanf("%d", &deduccio_asseguranca);

    
    printf("El cost total ha sigut: %d$\n",total(dies_hospita * preu_dia_hospitalitzat,cost_cosluta,preu_medicament,cost_diversos_extra));
    printf("El cost total menys l'asseguranca es de :%d$\n",deduccion(total(dies_hospita * preu_dia_hospitalitzat,cost_cosluta,preu_medicament,cost_diversos_extra),deduccio_asseguranca));
    printf("El cost reduit es de %d$\n",cost_reduccion(deduccion(total(dies_hospita * preu_dia_hospitalitzat,cost_cosluta,preu_medicament,cost_diversos_extra),deduccio_asseguranca),preu_medicament));

    return 0;
}
