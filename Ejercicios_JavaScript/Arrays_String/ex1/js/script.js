/*
Tens un array de noms d'usuari . Has de: (1) filtrar els que tenen mes de 5 caracters, (2)convertirl-los a mayuscules.
(3) ordenar-los alfabeticament i (4) mostrar el resultat a la consola

 const usuaris = ["anna" , "pol", "montserrat", "joan", "cristina", "pep"];

 Escriu aqui la teva solucio utilitzan filter, map i sort

 Resultat

*/

const usuaris = ["anna" , "pol", "montserrat", "joan", "cristina", "pep"];
console.log(usuaris);

let finales = usuaris
.filter(nom=>nom.length>5)
.map(nom=>nom.toUpperCase())
.sort();

console.log(finales);

// Alumnos de > 5
let filtrados = usuaris.filter(function(nom){
    return nom.length>5;
});

console.log(filtrados);

let mayusuclas = filtrados.map(function(nom){
    return nom.toUpperCase();
});

mayusuclas.sort();
console.log(mayusuclas);

/**
 * Estructres propies - Classes i herencia
 * 
 * Crea una classe Veichle amb propietats maca i any, i un metode info(). Despres crea una clase
 * Cotxe que hereti de Veichle, afegeix i la propietat portes i sobrescribiu info() per incloure-la.
 * Instancia un cotxe i mostra la informacio
 * 
 * Pistes
 * 
 * Usa class Veichle (constructor(marca,any){...})
 * 
 * class Cotxeextends Vehicle{constructor(marca,any,portes)}
 * 
 */

class Vehicle{
    constructor(marca,any){
        this.marca = marca;
        this.any = any;
    }
    info(){
        let info = "Marca: "+ this.marca + " Año: " + this.any;
        return this.marca
    }
}

class Cotxe extends Vehicle{
    constructor(marca, any, portes){
        super(marca,any);
        this.portes = portes;
    }
}

class Camio extends Vehicle{
    constructor(marca, any, kg){
        super(marca,any);
        this.kg = kg;
    }
}

class Moto extends Vehicle{
    constructor(marca, any, cilindrada){
        super(marca,any);
        this.cilindrada = cilindrada;
    }
}

function guardar(){

    

}


let c1 = new Cotxe("Seat", 1994, 4);
console.log(c1);