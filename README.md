# 👥 CustomerConnect

## 📌 Sistema de Gerenciamento de Clientes

O **CustomerConnect** é uma API REST desenvolvida para gerenciar clientes, permitindo operações completas de **CRUD (Create, Read, Update, Delete)**.

O sistema foi projetado seguindo boas práticas de desenvolvimento backend, incluindo **validação de dados, paginação, ordenação e busca flexível**.

---

# 🚀 Funcionalidades

- ✅ Cadastro de clientes  
- ✅ Listagem paginada de clientes  
- ✅ Busca por CPF e/ou Email  
- ✅ Atualização de dados  
- ✅ Remoção de clientes  
- ✅ Ordenação por data de criação  

---

# 🧠 Regras de Negócio

## 📋 Dados Cadastrais

Cada cliente possui os seguintes dados:

| Campo | Descrição |
|------|-----------|
| fullName | Nome completo do cliente |
| cpf | CPF do cliente |
| email | Email do cliente |
| phoneNumber | Telefone celular |
| createdAt | Data de criação do registro |
| updatedAt | Data da última atualização |

---

## 🔐 Cadastro Único

O sistema garante que não existam clientes duplicados com base nos seguintes campos:

- ❗ CPF único  
- ❗ Email único  
- ❗ ID único  

---

## 🔎 Busca Flexível

O sistema permite:

- Buscar clientes por **CPF**
- Buscar clientes por **Email**
- Buscar clientes por **CPF + Email**
- Listar todos os clientes com paginação

---

## 📄 Paginação e Ordenação

A listagem de clientes suporta:

- Paginação (controle de volume de dados)
- Ordenação por **data de criação (`createdAt`)**
- Ordenação crescente ou decrescente

---

# 🌐 Endpoints da API

## 📌 Criar Cliente

**POST /customers**

### 📥 Parâmetros

```json
{
  "fullName": "João Silva",
  "cpf": "12345678900",
  "email": "joao@email.com",
  "phoneNumber": "75999999999"
}

```
📤 Resposta
{
  "customerId": 1
}
