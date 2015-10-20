var clubes = [
  {
    nome: 'Arsenal',
    fundacao: new Date(1886, 0, 1),
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Manchester United',
    fundacao: new Date(1878, 0, 1),
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    fundacao: new Date(1892, 2, 15),
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    fundacao: new Date(1905, 2, 10),
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];

//Exercício 1
function ordenaPorTitulo(arr, titulo){
    return arr.sort(function(a, b){ return a.titulos[titulo].qtd < b.titulos[titulo].qtd; });
};

//Exercício 2
function somarPorTitulo(arr,index){
  return clubes.reduce(function(sum, elemAtual){return sum + elemAtual.titulos[index].qtd; });
};

//Exercício 3
function apenasOsMelhores(arr){
  return arr.filter(function (elem) { return elem.titulos[0].qtd > 18; });
};

//Exercício 4
function calcularIdadeMedia(clubes) {
  var soma = clubes
    .map(function(elem) {
      // projetando as idades
      return new Date().getFullYear() - elem.fundacao.getFullYear();
    })
    .reduce(function(acumulador, elem) {
      return acumulador + elem;
    }, 0);

  return soma / clubes.length;
};
