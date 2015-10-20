//Exercício 1.A
function ordenaPorNacionais(arr){
  var aux;
  for(var i = 0; i < arr.length - 1; i++){
    if(arr[i + 1].titulos[0].qtd > arr[i].titulos[0].qtd){
      aux = arr[i + 1];
      arr[i + 1] = arr[i];
      arr[i] = aux;
    }
  }
}

/*
*  function ordenaPorNacionais(arr){
*    arr.sort(function(a, b){ return a.titulos[0].qtd < b.titulos[0].qtd ? b : a; });
*  }
*/

//Exercício 1.B
function ordenaPorContinentais(arr){
  var aux;
  for(var i = 0; i < arr.length - 1; i++){
    if(arr[i + 1].titulos[1].qtd > arr[i].titulos[1].qtd){
      aux = arr[i + 1];
      arr[i + 1] = arr[i];
      arr[i] = aux;
    }
  }
}

//Exercício 1.C
function ordenaPorContinentais(arr){
  var aux;
  for(var i = 0; i < arr.length - 1; i++){
    if(arr[i + 1].titulos[2].qtd > arr[i].titulos[2].qtd){
      aux = arr[i + 1];
      arr[i + 1] = arr[i];
      arr[i] = aux;
    }
  }
}

//Exercício 2.A
function somarPorNacionais(arr){
  for(var i = 0, sum = 0; i < arr.length; i++){
    sum += arr[i].titulos[0].qtd;
  }
  return sum;
};

//Exercício 2.B
function somarPorContinentais(arr){
  for(var i = 0, sum = 0; i < arr.length; i++){
    sum += arr[i].titulos[0].qtd;
  }
  return sum;
};

//Exercício 2.C
function somarPorTodosTitulos(arr){
  for(var i = 0, sum = 0; i < arr.length; i++){
    sum += arr[i].titulos[0].qtd + arr[i].titulos[1].qtd + arr[i].titulos[2].qtd;
  }
  return sum;
};

//Exercício 3
function somarTodosTitulosDoClube(clube){
  for(var i = 0, sum = 0; i < 3; i++){
    sum += clube.titulos[i].qtd;
  }
  return sum;
}

function apenasOsMelhores(arr){
  var melhores = new Array();
  arr.forEach(function (a) { somarTodosTitulosDoClube(a) > 18 ? melhores.push(a) : a; })
  return melhores;
}

/*
function apenasOsMelhores(arr){
  var melhores = new Array();
  for(var i = 0; i < arr.length; i++){
    if(somarTodosTitulosDoClube(arr[i]) > 18){
      melhores.push(arr[i]);
    }
  }
  return melhores;
}
*/
