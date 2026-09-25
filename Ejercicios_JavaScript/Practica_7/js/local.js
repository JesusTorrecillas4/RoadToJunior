function validar(){

    let n = document.getElementById("nombre");
    let m = document.getElementById("mensaje");

    m.innerHTML = "<h3> Bienvendio "+ n.value + "</h3>";
    document.getElementById("login").style="display:none;";

    localStorage.setItem("Nombre", n.value);
}

// COMPUREBA SI HAY VALOR EN EL LOCALSTORAGE
// SI EXISTE USUARIO MUESTRA MENSAJE DE BEINVENIDA
// SI NO EXISTE MUESTRA FORMULARIO DE LOGIN

let user = localStorage.getItem("Nombre");
if(user){

    let m = document.getElementById("mensaje");
     m.innerHTML = "<h3> Bienvendio "+ n.value + "</h3>";
    document.getElementById("login").style="display:none;";
}

// ELIMINAR VALOR POR CODIGO
// localStorage.removeItem("nombre");
