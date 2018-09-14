// Controles
var inputNombre = "<input type='text' class='nombre'/>";
var inputApellido = "<input type='text' class='apellido'/>";
var inputCedula = "<input type = 'text class='cedula'/>";
var inputDireccion = "<input type = 'text class='direccion'/>";
var inputTelefono = "<input type = 'text class='telefono'/>";
var inputEmail = "<input type='email' class='email'/>";
var inputContraseña = "<input type = 'text class='passW'/>";
var inputCargo = "<input type = 'text class='cargo'/>";
var botonEliminar = "<button class='eliminar btn btn-danger btn-sm ' onclick='borrarFila(this)' ><i class='fa fa-trash-o'></i></button>";
var botonEditar = "<button class='editar btn btn-info ' onclick='editarFila(this)'><i class='fa fa-pencil'></i></button>";
var botonCopiar = "<button class='copiar btn btn-warning ' onclick='copiarFila(this)' ><i class='fa fa-clone'></i></button>";
var botonInsertar = "<button class='insertar btn btn-primary ' onclick='asignarCita(this)' ><i class='fa fa-plus'></i></button>";
var botonGuardar = "<button class='guardar btn btn-success btn-sm' onclick='guardar(this)'><i class='fa fa-floppy-o'></i></button>";

// Variables tipo arreglo para almacenar los valores
var nombres = [];
var apellidos = [];
var identificacion = [];
var direccion = [];
var telefono = [];
var emails = [];
var citas = [];
// var confirmPsw = [];
var conteo = 0;
var posicion = 0;
var buscar = "";
var bandera = false;
var insertar = false;

// Variable que trae la tabla
var tabla = document.getElementById("myTable");
//Se inicializan los array//
nombres[0] = "Manuel";
apellidos[0] = "Gonzales";
identificacion[0] = "1234567899";
direccion[0] = "diagonal 123";
telefono[0] = "3101234567";
emails[0] = "admon@homeins.co";
cita[0] = "jlkjk";
// confirmPsw[0] = "****";

// nombres[1] = "Camila";
// apellidos[1] = "Gonzalez";
// emails[1] = "Camila@ejemplo.com";

// Se pasan a la tabla los valores que están en los array: Usuario 1
document.getElementById("nameUser").innerHTML = nombres[0];
document.getElementById("lastNameUser").innerHTML = apellidos[0];
document.getElementById("identify").innerHTML = identificacion[0];
document.getElementById("direccion").innerHTML = direccion[0];
document.getElementById("telefono").innerHTML = telefono[0];
document.getElementById("emailUser").innerHTML = emails[0];
document.getElementById("cita").innerHTML = cita[0];
// document.getElementById("contrasena").innerHTML = contrasena[0];
// document.getElementById("confirmPsw").innerHTML = confirmPsw[0];

// // Se pasan a la tabla los valores que están en los array: Usuario 2
// document.getElementById("user2_ap").innerHTML = apellidos[1];
// document.getElementById("user2_nom").innerHTML = nombres[1];
// document.getElementById("user2_email").innerHTML = emails[1];

// Pasa los datos de un formulario a una tabla
function pasaDatos() {
  // Se almacenan los valores de los input en variables
  let nombre = document.getElementById('nombre').value;
  let apellido = document.getElementById('apellido').value;
  let identificacion = document.getElementById('identify').value;
  let direccion = document.getElementById('direccion').value;
  let telefono = document.getElementById('telefono').value;
  let email = document.getElementById('email').value;
  let cita = document.getElementById('cita').value;
  // let confirmPsw = document.getElementById('confirmPsw').value;

  //Condicion para buscar valores repetidos//
  if (nombre != "" && apellido != "" && email != "") {

    // Coloque una fila en la ultima parte de la tabla
    let i = tabla.rows.length;
    let fila = tabla.insertRow(i);

    // Crear las celdas de la fila en una posición determinada
    let celda1 = fila.insertCell(0);
    let celda2 = fila.insertCell(1);
    let celda3 = fila.insertCell(2);
    let celda4 = fila.insertCell(3);
    let celda5 = fila.insertCell(4);
    let celda6 = fila.insertCell(5);
    let celda7 = fila.insertCell(6);
    // let celda8 = fila.insertCell(7);
    // Clonar los botones
    let botones = document.getElementById('botones');
    let cln = botones.cloneNode(true);
    // Almacenar y mostrar los valores de las variables
    celda1.innerHTML = nombre;
    celda2.innerHTML = apellido;
    celda3.innerHTML = identificacion;
    celda4.innerHTML = direccion;
    celda5.innerHTML = telefono;
    celda6.innerHTML = email;
    // celda7.innerHTML = contrasena;
    // celda8.innerHTML = confirmPsw;

    //Almacena los datos en un array depende de la posicion//
    nombres[conteo] = nombre;
    apellidos[conteo] = apellido;
    identificacion[conteo] = identificacion;
    direccion[conteo] = direccion
    telefono[conteo] = telefono
    emails[conteo] = email;
    // contrasena[conteo] = contrasena
    // confirmPsw[conteo] = confirmPsw


    // Muestra los valores de la celda que se clonó
    let celda9 = fila.appendChild(cln);
    // Reiniciar los input de texto
    document.getElementById("createUser").reset();
    // primer input (nombre), reciba el efoque 
    document.getElementById("nombre").focus();

    conteo++;
    swal({
      title: "El usuario " + nombre + " " + apellido + " ha sido creado",
      text: "",
      icon: "success",
    });
  } else {
    swal({
      title: "Error!",
      text: "Ningún campo puede estar vacío!",
      icon: "error",
      button: "aceptar",
    });
  }
}

//Buscar registros de la tabla//
function consultarDatos() {
  buscar = document.getElementById("email").value;
  if (buscar == "") {
    document.getElementById("email").style.border = "1px solid red";

  } else {
    for (var i = 0; i < nombres.length; i++) {
      if (buscar == emails[i]) {
        document.getElementById("nombre").value = nombres[i];
        document.getElementById("apellido").value = apellidos[i];
        document.getElementById("email").value = emails[i];
        i = nombres.length;
        bandera = true;
      } else {
        bandera = false;
      }
    }
    if (bandera == false) {
      swal("No se encontro ningun elemento identificado como '" + buscar + "'");
    }
  }
}

// Eliminar fila
function borrarFila(fila) {
  let i = fila.parentNode.parentNode.rowIndex;
  let celdas = tabla.rows[i];
  let buscaCorreo = celdas.cells[5].firstChild.data;

  swal({
      title: "Está seguro de eliminar el registro",
      text: "Si elimina el registro, ya no podrá ser recuperado de la memoria!",
      icon: "warning",
      buttons: [true, "Aceptar"],
      dangerMode: true,
    })
    .then((willDelete) => {
      for (var k = 0; k < emails.length; k++) {
        if (buscaCorreo == emails[k]) {
          nombres[k] = "";
          apellidos[k] = "";
          emails[k] = "";
          k = emails.length;
        }
      }
      if (willDelete) {
        swal("El registro ha sido eliminado!", {
          icon: "success",
        });

        tabla.deleteRow(i);
      } else {
        swal("Su registro no corre peligro");
      }
    });
}

//Copiar fila
function copiarFila(fila) {
  let i = fila.parentNode.parentNode.rowIndex;
  let celdas = tabla.rows[i];

  console.log(i);

  let filaV = tabla.insertRow(i + 1);
  let celda = filaV.insertCell(0);
  let celda1 = filaV.insertCell(1);
  let celda2 = filaV.insertCell(2);
  let celda3 = filaV.insertCell(3);

  let nombre = celdas.cells[0].firstChild.data;
  let apellido = celdas.cells[1].firstChild.data;
  let email = celdas.cells[2].firstChild.data;
  nombres[conteo] = nombre
  apellidos[conteo] = apellido;
  emails[conteo] = email;

  celda.innerHTML = nombre;
  celda1.innerHTML = apellido;
  celda2.innerHTML = email;
  celda3.innerHTML = botonEditar + '&nbsp;' + botonInsertar + '&nbsp;' + botonCopiar + '&nbsp;' + botonEliminar;
  conteo++;
}

// Insertar fila
function asignarCita(fila) {
  insertar = true;
  let i = fila.parentNode.parentNode.rowIndex;
  let celdas = tabla.rows[i];
  let filaV = tabla.insertRow(i + 1);
  let celda = filaV.insertCell(0);
  let celda1 = filaV.insertCell(1);
  let celda2 = filaV.insertCell(2);
  let celda3 = filaV.insertCell(3);


  celda.innerHTML = inputNombre;
  celda1.innerHTML = inputApellido;
  celda2.innerHTML = inputCedula;
  celda3.innerHTML = inputDireccion;
  celda4.innerHTML = inputTelefono;
  celda5.innerHTML = inputEmail;
  celda6.innerHTML = inputContraseña;
  celda7.innerHTML = botonGuardar;
}

// Editar la fila
function editarFila(fila) {
  let i = fila.parentNode.parentNode.rowIndex;
  let celdas = tabla.rows[i];

  let nombre = celdas.cells[0].firstChild.data;
  let apellido = celdas.cells[1].firstChild.data;
  let identificacion = celdas.cells[2].firstChild.data;
  let direccion = celdas.cells[3].firstChild.data;
  let telefono = celdas.cells[4].firstChild.data;
  let email = celdas.cells[5].firstChild.data;
  let contrasena = celdas.cells[6].firstChild.data;
  let confirmPsw = celdas.cells[7].firstChild.data;

  celdas.cells[0].innerHTML = inputNombre;
  celdas.cells[1].innerHTML = inputApellido;
  celdas.cells[2].innerHTML = inputCedula;
  celdas.cells[3].innerHTML = inputDireccion
  celdas.cells[4].innerHTML = inputTelefono
  celdas.cells[5].innerHTML = inputEmail;
  celdas.cells[6].innerHTML = inputContraseña
  celdas.cells[7].innerHTML = inputCargo
  celdas.cells[8].innerHTML = botonGuardar;

  document.querySelector('input.nombre').value = nombre;
  document.querySelector('input.apellido').value = apellido;
  document.querySelector('input.identificacion').value = identificacion;
  document.querySelector('input.direccion').value = direccion;
  document.querySelector('input.telefono').value = telefono;
  document.querySelector('input.email').value = email;
  document.querySelector('input.contrasena').value = contrasena;
  document.querySelector('input.confirmPsw').value = confirmPsw;
  let editame = document.querySelector('input.email').value = email;
  for (var j = 0; j < nombres.length; j++) {
    if (editame == emails[j]) {
      posicion = j;
    }
  }
}

// Guarda los datos de la fila
function guardar(fila) {
  let nombre = document.querySelector('input.nombre').value;
  let apellido = document.querySelector('input.apellido').value;
  let identificacion = document.querySelector('input.identificacion').value 
  let direccion = document.querySelector('input.direccion').value 
  let telefono = document.querySelector('input.telefono').value 
  let email = document.querySelector('input.email').value 
  let contrasena = document.querySelector('input.contrasena').value 
  let confirmPsw = document.querySelector('input.confirmPsw').value 

  if (insertar == true) {
    if (nombre != "" && apellido != "" && email != "") {
      let i = fila.parentNode.parentNode.rowIndex;
      let celdas = tabla.rows[i];

      celdas.cells[0].innerHTML = nombre;
      nombres[conteo] = nombre;

      celdas.cells[1].innerHTML = apellido;
      apellidos[conteo] = apellido;

      celdas.cells[2].innerHTML = identificacion;
      identificacion[conteo] = identificacion;

      celdas.cells[3].innerHTML = direccion;
      direccion[conteo] = direccion;

      celdas.cells[4].innerHTML = telefono;
      telefono[conteo] = telefono;

      celdas.cells[5].innerHTML = email;
      emails[conteo] = email;

      celdas.cells[6].innerHTML = contrasena;
      contrasena[conteo] = contrasena;

      celdas.cells[7].innerHTML = confirmPsw;
      confirmPsw[conteo] = confirmPsw;
      // celdas.cells[3].innerHTML = botonEditar + '&nbsp;' + botonInsertar + '&nbsp;' + botonCopiar + '&nbsp;' + botonEliminar;
      swal({
        title: "El usuario ha sido creado",
        text: "Bienvenido!" + nombre,
        icon: "success",
      });

    } else {
      swal({
        title: "Error!",
        text: "Ningún elemento puede estar vacío!",
        icon: "error",
        button: "aceptar",
      });
    }
    insertar = false;
  } else {
    if (nombre != "" && apellido != "" && email != "") {
      let i = fila.parentNode.parentNode.rowIndex;
      let celdas = tabla.rows[i];

      celdas.cells[0].innerHTML = nombre;
      nombres[posicion] = nombre;
      celdas.cells[1].innerHTML = apellido;
      apellidos[posicion] = apellido;
      celdas.cells[2].innerHTML = email;
      emails[posicion] = email;
      celdas.cells[3].innerHTML = botonEditar + '&nbsp;' + botonInsertar + '&nbsp;' + botonCopiar + '&nbsp;' + botonEliminar;

    } else {
      swal({
        title: "Error!",
        text: "Ningún elemento puede estar vacío!",
        icon: "error",
        button: "aceptar",
      });
    }
  }
  conteo++;
}