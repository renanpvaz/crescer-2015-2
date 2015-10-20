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
