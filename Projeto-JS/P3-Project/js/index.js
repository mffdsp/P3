var paciente = [];
paciente[0] = new Object();
var CONT = 0;


function saveForm(form) {

  var fname = form.formNOME.value;
  var fage = form.formIDADE.value;
  var fadress = form.formENDERECO.value;
  if(fname == "" || fage == "" || fadress == ""){
    alert("Todos os dados devem ser preenchidos!");
    return;
  } 
  paciente[CONT] = new Object();
  paciente[CONT].nome = fname;
  paciente[CONT].idade = fage;
  paciente[CONT].endereco = fadress;
  alert("Paciente adicionado com os dados:" + 
      "\nNOME: " + paciente[CONT].nome + 
      "\nIDADE: " + paciente[CONT].idade +
      "\nENDEREÇO: " + paciente[CONT].endereco +
      "\nSINTOMAS: " + paciente[CONT].idade);
  CONT += 1;
}
function containerON () { 
  $('#container').show();
}

function containerOFF () { 
  $('#container').hide();
}
