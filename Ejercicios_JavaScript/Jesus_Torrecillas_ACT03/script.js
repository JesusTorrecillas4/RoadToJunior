
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

    let usuariTrobat = usuaris.find(function(u) {
        return u.usuari === nom && u.contrasenya === pass;
    });

    if (usuariTrobat) {

        sessionStorage.setItem("usuariActual", nom);
        usuariActual = nom;
        comprovarSessio();
    } else {
        document.getElementById("errorLogin").textContent =
            "Usuari o contrasenya incorrectes";
    }
}


function comprovarSessio() {

    if (usuariActual) {
        document.getElementById("login").style.display = "none";
        document.getElementById("aplicacio").style.display = "block";

        carregarUsuaris();
        mostrarTasques();

    } else {
        document.getElementById("login").style.display = "block";
        document.getElementById("aplicacio").style.display = "none";
    }
}

// CARREGAR USUARIS
function carregarUsuaris() {

    let select = document.getElementById("assignada");
    select.innerHTML = "";

    usuaris.forEach(function(u) {
        let opcio = document.createElement("option");
        opcio.value = u.usuari;
        opcio.textContent = u.usuari;
        select.appendChild(opcio);
    });
}

// GUARDAR TASQUES
function guardarTasques() {
    localStorage.setItem("tasques", JSON.stringify(tasques));
}

// AFEGIR TASCA
function afegirTasca() {

    if (!usuariActual) return;

    let titol = document.getElementById("titol").value.trim();
    let descripcio = document.getElementById("descripcio").value.trim();
    let assignada = document.getElementById("assignada").value;
    let dataHora = document.getElementById("dataHora").value;

    if (titol === "" || descripcio === "" || dataHora === "") {
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

// MOSTRAR TASQUES
function mostrarTasques() {

    if (!usuariActual) return;

    let llista = document.getElementById("llistaTasques");
    let filtre = document.getElementById("filtre").value;

    llista.innerHTML = "";

    tasques.forEach(function(tasca) {

        if (filtre === "pendents" && tasca.finalitzada) return;
        if (filtre === "finalitzades" && !tasca.finalitzada) return;

        let div = document.createElement("div");
        div.className = "tasca";

        if (tasca.finalitzada) {
            div.classList.add("finalitzada");
        }

        let titol = document.createElement("h3");
        titol.textContent = tasca.titol;

        let descripcio = document.createElement("p");
        descripcio.textContent = tasca.descripcio;

        let assignada = document.createElement("p");
        assignada.textContent = "Assignada a: " + tasca.assignada;

        let data = document.createElement("p");
        data.textContent = "Data límit: " + tasca.dataHora.replace("T", " ");

        let estat = document.createElement("p");
        estat.textContent = "Estat: " +
            (tasca.finalitzada ? "Finalitzada" : "Pendent");

        div.appendChild(titol);
        div.appendChild(descripcio);
        div.appendChild(assignada);
        div.appendChild(data);
        div.appendChild(estat);

        if (!tasca.finalitzada) {
            let botoEstat = document.createElement("button");
            botoEstat.textContent = "Finalitzar";
            botoEstat.setAttribute("onclick", "finalitzarTasca(" + tasca.id + ")");
            div.appendChild(botoEstat);
        }

        let botoEditar = document.createElement("button");
        botoEditar.textContent = "Modificar";
        botoEditar.setAttribute("onclick", "modificarTasca(" + tasca.id + ")");

        let botoEliminar = document.createElement("button");
        botoEliminar.textContent = "Eliminar";
        botoEliminar.setAttribute("onclick", "eliminarTasca(" + tasca.id + ")");

        div.appendChild(botoEditar);
        div.appendChild(botoEliminar);

        llista.appendChild(div);
    });
}

// FINALITZAR TASCA
function finalitzarTasca(id) {

    let tasca = tasques.find(function(t) {
        return t.id === id;
    });

    if (tasca) {
        tasca.finalitzada = true;
        guardarTasques();
        mostrarTasques();
    }
}

// MODIFICAR TASCA
function modificarTasca(id) {

    let tasca = tasques.find(function(t) {
        return t.id === id;
    });

    if (!tasca) return;

    let titol = prompt("Nou títol:", tasca.titol);
    if (titol === null) return;

    let descripcio = prompt("Nova descripció:", tasca.descripcio);
    if (descripcio === null) return;

    let assignada = prompt("Persona assignada:", tasca.assignada);
    if (assignada === null) return;

    let dataHora = prompt("Nova data i hora (AAAA-MM-DDTHH:MM):", tasca.dataHora);
    if (dataHora === null) return;

    if (
        titol.trim() === "" ||
        descripcio.trim() === "" ||
        !usuaris.some(function(u) { return u.usuari === assignada; }) ||
        dataHora.trim() === "" ||
        isNaN(new Date(dataHora).getTime()) ||
        new Date(dataHora) <= new Date()
    ) {
        alert("Dades incorrectes");
        return;
    }

    tasca.titol = titol.trim();
    tasca.descripcio = descripcio.trim();
    tasca.assignada = assignada;
    tasca.dataHora = dataHora;

    guardarTasques();
    mostrarTasques();
}

// ELIMINAR TASCA
function eliminarTasca(id) {

    tasques = tasques.filter(function(t) {
        return t.id !== id;
    });

    guardarTasques();
    mostrarTasques();
}

// COMPROVAR SESSIÓ
comprovarSessio();
