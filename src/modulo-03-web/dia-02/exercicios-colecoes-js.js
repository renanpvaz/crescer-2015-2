var clubes = [
  {
    nome: 'Arsenal',
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Manchester United',
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];

//Exercício 1
function ordenaPorTitulo(arr, titulo){
    return arr.sort(function(a, b){ return a.titulos[titulo].qtd < b.titulos[titulo].qtd});
}

//Exercício 2
function somarPorTitulo(arr,index){
  return clubes.reduce(funtion(sum, elemAtual){return sum + elemAtual.titulos[index].qtd})
};

//Exercício 3
function apenasOsMelhores(arr){
  return arr.filter(function (elem) { return elem.titulos[0].qtd > 18});
}
