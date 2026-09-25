
var c = 5;
var num = Math.floor(Math.random()*11);
console.log(num);

var miInterval;

function inicio(){
    document.getElementById("juego").style="display:block;";
    let textoContador = document.getElementById("contador");
    textoContador.innerHTML = "Falten 30 segons";
    miInterval = setInterval(contador,1000);
    document.getElementById("btnInicio").style="display:none";
}

function contador(){
    if(c>0){

        c--;
        document.getElementById("contador").innerHTML = "Faltan "+ c + " segons";
    }else{
        document.getElementById("juego").innerHTML = "<h3>Has perdido</h3>";
        clearInterval(miInterval);
    }
    
}

function jugar(){

    let n = document.getElementById("numero").value;
    if(n == num){
        document.getElementById("juego").innerHTML = "<h3>Has Ganado</h3>";
        clearInterval(miInterval);
    }
}