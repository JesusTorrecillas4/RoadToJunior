
class Mascota {

    constructor(nombre, edad, foto, tipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.foto = foto;
        this.tipo = tipo;
    }

    // GETTERS
    get getNombre() {
        return this.nombre;
    }

    get getEdad() {
        return this.edad;
    }

    get getFoto() {
        return this.foto;
    }

    get getTipo() {
        return this.tipo;
    }

    // SETTERS
    set setNombre(nombre) {
        this.nombre = nombre;
    }

    set setEdad(edad) {
        this.edad = edad;
    }

    set setFoto(foto) {
        this.foto = foto;
    }

    set setTipo(tipo) {
        this.tipo = tipo;
    }

    detalls() {
        return "Nombre: " + this.nombre +
               " | Edad: " + this.edad +
               " | Tipo: " + this.tipo;
    }
}


// CLASE PERRO
class Perro extends Mascota {

    constructor(nombre, edad, foto, tipo, raza) {
        super(nombre, edad, foto, tipo);
        this.raza = raza;
    }

    get getRaza() {
        return this.raza;
    }

    set setRaza(raza) {
        this.raza = raza;
    }

    detalls() {
        return super.detalls() + " | Raza: " + this.raza;
    }
}


// CLASE GATO
class Gato extends Mascota {

    constructor(nombre, edad, foto, tipo) {
        super(nombre, edad, foto, tipo);
    }

    hacerSonido() {
        return "Miau miau";
    }

    detalls() {
        return super.detalls() + " | Sonido: " + this.hacerSonido();
    }
}


// CLASE PAJARO
class Pajaro extends Mascota {

    constructor(nombre, edad, foto, tipo) {
        super(nombre, edad, foto, tipo);
    }

    hacerSonido() {
        return "Piu piu";
    }

    detalls() {
        return super.detalls() + " | Sonido: " + this.hacerSonido();
    }
}


// RECUPERAR LAS MASCOTAS GUARDADAS
let mascotas = JSON.parse(localStorage.getItem("mascotas")) || [];


// GUARDAR MASCOTA
function guardar() {

    let nombre = document.getElementById("nombre").value;
    let edad = document.getElementById("edad").value;
    let foto = document.getElementById("foto").value;
    let tipo = document.getElementById("tipo").value;
    let raza = document.getElementById("raza").value;

    if (nombre == "" || edad == "" || edad < 0) {
        alert("Introduce un nombre y una edad válida");
        return;
    }

    let mascota;

    switch (tipo) {

        case "perro":
            mascota = new Perro(nombre, edad, foto, tipo, raza);
            break;

        case "gato":
            mascota = new Gato(nombre, edad, foto, tipo);
            break;

        case "pajaro":
            mascota = new Pajaro(nombre, edad, foto, tipo);
            break;


    }

    mascotas.push(mascota);
    guardarLocalStorage();
    mostrarMascotas();
    limpiarFormulario();
}


// GUARDAR EN LOCALSTORAGE
function guardarLocalStorage() {
    localStorage.setItem("mascotas", JSON.stringify(mascotas));
}


// MOSTRAR MASCOTAS
function mostrarMascotas() {

    let lista = document.getElementById("lista");
    lista.innerHTML = "";

    for (let i = 0; i < mascotas.length; i++) {

        let mascota = mascotas[i];

        let tarjeta = document.createElement("div");
        tarjeta.className = "tarjeta";

        // FOTO
        if (mascota.foto != "") {
            let imagen = document.createElement("img");
            imagen.src = mascota.foto;
            imagen.alt = mascota.nombre;
            tarjeta.appendChild(imagen);
        }

        // NOMBRE
        let titulo = document.createElement("h3");
        titulo.textContent = mascota.nombre;
        tarjeta.appendChild(titulo);

        // DETALLES
        let detalles = document.createElement("p");

        let texto = "Edad: " + mascota.edad +
                    " | Tipo: " + mascota.tipo;

        if (mascota.tipo == "perro") {
            texto += " | Raza: " + mascota.raza;
        }

        if (mascota.tipo == "gato") {
            texto += " | Sonido: Miau miau";
        }

        if (mascota.tipo == "pajaro") {
            texto += " | Sonido: Piu piu";
        }

        detalles.textContent = texto;
        tarjeta.appendChild(detalles);

        // BOTONES
        let botones = document.createElement("div");
        botones.className = "botones";

        let botonModificar = document.createElement("button");
        botonModificar.textContent = "Modificar";
        botonModificar.onclick = function() {
            modificar(i);
        };

        let botonEliminar = document.createElement("button");
        botonEliminar.textContent = "Eliminar";
        botonEliminar.className = "btn-eliminar";
        botonEliminar.onclick = function() {
            eliminar(i);
        };

        botones.appendChild(botonModificar);
        botones.appendChild(botonEliminar);

        tarjeta.appendChild(botones);
        lista.appendChild(tarjeta);
    }
}


// ELIMINAR MASCOTA
function eliminar(i) {

    mascotas.splice(i, 1);

    guardarLocalStorage();
    buscar();
}


// MODIFICAR MASCOTA
function modificar(i) {

    let mascota = mascotas[i];

    let nombre = prompt("Nuevo nombre:", mascota.nombre);

    if (nombre == null || nombre == "") {
        return;
    }

    let edad = prompt("Nueva edad:", mascota.edad);

    if (edad == null || edad == "" || edad < 0) {
        return;
    }

    let foto = prompt("Nueva URL de foto:", mascota.foto);

    if (foto == null) {
        return;
    }

    let objeto;

    switch (mascota.tipo) {

        case "perro":
            objeto = new Perro(
                mascota.nombre,
                mascota.edad,
                mascota.foto,
                mascota.tipo,
                mascota.raza
            );

            let raza = prompt("Nueva raza:", mascota.raza);

            if (raza == null) {
                return;
            }

            objeto.setRaza = raza;
            break;

        case "gato":
            objeto = new Gato(
                mascota.nombre,
                mascota.edad,
                mascota.foto,
                mascota.tipo
            );
            break;

        case "pajaro":
            objeto = new Pajaro(
                mascota.nombre,
                mascota.edad,
                mascota.foto,
                mascota.tipo
            );
            break;
    }

    // MODIFICAR CON SETTERS
    objeto.setNombre = nombre;
    objeto.setEdad = edad;
    objeto.setFoto = foto;

    mascotas[i] = objeto;

    guardarLocalStorage();
    buscar();
}


// BUSCAR MASCOTAS
function buscar() {

    let texto = document.getElementById("buscar").value.toLowerCase();

    let resultados = mascotas.filter(function(mascota) {
        return mascota.nombre.toLowerCase().includes(texto);
    });

    // Mostrar todas las tarjetas y ocultar las que no coinciden
    mostrarMascotas();

    let tarjetas = document.getElementsByClassName("tarjeta");

    for (let i = 0; i < mascotas.length; i++) {

        if (!resultados.includes(mascotas[i])) {
            tarjetas[i].style.display = "none";
        }
    }
}


// ORDENAR MASCOTAS
function ordenar() {

    mascotas.sort(function(a, b) {
        return a.nombre.localeCompare(b.nombre);
    });

    guardarLocalStorage();
    buscar();
}


// LIMPIAR FORMULARIO
function limpiarFormulario() {

    document.getElementById("nombre").value = "";
    document.getElementById("edad").value = "";
    document.getElementById("foto").value = "";
    document.getElementById("raza").value = "";
}


// MOSTRAR U OCULTAR LA RAZA
function cambiarTipo() {

    let tipo = document.getElementById("tipo").value;

    if (tipo == "perro") {
        document.getElementById("campoRaza").style.display = "flex";
    } else {
        document.getElementById("campoRaza").style.display = "none";
    }
}


// AL ABRIR LA PÁGINA
cambiarTipo();
mostrarMascotas();
