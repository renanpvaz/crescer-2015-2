function isNumber(number){ return typeof number === 'number' ? true : false; }

// Exercício 1
function daisyGame(petals){
  if(isNumber(petals)){
    return petals % 2 === 0 ? "Love me not" : "Love me";
  }
}

//Exercício 2
function maiorTexto (array) {
  return array.reduce(function (a, b) { return a.length > b.length ? a : b; });
}

//Exercício 3
function imprime(arr, f){
  try{
    arr.forEach(f);
  } catch(TypeError){
    console.log('Jabulani: '  + TypeError);
  }
}

//Exercício 4
function fiboSum(i){
  var f = [1, 1];
  for(x = 2; x < (i + 2); x++){
    f[x] = f[x - 1] + f[x - 2];
  }

  console.log(f.reduce(function (a, b) { return a + b; });
}

//Exercício 5
function excelis(a){
    var b = 0;
    for(var i = 0; i < a.length; i++){
      b = b * 26 + (a.charCodeAt(i) - 64);
    }
    return b;
  };

//Exercício 6
function queroCafe(x, precos){
  var r = new Array();
  for(var i = 0; i < precos.length; i++){
    if(precos[i] <= x){
      r.push(precos[i]);
    }
  }
  return r.sort(function(a, b){ return a >= b});
}
