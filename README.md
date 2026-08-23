# App Lista de Tarefas

<p align="center">
  <strong>Aplicativo Android para organização e gerenciamento de tarefas</strong>
</p>

<p align="center">
  Projeto acadêmico — Módulo 5
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-green" alt="Android">
  <img src="https://img.shields.io/badge/Language-Kotlin-purple" alt="Kotlin">
  <img src="https://img.shields.io/badge/IDE-Android%20Studio-blue" alt="Android Studio">
  <img src="https://img.shields.io/badge/Modulo-5-orange" alt="Modulo 5">
</p>

---

## Sobre o Projeto

O **App Lista de Tarefas** é um aplicativo móvel desenvolvido para a plataforma Android com o objetivo de ajudar os usuários a organizar e acompanhar suas atividades do dia a dia de maneira simples, prática e intuitiva.

O aplicativo permite criar tarefas, adicionar informações importantes, definir prioridades, acompanhar o status de conclusão e gerenciar as tarefas cadastradas em um único lugar.

> **Objetivo:** desenvolver uma solução móvel simples e funcional para melhorar a organização das tarefas pessoais e acadêmicas.

---

## Declaração do Problema

No dia a dia, muitas pessoas precisam administrar diversas atividades e podem esquecer tarefas, perder prazos ou ter dificuldade para acompanhar o que já foi realizado.

Anotações em papel ou informações distribuídas em diferentes locais podem tornar esse processo menos eficiente.

O **App Lista de Tarefas** busca solucionar esse problema oferecendo uma ferramenta centralizada para registrar, organizar e acompanhar tarefas diretamente pelo dispositivo móvel.

---

## Funcionalidades

O aplicativo possui as seguintes funcionalidades:

- ✅ Criar novas tarefas
- 📝 Adicionar título e descrição
- ⭐ Definir prioridade
- ✔️ Identificar tarefas concluídas e pendentes
- 📋 Visualizar a lista de tarefas
- 📄 Visualizar os detalhes de uma tarefa
- 🗑️ Excluir tarefas
- 💾 Armazenar informações localmente
- 🔄 Recuperar informações armazenadas
- 📱 Navegar entre diferentes telas do aplicativo

---

## Tecnologias Utilizadas

| Tecnologia | Utilização |
|---|---|
| **Kotlin** | Linguagem de programação |
| **Android Studio** | Ambiente de desenvolvimento |
| **Android SDK** | Desenvolvimento da aplicação |
| **XML** | Construção das interfaces |
| **SharedPreferences** | Persistência local de dados |
| **Intent** | Navegação entre telas e passagem de dados |
| **Git** | Controle de versão |
| **GitHub** | Hospedagem e documentação do projeto |

---

## Plataforma

O aplicativo foi desenvolvido para dispositivos com sistema operacional **Android**, utilizando o **Android Studio** como ambiente de desenvolvimento.

A aplicação utiliza componentes nativos da plataforma Android para criar a interface, controlar a navegação e armazenar informações localmente.

---

## Interface do Usuário

A interface foi desenvolvida com foco em simplicidade, organização e facilidade de utilização.

### Minhas Tarefas

A tela principal apresenta as tarefas cadastradas e permite ao usuário acompanhar quais atividades estão pendentes ou concluídas.

**Principais elementos:**

- Lista de tarefas
- Status de conclusão
- Informações da tarefa
- Botão para adicionar uma nova tarefa

---

### Nova Tarefa

A tela **Nova Tarefa** permite que o usuário cadastre uma nova atividade.

O usuário pode informar:

- Título
- Descrição
- Prioridade

Após o preenchimento das informações, a tarefa pode ser salva e adicionada à lista principal.

---

### Detalhes da Tarefa

A tela de detalhes permite visualizar as informações completas de uma tarefa cadastrada.

O usuário pode consultar:

- Título
- Descrição
- Prioridade
- Status da tarefa

Também é possível realizar ações relacionadas à tarefa, como sua exclusão.

---

## Interface do Administrador

O aplicativo não possui uma interface administrativa separada ou um painel web.

O projeto foi desenvolvido como uma aplicação pessoal de gerenciamento de tarefas. Dessa forma, o usuário final utiliza diretamente as telas do aplicativo, enquanto a manutenção técnica e administrativa do projeto é realizada pelo desenvolvedor por meio do **Android Studio** e do **GitHub**.

---

## Design e Wireframes

O design foi planejado para manter a navegação simples e reduzir a quantidade de etapas necessárias para criar e gerenciar uma tarefa.

### Wireframe — Minhas Tarefas

```text
┌────────────────────────────────┐
│          Minhas Tarefas        │
├────────────────────────────────┤
│ □ Comprar materiais            │
│ ✓ Enviar trabalho              │
│ □ Estudar Android              │
│                                │
│                                │
│                    + Nova      │
│                      Tarefa    │
└────────────────────────────────┘

┌────────────────────────────────┐
│          Nova Tarefa           │
├────────────────────────────────┤
│                                │
│ Título                         │
│ [___________________________]  │
│                                │
│ Descrição                      │
│ [___________________________]  │
│ [___________________________]  │
│                                │
│ Prioridade                     │
│ [___________________________]  │
│                                │
│             [ SALVAR ]         │
│                                │
└────────────────────────────────┘

┌────────────────────────────────┐
│       Detalhes da Tarefa       │
├────────────────────────────────┤
│                                │
│ Título: Estudar Android        │
│                                │
│ Descrição:                     │
│ Revisar o conteúdo do módulo.  │
│                                │
│ Prioridade: Alta               │
│ Status: Pendente               │
│                                │
│           [ EXCLUIR ]          │
│                                │
└────────────────────────────────┘

**Persistência de Dados — Módulo 5**

A persistência de dados é uma parte importante do Módulo 5.

O projeto utiliza **SharedPreferences** e `getSharedPreferences()` como mecanismo de armazenamento local para informações simples do aplicativo.

Essa abordagem permite salvar e recuperar dados diretamente no dispositivo, evitando que as informações sejam perdidas simplesmente quando uma tela ou Activity é encerrada.

---

**Estrutura do Projeto**

A estrutura principal do aplicativo inclui:

```text
app/
│
├── MainActivity.kt
│
├── AddTaskActivity.kt
│
├── TaskDetailActivity.kt
│
└── Tarefa.kt

## **Principais Componentes**

### **MainActivity.kt**

Responsável pela tela principal do aplicativo e pela apresentação da lista de tarefas.

### **AddTaskActivity.kt**

Responsável pela criação e cadastro de novas tarefas.

### **TaskDetailActivity.kt**

Responsável pela visualização das informações e gerenciamento dos detalhes de uma tarefa.

### **Tarefa.kt**

Modelo utilizado para representar uma tarefa.

## **A Tarefa Possui Informações Como:**

```text
Tarefa
├── titulo
├── descricao
├── concluida
└── prioridade

## **Versão | Alterações**

**0.1** — Criação da estrutura inicial do aplicativo e da tela principal

**0.2** — Criação da tela Nova Tarefa e implementação da navegação

**0.3** — Implementação do modelo de tarefa, prioridade, status e detalhes

**0.4** — Implementação/estruturação da persistência local e atualização da documentação

**0.5** — Preparação do projeto e README para a entrega do Módulo 5
