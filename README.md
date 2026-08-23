App Lista de Tarefas

Rascunho do Projeto — Módulo 5

Projeto: App Lista de Tarefas
Plataforma: Android
Repositório: https://github.com/amandavlima/app-lista-tarefas-android

1. Descrição do projeto

O App Lista de Tarefas é um aplicativo móvel Android desenvolvido para ajudar o usuário a organizar atividades do dia a dia de maneira simples e objetiva. O aplicativo permite criar tarefas, visualizar informações, identificar tarefas concluídas ou pendentes e excluir tarefas quando necessário.

O projeto foi desenvolvido como atividade acadêmica no curso de Tecnologia da Informação, utilizando o Android Studio.

2. Declaração do problema

Muitas pessoas precisam administrar várias atividades ao mesmo tempo e podem esquecer compromissos ou perder o controle do que já foi realizado. Anotações em papel ou listas dispersas dificultam a organização e a atualização das tarefas.

O problema abordado pelo projeto é a necessidade de uma solução móvel simples, acessível e fácil de usar para registrar e acompanhar tarefas em um único local.

3. Plataforma

Android

Desenvolvimento no Android Studio

Linguagem: Kotlin

Interface baseada em layouts XML

Navegação entre telas com Intent

Uso de componentes Android para interação com o usuário

Persistência local planejada/implementada no Módulo 5 com SharedPreferences, conforme os requisitos da disciplina

4. Interface do usuário

A interface do usuário foi projetada para ser direta e intuitiva.

Tela principal — Minhas Tarefas

A tela principal apresenta:

título do aplicativo;

lista de tarefas;

indicação de tarefas concluídas e pendentes;

botão + Nova Tarefa para criar uma tarefa.

Tela Nova Tarefa

A tela de cadastro permite informar:

título;

descrição;

prioridade.

Após o cadastro, a tarefa pode ser apresentada na lista principal.

Tela de detalhes

A tela de detalhes apresenta as informações da tarefa e permite realizar ações relacionadas à tarefa, incluindo sua exclusão mediante confirmação.

5. Interface do administrador

O aplicativo não possui uma interface administrativa separada, painel web ou servidor. O projeto foi concebido como um aplicativo pessoal de gerenciamento de tarefas.

A manutenção técnica do aplicativo é realizada pelo desenvolvedor por meio do Android Studio e do GitHub. Portanto, a função administrativa está relacionada ao desenvolvimento e manutenção do código, e não a uma área administrativa utilizada pelo usuário final.

6. Funcionalidade

As principais funcionalidades do protótipo são:

Visualizar a lista de tarefas.

Criar uma nova tarefa.

Informar título, descrição e prioridade.

Identificar tarefas concluídas e pendentes.

Abrir informações da tarefa.

Excluir uma tarefa com confirmação.

Navegar entre as telas utilizando Intent.

Armazenar/recuperar dados localmente conforme a estratégia de persistência do Módulo 5.

7. Estrutura principal do aplicativo

MainActivity.kt — tela principal e acesso à lista de tarefas.

AddTaskActivity.kt — tela de criação de novas tarefas.

TaskDetailActivity.kt — visualização dos detalhes e ações da tarefa.

Tarefa — modelo de dados utilizado para representar uma tarefa.

Exemplo conceitual do modelo:

Tarefa
├── titulo
├── descricao
├── concluida
└── prioridade

8. Persistência de dados — Módulo 5

O Módulo 5 introduz a persistência de dados em aplicativos Android. Para informações simples relacionadas às tarefas, a solução considerada para este projeto é o SharedPreferences, permitindo salvar e recuperar dados localmente no dispositivo.

A abordagem também utiliza getSharedPreferences() para acessar o armazenamento local do aplicativo.

O objetivo é evitar que os dados desapareçam simplesmente quando a Activity é encerrada ou quando o usuário retorna à tela principal.

9. Design / Wireframes

Wireframe 1 — Tela principal

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

Wireframe 2 — Nova tarefa

┌────────────────────────────────┐
│          Nova Tarefa           │
├────────────────────────────────┤
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
│             [ Salvar ]         │
└────────────────────────────────┘

Wireframe 3 — Detalhes

┌────────────────────────────────┐
│        Detalhes da Tarefa      │
├────────────────────────────────┤
│ Título: Estudar Android        │
│                                │
│ Descrição:                     │
│ Revisar o conteúdo do módulo.  │
│                                │
│ Prioridade: Alta               │
│ Status: Pendente               │
│                                │
│           [ Excluir ]          │
└────────────────────────────────┘

10. Objetivo do produto

O objetivo é oferecer uma ferramenta pequena, clara e funcional para gerenciamento de tarefas, priorizando facilidade de uso e organização.

11. Evolução do projeto

O projeto foi construído progressivamente, partindo da tela principal e da navegação para a criação de tarefas e, posteriormente, para detalhes, exclusão e persistência dos dados.

O GitHub é utilizado para versionamento e documentação do desenvolvimento.

12. Registro de alterações

Versão 0.1 — Estrutura inicial

Criação do projeto Android.

Criação da tela principal.

Criação da tela Nova Tarefa.

Versão 0.2 — Navegação

Implementação da navegação entre Activities.

Uso de Intent e Intent Extras.

Versão 0.3 — Gerenciamento de tarefas

Inclusão do modelo Tarefa.

Exibição de tarefas.

Controle de concluída/pendente.

Inclusão de prioridade.

Tela de detalhes.

Exclusão com confirmação.

Versão 0.4 — Módulo 5

Preparação da persistência local.

Uso de SharedPreferences/getSharedPreferences() como abordagem de armazenamento simples.

Atualização da documentação no README.

13. Conclusão

O App Lista de Tarefas atende ao objetivo de criar uma solução Android simples para organização pessoal. O projeto demonstra conceitos de interface, navegação entre Activities, passagem de dados, gerenciamento de tarefas e persistência local, além do uso do GitHub para versionamento e documentação.
