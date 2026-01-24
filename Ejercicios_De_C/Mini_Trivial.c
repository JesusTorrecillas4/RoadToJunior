#include <stdio.h>
#include <string.h>

int main(void) {

    int respuesta, puntuacion = 0;
    char opcion;

    // Preguntas y opciones
    char pregunta1[100] = "1. Cual es el idioma mas hablado del mundo?";
    char opciones1_1[100] = "1.Espanyol";
    char opciones1_2[100] = "2.Ingles";
    char opciones1_3[100] = "3.Chino";
    char opciones1_4[100] = "4.Frances";
    char pregunta2[100] = "2. Cuantos episodios tiene One Piece?";
    char opciones2_1[100] = "1.1155";
    char opciones2_2[100] = "2.1141";
    char opciones2_3[100] = "3.2019";
    char opciones2_4[100] = "4.1166";
    char pregunta3[100] = "3. Cuantos mundiales tiene espanya?";
    char opciones3_1[100] = "1. 3";
    char opciones3_2[100] = "2. 1";
    char opciones3_3[100] = "2. 2";
    char opciones3_4[100] = "4. 4";
    char pregunta4[100] = "4. Como se llama el mejor juego del mundo?";
    char opciones4_1[100] = "1.ARK";
    char opciones4_2[100] = "2.Fifa";
    char opciones4_3[100] = "3.Lol";
    char opciones4_4[100] = "4.CSGO";
    char pregunta5[100] = "5. Cual es el mejor animal?";
    char opciones5_1[100] = "1.Gato";
    char opciones5_2[100] = "2.Perro";
    char opciones5_3[100] = "3.Caballo";
    char opciones5_4[100] = "4.Delfin";


    do{ 
        printf("Preguntas:\n");

            // Bucle de preguntas
            for (int i = 0; i < 5; i++) {
            
            if(i == 0){
                printf("%s\n", pregunta1),
                printf("%s\n",opciones1_1);
                printf("%s\n",opciones1_2);
                printf("%s\n",opciones1_3);
                printf("%s\n",opciones1_4);
                scanf("%d",&respuesta);

                if(respuesta == 2){

                    printf("Respusta correcta. \n");
                    puntuacion += 1;
                }else{

                    printf("Respuesta incorrecta X \n");
                    printf("La respues correcta es %s\n",opciones1_2);
                }
            }else if(i == 1){
                printf("%s\n", pregunta2),
                printf("%s\n",opciones2_1);
                printf("%s\n",opciones2_2);
                printf("%s\n",opciones2_3);
                printf("%s\n",opciones2_4);
                scanf("%d",&respuesta);

                if(respuesta == 4){
                    printf("Respusta correcta. \n");
                    puntuacion += 1;
                }else{

                    printf("Respuesta incorrecta X \n");
                    printf("La respues correcta es %s\n",opciones2_4);
                }
            }else if(i == 2){
                printf("%s\n", pregunta3),
                printf("%s\n",opciones3_1);
                printf("%s\n",opciones3_2);
                printf("%s\n",opciones3_3);
                printf("%s\n",opciones3_4);
                scanf("%d",&respuesta);

                if(respuesta == 2){

                    printf("Respusta correcta. \n");
                    puntuacion += 1;
                }else{

                    printf("Respuesta incorrecta X \n");
                    printf("La respues correcta es %s\n",opciones3_2);
                }

            }else if(i == 3){
                printf("%s\n", pregunta4),
                printf("%s\n",opciones4_1);
                printf("%s\n",opciones4_2);
                printf("%s\n",opciones4_3);
                printf("%s\n",opciones4_4);
                scanf("%d",&respuesta);

                if(respuesta == 1){

                    printf("Respusta correcta. \n");
                    puntuacion += 1;
                }else{

                    printf("Respuesta incorrecta X \n");
                    printf("La respues correcta es %s\n",opciones4_1);
                }
            }else if(i == 4){
                printf("%s\n", pregunta5),
                printf("%s\n",opciones5_1);
                printf("%s\n",opciones5_2);
                printf("%s\n",opciones5_3);
                printf("%s\n",opciones5_4);
                scanf("%d",&respuesta);

                if(respuesta == 1){

                    printf("Respusta correcta. \n");
                    puntuacion += 1;
                }else{

                    printf("Respuesta incorrecta X \n");
                    printf("La respues correcta es %s\n",opciones5_1);
                }
            }
        }

        
        printf("Puntuacion final: %d de 5\n", puntuacion);

        
        if (puntuacion == 5){
            
             printf("Felicidades ha acertqdo todas las respuestas.\n");
        }else if (puntuacion >= 3){

            printf("Felicidades has acertado al menos la mitad.\n");
        }else{

             printf("Has acertado menos de la mitad.\n");
        }
           

    
        

            printf("Queres repetir el quiz? \n");
            printf("s(yes)/n(no)\n");
            scanf(" %c", &opcion);

        switch(opcion){

            case 's':

                printf("Muy bien volvamos a jugar \n");
                puntuacion = 0;
                break;

            case 'n':

                printf("Saliedno del quiz...");
                break;

            default:

                printf("ERROR , opcion no valida");
                break;

        }

    }while (opcion == 's' || opcion == 'S');

    return 0;
}
