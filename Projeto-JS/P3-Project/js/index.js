class Paciente {
  constructor(nome, idade, endereco, tipoS, code) {
    this.nome = nome;
    this.idade = idade;
    this.endereco = endereco;
    this.tipoS = tipoS;
    this.code = code;
  }
}

var paciente = [];
var CONT = 0;


function saveForm(form) {

  var fname = form.formNOME.value;
  var fage = form.formIDADE.value;
  var fadress = form.formENDERECO.value;
  var fsintomas = form.formSINTOMAS.value;
  var fcode = document.getElementById("formCODE").innerHTML;


  try{
    paciente[CONT] = new Object();
    var fsangue = form.formSANGUE.value;
    if(!(fsangue == "A+"||
      fsangue == "B+" ||
      fsangue == "O+" ||
      fsangue == "AB+" ||
      fsangue == "A-" ||
      fsangue == "B-" ||
      fsangue == "O-" ||
      fsangue == "AB-"))
      {
        throw new Exception("ERRO");
      }else  document.getElementById("erro").innerHTML = "";
    }
    catch(e){
        document.getElementById("erro").innerHTML = "Tipo incorreto!";
        logMyErrors(e); 
         
    }

  if(fname == "" || fage == "" || fadress == "" || fsangue == "" || fsintomas == ""){
      alert("Todos os dados devem ser preenchidos!");
      return;
  } 

  paciente[CONT] = new Paciente(fname, fage, fadress, fsangue, fcode);
  var index = 0;
  while(index < 100){
    
    if(paciente[index] instanceof Paciente){
      alert("Paciente adicionado com os dados:" + 
      "\nNOME: " + paciente[index].nome + 
      "\nIDADE: " + paciente[index].idade +
      "\nENDEREÇO: " + paciente[index].endereco +
      "\nSINTOMAS: " + paciente[index].idade +
      "\nTipo Sang.: " + paciente[index].tipoS + 
      "\nCODE.: " + paciente[index].code);
    }
    
    index += 1;
  }

  CONT += 1;
  resetALL();
 
}
function addBTN () { 
  document.getElementById("formCODE").innerHTML = "2019" + CONT;
  $('#container1').show();
  $('#container2').hide();
  $('#container3').hide();
  $('#containerINICIAL').hide();
}

function editBTN () { 
  $('#container1').hide();
  $('#container2').show();
  $('#container3').hide();
  $('#containerINICIAL').hide();
  
}
function resetALL(){
  document.getElementById("formCODE").innerHTML = "2019" + CONT;
  document.getElementById("formNOME").value = "";
  document.getElementById("formIDADE").value = "";
  document.getElementById("formENDERECO").value = "";
  document.getElementById("formSINTOMAS").value = "";
  document.getElementById("formSANGUE").value = "";

}
function search(){
  
    alert(document.getElementById("editBUSCA").value - 20190);
    if(paciente[document.getElementById("editBUSCA").value - 20190] instanceof Paciente){
      realedit();
    }else alert("EXISTE N");
}
function realedit(){
  $('#container2').hide();
  $('#container3').show();
}

