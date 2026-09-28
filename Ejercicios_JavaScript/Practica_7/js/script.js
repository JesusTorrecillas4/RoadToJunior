

var concepto = document.getElementById("concepto");
var precio = document.getElementById("precio");

let tickets = JSON.parse(localStorage.getItem("mistickets")) || [];
var i = tickets.length;

function guardar(){

    let ticket = document.getElementById("tickets");
    let num = document.getElementById("numTicket");
    
        i++;

        ticket.innerHTML += "<p> " + i + " - " + concepto.value + " - " +  precio.value + " $</p>";
        console.log("test")
        num.innerHTML = "<legend>Ticket "+ i + "</legend>"

    

    //localStorage.setItem("Ticket",  i + " - " + concepto.value + " - " +  precio.value);
    guardar_local(i,concepto.value,precio.value);
}


function guardar_local(i,concepto, precio){

    /*
    localStorage.setItem("Ticket",  i );
    localStorage.setItem("Concepte",  concepto );
    localStorage.setItem("Precio",  precio );
    



    let tik = concepto + " - " + precio;
    let tikC = "ticket " + i;
    localStorage.setItem(tikC, tik);
    */

    let tickets = JSON.parse(localStorage.getItem("mistickets")) || [];

    let nTicket = {
        numero: i,
        texto: concepto,
        preu: precio
    };

    tickets.push(nTicket);


    localStorage.setItem("mistickets", JSON.stringify(tickets));

    console.log(tickets);

}

function mostrarTickets(){

    let tickets = JSON.parse(localStorage.getItem("mistickets")) || [];

    if(tickets.length == 0){
        console.log("No hay tickets");
    }else{
        for(let i=0;i<tickets.length;i++){
            console.log(tickets[i].numero);
            console.log(tickets[i].texto);
            console.log(tickets[i].preu);

            let divTickets = document.getElementById("tickets");

            divTickets.innerHTML += "<p> "+ tickets[i].numero + " - "
            + tickets[i].texto + " - " + tickets[i].preu + " $";
        }
    }
}

mostrarTickets();