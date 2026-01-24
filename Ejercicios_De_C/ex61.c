#include <stdio.h>

/*
Inventario de un producto
Calcular el IVA
Calcular total del producto sin IVA
Calcular total del producto con IVA
Calcular descuento indicado
*/

float iva(float a){

    return (a * 21) / 100;

};

struct productos{

    char nombre[50];
    int cantidad;
    float precio;

};

int main(){

    struct productos producto;

    printf("Introduce el nombre del producto\n");
    scanf("%s", &producto.nombre);

    printf("Introduce la cantidad del producto\n");
    scanf("%d", &producto.cantidad);

    printf("Introduce el precio unitario sin IVA del producto\n");
    scanf("%f", &producto.precio);

    printf("Producto:\n");
    printf("Nombre: %s\n", producto.nombre);
    printf("Cantidad: %d\n", producto.cantidad);
    printf("Precio/u sin IVA: %.2f\n", producto.precio);
    printf("Precio/u con IVA: %.2f\n", producto.precio + iva(producto.precio));
    printf("IVA: %.2f\n", iva(producto.precio));
    printf("Precio total sin IVA: %.2f\n", producto.precio * producto.cantidad);
    printf("Precio total con IVA: %.2f\n", (producto.precio + iva(producto.precio)) * producto.cantidad);

    return 0;
}