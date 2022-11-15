# Daily Menu - 🚧 Em construção 🚧

[English Version](README.en.md)

**Licença**

[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://github.com/tterb/atomic-design-ui/blob/master/LICENSEs)

### _**O que é?**_

- Daily Menu é/será uma aplicação web para cadastro de produtos e organização da sua rotina alimentar. Os principais objetivos do sistema são:

**- Antes da autenticação no sistema permitir que o usuário:**

    - Cadastre usuários no sistema
    - Autenticar/autorizar seu usuário através de JWT (fazer login)

**- Após autenticação no sistema permitir que o usuário:**

    - Cadastre produtos
    - Crie uma lista de compras de supermercado
    - Crie um cardápio para sua rotina alimentar

### _**Principais ferramentas utilizadas:**_

- **Backend:** Java 11 com Spring Boot
- **Banco de dados:** MySQL 8.0.31
- **Gerenciamento de projeto:** Maven
- **Versionamento de banco de dados:** Flyway _(aprenda mais sobre [aqui](https://flywaydb.org/documentation/usage/commandline/migrate))_
- **Documentação de API**: Swagger _(aprenda mais sobre [aqui](https://petstore.swagger.io/))_

---

### **Passo a passo para colaborar com o Daily Menu**

Existem duas formas para você iniciar sua colaboração:

1 - [**AQUI**](https://github.com/evandroafonso/daily-menu-backend/issues) você encontrará todas as issues que precisam de atenção.

2 - Encontrou um bug, um erro na aplicação ou quer criar uma nova funcionalidade? CRIE uma issue [**AQUI**](https://github.com/evandroafonso/daily-menu-backend/issues).

**REGRA BÁSICA**: Nunca inicie o desenvolvimento de qualquer coisa sem ter uma tarefa vinculada e mantenha o foco no escopo da tarefa!

## **Encontrei a issue perfeita para trabalhar, mas como começar?**

**Siga os passos abaixo para configurar seu ambiente:** (Caso já tenha configurado, pule para o próximo tópico)

1. clone o projeto [Daily Menu](https://github.com/evandroafonso/daily-menu-backend) em sua máquina. (aprenda [aqui](https://github.com/evandroafonso/daily-menu-backend))
2. para baixar as dependencias e compilar localmente o projeto, rode o comando abaixo na pasta raiz do projeto:

```bash
mvn clean compile
```

3. para rodar o projeto você precisará ter alguns programas instalados em sua máquina, são eles:
   - [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
   - [Spring Tools Suite - STS](https://spring.io/tools) (ou qualquer outra que você prefira)
   - [MySQL versão 8.0.31](https://dev.mysql.com/downloads/mysql/) - para desenvolvimento local eu utilizo o editor [DBeaver](https://dbeaver.io/), mas fique a vontade para usar o que preferir.
     Aqui é importante criar um usuário para o banco de dados local e guardar essas credenciais para que você possa utiliza-las no próximo passo.
4. será necessário configurar as variáveis de ambiente do seu projeto local para que seja possível a conexão com o banco de dados, login com JWT e demais configurações. Essas variáveis estão declaradas no arquivo _**application.properties**_ do projeto. Caso tenha dúvidas como criar variáveis de ambiente para o projeto, você pode [aprender mais com esse vídeo a partir de 08:45](https://www.youtube.com/watch?v=sXrZNGWVHVA)
5. para criar as tabelas em seu banco de dados local e atualiza-las conforme o "ambiente de produção" será necessário rodar o comando do **WildFly**. Esse comando criará todas as tabelas e atualizações do banco de dados que existe até o momento. Entre na pasta raiz do projeto, abra o terminal e rode o comando abaixo:

```bash
mvn flyway:migrate
```

### **fluxo de desenvolvimento**

Seu ambiente de desenvolvimento já está configurado e já definiu em qual tarefa você irá trabalhar? Então siga os passos abaixo:

aqui utilizaremos branchs de desenvolvimento, caso não saiba o que é isso, aprenda mais [aqui](https://medium.com/reprogramabr/entendendo-sobre-branch-e-pull-request-516aea4e364f)

    ciclo de desenvolvimento: branch local -> pull request -> aprovação pull request -> main

1. na [issue](https://github.com/evandroafonso/daily-menu-backend/issues) que você irá trabalhar, na sessão **development**, clique em _Create a branch_ e no modal que abrir, adicione/edite o nome da branch e clique em _Create branch_
2. na pasta raiz do projeto, abra um terminal e altere a branch conforme a que você criou, por exemplo:

```bash
git checkout branch-que-voce-criou
```

e execute um git pull para garantir que todas as alterações estarão em sua máquina:

```bash
git pull
```

3. após o desenvolvimento, crie o commit

```bash
git push
```

4. crie o pull request e aguarde a revisão!

---
