Sugestão João Paolinelli -- > Alterar de Gestão de Estoque Inteligente para Gestão de fornecedores Inteligente.

· Relacao_01 – Ligação N..1 entre fornecedor e cidade, onde uma cidade poderá ter vários fornecedores, então o campo codcidade é transportado para a tabela de fornecedor, possibilitando saber que cidade pertence um determinado fornecedor.

Relacao_02 – Junção 1..N entre as tabelas Categoria e Produto, onde uma categoria pode ter vários produtos levando. Com isso, a tabela de produtos passa a ter a chave estrangeira codcategoria, possibilitando o controle de produtos por categoria.

· Relacao_03 – Vínculo de 1..N entre as tabelas Fornecedor e Produto, onde um fornecedor poderá ter vários produtos cadastrados a ele. Com isso, o campo codfornecedor irá para a tabela de produto.

· Relacao_04 – Nó 1..N entre Entrada e ItemEntrada, onde uma entrada terá vários itens (produtos). Com isso, a tabela ItemEntrada receberá o campo codentrada da entrada como chave estrangeira, para posteriormente poder saber em qual entrada estava um determinado produto.

Relacao_05 – Relacionamento 1..N entre Produto e ItemEntrada, onde um produto poderá estar em vários itens de entrada. Assim, a tabela ItemEntrada receberá o campo codproduto para quando houver a necessidade saber qual produto pertenceu aquele item.

· Relacao_06 – União N..1 entre Entrada e Transportadora, onde uma transportadora poderá levar várias entradas e uma entrada será transportada por apenas uma transportadora. A tabela de entrada recebe o campo codtransportadora da tabela Transportadora.

· Relacao_07 – Elo 1.N entre Produto e ItemSaida, onde um produto poderá estar em vários itens de saída. Assim, a tabela ItemSaida recebe o campo codproduto da tabela produto.

· Relacao_08 – Relacionamento N..1 entre ItemSaida e Saída, onde uma saída terá vários itens, por isso a tabela de ItemSaida receberá o campo codsaida.

· Relacao_09 – Ligação 1..N entre a tabela Transporte e Saída, onde uma transportadora poderá carregar várias saídas. Para um melhor controle de qual transportadora fez uma saída, a tabela de saída recebe o campo codtransportadora.

· Relacao_10 – Junção N..1 entre a tabela Loja e Saída, onde uma loja receberá várias saídas, e uma saída será somente para uma loja. Para obter melhor o controle para qual loja pertence uma saída, a tabela de saída recebe o campo codloja.

· Relacao_11 – Vínculo 1..N entre a tabela Cidade e Loja, onde uma cidade poderá ter várias lojas e uma loja estará somente em uma cidade. A chave estrangeira será transportada para tabela da loja, tendo a possibilidade de controlar as lojas que uma determinada cidade possui

· Relacao_12 – Conexão 1..N entre Cidade e Transportadora, onde a Cidade poderá ter várias Transportadoras e uma transportadora será de apenas uma cidade. Nesse caso, o campo codcidade será enviado para a tabela de Transportadora.