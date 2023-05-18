'use strict'

// ACCESS TO DOM
let mail = document.getElementById("mail");
let pswd = document.getElementById("pswd");
let btnLogIn = document.getElementById("btnLogIn");
let alertVal = document.getElementById("alertVal");
let alertValText = document.getElementById("alertValText");
let togglePassword = document.getElementById("togglePassword");
let idTimeout;
let isValid = true;
let usuario = [];

// TOGGLE PASSWORD 

togglePassword.addEventListener("click", function(e) {
    const type = pswd.getAttribute("type") === "password" ? "text" : "password";
    pswd.setAttribute("type", type);
    this.classList.toggle("fa-eye-slash");
});

// BUTTON WITH ADD EVENT LISTENER

btnLogIn.addEventListener("click", function (event) {
    event.preventDefault();
    alertVal.style.display = "none";
    alertValText.innerHTML = "";
    let alertMsg = "";
    isValid = true;
    clearTimeout(idTimeout);
    
    let usuario = {
                "mail": mail.value,
                "password": pswd.value
    };
    
    

    fetch('/login/', {
    method: 'POST', // or 'PUT'
    headers: {
     'Content-Type': 'application/json',
   },
   body: JSON.stringify(usuario),
 })
 .then(response => response.json())
 .then(data => {
   console.log('Success:', data);
   let usuarioLogged = {
                "mail": mail.value,
                "token": data
    };
    data = JSON.stringify(data);
    if (data.match(/^{"accessToken"/)){
   sessionStorage.setItem("usuarioLogin",JSON.stringify(usuarioLogged));
   Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Bienvenido',
            showConfirmButton: false,
            timer: 2500
        })

        alertVal.style.display = "none";
        alertValText.innerHTML = "";

        idTimeout = setTimeout(function () {
            window.location.href = "./index.html";
            
        }, 1000);}
        else {
			mail.style.border = "solid thin red";
   			pswd.style.border = "solid thin red";
   			alertMsg = "Usuario o contraseña incorrectos."
   			alertVal.style.display = "block";
   			alertValText.insertAdjacentHTML("beforeend", alertMsg);
		}
 })
 
 .catch((error) => {
	mail.style.border = "solid thin red";
   	pswd.style.border = "solid thin red";
   	alertVal.style.display = "block";
   	alertMsg += "Usuario o contraseña incorrectos."
   console.log(error);
  });
	
    
	
});


