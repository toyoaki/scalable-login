# scalable-login
POC com implementação de um sistema escalável de login e tela de perfil. Este projeto possui apenas a implementação de uma API REST de login e recuperação de perfil que pode ser utilizada por qualquer client que acesse este tipo de API, como por exemplo páginas web e aplicativos mobile.

**Notas**

- Como para a POC não foi implementada a sincronização entre um banco de dados relacional e o cache (Redis), é necessário popular o cache manualmente com dados de teste através do método GET no endpoint:

http://host:port/scalable-login/populate-cache

Ao executar este serviço, é possível se autenticar com os seguintes usuários:

|Usuário|Senha|
|-------|-----|
|toyo   |123  |
|carol  |456  |
|marina |789  |

- Informações de host e porta de um redis externo podem ser fornecidas através das system properties redis.host e redis.port, ou alterando o arquivo data-access.properties dentro do projeto.

**Melhorias**

- Implementar testes unitários, integrados e de desempenho
- Consultar TODOs espalhados no fonte
