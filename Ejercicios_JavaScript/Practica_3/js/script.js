
let mail = "jetohi@jviladoms.cat";
let pass1 = 1234;

function validar(){
    
    let ok = 0;
    let inputMail = document.getElementById("email");
    let inputPass = document.getElementById("pass");

    if(inputMail.value == mail){
        ok = 1
    
        document.getElementById("menssajeEmail").innerHTML="Email correcto";
    }else{
        document.getElementById("menssajeEmail").innerHTML="Email incorrecto";
    }

    if(inputPass.value==pass1){
        ok = 1
        document.getElementById("menssajePass").innerHTML="Password correcto";
    }else{
        document.getElementById("menssajePass").innerHTML="Password incorrecto";
    }
    
    if(inputMail.value == mail && inputPass.value==pass1){
          ok = 1
           document.getElementById("resultado").styles="color:green";
        document.getElementById("resultado").innerHTML="Login correcto";
    }else{
        document.getElementById("resultado").innerHTML="login incorrecto";
    }
    
}