/*
    Crear estructura de alumnos que contenga : nom, edat i curs
    Rellenar estructura con 3 alumnos
    MENU
    1. Mostrar alumno más grande
    2. Mostrar alumno más pequeño
    3. La media de edad
    4. Alumno con el nombre más largo
    5. Salir
*/

#include <stdio.h>
#include <string.h>

struct alumnes {
    char nom[15];
    int edat;
    char curs[15];
};

int main() {

    struct alumnes alumne[3];
    int opcion;

    // --- Introducir datos ---
    for (int i = 0; i < 3; i++) {
        printf("\nAlumno %d\n", i + 1);

        printf("Introduce el nombre: ");
        scanf("%s", alumne[i].nom);

        printf("Introduce la edad: ");
        scanf("%d", &alumne[i].edat);

        printf("Introduce el curso: ");
        scanf("%s", alumne[i].curs);
    }

    do {
        printf("\n--- MENU ---\n");
        printf("1. Mostrar alumno mas grande\n");
        printf("2. Mostrar alumno mas pequeno\n");
        printf("3. Media de edad\n");
        printf("4. Alumno con el nombre mas largo\n");
        printf("5. Salir\n");
        printf("Escoge una opcion: ");
        scanf("%d", &opcion);

        switch (opcion) {

            case 1: { // Alumno más grande
                int i_gran = 0;
                for (int i = 1; i < 3; i++) {
                    if (alumne[i].edat > alumne[i_gran].edat) {
                        i_gran = i;
                    }
                }
                printf("Alumno mas grande: %s (%d anios)\n",
                       alumne[i_gran].nom, alumne[i_gran].edat);
                break;
            }

            case 2: { // Alumno más pequeño
                int i_petit = 0;
                for (int i = 1; i < 3; i++) {
                    if (alumne[i].edat < alumne[i_petit].edat) {
                        i_petit = i;
                    }
                }
                printf("Alumno mas pequeno: %s (%d anios)\n",
                       alumne[i_petit].nom, alumne[i_petit].edat);
                break;
            }

            case 3: { // Media de edad
                float suma = 0;
                for (int i = 0; i < 3; i++) {
                    suma += alumne[i].edat;
                }
                printf("Media de edad: %.2f\n", suma / 3);
                break;
            }

            case 4: { // Nombre más largo
                int i_llarg = 0;
                for (int i = 1; i < 3; i++) {
                    if (strlen(alumne[i].nom) > strlen(alumne[i_llarg].nom)) {
                        i_llarg = i;
                    }
                }
                printf("Nombre mas largo: %s\n", alumne[i_llarg].nom);
                break;
            }

            case 5:
                printf("Saliendo...\n");
                break;

            default:
                printf("Opcion incorrecta\n");
        }

    } while (opcion != 5);

    return 0;
}
