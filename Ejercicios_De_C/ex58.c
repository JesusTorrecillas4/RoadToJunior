/*
    Crear estrucutra de productoss
    Nombre, ID, y precio

    -Tenemos 5 productos
    -Pedimos datos al usuario
    -listamos los productos
    -Listamos el valor total de la compra
    -Muestre el producto mas caro y mas barato 

*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct productos{

    char nombre[25];
    int ID;
    float precio;

};

int main(){


    struct productos producto[5];

    float total_precio = 0;
    float precio_max = producto[0].precio;
    float precio_min = producto[0].precio;

    int indice_max = 0;
    int indice_min = 0;

    for(int i=0;i<5;i++){

        printf("Introduce el nombre del articulo: \n");
        scanf("%s", &producto[i].nombre);
        printf("Intoduce el ID del producto: \n");
        scanf("%d", &producto[i].ID);
        printf("Introduce el precio del producto: \n");
        scanf("%f", &producto[i].precio);

        total_precio += producto[i].precio;

        
    }



    for (int i = 1; i < 5; i++) {

        if (producto[i].precio > precio_max) {
            precio_max = producto[i].precio;
            indice_max = i;
        }

        if (producto[i].precio < precio_min) {
            precio_min = producto[i].precio;
            indice_min = i;
        }
    }

    for(int i=0;i<5;i++){

        printf("Los productos son %s \n", producto[i].nombre);
    }
    

    printf("El total ha sido %.2f \n", total_precio);
    printf("El producto más caro es: %s, con precio: %.2f €\n", producto[indice_max].nombre, producto[indice_max].precio);
    printf("El producto más barato es: %s, con precio: %.2f €\n", producto[indice_min].nombre, producto[indice_min].precio);
    





}


