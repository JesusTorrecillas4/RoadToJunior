let usuario = "marcos";
let password = "123456";

function validar() {
    if (document.getElementById("usuario").value == usuario) {
        if (document.getElementById("pass").value = password) {
            console.log("usuario ok");
            document.getElementById("login").style="display:none;";
            document.getElementById("formulario").style="display:inline-block;";
        }


    } else {
        console.log("usuario incorrecto");

    }
}


function enviar() {
    let n = document.getElementById("nombre"); 
    let a = document.getElementById("apellido");
    let s = document.getElementById("sexo");
    let o = document.getElementById("observaciones");
    let i = document.getElementById("info");

    let resultado = document.getElementById("resultado");

    let parrafo = document.createElement("p");
    parrafo.textContent = n.value;
    resultado.append(parrafo);

    document.getElementById("formulario").style="display:none;";
    resultado.style="display:block";


}