/*
    Crea una estrucutra de alumnos do de guardemos
    nombre, edad, nota
    Crear un aluno con los datos que intoduce el usuario por teclado
*/




#include <stdio.h>
#include <string.h>
#include <stdlib.h>

//Declaramos la estrucutra
//Fuera del main
struct alumnes{

    char nom[25];
    int edad;
    float nota;
    char fehca_nacimineto[100];
    char gmail[100];

};

void main(){

    //Definimos solo un alumno
    // Tipo de daot de nuestras variables
    //Si ponermos es true significa vamos a trener una varaible alumne del tipo estructura alumnes
    struct alumnes alumne;

    //pedimos los datos
    printf("Inroduce el nombre del alumno. \n");
    //Con el . accedemos al "campo" de la estrucutura
    scanf("%s", &alumne.nom);

    printf("Inroduce la edad del alumno. \n");
    scanf("%d", &alumne.edad);

    printf("Inroduce la nota del alumno. \n");
    scanf("%f", &alumne.nota);

    printf("Inroduce la fecha de nacimineto del alumno. \n");
    scanf("%s", &alumne.fehca_nacimineto);

    printf("Inroduce el gmail del alumno. \n");
    scanf("%s", &alumne.gmail);

    //mostramos los datos por pantalla
    printf("Nom: %s, edad: %d, nota: %.2f \n", alumne.nom,alumne.edad,alumne.nota);
    printf("La fecha de naceimineto es: %s, y su gmail es: %s \n", alumne.fehca_nacimineto, alumne.gmail);
}