function guardarWeb(){
    let colorFondo = document.getElementById("colorFondo").value;
    let colorTexto = document.getElementById("colorLetra").value;
    let tipoLetra = document.getElementById("tipo").value;
    let alTexto = document.getElementById("alineacion").value;
    let imagenT = document.getElementById("imagenT").value

    localStorage.setItem("colorFondo",colorFondo);
    localStorage.setItem("colorTexto",colorTexto);
    localStorage.setItem("tipoLetra",tipoLetra);
    localStorage.setItem("alTexto",alTexto);
    localStorage.setItem("imagenT",imagenT);

    mostrarWeb();
}

function resetWeb(){
    localStorage.clear();
    mostrarWeb();
    
}


function mostrarWeb(){
    let colorFondo = localStorage.getItem("colorFondo");
    let colorTexto = localStorage.getItem("colorTexto");
    let tipoLetra = localStorage.getItem("tipoLetra");
    let alTexto = localStorage.getItem("alTexto");
    let imagenT = localStorage.getItem("imagenT");

    let estilo = "color:"+colorTexto+";font-family:"+tipoLetra+";text-align:"+alTexto;

    let haches = document.getElementsByTagName("h2");
    for(let i = 0 ; i<haches.length;i++){
        haches[i].style=estilo;
       
    }

    let peses = document.getElementsByTagName("p");
    for(let i = 0 ; i<peses.length;i++){
        peses[i].style=estilo;
    }

    let imagenes =  document.getElementsByTagName("img");
    for(let i = 0 ; i<imagenes.length;i++){
        imagenes[i].width = imagenT;
    }
}
/* 
AL INICIAR LA WEB COGE LOS VALORES 
DEL LOCALSTORAGE
 */
mostrarWeb();

