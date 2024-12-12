# Projeto: API Java Spring Boot com Front-end HTML, CSS e JavaScript
### **Equipe**

* Alváro felix - Product Owner
* Jennifer - Scrum master
* Dhiego Emmanuel - Back-end
* Lucas Santos - Back end
* Gabriel Coelho - FullStack
* João Pedro - Front-end
* Marcelo - Front-end
* Ryan - Desing
* Thalita - Desing
* Marco - Teste


### **Descrição**
O projeto funciona como um mini sistema de RH, onde é capaz de registrar novos usuários com bases em seus cargos na empresa, login para acesso as suas tarefas e responsabilidades, após feito login acessa uma área de tarefas onde quem tem autorização pode realizar as operações de CRUD, criando, lendo, deletando ou atualizando as tarefas. Para concluir o projeto, foi utilizada o framework Scrum para servir como ferramenta para o gerenciamento do projeto e sua conclusão.
Este projeto consiste em uma API RESTful desenvolvida em Java utilizando o framework Spring Boot. A API oferece funcionalidades de:

* **Autenticação:**
    * Registro de novos usuários.
    * Login de usuários existentes.
    * Validação de credenciais de login.
* **Gerenciamento de Tarefas:**
    * Criação de novas tarefas.
    * Listagem de todas as tarefas.
    * Atualização de tarefas existentes.
    * Deleção de tarefas.

O front-end da aplicação foi desenvolvido utilizando HTML, CSS e JavaScript, proporcionando uma interface simples e intuitiva para interagir com a API.

### **Tecnologias Utilizadas**

* **Back-end:** Java, Spring Boot
* **Front-end:** HTML, CSS, JavaScript
* **Banco de dados:** MySQL

### **Endpoints da API**

* **Autenticação:**
    * POST /register: Registra um novo usuário.
    * POST /login: Realiza o login de um usuário.
* **Gerenciamento de Tarefas:**
    * POST /tasks: Cria uma nova tarefa.
    * GET /tasks: Lista todas as tarefas.
    * PUT /tasks/{id}: Atualiza uma tarefa específica.
    * DELETE /tasks/{id}: Deleta uma tarefa específica.

### **Metodologia**

O desenvolvimento deste projeto foi conduzido utilizando a metodologia **Scrum**. Através de sprints, foram definidas as funcionalidades a serem implementadas em cada iteração, permitindo um desenvolvimento ágil e adaptativo.
