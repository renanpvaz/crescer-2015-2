Date.prototype.possuiAnoBissexto = function(){
  return this % 4 == 0 && this % 100 != 0 || this % 400 == 0;
}
