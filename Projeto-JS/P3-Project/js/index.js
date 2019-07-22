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
  document.getElementById("formCPF3").value = paciente[INDEX].CPF;
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

function hideALL(){

  $('#container1').hide();
  $('#container2').hide();
  $('#container3').hide();
  $('#container5').hide();
  $('#container4').hide();
  $('#container6').hide()
  $('#containerINICIAL').hide();
  $('#doenca').hide();
  $('#containerINICIAL').hide();
  $('#contact_b').hide();
  $('#container7').hide();
}
function addBTN () { 

  document.getElementById("bt1").style.backgroundColor = "#f44336";
  document.getElementById("bt2").style.backgroundColor = "#363b48";
  document.getElementById("bt3").style.backgroundColor = "#363b48";
  document.getElementById("bt4").style.backgroundColor = "#363b48";
  document.getElementById("bt5").style.backgroundColor = "#363b48";

  hideALL();
  $('#container1').show();

}

function editBTN () { 

  document.getElementById("bt1").style.backgroundColor = "#363b48";
  document.getElementById("bt2").style.backgroundColor = "#f44336";
  document.getElementById("bt3").style.backgroundColor = "#363b48";
  document.getElementById("bt4").style.backgroundColor = "#363b48";
  document.getElementById("bt5").style.backgroundColor = "#363b48";

  hideALL();
  $('#container2').show();
  
  document.getElementById("errosearch").innerHTML = "";
  
}
function doencaBTN(){

  document.getElementById("bt1").style.backgroundColor = "#363b48";
  document.getElementById("bt2").style.backgroundColor = "#363b48";
  document.getElementById("bt3").style.backgroundColor = "#f44336";
  document.getElementById("bt4").style.backgroundColor = "#363b48";
  document.getElementById("bt5").style.backgroundColor = "#363b48";

  hideALL();
  $('#container4').show();

}
function backToBegin(){
  hideALL();
  $('#containerINICIAL').show();
}

function ldoencaBTN(){
  
  document.getElementById("bt1").style.backgroundColor = "#363b48";
  document.getElementById("bt2").style.backgroundColor = "#363b48";
  document.getElementById("bt3").style.backgroundColor = "#363b48";
  document.getElementById("bt4").style.backgroundColor = "#f44336";
  document.getElementById("bt5").style.backgroundColor = "#363b48";


  hideALL();
  $('#doenca').show();
  primitiveDOC()

}

function medicamentoBTN(){

  document.getElementById("bt1").style.backgroundColor = "#363b48";
  document.getElementById("bt2").style.backgroundColor = "#363b48";
  document.getElementById("bt3").style.backgroundColor = "#363b48";
  document.getElementById("bt4").style.backgroundColor = "#363b48";
  document.getElementById("bt5").style.backgroundColor = "#f44336";

  hideALL();
  $('#container6').show();


}
//botoes


function contact(){

  hideALL();
  $('#container7').show();

}
jQuery(function($)  
{
    $("#contact_form").submit(function()
    {
        var email = $("#email").val(); // get email field value
        var phone = $("#phone").val(); // get email field value
        var name = $("#name").val(); // get name field value
        var msg = $("#msg").val(); // get message field value
        $.ajax(
        {
            type: "POST",
            headers: {
                'Authorization':'',
                'Content-Type':'application/json'},
            url: "https://mandrillapp.com/api/1.0/messages/send.json",
            data: {
                'key': 'sVRLFidC1A7K56TuUkyUQg',
                'email': email,
                'phone': phone,
                'name': name,
                'message': msg
            }
        })
        .done(function(response) {
            alert('Your message has been sent. Thank you!'); // show success message
            $("#name").val(''); // reset field after successful submission
            $("#email").val(''); // reset field after successful submission
            $("#msg").val(''); // reset field after successful submission
        })
        .fail(function(response) {
            alert('Error sending message.');
        });
        return false; // prevent page refresh
    });
});