

var concepto = document.getElementById("concepto");
var precio = document.getElementById("precio");
var i = 0;

function guardar(){

    let ticket = document.getElementById("tickets");
    let num = document.getElementById("numTicket");

        ticket.innerHTML += "<p> " + i + " - " + concepto.value + " - " +  precio.value + " $</p>";
        console.log("test")
        num.innerHTML = "<legend>Ticket "+ i + "</legend>"

    i++;

    localStorage.setItem("Ticket",  + i + " - " + concepto.value + " - " +  precio.value + );

}