create or replace package pck_cidade is

  -- Author  : Andre Nunes
  -- Purpose : controlar cadastro de cidades
  
  -- Public declarations
  function busca_cidade (pNome in varchar2,
                         pUF   in varchar2) return integer;
  
end pck_cidade;
/

create or replace package body pck_cidade is

  -- Private type declarations
  ------------------------------------------------------------------------------------------------  
  /* retorna o ID da cidade */
  function busca_idcidade (pNome in varchar2,
                           pUF   in varchar2) return integer as
    v_idcidade integer;
  begin
    
    select idcidade
    into   v_idcidade 
    from   cidade
    where  lower(nome) = lower(pNome)   -- utiliza a vers�o, pois o oracle � case sensitive
    and    lower(uf)   = lower(pUF);
    
    return v_idcidade;
    
  exception
     when no_data_found then -- caso n�o encontre a cidade
        return -1;
  end;                          
  ------------------------------------------------------------------------------------------------
  procedure cria_cidade (pNome in varchar2,
                         pUF   in varchar2,
                         pIDCidade out integer) as
     -- N�o � permitido o uso de operacoes Insert, Update e Delete dentro de fun��es
     -- Para evitar o erro � preciso criar uma transa��o aut�noma e utilizar do commit 
     pragma autonomous_transaction;
  begin
     
     insert into Cidade
        (nome, uf)
     values
        (initcap(pNome),
         upper(pUF) )
      returning IDCidade into pIDCidade; -- ir� retornar o IDCidade gerado conforme sequence/trigger

      -- confirma a transa��o aut�noma
      commit; 
      
  end cria_cidade;
  ------------------------------------------------------------------------------------------------
  function busca_cidade (pNome in varchar2,
                         pUF   in varchar2) return integer as
      v_idcidade integer;
  begin

      v_idcidade := busca_idcidade(pNome, pUF);

      -- caso a cidade n�o exista
      if v_idcidade = -1 then
        cria_cidade(pNome, pUF, v_idcidade); -- procedure com parametro OUT
      end if;
      
      return v_idcidade;
  end busca_cidade;
  
begin
  -- Initialization
  null;
end pck_cidade;
/
