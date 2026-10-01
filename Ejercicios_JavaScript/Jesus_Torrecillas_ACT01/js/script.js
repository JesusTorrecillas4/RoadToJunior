
function validar(){

    let n = document.getElementById("nombre1").value;
    let p = document.getElementById("password").value;

    if(n === "j" && p === "1"){

        document.getElementById("cv").style="display:block;";
        document.getElementById("registro").style="display:none;";
        console.log("registrado");
    }else{

            console.log("error");

    }


}


 let nombre = "";
 let gmail = "";
 let tel = "";
 let foto = "";
 let empresa = "";
 let puesto = "";
 let tiempo = "";

function guardar(){

 nombre = document.getElementById("nombre2").value;
 gmail = document.getElementById("gmail").value;
 tel = document.getElementById("telefono").value;
 foto = document.getElementById("foto").value;

 
 empresa = document.getElementById("empresa").value;
 puesto = document.getElementById("puesto").value;
 tiempo = document.getElementById("tiempo").value;

 document.getElementById("cv").style="display:none;";
 console.log("guardado");

 mostrarcv();
}

function mostrarcv(){

    let imagen = "";

    if(foto != ""){
        imagen = "<img class='foto' src='" + foto + "'>";
    }

    document.getElementById("curriculum").style="display:block;";
    
    document.getElementById("curriculum").innerHTML = 
    imagen +
  
        "<div class='fila'><h2>Nombre:</h2><p>" + nombre + "</p></div>" +
        "<div class='fila'><h2>Gmail:</h2><p>" + gmail + "</p></div>" +
        "<div class='fila'><h2>Telefono:</h2><p>" + tel + "</p></div>" +

        "<h3>Experiencia</h3>" +

        "<div class='fila'><h2>Empresa:</h2><p>" + empresa + "</p></div>" +
        "<div class='fila'><h2>Puesto:</h2><p>" + puesto + "</p></div>" +
        "<div class='fila'><h2>Tiempo:</h2><p>" + tiempo + "</p></div>";
    
    ;
    console.log("mostrando");
    
}