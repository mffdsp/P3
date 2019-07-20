class Paciente {
  constructor(nome, idade, endereco, tipoS, sintomas, CPF) {
    this.nome = nome;
    this.idade = idade;
    this.endereco = endereco;
    this.tipoS = tipoS;
    this.sintomas = sintomas;
    this.CPF = CPF;
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
var CONT2 = 5;
var CONTDOC = 0;

function saveForm(form) {

  var fname = form.formNOME.value;
  var fage = form.formIDADE.value;
  var fadress = form.formENDERECO.value;
  var fsintomas = form.formSINTOMAS.value;
  var fsintomas = form.formSINTOMAS.value;
  var fCPF = form.formCPF.value;

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

  paciente[CONT] = new Paciente(fname, fage, fadress, fsangue, fsintomas, fCPF);
  var index = 0;
  while(index < 100){
    
    if(paciente[index] instanceof Paciente){
      alert("Paciente adicionado com os dados:" + 
      "\nNOME: " + paciente[index].nome + 
      "\nIDADE: " + paciente[index].idade +
      "\nENDEREÇO: " + paciente[index].endereco +
      "\nSINTOMAS: " + paciente[index].idade +
      "\nTipo Sang.: " + paciente[index].tipoS + 
      "\nCpf.: " + paciente[index].CPF );
    }
    
    index += 1;
    
  }

  CONT += 1;
  backToBegin();
  resetALL();
 
}

function resetALL(){
 
  document.getElementById("formCPF").value = "";
  document.getElementById("formNOME").value = "";
  document.getElementById("formIDADE").value = "";
  document.getElementById("formENDERECO").value = "";
  document.getElementById("formSINTOMAS").value = "";
  document.getElementById("formSANGUE").value = "";
  document.getElementById("formNOME4").value =  "";
  document.getElementById("formAPARICAO4").value =  "";
  document.getElementById("formDOR4").value =   "";
  document.getElementById("formSINTOMAS4").value =  "";
  document.getElementById("formPREV4").value =  "";
  document.getElementById("formTRATAMENTO4").value =  "";

}
var INDEX = 0;

function search(){
  INDEX = 0;
  var find = false;
  for(var i = 0; i < 5; i++){
    if(paciente[i] instanceof Paciente){
      if(paciente[i].CPF == document.getElementById("editBUSCA").value && !find){
        find = true;
        document.getElementById("errosearch").innerHTML = "";
        INDEX = i;
        realedit();
      }
      
    }
  }
  document.getElementById("errosearch").innerHTML = "CPF não encontrado!";
    
}
function realedit(){
  document.getElementById("formNOME3").value = paciente[INDEX].nome;
  document.getElementById("formIDADE3").value =  paciente[INDEX].idade;
  document.getElementById("formENDERECO3").value = paciente[INDEX].endereco;
  document.getElementById("formSINTOMAS3").value = paciente[INDEX].sintomas;
  document.getElementById("formSANGUE3").value = paciente[INDEX].tipoS;
  document.getElementById("formCPF").value = paciente[INDEX].CPF;
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
  for(var i = 0; i < 10; i++){
    if(doenca[i] instanceof Doenca && nome.toLowerCase() == (doenca[i].nome).toLowerCase()){
      alert("ERRO!\nDoença já cadastrada no sistema!");
      return;
    }
  }
 
  doenca[CONT2] = new Doenca(nome, aparicao, dor, sintomas, prevencao, tratamento);

  var elemento_pai = document.getElementById("myUL");
  var titulo = document.createElement('li');

  // Criando o nó de texto de outra forma
  titulo.textContent = nome;
  titulo.id = CONT2;
  
  titulo.onclick = function () {
    verdoenca(titulo.id);
};

  // Inserir (anexar) o elemento filho (titulo) ao elemento pai (body)
  elemento_pai.appendChild(titulo);

  alert('Salvo com sucesso!');
  resetALL();
  backToBegin();
  CONT2 += 1;
}
function addElement(value, nome){
  var elemento_pai = document.getElementById("myUL");
  var titulo = document.createElement('li');
   
    titulo.textContent = nome;
    titulo.id = value;
    titulo.onclick = function () {
      verdoenca(titulo.id);
    };
    elemento_pai.appendChild(titulo);
}
var justOnly = false;
function primitiveDOC(){
  if(justOnly){
    return;
  }
  justOnly = true;
  var nome = ["Cancer", "Aids", "Gripe", "Lupus", "Hanseniase"];
  var aparicao = [10,50,30,10,65];
  var dor = ["Pe", "cabeça", "Orelha", "fígado", "Asa"];
  var sintomas = ["dor", "febre", "febre", "febre", "febre"];
  var prevencao = ["vacina", "vacina", "vacina, vacina", "vacina", "vacina"];
  var tratamento = ["Soro", "Soro", "Soro", "Soro", "Soro", "Soro"];

  for(var i  = 0; i < 5; i++){
    doenca[i] = new Object();
    doenca[i] = new Doenca(nome[i], aparicao[i], dor[i], sintomas[i], prevencao[i], tratamento[i]);
    addElement(i, nome[i]);
  
  }
  i = 0;
}
//AQ

// Click on a close button to hide the current list item

// Create a new list item when clicking on the "Add" button
// function newElement() {
//   var li = document.createElement("li");
//   var inputValue = document.getElementById("myInput").value;
//   var t = document.createTextNode(inputValue);
//   li.appendChild(t);
//   if (inputValue === '') {
//     alert("You must write something!");
//   } else {
//     document.getElementById("myUL").appendChild(li);
//   }
//   document.getElementById("myInput").value = "";

//   var span = document.createElement("SPAN");
//   var txt = document.createTextNode("\u00D7");
//   span.className = "close";
//   span.appendChild(txt);
//   li.appendChild(span);

//   for (i = 0; i < close.length; i++) {
//     close[i].onclick = function() {
//       var div = this.parentElement;
//       div.style.display = "none";
//     }
//   }
// }
function teste(){
  alert("dsdsa");
}

function verdoenca(busca){
  var achou = false;
  for(var i = 0; i < 100; i++){
    if(i == busca){
      alert(busca); 
      achou = true;
      listarD(busca);
     
    }
  }
  if(!achou){
    alert("Não encontrado!");
  }
}

function listarD(busca){
  $('#doenca').hide();
  $('#container5').show();
  alert(doenca[busca].nome);
  document.getElementById("formNOME5").value = doenca[busca].nome;
  document.getElementById("formAPARICAO5").value = doenca[busca].aparicao;
  document.getElementById("formDOR5").value = doenca[busca].dor;
  document.getElementById("formSINTOMAS5").value = doenca[busca].sintomas;
  document.getElementById("formPREV5").value = doenca[busca].prevencao;
  document.getElementById("formTRATAMENTO5").value = doenca[busca].tratamento;

}
//botoes

function addBTN () { 
  $('#container1').show();
  $('#container2').hide();
  $('#container3').hide();
  $('#container5').hide();
  $('#container4').hide();
  $('#doenca').hide();
  $('#containerINICIAL').hide();
}

function editBTN () { 
  $('#container1').hide();
  $('#container2').show();
  $('#container3').hide();
  $('#container4').hide();
  $('#container5').hide();
  $('#containerINICIAL').hide();
  $('#doenca').hide();
  document.getElementById("errosearch").innerHTML = "";
  
}
function doencaBTN(){
  $('#container1').hide();
  $('#container4').show();
  $('#container3').hide();
  $('#container2').hide();
  $('#container5').hide();
  $('#doenca').hide();
  $('#containerINICIAL').hide();

}
function backToBegin(){
  $('#container1').hide();
  $('#container2').hide();
  $('#container4').hide();
  $('#container3').hide();
  $('#container5').hide();
  $('#containerINICIAL').show();
  $('#doenca').hide();

}

function ldoencaBTN(){
  
  $('#container1').hide();
  $('#container2').hide();
  $('#container4').hide();
  $('#container3').hide();
  $('#containerINICIAL').hide();
  $('#container5').hide();
  $('#doenca').show();
  primitiveDOC()

}


//botoes