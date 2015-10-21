function CarrinhoDeCompras(){
  this.itens = new Array();
}

function Item(sku, descricao, quantidade, valorUnitario){
  this.sku = sku;
  this.descricao = descricao;
  this.quantidade = quantidade;
  this.valorUnitario = valorUnitario;
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

Item.prototype.calcularSubTotal = function(){
  return this.quantidade * this.valorUnitario;
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

CarrinhoDeCompras.prototype.forcarCompra = function(){
  if(!this.intervalo){
    this.intervalo =
    setInterval(
      function(){
        this.itens.forEach(function(elem){
          elem.valorUnitario += elem.valorUnitario * 0.1;
          console.log(elem.valorUnitario);
        }
      )}.bind(this), 5000);
  }
}

CarrinhoDeCompras.prototype.concluirPedido = function(){
  clearInterval(this.intervalo);
  this.interval = 'undefined';
}
