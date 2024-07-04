function copiarAlPortapapeles(element) {
  // Crea un campo de texto "oculto"
  if(typeof element == "string"){
  	console.log("copy #"+element);
  	element = document.getElementById(element);
  }
  var aux=document.createElement('textarea');
  aux.innerHTML=element;
  if(aux.innerHTML.indexOf('javascript:void(0)')!==-1){
    console.log("is object");
     aux.innerHTML=element.innerHTML;    
  }
  element.appendChild(aux);
  console.log("copy:"+aux.innerHTML+"=>"+aux);
  aux.select();
  // Copia el texto seleccionado
  document.execCommand("copy");
  aux.remove();
  aux=document.createElement('em');
  aux.innerHTML="copied!<br/>";
  element.parentNode.insertBefore(aux,element);
}