# Gestão de Estoque Inteligente


**Diogo Araújo Miranda, diogoaraujomiranda@hotmail.com**

**Danniel Henrique Correa Vieira, danniel.hcvieira@gmail.com**

**Gustavo Martins Lopes da Costa, gusluud@gmail.com**

**João Paolinelli e Silva, joaopaolinelli@gmail.com**


---

_Curso de Ciência da Computação, Unidade {Coração Eucarístico | Praça da Liberdade}_

_Instituto de Informática e Ciências Exatas – Pontifícia Universidade de Minas Gerais (PUC MINAS), Belo Horizonte – MG – Brasil_

---

_**Resumo**.  - Objetivando otimizar investimentos, aumentar efiência de ferramentas internas dentro de empresas e minimizar as necessidades de capital investido em estoque, o grupo propõe, por meio de tecnologias inteligentes e do gerenciamento por meio de banco de dados, a criação de um sistema acessível e inovador à população brasileira. Devido ao fato de que  muitos indivíduos têm o potêncial de seu negócio prejudicado pela ausência de um ERP ou má administração de seus dados o que acarreta em erros na emissão de relatórios e gastos desnecessários, o uso de uma software que auxilie com tecnologia moderna e inteligente revela-se agregar eficiência e melhoria nos sistema de gestão de Estoque.


## 1.Introdução
**1.1 Contextualização**
 - O trabalho proposto pelo grupo a ser desenvolvido toma parte em um contexto na qual diversas epresas e microempresas necessitam de aprimorar o seu sistema de gerenciamento    de estoques, visto que seu potêncial total não é alcançado devido a uma  má administração de seus dados. Com isso, o processo de fazer relatórios e consultar disponibilidade é feito de forma não clara e muitas vezes que não condiz com a realidade, o que acaba por gerar erros graves que afetam a venda e compra de produtos, tanto no atacado quanto no varejo.
    
 Além disso, a proposta do grupo se baseia no fato de que tanto no atacado quanto no varejo o bom gerenciamento de estoque é essencial para que negócio se desenvolva e se mantenha seja desde o âmbito de estoque de matéria prima, até brinquedos, alimentos, produtos de beleza, entre outros. Assim automatizar a contabilidade de recursos de forma inteligente se torna uma oportunidade de trabalho interessante.  
   
**1.2 Problema**
 - Segundo a "guiaempreendedor" um gerenciamento de estoque ineficaz pode causar diversos prejuízos para uma empres, tal como perda da produtividade, perda de dinheiro, representado pelo investimento na compra dos produtos, erros de expedição, retrabalho. Ao ponderar sobre o assunto o grupo encontrou como problema principal para buscar solucionar a falta de produtividade e organização que diversas empresas e microempresas possuem no processo de gerenciamento de seus estoques. Visto que, essa adversidade afeta não só a velocidade com que a pesquisa e atualização é executada, como também a relação com o cliente em casos de discrepância na real disponibilidade de determinado produto.     
**1.3 Objetivo geral**
 - Nosso objetivo como grupo desenvolvedor do projeto é proporcionar um produto, simples, intuitivo e inteligente para que o processo de gerenciamento de estoques seja muito mais produtivo evitando erros de discrepância e facilitando o trabalho do usuário final.

   - **1.3.1 Aprimorar o potencial de vendas de empresas e microempresas**.
   
   - **1.3.2 Integrar sistemas inteligentes para aprimorar a experiência do usuário**.
   
   - **1.3.3 Mitigar discrepâncias no gerenciamento de estoques**.

**1.4 Justificativas**
 - Realizar esse projeto se tornou extremamente justificável para o grupo, ao passo que o tema de gerenciamento de estoque abre portas para fortemente exercitar o que foi aprendido na disciplina de banco de dados e de Introdução aos Sistemas Inteligentes. Proporcionando assim como diferencial do trabalho desenvolvido a aplicação dos sistemas inteligentes para aprimorar ainda mais a experiência do usuário e entregar uma melhor interação com a aplicação. 

**2. Projeto da Solução**

    2.1. Requisitos funcionais
	
A tabela a seguir representa os requisitos funcionais do projeto, em grupos de identificador, descrição e sua prioridade.

| No.           | Descrição                                 | Prioridade |
|:------------- | :---------------------------------------: | ----------:|
| RF-01         | Menu com opções de ações do usuário       | Alta       |
| RF-02         | Consultar quantidade de produto no estoque| Alta       | 
| RF-03         | Registrar produtos do estoque             | Alta       |
| RF-04         | Alertar sobre baixa quantidade de produto | Média      |
| RF-05         | Gerar gráficos dinâmicos sobre vendas     | Média      |
| RF-06         | Login para acesso ás funcionalidades      | Alta       |
| RF-07         | Cadastro de usuários                      | Alta       |
| RF-08         | Autopreenchimento nos filtros de busca    | Baixa      |
| RF-09         | Geração de relatório refêrente ao estoque | Baixa      |

    2.2. Tecnologias 

O desenvolvimento da aplicação é baseado no modelo MVC (Model-View-Controller) em que seus servições serão disponilizados
via aplicação web (website), e seu diagrama de tecnologias é representado a seguir: 

![Diagrama de tecnologias](imagens/tecnologias.png "Diagrama de tencologias")

- (VIEW) As tecnologias básicas de desenvolvimento web - HTML, CSS, JS - serão utilizadas para tornar os dados visíveis aos usuários finais.
- (CONTROLLE) A parte de controle da aplicação é feita em Java, com auxilio das tecnologias Spark Framework e Maven integrada, e como ambiente
de trabalho foi utilizado a IDE Eclipse.
- (MODEL) O modelo da aplicação é feita no banco de dados relacional PostgreSQL

    2.3. Serviços inteligentes

O sistema possui mecanismos de inteligência que melhoram o resultado final na utilização da aplicação. Basicamente
o mecanismo busca realizar análises estatísticas com os dados gerados pela própria aplicação e dados extraídos da 
internet, gerando relatórios essências para a tomada de decisões. O diagrama a seguir demonstra o fluxo de execução
desse sistema inteligente

![Fluxo do serviço inteligênte](imagens/servicoInteligente.png "Diagrama de tencologias")

**3. Metodologia**

A metodologia contempla as definições de ferramentas utilizadas pela equipe tanto
para a manutenção dos códigos e demais artefatos quanto para a organização do time na
execução das tarefas do projeto.

    3.1. Ambientes de Trabalho

Os artefatos do projeto são desenvolvidos a partir de diversas plataformas e a
relação dos ambientes com seu respectivo propósito é apresentada na tabela que se segue:

| Ambiente           | Plataforma                       | Link de Acesso |
| ------------------ |:--------------------------------:| --------------:|
| Repósitorio        | GitHub                           | https://github.com/icei-pucminas/ti2-cc-gestao-de-estoque-ti-ii |
| Documentação       | Github                           | https://github.com/icei-pucminas/ti2-cc-gestao-de-estoque-ti-ii/tree/master/documentacao |
| Wireframes         | MarvelApp                        | https://marvelapp.com/23j0g346/ |
| Gerenciamento do Projeto| Trello/GitHub Projects      | https://trello.com/b/joigfD6h/ti-2 / https://github.com/icei-pucminas/ti2-cc-gestao-de-estoque-ti-ii/projects |

    3.2. Fluxo de Publicação

Com relação à gestão do código fonte, o grupo utiliza um processo baseado no
GitHub Flow criado pelo próprio GitHub (2011), mostrado na Figura a seguir. Portanto, o
projeto segue a seguinte convenção para o nome de branchs:
- master: versão pronta para implementação (deploy).
- nome-explicativo: versão herdada da master.

Mais informações podem ser encontradas nesse [repositório](https://github.com/Warlord006/Estoque/blob/master/docs/4-Gest%C3%A3o-Configura%C3%A7%C3%A3o.md#controle-de-vers%C3%A3o) e nesse [link](https://guides.github.com/introduction/flow/).

![GitHub Flow](imagens/github_flow.gif)

Seguindo o modelo apresentado acima, a branch master deve estar
sempre pronta para deploy. Portanto, no momento que os pull-requests para a master são
confirmados e assinados, o projeto deve ir ao ar na plataforma escolhida para hospedagem.

    3.3. Gerenciamento do Projeto

A equipe se organiza por meio do manuseamento virtual da ferramenta Kanban
disponibilizada na plataforma Trello e no GitHub Projects. 

Utilizando o metódo Scrum combinado com o Kanban, o grupo foi organizado da seguinte forma:
- Product Owner: Diogo Araujo Miranda
- Scrum Master: João Paolinelli
- Development Team: Danniel Henrique Correa Vieira, Gustavo Martins Lopes da Costa

**4. Modelagem de dados**

A estrutura do banco de dados basea-se basicamente em dados relacionais, em que sua abstração leva 
em conta os requisitos e as histórias de usuário apresentadas nesse artigo. Abaixo é representado
o diagrama de entidade-relacionamento do sistema, que explica a relação entre os dados e suas abstrações.

    4.1. Diagrama de Entidade-Relacionamento

![Diagrama de Entidade Relacionamento](imagens/diagrama_entidade_relacionamento.png "Diagrama de Entidade Relacionamento")

**5. Sistema desenvolvido**

O sistema se encontra em estado de teste. Com objetivo de obter 100% do funcionamento das ferramentas utilizadas, foi adotado pela equipe uma interface estatica para facilitar as interacoes e consultas efetivadas. Na pagina, 162.214.151.86/~ti2/ , o sistema se divide, no momento em 3 fases, contendo um header, um painel lateral esquerdo e uma tela de reproducao dos elementos, centralizada no meio/canto direito.
As seguintes opcoes estao disponiveis, "Registrar" & "Fornecedor", porem ainda nao estao sincronizadas com o atual banco de dados.

**6. Avaliação**

O software é intuitivo. A interação com o menu lateral torna possível visualizar o objetivo do empreendimento e obter resultados imediatos, sendo a expectiva da proposta e conclusão do trabalho uma ferramenta de alto nível que promete atender nosso público-alvo. A interação entre a pagina web e nosso banco de dados ainda está sendo trabalhada, ademais, servidor, estrutura e preparação para integração com o sistema inteligente já está sendo trabalhada.

**7. Conclusão**

Nesse momento, as expectivas são altas. Com o novo método adotado pelo time de, não se preocupar, nesse momento, com a interface externa, o projeto promete uma estrutura robusta de back-end. - João Paolinelli e Silva. 


**REFERÊNCIAS**


**[1.1]** - _ELMASRI, Ramez; NAVATHE, Sham. **Sistemas de banco de dados**. 7. ed. São Paulo: Pearson, c2019. E-book. ISBN 9788543025001._

**[1.2]** - _COPPIN, Ben. **Inteligência artificial**. Rio de Janeiro, RJ: LTC, c2010. E-book. ISBN 978-85-216-2936-8._

**[1.3]** - _CORMEN, Thomas H. et al. **Algoritmos: teoria e prática**. Rio de Janeiro, RJ: Elsevier, Campus, c2012. xvi, 926 p. ISBN 9788535236996._

**[1.4]** - _SUTHERLAND, Jeffrey Victor. **Scrum: a arte de fazer o dobro do trabalho na metade do tempo**. 2. ed. rev. São Paulo, SP: Leya, 2016. 236, [4] p. ISBN 9788544104514._

**[1.5]** - _RUSSELL, Stuart J.; NORVIG, Peter. **Inteligência artificial**. Rio de Janeiro: Elsevier, c2013. xxi, 988 p. ISBN 9788535237016._
