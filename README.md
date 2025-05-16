# 🚀 API Credi - Execução via Docker

## 📌 **Descrição**
Este projeto é uma API Spring Boot que utiliza **PostgreSQL** como banco de dados e é executada via Docker. Aqui estão os passos necessários para configurar e rodar a aplicação.

---

## ✅ **Requisitos**
Antes de iniciar, certifique-se de que possui:
- [Docker](https://www.docker.com/get-started) instalado
- [Docker Compose](https://docs.docker.com/compose/install/) instalado
- Java **24+**
- Maven ou Gradle (dependendo do seu gerenciamento de dependências)
- PostgreSQL instalado (caso queira rodar sem Docker)

---

## ⚙ **Configuração do Banco de Dados**
A API usa PostgreSQL e carrega a estrutura do banco a partir do arquivo `init.sql`. No **Docker**, o banco será criado automaticamente.

### 🛠 **Configuração de conexão**
No `application.properties` ou `application.yml`, a conexão está definida como:
```properties
spring.datasource.url=jdbc:postgresql://db:5432/ecommece
spring.datasource.username=credi
spring.datasource.password=Si@010101
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

🔨 Build da aplicação
1️⃣ Gerar o .jar da aplicação
Execute um dos comandos abaixo, dependendo do seu gerenciador de dependências:
✅ Para Maven:
mvn clean package

Para Gradle:
./gradlew build

Isso gerará o arquivo .jar na pasta target/ (Maven) ou build/libs/ (Gradle).

Criar e executar os containers com Docker

1️⃣ Construir a imagem da API
Certifique-se de estar no diretório que contém o Dockerfile e rode:
docker build -t apicredito .


2️⃣ Executar a aplicação via docker-compose
Com o docker-compose.yml configurado corretamente, rode:
docker-compose up --build -d


Isso iniciará os containers da API e do PostgreSQL.
3️⃣ Verificar se os containers estão rodando
Execute:
docker ps


Isso mostrará os containers ativos.

🔄 Atualizar a aplicação sem reconstruir a imagem
Caso precise atualizar apenas o código sem recriar a imagem, copie o novo .jar para dentro do container:
docker cp target/credi-0.0.1-SNAPSHOT.jar api_container:/app/app.jar
docker restart api_container


Isso aplicará a nova versão da aplicação no container.

🎯 Testar a API
Após a execução, acesse a API via navegador ou ferramenta como Postman:
http://localhost:8080





