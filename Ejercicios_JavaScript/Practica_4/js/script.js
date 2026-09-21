

let iFoto;

function modificar() {
    
    let foto = document.getElementById("nFoto");


    switch (foto.value) {
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


    
    document.getElementById(iFoto).style="width:50px";
}