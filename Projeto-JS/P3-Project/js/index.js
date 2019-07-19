class Paciente {
  constructor(nome, idade, endereco, tipoS, code, sintomas) {
    this.nome = nome;
    this.idade = idade;
    this.endereco = endereco;
    this.tipoS = tipoS;
    this.code = code;
    this.sintomas = sintomas;
  }
}
class Doenca {
  constructor(nome, aparicao, dor, sintomas, prevencao, tratamento) {
    this.nome = nome;
    this.aparicao = aparicao;
    this.dor = dor;
    this.sintomas = sintomas;
    this.prevencao = prevencao;
    this.tratamento = tratamento;
  }
  // setName(name){
  //   alert('asassa');
  //   this.name = name;
  // }
}

var paciente = [];
var doenca = [];
var CONT = 0;
var CONT2 = 0;


function saveForm(form) {

  var fname = form.formNOME.value;
  var fage = form.formIDADE.value;
  var fadress = form.formENDERECO.value;
  var fsintomas = form.formSINTOMAS.value;
  var fcode = document.getElementById("formCODE").innerHTML;
  var fsintomas = form.formSINTOMAS.value;

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

  paciente[CONT] = new Paciente(fname, fage, fadress, fsangue, fcode, fsintomas);
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
  $('#container4').hide();
  $('#containerINICIAL').hide();
}

function editBTN () { 
  $('#container1').hide();
  $('#container2').show();
  $('#container3').hide();
  $('#container4').hide();
  $('#containerINICIAL').hide();
  
}
function doencaBTN(){
  $('#container1').hide();
  $('#container4').show();
  $('#container3').hide();
  $('#container2').hide();
  $('#containerINICIAL').hide();

}
function backToBegin(){
  $('#container1').hide();
  $('#container2').hide();
  $('#container4').hide();
  $('#container3').hide();
  $('#containerINICIAL').show();

}
function resetALL(){
  document.getElementById("formCODE").innerHTML = "2019" + CONT;
  document.getElementById("formNOME").value = "";
  document.getElementById("formIDADE").value = "";
  document.getElementById("formENDERECO").value = "";
  document.getElementById("formSINTOMAS").value = "";
  document.getElementById("formSANGUE").value = "";

}
var INDEX = 0;

function search(){
    var INDEX = document.getElementById("editBUSCA").value - 20190;
    if(paciente[INDEX] instanceof Paciente){
      realedit();
    }else alert("EXISTE N");
}
function realedit(){
  document.getElementById("formNOME3").value = paciente[INDEX].nome;
  document.getElementById("formIDADE3").value =  paciente[INDEX].idade;
  document.getElementById("formENDERECO3").value = paciente[INDEX].endereco;
  document.getElementById("formSINTOMAS3").value = paciente[INDEX].sintomas;
  document.getElementById("formSANGUE3").value = paciente[INDEX].tipoS;
  $('#container2').hide();
  $('#container3').show();
}

function saveEdit(){
  if(!window.confirm("Deseja confirmar as alterações?")){
    return;
  }else 

  paciente[INDEX].nome =  document.getElementById("formNOME3").value ;
  paciente[INDEX].idade =  document.getElementById("formIDADE3").value ;
  paciente[INDEX].endereco =  document.getElementById("formENDERECO3").value ;
  paciente[INDEX].sintomas =  document.getElementById("formSINTOMAS3").value ;
  paciente[INDEX].tipoS =  document.getElementById("formSANGUE3").value ;

  alert('Alterações Feitas com sucesso.');
  backToBegin();

}
function saveDOENCA(){
  doenca[CONT2] = new Object();
  var nome =  document.getElementById("formNOME4").value;
  var aparicao =  document.getElementById("formAPARICAO4").value;
  var dor =  document.getElementById("formDOR4").value;
  var sintomas =  document.getElementById("formSINTOMAS4").value;
  var prevencao =  document.getElementById("formPREV4").value;
  var tratamento =  document.getElementById("formTRATAMENTO4").value;
  if(nome == "" || aparicao == "" || dor == "" || sintomas == "" || prevencao == "" || tratamento == ""){
    alert("Todos os dados devem ser preenchidos!");
    return;
  }
  doenca[CONT2] = new Doenca(nome, aparicao, dor, sintomas, prevencao, tratamento);
  alert('SAVED');
  CONT2 += 1;
}
