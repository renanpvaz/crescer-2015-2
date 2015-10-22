function CarrinhoDeCompras(){
  this.itens = new Array();
}

CarrinhoDeCompras.prototype.adicionarItem = function(item){
  this.itens.push(item);
}

CarrinhoDeCompras.prototype.removerItem = function(sku){
  this.itens = this.itens.filter(function(elem, itens) { elem.sku !== sku});
}

CarrinhoDeCompras.prototype.atualizarQuantidade = function(sku, qtd){
  this.itens.forEach(function (elem){ if(elem.sku === sku){ elem.qtd = qtd;}});
}

CarrinhoDeCompras.prototype.calcularTotal = function(){
  return this.itens
  .reduce(function(sum, elem){ return sum + elem.calcularSubTotal()} ,0);
}

CarrinhoDeCompras.prototype.sortearDesconto = function(){
  var sorte = Math.floor(Math.random() * 10) + 1;
  if(sorte <= 4){
    this.itens.forEach(function(elem){ elem.valorUnitario *= 0.9; });
  }
}
