
ver c = 30;

function inicio(){
    document.getElementById("Juego").style="display:block;";
    let textoContador = document.getElementById("contador");
    textoContador.innerHTML = "Falten 30 segons";
    setInterval(contador(),1000);

}

function contadro(){
    c--;
    document.getElementById("contador").innerHTML = "Faltan "+ c + " segos"
}