jsonwebservice
==============

Este projeto trabalha a interligaçao de JSON com web service.

Usa a biblioteca Gson do Google para geração de arquivos JSON.

Organização
Pacotes
br.com.maplink2.json.io : models de entrada e saída dos dados JSON
br.com.maplink2.json.repository : repositório que gerencia operações  com JSON
br.com.maplink2.json.webservice: classes de interação web service - Cliente 
br.com.maplink2.json.webservice.consumer: classe main para consumir o webs ervice
br.com.maplink2.json.webservice.repository: repositório que gerencia operações de JSON com o web service


PASTAS

doc : possui o javadoc completo do projeto
lib : blibotecas usadas no projeto
input : pasta referência para arquivo de entrada dos dados JSON
output : pasta referência para arquivo de saida dos dados JSON


Proposito deste projeto:

Ler arquivos ou Url com dados JSON e injeta-los em um webservice, que faz calculos e 
devolve informações que são tranformadas em arquivo de JSON de saída.

Quanto ao Desenvolvedor :

Constitui um aprendizado sobre webservices , conhecimento mais amplo de JSON, e despertou interesse pelo
uso do Jersey Framework e padrão Rest Full
