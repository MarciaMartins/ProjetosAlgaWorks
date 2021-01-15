var formulario = document.querySelector(".form-produto");
console.log(formulario);

var controlRadioButton = document.querySelector(".form-radio-confirm");
console.log(controlRadioButton);

function configuraCampoConjunto() {
  var campo= document.getElementById('form-quantPacote');
    if(campo.disabled == false){
      campo.disabled=true;
    }else  campo.disabled = false;
}


function habilitaPreco(){
  var campo = document.getElementById('inclusaopreco');
      campo.style.display = "block";
}

function desabilitaPreco(){
  var campo = document.getElementById('inclusaopreco');
    campo.style.display = "none";

}
