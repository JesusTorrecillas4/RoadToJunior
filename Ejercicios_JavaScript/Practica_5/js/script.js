
let columnas = document.getElementById("columnas");
let filas = document.getElementById("filas");

let filasColumnas = document.getElementById("filasColumnas");

function crear(){

    let contador = 1;

      let tabla = "<table border=1>";
    for (let i = 0; i < filas.value; i++) {
            tabla +="<tr>"; 
        for (let j = 0; j < columnas.value; j++) {
            tabla += "<td>" + contador + "</td>";
            contador++;
        }
        tabla+="</tr>"
    }

     tabla+="</table>"

     filasColumnas.innerHTML= tabla;
}
