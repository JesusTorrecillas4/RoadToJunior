#include <stdio.h>

/*
    Programa que ahce desceutno del 10% si supera o es igual a los 100$ de compra.
    Pedir 5 precios de prodctos al usuario.
    mostrar el total y el descuento.
*/

int main(){

    //Variables
    int producto;
    int total = 0;
    int descuento = 10;
    int i = 0;
    int descuento_precio;
    int total_compra;

    //Pediremos el preico de los 5 productos
    while(i < 5){

        printf("Intoduce el predio del producto: \n");
        scanf("%d", &producto);

        //Suma incremental de los precios del producto
        //En cada interacion me voy guardanod en total la suma incremental
        total += producto;
        //total = total + producto;
        i++;
    }

    //Comprobamos si teine descuento
    if(total >= 100){
        //Si que tiene descuentazo
        descuento_precio = (total*descuento)/100;

        total_compra = total;
        //total = total - descuento_precio;
        total -= descuento_precio;

        printf("Enhorabuena has tenido descuento de %d$ del total : %d y te ha quedado en : %d \n", descuento_precio,total_compra, total);
    }else{

        printf("No tienes descuento el total es %d. \n", total_compra);

    }

    return 0;
}