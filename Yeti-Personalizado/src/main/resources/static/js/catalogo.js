
  let promesa = fetch('/producto/', {
    method: 'GET',
  });
  promesa.then((reponse) => {
    reponse.json().then(
      (prods) => {
        localStorage.setItem("datos", JSON.stringify(prods));
      } //prods
    ) //json
      .catch((err) => {
        console.log("Error en el formato de la respuesta" + err.message);
      }); //catch json
  } //respuesta
  ) //then
    .catch((error) => {
      console.log("Error en la respuesta" + error.message);
    });

