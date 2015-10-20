//Exercício 1.A
function ordenaPorNacionais(arr){
    arr.sort(function(a, b){ return a.titulos[0].qtd < b.titulos[0].qtd});
}


//Exercício 1.B
function ordenaPorContinentais(arr){
  arr.sort(function(a, b){ return a.titulos[1].qtd < b.titulos[1].qtd});
}

//Exercício 1.C
function ordenaPorMundiais(arr){
  arr.sort(function(a, b){ return a.titulos[2].qtd < b.titulos[2].qtd});
}

//Exercício 2.A
function somarPorNacionais(arr){
  var sum = 0;
  for(var i in arr){
    sum += arr[i].titulos[0].qtd;
  }
  return sum;
};

//Exercício 2.B
function somarPorContinentais(arr){
  var sum = 0;
  for(var i in arr){
    sum += arr[i].titulos[1].qtd;
  }
  return sum;
};

//Exercício 2.C
function somarPorTodosTitulos(arr){
  var sum = 0;
  for(var i in arr){
    sum += somarTodosTitulosDoClube(arr[i]);
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
  return arr.filter(function (elem) { return somarTodosTitulosDoClube(elem) > 18});
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
