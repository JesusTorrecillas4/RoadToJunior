
 let foto = document.getElementById("nFoto");
let iFoto;

let ancho = document.getElementById("ancho");
let alto = document.getElementById("alto");
let url = document.getElementById("url");

function modificar() {
    
  


    switch (foto.value) {
        case "0":
            iFoto = "0";
            break;
        case "1":
            console.log("Foto 1");
            iFoto = "f1";
            break;
        case "2":
            console.log("Foto 2");
             iFoto = "f2";
            break;
        case "3":
            console.log("Foto 3");
             iFoto = "f3";
            break;
        case "4":
            console.log("Foto 4");
             iFoto = "f4";
            break;
    
        default:
            break;
    }


    let estilo = "width: "+ ancho.value + "px;";
    estilo += "height: "+ alto.value + "px;";

    
    if(iFoto==0){
        for(let i=1;i<5;i++){
            let f = "f" +i;
             document.getElementById(f).style=estilo;
             document.getElementById(f).src=url.value;
        }
    }else{

            
        document.getElementById(iFoto).style=estilo;

        if(url.value !=" "){
            document.getElementById(iFoto).src=url.value;
        }
    }
}