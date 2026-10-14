var usuarioActual = "";
let carrito = [];
let tickets = JSON.parse(localStorage.getItem("mistickets")) || [];
var i = tickets.length;

function iniciar(){

    let nombre = document.getElementById("nombre").value;
    let password = document.getElementById("password").value;

    if(nombre == "j" && password == "1"){
        usuarioActual = nombre;
        document.getElementById("login").style.display = "none";
        document.getElementById("tienda").style.display = "block";
    }else{
        alert("Usuario o contraseña incorrectos");
    }
}

function add(nombre, precio){

    let encontrado = false;

    for(let j = 0; j < carrito.length; j++){
        if(carrito[j].texto == nombre){
            carrito[j].cantidad++;
            encontrado = true;
        }
    }

    if(encontrado == false){
        let producto = {
            texto: nombre,
            preu: precio,
            cantidad: 1
        };
        carrito.push(producto);
    }

    mostrarCarrito();
}

function mostrarCarrito(){

    let divCarrito = document.getElementById("carrito");
    divCarrito.innerHTML = "";

    let total = 0;

    for(let j = 0; j < carrito.length; j++){
        let subtotal = carrito[j].preu * carrito[j].cantidad;
        total += subtotal;

        divCarrito.innerHTML += "<p>" + carrito[j].texto + " x" + carrito[j].cantidad
        + " - " + subtotal + " €</p>";
    }

    document.getElementById("total").innerHTML = "Total: " + total + " €";
}

function finalizarCompra(){

    if(carrito.length == 0){
        alert("El carrito está vacío");
        return;
    }

    i++;

    let total = 0;
    for(let j = 0; j < carrito.length; j++){
        total += carrito[j].preu * carrito[j].cantidad;
    }

    let nTicket = {
        numero: i,
        usuario: usuarioActual,
        productos: carrito,
        total: total
    };

    let tickets = JSON.parse(localStorage.getItem("mistickets")) || [];
    tickets.push(nTicket);
    localStorage.setItem("mistickets", JSON.stringify(tickets));

    carrito = [];
    mostrarCarrito();
    mostrarTickets();
}

function mostrarHistorial(){

    let historial = document.getElementById("historial");

    if(historial.style.display == "none"){
        mostrarTickets();
        historial.style.display = "block";
    }else{
        historial.style.display = "none";
    }
}

function mostrarTickets(){

    let tickets = JSON.parse(localStorage.getItem("mistickets")) || [];
    let divTickets = document.getElementById("tickets");
    divTickets.innerHTML = "";
    document.getElementById("detalle").innerHTML = "";

    if(tickets.length == 0){
        divTickets.innerHTML = "<p>No hay compras todavía</p>";
        return;
    }

    for(let k = 0; k < tickets.length; k++){
        divTickets.innerHTML += "<p>Ticket " + tickets[k].numero + " - "
        + tickets[k].total + " € "
        + "<button onclick='verTicket(" + k + ")'>Ver ticket</button></p>";
    }
}

function verTicket(numTicket){

    let tickets = JSON.parse(localStorage.getItem("mistickets")) || [];
    let t = tickets[numTicket];
    let divDetalle = document.getElementById("detalle");

    divDetalle.innerHTML = "<h3>Ticket " + t.numero + "</h3>";
    divDetalle.innerHTML += "<p>Usuario: " + t.usuario + "</p>";

    for(let j = 0; j < t.productos.length; j++){
        let p = t.productos[j];
        divDetalle.innerHTML += "<p>" + p.texto + " x" + p.cantidad
        + " - " + (p.preu * p.cantidad) + " €</p>";
    }

    divDetalle.innerHTML += "<p><b>Total: " + t.total + " €</b></p>";
}