// javascript tabla clientes

function mostrarCliente(mostrar, clientName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(clientName).style.display = "block";
  mostrar.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
// document.getElementById("defaultOpen").click();

// javascript técnicos
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}




/* definir tamaño de la barra al mostrar */
function abrirBarra() {
  document.getElementById("barraLateral").style.width = "250px";
}

/* tamaño de la  barra al cerrar */
function cerrarBarra() {
  document.getElementById("barraLateral").style.width = "0";
}


// funcion ingreso a perfiles
function logIn() {
  var usuario = document.getElementById('usuario').value;
  var password = document.getElementById('psw').value;

  if (usuario == 'admin@homeins.co' && password == "12345") {
    console.log("Bienvenido administrador");
    window.location = 'html/admin/admin.html';
    swal({
      title: "Datos correctos",
      text: "Bienvenido! " + usuario,
      icon: "success",
    });

  } else if (usuario == 'admin@homeins.co' && password != "12345") {
    swal("Datos Incorrectos", "Tu usuario y/o contraseña son incorrectos");

  } else if (usuario == 'disenador@homeins.co' && password == "123456") {
    console.log("perfil diseñador");
    window.location = 'html/diseñador/diseñador.html';
    swal({
      title: "Datos correctos",
      text: "Bienvenido! " + usuario,
      icon: "success",
    });
  } else if (usuario == 'disenador@homeins.co' && password != "123456") {
    console.log("perfil diseñador");

    swal("Datos Incorrectos dis", "Tu usuario y/o contraseña son incorrectos");

  } else if (usuario == 'tecnico@homeins.co' && password == "1234567") {
    console.log("perfil tecnico");
    window.location = 'html/tecnico/tecnico.html';
    swal({
      title: "Datos correctos",
      text: "Bienvenido! " + usuario,
      icon: "success",
    });
  } else if (usuario == 'tecnico@homeins.co' && password != "1234567") {
    console.log("perfil diseñador");

    swal("Datos Incorrectos tec", "Tu usuario y/o contraseña son incorrectos");

  } else {
    swal("Campos Obligatorios", "Por favor ingresa los datos");
  }
}

function contactUs() {

  swal({
    title: "Mensaje Enviado",
    text: "Pronto nos comunicaremos contigo!",
    icon: "success",
  });

}

function forgotPsw() {
  var usuario = document.getElementById('contactMail').value;

  if (usuario == 'admin@homeins.co' || usuario == 'disenador@homeins.co' || usuario == 'tecnico@homeins.co') {
    window.location = 'recoverPass.html';
    swal({
      title: "Datos correctos",
      text: "Bienvenido!",
      icon: "success",
    });
  } else if (usuario == '') {
    swal("Campos Obligatorios", "Por favor ingresa el correo");
  } else if (usuario != 'admin@homeins.co' || usuario != 'disenador@homeins.co' || usuario != 'tecnico@homeins.co') {
    swal("Este correo no existe", "Por favor ingresa un usuario válido");
  }

}

function confirmPsw() {
  let contrasena = document.getElementById('contrasena').value;
  let confirmContra = document.getElementById('confirmPsw').value;
  if (contrasena.value == confirmContra.value) {
    window.location = 'index.html'
    swal({
      title: "Contraseña Cambiada",
      text: "Puedes iniciar sesión nuevamente!",
      icon: "success",
    });
  }
  swal("Error", "Las contraseñas no coinciden");

}