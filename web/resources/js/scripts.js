// Pasa los datos de un formulario a una tabla
// function pasaDatos(){  

//     let nombre = document.getElementById('nombre').value;
//     let apellido = document.getElementById('apellido').value;
//     let email = document.getElementById('email').value;

//     nombres[conteo] = nombre;
//     apellidos[conteo] = apellido;
//     emails[conteo] = email;

//     conteo++;
// }



var nombres =[];
var apellidos=[];
var emails=[];
var conteo=2;
var posicion=0;
var buscar="";
var bandera=false;
var insertar=false;

//SE INICIAN LOS ARRAYS

nombres[0]= "Jhon";
apellidos[0] ="Ramirez";
emails[0] = "Jhon@ejemplo.com";

nombres[1]= "Camila";
apellidos[1] ="Gonzales";
emails[1] = "Camila@ejemplo.com";

//USUARIO 1

document.getElementById("user1_ap").innerHTML = apellidos[0];
document.getElementById("user1_nom").innerHTML = nombres[0];
document.getElementById("user1_email").innerHTML = emails[0];

//USUARIO 2

document.getElementById("user2_ap").innerHTML = apellidos[1];
document.getElementById("user2_nom").innerHTML = nombres[1];
document.getElementById("user2_email").innerHTML = emails[1];

function consultarDatos(){
	buscar = document.getElementById("email").value;
	if (buscar == "") {
		document.getElementById("email").style.border = "1px solid red";
	}
	else{
		for (var i = 0; i < nombres.length; i++) {
			if (buscar == emails[i]) {
				document.getElementById("nombre").value = nombres[i];
				document.getElementById("apellido").value = apellidos[i];
				document.getElementById("email").value = emails[i];
				i = nombres.length;
				bandera = true;
			}
			else{
				bandera= false;
			}
		}
		if (bandera = false) {
			alert("No se encontro ningun elemento identificado como"  + "buscar" );
		}
	}
}

