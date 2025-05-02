📝 Backend do Sistema de Almoxarifado
<div align="center">
Status: Em Desenvolvimento
Versão: 0.1.0
Tecnologias

</div>
🚀 Visão Geral
Backend do sistema de gerenciamento de almoxarifado desenvolvido com Java Spring Boot e banco de dados H2.
Atenção: Este projeto está em fase ativa de desenvolvimento!

🛠 Funcionalidades Implementadas
Ícone	Funcionalidade	Status
🗃️	CRUD de itens	✅ Completo
🔍	Busca por ID	✅ Completo
📊	Paginação de resultados	🚧 Em andamento
🔒	Autenticação básica	❌ Pendente
⚙️ Tecnologias Utilizadas
Tecnologia	Descrição	Versão
Java	Linguagem principal	17+
Spring Boot	Framework backend	3.x
H2	Banco em memória	2.1+
JPA	Persistência de dados	-
Lombok	Redução de boilerplate	1.18+
🏗️ Estrutura do Projeto
src/
├── main/
│   ├── java/
│   │   └── com/almoxarifado/
│   │       ├── config/       # Configurações
│   │       ├── controller/   # Endpoints REST
│   │       ├── model/        # Entidades JPA
│   │       ├── repository/   # Interfaces DAO
│   │       ├── service/      # Lógica de negócio
│   │       └── Application.java
│   └── resources/
│       ├── application.yml   # Configurações
│       └── data.sql          # Dados iniciais
