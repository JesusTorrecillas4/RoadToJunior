
const usuaris = [
    { usuari: "admin", contrasenya: "1234" },
    { usuari: "joan", contrasenya: "abcd" },
    { usuari: "maria", contrasenya: "5678" }
];

let tasques = JSON.parse(localStorage.getItem("tasques")) || [];
let usuariActual = sessionStorage.getItem("usuariActual");


function iniciarSessio() {

    let nom = document.getElementById("usuari").value;
    let pass = document.getElementById("contrasenya").value;

    let resultat = usuaris.filter(function(u) {
        return u.usuari == nom && u.contrasenya == pass;
    });

    if (resultat.length > 0) {
        sessionStorage.setItem("usuariActual", nom);
        usuariActual = nom;
        comprovarSessio();
    } else {
        document.getElementById("errorLogin").innerHTML =
            "Usuari o contrasenya incorrectes";
    }
}


function comprovarSessio() {

    if (usuariActual != null && usuariActual != "") {
        document.getElementById("login").style.display = "none";
        document.getElementById("aplicacio").style.display = "block";
        mostrarTasques();
    } else {
        document.getElementById("login").style.display = "block";
        document.getElementById("aplicacio").style.display = "none";
    }
}


function guardarTasques() {
    localStorage.setItem("tasques", JSON.stringify(tasques));
}


function afegirTasca() {

    let titol = document.getElementById("titol").value;
    let descripcio = document.getElementById("descripcio").value;
    let assignada = document.getElementById("assignada").value;
    let dataHora = document.getElementById("dataHora").value;

    if (titol.trim() == "" || descripcio.trim() == "" || dataHora == "") {
        alert("Omple tots els camps");
        return;
    }

    if (new Date(dataHora) <= new Date()) {
        alert("La data ha de ser futura");
        return;
    }

    let tasca = {
        id: Date.now(),
        titol: titol,
        descripcio: descripcio,
        assignada: assignada,
        dataHora: dataHora,
        finalitzada: false
    };

    tasques.push(tasca);

    guardarTasques();
    mostrarTasques();

    document.getElementById("titol").value = "";
    document.getElementById("descripcio").value = "";
    document.getElementById("dataHora").value = "";
}


function mostrarTasques() {

    let llista = document.getElementById("llistaTasques");
    let filtre = document.getElementById("filtre").value;

    let resultat = tasques;

    if (filtre == "pendents") {
        resultat = tasques.filter(function(t) {
            return t.finalitzada == false;
        });
    }

    if (filtre == "finalitzades") {
        resultat = tasques.filter(function(t) {
            return t.finalitzada == true;
        });
    }

    llista.innerHTML = "";

    for (let i = 0; i < resultat.length; i++) {

        let t = resultat[i];

        let estat = "Pendent";
        let classe = "tasca";
        let botoFinalitzar = "";

        if (t.finalitzada == true) {
            estat = "Finalitzada";
            classe = "tasca finalitzada";
        } else {
            botoFinalitzar =
                "<button onclick='finalitzarTasca(" + t.id + ")'>Finalitzar</button>";
        }

        llista.innerHTML +=
            "<div class='" + classe + "'>" +
            "<h3></h3>" +
            "<p></p>" +
            "<p>Assignada a: " + t.assignada + "</p>" +
            "<p>Data límit: " + t.dataHora + "</p>" +
            "<p>Estat: " + estat + "</p>" +
            botoFinalitzar +
            "<button onclick='modificarTasca(" + t.id + ")'>Modificar</button>" +
            "<button onclick='eliminarTasca(" + t.id + ")'>Eliminar</button>" +
            "</div>";

        
        let div = llista.lastElementChild;
        div.getElementsByTagName("h3")[0].textContent = t.titol;
        div.getElementsByTagName("p")[0].textContent = t.descripcio;
    }
}


function finalitzarTasca(id) {

    for (let i = 0; i < tasques.length; i++) {

        if (tasques[i].id == id) {
            tasques[i].finalitzada = true;
        }
    }

    guardarTasques();
    mostrarTasques();
}


function modificarTasca(id) {

    for (let i = 0; i < tasques.length; i++) {

        if (tasques[i].id == id) {

            let titol = prompt("Nou títol:", tasques[i].titol);
            if (titol == null) return;

            let descripcio = prompt("Nova descripció:", tasques[i].descripcio);
            if (descripcio == null) return;

            let assignada = prompt("Persona assignada:", tasques[i].assignada);
            if (assignada == null) return;

            let dataHora = prompt("Nova data i hora (AAAA-MM-DDTHH:MM):", tasques[i].dataHora);
            if (dataHora == null) return;

            if (titol.trim() == "" || descripcio.trim() == "") {
                alert("Omple tots els camps");
                return;
            }

            let persona = usuaris.filter(function(u) {
                return u.usuari == assignada;
            });

            if (persona.length == 0) {
                alert("Usuari incorrecte");
                return;
            }

            if (dataHora == "" || isNaN(new Date(dataHora).getTime()) ||
                new Date(dataHora) <= new Date()) {
                alert("La data ha de ser futura");
                return;
            }

            tasques[i].titol = titol;
            tasques[i].descripcio = descripcio;
            tasques[i].assignada = assignada;
            tasques[i].dataHora = dataHora;
        }
    }

    guardarTasques();
    mostrarTasques();
}


function eliminarTasca(id) {

    tasques = tasques.filter(function(t) {
        return t.id != id;
    });

    guardarTasques();
    mostrarTasques();
}


comprovarSessio();
