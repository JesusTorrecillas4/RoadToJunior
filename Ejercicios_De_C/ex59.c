/*
    Control de inventario
        Estructura con nombre, cantidad, y precio
        - Pedir al usuario 
        - Intoducimos los productos
        - Crean un menu con opcones;
            1.Mostrar inventario completo   
                Productos y precio total (cantidad * precio)
            2.Mostrar valor de inventario
            3.Mostrar un producto determinado
            4.Mostrar productos con una cantidad inferior a 2
            5.Acutalizar cantidad de un producto
            6.Salir

*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct inventario{

    char nombre[50];
    int cantidad;
    float precio;

};


int menu(){

    int opcion;
    printf("1.Mostrar inventario completo\n");
    printf("2.Mostrar valor de inventario\n");
    printf("3.Mostrar un producto determinado\n");
    printf("4.Mostrar productos con una cantidad inferior a 2\n");
    printf("5.Acutalizar cantidad de un producto\n");
    printf("6.Salir\n");
    scanf("%d", &opcion);

    return opcion;
}


int main(){

 
    int i = 0;
    int numero;
    int opcion;

    float precio_total = 0;

    struct inventario productos[5];

    for(int i = 0;i<5;i++){

        printf("Producto %d/5 \n", i + 1);
        printf("Introduce el nombre del producto: \n");
        scanf("%s", productos[i].nombre);

        printf("Introduce la cantidad de productos: \n");
        scanf("%d", &productos[i].cantidad);

        printf("Intoduce el precio del producto: \n");
        scanf("%f", &productos[i].precio);

        precio_total += productos[i].precio;

    }

    do{

        opcion = menu();

        switch(opcion){

        
            case 1:
                    for(int i = 0;i<5;i++){
                    
                        printf("Producto: %s, cantidad %d, precio %.2f \n",productos[i].nombre,productos[i].cantidad,productos[i].precio);
                    }
                break;
            case 2:
                    precio_total = 0;
                    for(int i = 0; i < 5; i++){
                    precio_total += productos[i].precio * productos[i].cantidad;  
                    }
                    printf("Valor total del inventario: %.2f EUROS\n", precio_total);
                
                break;
            case 3:
                    
                    char nombreBuscado[50];
                    int encontrado = 0;

                    printf("Introduce el nombre del producto que quieres buscar: ");
                    scanf("%s", nombreBuscado);

                    for (int i = 0; i < 5; i++) {
                        if (strcmp(productos[i].nombre, nombreBuscado) == 0) {

                            printf("El producto seleccionado es %s \n", productos[i].nombre);
                            printf("Tiene %d unidades \n", productos[i].cantidad);
                            printf("Cuesta %.2f euros \n", productos[i].precio);

                            encontrado = 1;
                            break;
                        }
                    }

                    if (!encontrado) {
                        printf("Nombre incorrecto\n");
                    }

 
                
                    
                    /*for(int i = 0;i<5;i++){
                    
                        printf("Producto:%d/5 %s\n",i+1,productos[i].nombre);
                    }
                    printf("Que producto queires elegir? \n");
                    scanf("%d", &numero); */

                    
                break;
            case 4:
                    
                //Mostrar productos con una cantidad inferior a 2
                for(int i = 0;i<5;i++){

                    if(productos[i].cantidad < 2){

                        printf("Estos productos son inferiores a 2: %s \n", productos[i].nombre);
                    }

                }
                   

                break;
            case 5:
                    printf("Intoduce la canidad nueva de los productos\n");
                    //5.Acutalizar cantidad de un producto
                    for(int i = 0;i<5;i++){

                        printf("Intoduce la canidad nueva del producto %s \n", productos[i].nombre);
                        scanf("%d", &productos[i].cantidad);

                    }
                break;
            case 6:
                        printf("Saliendoo...\n");
                break;
            
            default:
                    printf("NUMERO INCORRECTO \n");
                break;

        }

    }while(opcion != 6);





}