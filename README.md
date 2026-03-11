# 📌 API de Rede Social (Usuário, Postagem e Comentário)

Este projeto foi desenvolvido com o objetivo de **fixar conceitos fundamentais de desenvolvimento backend com Java e Spring Boot**.
A ideia foi praticar **relacionamentos entre entidades, estruturação de API REST, arquitetura em camadas e operações CRUD**.

O projeto simula uma **estrutura básica de rede social**, onde:

* Usuários podem ser cadastrados
* Usuários podem criar postagens
* Usuários podem comentar em postagens

---

# 🚀 Tecnologias utilizadas

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Maven
* Banco de dados relacional
* Postman (para testes da API)

---

# 🧠 Objetivo do projeto

Este projeto foi criado **principalmente para fixar a base do desenvolvimento backend**.

Durante o desenvolvimento foram praticados conceitos importantes como:

* Estrutura de **API REST**
* **CRUD completo**
* **Relacionamentos entre entidades**
* Arquitetura em camadas
* Tratamento de exceções
* Testes de endpoints com Postman

A ideia foi **consolidar os fundamentos antes de avançar para implementações mais complexas**.

---

# 🏗️ Arquitetura do projeto

O projeto segue uma **arquitetura em camadas**, separando responsabilidades.

```
controller
   ↓
service
   ↓
repository
   ↓
entity
```

### Controller

Responsável por receber as requisições HTTP da API.

### Service

Responsável pela lógica de negócio da aplicação.

### Repository

Responsável pela comunicação com o banco de dados usando **Spring Data JPA**.

### Entity

Representação das tabelas do banco de dados.

---

# 📦 Estrutura das entidades

## 👤 Usuário

Representa o usuário da aplicação.

Campos principais:

* id
* nome
* email
* apelido

Um usuário pode ter **várias postagens**.

---

## 📝 Postagem

Representa uma publicação feita por um usuário.

Campos:

* id
* imagem
* local
* menção
* usuario

Relacionamento:

```
Usuario 1 → N Postagens
```

Ou seja, um usuário pode ter várias postagens.

---

## 💬 Comentário

Representa um comentário feito em uma postagem.

Campos:

* id
* frase
* usuario
* postagem

Relacionamentos:

```
Usuario 1 → N Comentarios
Postagem 1 → N Comentarios
```

---

# 🔗 Relacionamentos JPA utilizados

### ManyToOne

Utilizado para relacionar:

* Postagem → Usuário
* Comentário → Usuário
* Comentário → Postagem

Exemplo:

```java
@ManyToOne
@JoinColumn(name = "usuario_id")
private Usuario usuario;
```

---

# 🌐 Endpoints da API

## 👤 Usuários

### Criar usuário

```
POST /usuarios
```

Body exemplo:

```json
{
  "nome": "Jose",
  "email": "jose@email.com",
  "apelido": "zezin"
}
```

---

### Buscar usuário por ID

```
GET /usuarios/{id}
```

---

### Atualizar usuário

```
PUT /usuarios/{id}
```

---

### Deletar usuário

```
DELETE /usuarios/{id}
```

---

# 📝 Postagens

### Criar postagem para um usuário

```
POST /postagem/{usuarioId}/postagem
```

Body:

```json
{
  "imagem": "Cidade movimentada",
  "local": "São Paulo",
  "menção": "@joao"
}
```

---

### Buscar postagens de um usuário

```
GET /postagem/usuarios/{id}/postagem
```

---

### Deletar postagem

```
DELETE /postagem/{id}
```

---

# 💬 Comentários

### Criar comentário em uma postagem

```
POST /comentarios/usuarios/{usuarioId}/postagem/{postagemId}/comentarios
```

Body:

```json
{
  "frase": "Muito boa essa postagem!"
}
```

---

### Buscar comentários de uma postagem

```
GET /comentarios/postagem/{postagemId}/comentarios
```

---

### Deletar comentário

```
DELETE /comentarios/{id}
```

---

# 🧪 Como testar a API

A API pode ser testada utilizando ferramentas como **Postman** ou **Insomnia**.

### 1️⃣ Criar um usuário

```
POST http://localhost:8080/usuarios
```

Body:

```json
{
  "nome": "Jose",
  "email": "jose@email.com",
  "apelido": "zezin"
}
```

---

### 2️⃣ Criar uma postagem para o usuário

```
POST http://localhost:8080/postagem/1/postagem
```

Body:

```json
{
  "imagem": "Cidade movimentada",
  "local": "São Paulo",
  "menção": "@joao"
}
```

---

### 3️⃣ Criar um comentário em uma postagem

```
POST http://localhost:8080/comentarios/usuarios/1/postagem/1/comentarios
```

Body:

```json
{
  "frase": "Muito boa essa postagem!"
}
```

---

### 4️⃣ Buscar comentários da postagem

```
GET http://localhost:8080/comentarios/postagem/1/comentarios
```

---

### 5️⃣ Deletar comentário

```
DELETE http://localhost:8080/comentarios/1
```

---

### 6️⃣ Deletar postagem

```
DELETE http://localhost:8080/postagem/1
```

---

# ⚠️ Sobre o uso de DTO

Durante o desenvolvimento foi criada uma estrutura para **DTO (Data Transfer Object)** com o objetivo de **manter uma arquitetura organizada e preparada para projetos maiores**.

Porém, neste projeto específico, os DTOs **não foram utilizados diretamente nas respostas da API**, pois o foco principal era **fixar os conceitos fundamentais de relacionamento entre entidades e operações CRUD**.

Em projetos maiores, os DTOs são importantes para:

* controlar dados expostos pela API
* evitar problemas de serialização
* desacoplar entidade do retorno da API

---

# 📚 Conceitos praticados

Este projeto foi utilizado para fixar conhecimentos importantes como:

* API REST
* CRUD
* Relacionamentos JPA
* Arquitetura em camadas
* Spring Boot
* Spring Data JPA
* Tratamento de exceções
* Testes com Postman

---

# 👨‍💻 Autor

Projeto desenvolvido por **Gustavo Gonzaga**
com o objetivo de **consolidar conhecimentos em desenvolvimento backend com Java e Spring Boot**.

---

