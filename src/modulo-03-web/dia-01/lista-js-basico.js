// Exercício 1
function daisyGame(petals){
  return petals % 2 === 0 ? "Love me not" : "Love me";
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
  console.log(f);
}

//Exercício 5
function excelis(a){
  var code = 0;
  var code2 = 0;
  for (var i in a){
    if(i.equals(0){
     code += (a[i].charCodeAt() - 64);
   }else{
     code2 += (a[i].charCodeAt() - 38);
   }
  }
  return a.length === 1? code : (code * code2) - ((a[0].charCodeAt() - 65) * (a[1].charCodeAt() - 64));
}
