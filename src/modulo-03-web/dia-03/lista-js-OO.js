function carrinhoDeCompras(){
  this.itens = new Array();
}

function item(sku, descricao, quantidade, valorUnitario){
  this.sku = sku;
  this.descricao = descricao;
  this.quantidade = quantidade;
  this.valorUnitario = valorUnitario;
}

carrinhoDeCompras.prototype.adicionarItem = function(item){
  this.itens.push(item);
}

carrinhoDeCompras.prototype.removerItem = function(sku){
  this.itens = this.itens.filter(function(elem, itens) { elem.sku != sku});
}

carrinhoDeCompras.prototype.atualizarQuantidade = function(sku, qtd){
  this.itens.forEach(function (elem){ if(elem.sku === sku){ elem.qtd = qtd;}});
}

carrinhoDeCompras.prototype.calcularSubTotal = function(item){
  return item.quantidade * item.valorUnitario;
}

carrinhoDeCompras.prototype.calcularTotal = function(carrinho){
  return carrinho.itens
  .reduce(function(sum, elem){ return sum + carrinho.calcularSubTotal(elem)} ,0);
}

carrinhoDeCompras.prototype.sortearDesconto = function(carrinho){
  var sorte = Math.floor(Math.random() * 10) + 1;
  if(sorte <= 10){
    carrinho.itens.forEach(function(elem){ elem.valorUnitario = elem.valorUnitario * 0.1})
  }
}
