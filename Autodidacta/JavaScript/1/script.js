//Para imprimir en consola
console.log("Hola mundo");

//Para declarar una variable, el getElementById esgoge cualquer id que sea el del texto
let titulo = document.getElementById("titulo");
let boton1 = document.getElementById("boton1");





//Evento de boton 
//textContent cambia el texto
boton1.addEventListener("click", function(){
    titulo.textContent = "Has pulsado el boton";
});


//Array de productos
const productos = [

    {   
        nombre: "Manga",
        precio: 9,
        categoria: "Libro"
    },
    {
        nombre: "Cartas",
        precio: 99,
        categoria: "Juegos de mesa"
    },
    {
        nombre: "Figura",
        precio: 80,
        categoria: "Decoracion"
    }
];

//Array vacia para comprar coasas que se añadiran
const carrito = [];
//variable de contenedor del html donde saldra el carro de compra
const contenedorCarrito = document.querySelector(".carrito");

//Todo esot que se declara es lo del html para usar aqui
const boton = document.querySelector("#btn2");
const contenedor = document.querySelector("#productos");
const contenedorComprados = document.querySelector("#comprados");
const btn3 = document.querySelector("#btn3");
const contenedorBaratos = document.querySelector("#productosBaratos");

//Para filtrar porducot baratos .filter  devuelve un array con todos los elementos que cumplen una condición
const productosBaratos = productos.filter((producto) => {
    return producto.precio < 90;
});

console.log(productosBaratos);

const btn4 = document.querySelector("#btn4");
const contenedorIVA = document.querySelector("#productosIva");

//EL .map recorre el array y crea OTRO array, recorre los prdocutos y saca otro array con los productos con IVA
const preciosIVA = productos.map((producto) =>{
    return{
        nombre: producto.nombre,
        precio: producto.precio * 1.21,
        categoria: producto.categoria
    };
});

console.log(preciosIVA);

//El .find es para buscar alñgo que sea exacto a lo descrito devuelve el primer elemento que cumple la condición.
const productosBuscado = productos.find((producto) =>{
    return producto.nombre === "Manga";
})

console.log(productosBuscado);

const buscador = document.querySelector(".buscador");
const botonBuscar = document.querySelector(".btnBuscar");
const resultado = document.querySelector(".resultado");


botonBuscar.addEventListener("click", () =>{

     resultado.innerHTML = ``;
    //Pilla el texto el .trim elimina los espacios vacios y el .tolowercase lo pone ne minusculas
    const texto = buscador.value.trim().toLowerCase();

    //El . inculde es para comprobar si existe o no y te da true si si o false si no
    const productoEncontrado  = productos.find((productoActual) => {
        return productoActual.nombre.toLowerCase().includes(texto);
    })

    if(productoEncontrado){

        resultado.innerHTML = `
            <h2>${productoEncontrado.nombre}</h2>
            <p>Precio: ${productoEncontrado.precio} €</p>
            <p>Categoría: ${productoEncontrado.categoria}</p>
        
        `;

    }else{

        resultado.innerHTML = `

            <p>Producto no encontrado</p>
        `;
    
    }


})


const buscador2 = document.querySelector(".buscador2");
const sugerencias = document.querySelector(".sugerencias");
//Si uso .filer busca todos los que se parezcan
//el input es para escribir y que aparezca sin clicar ningun boton de busqueda
buscador2.addEventListener("input", () =>{

    const texto = buscador2.value.trim().toLowerCase();

    
    
    const productoEncontrado  = productos.filter((productoActual) => {
        return productoActual.nombre.toLowerCase().includes(texto);
    })

     sugerencias.innerHTML = ``;
     
    if (productoEncontrado.length > 0) {

    productoEncontrado.forEach((producto) => {
        sugerencias.innerHTML += `
            <div class="sugerencia">
                ${producto.nombre} - ${producto.precio} €
            </div>
        `;
    });

    } else {

    sugerencias.innerHTML = `<p>Producto no encontrado</p>`;

}


});

//Si uso .find((productoActual)) busca uno solo
/*
buscador.addEventListener("click", () =>{

    const texto = buscador.value.trim().toLowerCase();

    //Si uso .find((productoActual)) busca uno solo
    //pero .filer busca todos los que se parezcan
    const productoEncontrado  = productos.find((productoActual) => {
        return productoActual.nombre.toLowerCase().includes(texto);
    })

    if(productoEncontrado){

        resultado.innerHTML = `
            <h2>${productoEncontrado.nombre}</h2>
            <p>Precio: ${productoEncontrado.precio} €</p>
            <p>Categoría: ${productoEncontrado.categoria}</p>
        
        `;

    }else{

        resultado.innerHTML = `

            <p>Producto no encontrado</p>
        `;
    
    }


});
*/ 



btn4.addEventListener("click", () => {

    
     contenedorIVA.innerHTML = ``;

    preciosIVA.forEach((producto) => {

        contenedorIVA.innerHTML += `
    
        <div>
            <h2>${producto.nombre}</h2>
            <p>Precio: ${producto.precio}</p>
        </div> 
    
    `;
    });

});



//El createElement crea el elemento del html desde aqui , esto es mejor porque asi lo puedes modificar mas facil 
boton.addEventListener("click", () => {

    contenedor.innerHTML = ``;
    
    productos.forEach((producto) => {

        const tarjeta = document.createElement("div");

        //Aqui se le añade una classe al elemento creado desde javaScript
        tarjeta.classList.add("producto");

        tarjeta.innerHTML = `
    
            <h2>${producto.nombre}</h2>
            <p>Precio: ${producto.precio}</p>
            <p>Categoria: ${producto.categoria}</p>
            <button class="btn-comprar">Comprar</button>
    
    `;

     

        const botonCompra = tarjeta.querySelector(".btn-comprar");

            botonCompra.addEventListener("click", () => {
                console.log(`Has comprado ${producto.nombre}`);

                const tarjeta2 = document.createElement("div");

                tarjeta2.classList.add("producto");

                tarjeta2.innerHTML = `
                    <h2>Has comprado ${producto.nombre}</h2>
                    <p>Por ${producto.precio} Euros</p>

                `; 

                //el .append mete el elemento creado ene l html
                contenedorComprados.append(tarjeta2);

                //el .push pone el objeto en el ultimo pueso del array
                carrito.push(producto);

                //.reduce reocrre el array y suma entre el producto y lo acumulado
                const total = carrito.reduce((acumulado, producto) =>{
                    return acumulado + producto.precio;
                }, 0);

                const totalHTML = document.querySelector(".total");

                totalHTML.textContent = `Total: ${total} EUROS`;

                 contenedorCarrito.innerHTML =`
                    <h2>Has añadido al carro ${producto.nombre}</h2>
                    <p>Por ${producto.precio} Euros</p>
                    <p>El total es: ${total}</p>
                `


                console.log(carrito);
            });


        contenedor.append(tarjeta);
    });

    
});

btn3.addEventListener("click", () => {

    contenedorBaratos.innerHTML = ``;
    // Después mostramos los productos BARATOS
    productosBaratos.forEach((producto) => {

        contenedorBaratos.innerHTML += `
            <div>
                <h2>${producto.nombre}</h2>
                <p>Precio: ${producto.precio}</p>
                <p>Categoria: ${producto.categoria}</p>
            </div>
        `;

    });


});


const contenedorPorductos2 = document.querySelector(".productos2");

const tarjeta = document.createElement("div");

tarjeta.classList.add("productos2");

tarjeta.innerHTML = `
    <h2>Camiseta</h2>
    <p>Precio: 20 Euros</p>
    <button class="btn-comprar">Comprar</button>
`;

contenedorPorductos2.append(tarjeta);






























const btnLimpiar = document.querySelector("#btnLimpiar");

btnLimpiar.addEventListener("click",() =>{
    contenedor.innerHTML = "";
    contenedorBaratos.innerHTML = "";
    contenedorIVA.innerHTML = "";
    resultado.innerHTML = "";
    sugerencias.innerHTML = "";
    buscador.value = ""
    contenedorComprados.innerHTML = "";
});


const formulario = document.querySelector(".formulario");
const mensaje = document.querySelector(".mensaje");

formulario.addEventListener("submit", (event) =>{
    event.preventDefault();

    const nombre =document.querySelector(".nombre").value;
    const email = document.querySelector(".email").value;
    const password = document.querySelector(".password").value;


    if(nombre === "" || email === "" || password === ""){

        mensaje.textContent = "Todos los campos son obligatorios";
        return;
    };

    if(password.length < 8){
        mensaje.textContent = "La contraseña tine que tener minimo 8 caracteres";
        return;
    };

    if(!email.includes("@")){
        mensaje.textContent = "El gmail tinee que tener @";
        return;
    };

     mensaje.textContent = "Registo correcto";
    

});



//Aqui comenzamos con fetch para conectarnos a otros archivos

//fetch("datos.json");

//Para recoger la respuesta es:
//then significa cuadno termine la operacion anterior haz esto
fetch("datos.json")
    .then((respuesta) =>{
        return respuesta.json();
    })
    .then((datos) => {
        console.log(datos);
        document.querySelector(".nombre3").textContent = datos.nombre;
        document.querySelector(".edad3").textContent = datos.edad;
        document.querySelector(".ciudad3").textContent = datos.ciudad;
    });





















const usuario = {

    nombre : "Jesus",
    edad : 22
};

//.stringify pasa de datos de javaScribt objeto a JSON
const datos2 = JSON.stringify(usuario);

console. log(datos2);


const datos3 = '{"nombre":"Jesus2","edad":22}';

//.parse  pasa datos de JSON a datos para javascript 
const usuario2 = JSON.parse(datos3);

console.log(usuario2.nombre);
console.log(usuario2.edad);


//Esta función va a trabajar con operaciones asíncronas
async function cargarDatos() {
    
    try{
    //El await es, Haz el fetch y espera a tener la respuesta antes de continuar con esta línea."
    const respuesta = await fetch("datos.json");

     if (!respuesta.ok) {
            throw new Error("No se ha podido obtener el archivo");
        }
        
    const datos = await respuesta.json();


    document.querySelector(".datos").innerHTML = `
    
        <h2>${datos.nombre}</h2>
            <p>Edad: ${datos.edad} </p>
            <p>Ciudad: ${datos.ciudad}</p>
    
    
    `;
    console.log(datos);

    }catch(error){

         document.querySelector(".datos").textContent = "No se han podido cargar los datos";
        console.log("Ha ocurrido un error", error);
    }
};

cargarDatos();


















const nombres = ["Jesus", "Pedro", "Juan"];

console.log(nombres[0]);
console.log(nombres[1]);

nombres.forEach(nombre => {
    console.log(nombre);
});

const resultadoNombre = nombres.filter((nombre) => {
    return nombre == "Jesus";
})

console.log(resultadoNombre);

const mayusculas = nombres.map((nombre) =>{
    return nombre.toUpperCase();
});

console.log(mayusculas);

const edades = [15, 22, 17, 35, 12, 40];

const mayores = edades.filter((edad) => {
    return edad >= 18;
})

console.log(mayores);