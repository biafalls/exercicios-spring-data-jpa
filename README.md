<div align="center">

# ☕ Java: Persistência de Dados e Consultas com Spring Data JPA

### Persistindo dados com PostgreSQL utilizando Spring Boot, Spring Data JPA e Hibernate

Exercícios desenvolvidos durante os estudos de **Persistência de Dados com Spring Data JPA**, abordando desde a configuração do banco de dados até consultas avançadas utilizando JPQL, Derived Queries e integração com APIs externas.

---

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-6DB33F?style=for-the-badge&logo=springboot)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven)
![Curso](https://img.shields.io/badge/ALURA-CURSO-05122A?style=for-the-badge)

</div>

---

# 📖 Sobre o Projeto

Este repositório reúne os principais conceitos aprendidos durante o curso de **Persistência de Dados e Consultas com Spring Data JPA**.

O objetivo foi compreender como aplicações Java realizam a persistência de dados utilizando bancos relacionais, explorando a abstração fornecida pela **Java Persistence API (JPA)** e sua implementação mais popular, o **Hibernate**.

Além da implementação prática, este material busca funcionar como um **guia de consultas futuras**, contendo explicações detalhadas sobre cada conceito estudado, exemplos comentados e boas práticas.

---

- [💾 1. Persistência de Dados](#-1-persistência-de-dados)
- [⚙️ 2. Configurando o Ambiente](#️-2-configurando-o-ambiente)
- [🔐 3. Variáveis de Ambiente](#-3-variáveis-de-ambiente)
- [☕ 4. JDBC, JPA, Hibernate e ORM](#-4-jdbc-jpa-hibernate-e-orm)
- [🗂️ 5. Mapeamento de Entidades](#️-5-mapeamento-de-entidades)
- [🔗 6. Relacionamentos](#-6-relacionamentos)
- [🌱 7. Spring IoC e Injeção de Dependência](#-7-spring-ioc-e-injeção-de-dependência)
- [📦 8. Repositories](#-8-repositories)
- [🔍 9. Derived Queries](#-9-derived-queries)
- [📝 10. Consultas Personalizadas](#-10-consultas-personalizadas)
- [🏷️ 11. Enum](#️-11-enum)
- [🤖 12. Integração com a API do ChatGPT](#-12-integração-com-a-api-do-chatgpt)
  
---
## 💾 1. Persistência de Dados

### O que é Persistência de Dados?

Persistência de dados é a capacidade de armazenar informações de forma permanente, permitindo que elas continuem disponíveis mesmo após o encerramento da aplicação.

Em uma aplicação Java, por exemplo, os objetos são armazenados na memória apenas durante a execução do programa. Ao finalizar a aplicação, esses dados são perdidos. Para evitar isso, utilizamos bancos de dados, que permitem salvar e recuperar informações sempre que necessário.

Esse processo de comunicação entre a aplicação e o banco de dados é chamado de **persistência de dados**.

### Bancos de Dados Relacionais (RDBMS)

Os bancos de dados relacionais (**Relational Database Management System**) organizam as informações em **tabelas**, compostas por linhas (registros) e colunas (atributos).

Cada tabela representa uma entidade da aplicação e pode possuir relacionamentos com outras tabelas através de chaves primárias (**Primary Key**) e chaves estrangeiras (**Foreign Key**).

São ideais para aplicações que necessitam de consistência, integridade e relacionamentos bem definidos entre os dados.

**Exemplos:**

- PostgreSQL
- MySQL
- Oracle Database
- SQL Server

### Bancos de Dados Não Relacionais (NoSQL)

Os bancos de dados **NoSQL** (**Not Only SQL**) foram desenvolvidos para lidar com grandes volumes de dados e estruturas mais flexíveis.

Diferentemente dos bancos relacionais, eles não dependem exclusivamente de tabelas e podem armazenar informações em diferentes formatos, como documentos, chave-valor, grafos ou colunas.

São bastante utilizados em aplicações distribuídas, Big Data e sistemas que precisam escalar rapidamente.

### Bancos Orientados a Documentos

Os bancos orientados a documentos são um dos principais tipos de bancos NoSQL.

Nesse modelo, os dados são armazenados em **documentos** (geralmente no formato JSON ou BSON), permitindo estruturas mais flexíveis do que tabelas tradicionais.

Um documento pode conter objetos, listas e outros documentos aninhados, reduzindo a necessidade de diversos relacionamentos.

**Exemplos:**

- MongoDB
- CouchDB
- Firebase Firestore

### Quando utilizar cada um?

| Banco Relacional (RDBMS) | Banco Não Relacional (NoSQL) |
|---------------------------|------------------------------|
| Dados altamente estruturados | Dados com estrutura variável |
| Possui relacionamentos complexos | Poucos ou nenhum relacionamento |
| Necessita de consistência e integridade | Necessita de alta escalabilidade |
| Utiliza SQL | Pode utilizar outros modelos de consulta |
| Ex.: Sistemas bancários, ERP, e-commerce | Ex.: Redes sociais, chat, Big Data, IoT |

> **Neste curso foi utilizado o PostgreSQL**, um dos bancos de dados relacionais mais populares e amplamente utilizado em aplicações Java com Spring Boot.

---

# ⚙️ 2. Configurando o Ambiente

Antes de iniciar o desenvolvimento da aplicação, é necessário configurar o banco de dados que será utilizado pelo Spring Boot.

Neste projeto foi utilizado o **PostgreSQL**, juntamente com o **Spring Data JPA**, responsável pela comunicação entre a aplicação e o banco.

### PostgreSQL

O PostgreSQL é um Sistema Gerenciador de Banco de Dados Relacional (SGBD) gratuito, open source e bastante utilizado em aplicações corporativas.

Durante sua instalação alguns pontos merecem atenção:

- A porta padrão utilizada é **5432**;
- É necessário definir uma senha para o usuário padrão (`postgres`);
- O **Stack Builder** é opcional e pode ser desmarcado durante a instalação;
- O **pgAdmin** é instalado junto com o PostgreSQL e oferece uma interface gráfica para gerenciamento do banco.

### pgAdmin

O **pgAdmin** é a interface gráfica oficial do PostgreSQL.

Com ele é possível:

- criar bancos de dados;
- executar comandos SQL;
- visualizar tabelas;
- editar registros;
- administrar usuários e permissões.

### PSQL

O **PSQL** é o terminal oficial do PostgreSQL.

Ele permite executar comandos SQL diretamente pelo prompt de comando, sendo bastante utilizado para administração e testes rápidos.

### Dependências do Projeto

Para que o Spring Boot consiga se comunicar com o PostgreSQL, foram adicionadas duas dependências ao arquivo `pom.xml`.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
```

- **Spring Data JPA:** fornece toda a camada de persistência da aplicação.
- **PostgreSQL Driver:** permite que a aplicação estabeleça conexão com o banco de dados.

### Configurando o `application.properties`

O Spring Boot utiliza o arquivo `application.properties` para armazenar as configurações da aplicação.

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=postgres
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

| Propriedade | Função |
|-------------|--------|
| `spring.datasource.url` | Endereço de conexão com o banco de dados. |
| `spring.datasource.username` | Usuário utilizado para acessar o banco. |
| `spring.datasource.password` | Senha do usuário do banco. |
| `spring.jpa.hibernate.ddl-auto` | Define como o Hibernate tratará a criação e atualização das tabelas. |
| `spring.jpa.show-sql` | Exibe no console os comandos SQL executados pela aplicação. |
| `spring.jpa.properties.hibernate.format_sql` | Formata os comandos SQL para facilitar a leitura durante o desenvolvimento. |

---

# 🔐 3. Variáveis de Ambiente

### O que são?

Variáveis de ambiente são valores armazenados no sistema operacional que podem ser acessados pela aplicação durante sua execução.

Elas são frequentemente utilizadas para armazenar informações sensíveis, como senhas, tokens de autenticação e chaves de API.

### Por que utilizar?

Armazenar informações confidenciais diretamente no código ou no repositório Git representa um risco de segurança.

Ao utilizar variáveis de ambiente, esses dados permanecem protegidos no sistema operacional e podem ser alterados sem modificar o código da aplicação.

### Como criar?

Cada sistema operacional possui sua própria forma de criar variáveis de ambiente.

Após criadas, elas ficam disponíveis para qualquer aplicação executada pelo usuário.

### Como acessar?

No Java, uma variável de ambiente pode ser obtida através do método:

```java
System.getenv("DB_PASSWORD");
```

No Spring Boot, também é possível utilizá-las diretamente no arquivo `application.properties`:

```properties
spring.datasource.password=${DB_PASSWORD}
```

Essa abordagem evita que senhas e outras informações sensíveis sejam armazenadas no código-fonte.

---

# ☕ 4. JDBC, JPA, Hibernate e ORM

Durante o desenvolvimento de aplicações Java, diversas tecnologias trabalham em conjunto para realizar a comunicação com o banco de dados.

O fluxo dessa comunicação pode ser representado da seguinte forma:

```text
Java
  │
  ▼
JDBC
  │
  ▼
JPA
  │
  ▼
Hibernate
  │
  ▼
Banco de Dados
```

### JDBC (Java Database Connectivity)

O **JDBC** é a API padrão do Java para acesso a bancos de dados relacionais.

Ele fornece classes e interfaces responsáveis por abrir conexões, executar comandos SQL e recuperar os resultados das consultas.

Apesar de ser bastante poderoso, exige que o desenvolvedor escreva manualmente grande parte do código responsável pela persistência.

### ORM (Object Relational Mapping)

ORM (**Mapeamento Objeto-Relacional**) é uma técnica que permite converter automaticamente objetos Java em registros de tabelas do banco de dados, e vice-versa.

Dessa forma, o desenvolvedor trabalha principalmente com objetos da aplicação, enquanto o framework se encarrega de gerar os comandos SQL necessários.

### JPA (Java Persistence API)

A **JPA** é uma especificação do Java que define um padrão para persistência de dados utilizando ORM.

Ela estabelece um conjunto de interfaces, anotações e regras para mapear classes Java em tabelas do banco de dados, independentemente da implementação utilizada.

### Hibernate

O **Hibernate** é uma das implementações mais populares da JPA.

Ele é responsável por interpretar as anotações presentes nas entidades, gerar consultas SQL automaticamente e realizar a comunicação entre a aplicação e o banco de dados.

No Spring Boot, o Hibernate é utilizado de forma transparente por meio do Spring Data JPA.

### EntityManager

O **EntityManager** é a principal interface da JPA responsável por gerenciar o ciclo de vida das entidades.

Operações como salvar, atualizar, remover e consultar objetos passam por ele.

Embora o Spring Data JPA utilize o `EntityManager` internamente, na maioria dos projetos o desenvolvedor interage diretamente com os **Repositories**, que simplificam essas operações.

# 🗂️ 5. Mapeamento de Entidades

Para que o Hibernate consiga converter objetos Java em registros do banco de dados, é necessário mapear as classes da aplicação utilizando anotações da JPA.

Essas anotações informam como cada classe e atributo será representado nas tabelas do banco.

## `@Entity`

Indica que uma classe representa uma entidade persistente e deve ser mapeada para uma tabela no banco de dados.

Sem essa anotação, a JPA ignora completamente a classe.

**Exemplo:**

```java
@Entity
public class Produto {

}
```

---

## `@Table`

Permite personalizar a tabela associada à entidade.

Caso não seja utilizada, o Hibernate utiliza, por padrão, o nome da classe como nome da tabela.

**Principais atributos**

- `name` → nome da tabela.

**Exemplo:**

```java
@Entity
@Table(name = "produtos")
public class Produto {

}
```

---

## `@Id`

Define qual atributo será utilizado como chave primária (**Primary Key**) da tabela.

Toda entidade deve possuir um identificador único.

**Exemplo:**

```java
@Id
private Long id;
```

---

## `@GeneratedValue`

Indica que o valor da chave primária será gerado automaticamente.

A estratégia de geração pode variar conforme o banco de dados utilizado.

**Principais estratégias**

| Estratégia | Descrição |
|------------|-----------|
| `AUTO` | O Hibernate escolhe automaticamente a melhor estratégia. |
| `IDENTITY` | O banco gera o identificador utilizando auto incremento. |
| `SEQUENCE` | Utiliza uma sequência do banco de dados para gerar os IDs. |
| `TABLE` | Utiliza uma tabela específica para controlar os identificadores. |

**Exemplo:**

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

> Neste curso foi utilizada principalmente a estratégia `IDENTITY`, bastante comum no PostgreSQL.

---

## `@Column`

Permite personalizar o mapeamento de um atributo para uma coluna da tabela.

Quando omitida, a JPA utiliza o nome do atributo como nome da coluna.

**Principais atributos**

- `name`
- `nullable`
- `unique`
- `length`

**Exemplo:**

```java
@Column(name = "titulo", nullable = false, length = 100)
private String titulo;
```

---

## `@Transient`

Indica que um atributo **não deve ser persistido** no banco de dados.

É útil para informações calculadas durante a execução da aplicação.

**Exemplo:**

```java
@Transient
private Integer quantidadeEmEstoque;
```

Nesse caso, o atributo existirá apenas em memória e não será criado como coluna na tabela.

---

## `@Enumerated`

Utilizada para mapear atributos do tipo **Enum**.

A forma de armazenamento pode ser definida através do `EnumType`.

| Tipo | Funcionamento |
|-------|---------------|
| `STRING` | Armazena o nome da constante do Enum. |
| `ORDINAL` | Armazena a posição (índice) do Enum. |

**Exemplo:**

```java
@Enumerated(EnumType.STRING)
private Categoria categoria;
```

> A estratégia `STRING` é a mais recomendada, pois evita inconsistências caso novos valores sejam adicionados ao Enum.

---

## `@Embeddable`

Define uma classe cujos atributos podem ser incorporados em outra entidade.

Ela **não gera uma tabela própria**, apenas adiciona suas colunas na tabela da entidade principal.

**Exemplo:**

```java
@Embeddable
public class Endereco {

    private String rua;
    private String cidade;
}
```

---

## `@Embedded`

Utilizada dentro de uma entidade para incorporar uma classe marcada com `@Embeddable`.

**Exemplo:**

```java
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Endereco endereco;
}
```

Nesse exemplo, os campos de `Endereco` serão adicionados diretamente à tabela `cliente`.

---

# 🔗 6. Relacionamentos

Em bancos de dados relacionais, é comum que diferentes entidades possuam vínculos entre si.

A JPA permite representar esses relacionamentos utilizando anotações específicas, facilitando a navegação entre os objetos da aplicação.

## `@OneToMany`

Representa um relacionamento **um para muitos**.

Uma entidade pode estar associada a várias instâncias de outra entidade.

**Exemplo:**

Um artista pode possuir vários álbuns.

```java
@OneToMany(mappedBy = "artista")
private List<Album> albuns;
```

---

## `@ManyToOne`

Representa o lado oposto do relacionamento.

Várias entidades podem estar associadas a uma única entidade principal.

**Exemplo:**

Vários álbuns pertencem ao mesmo artista.

```java
@ManyToOne
@JoinColumn(name = "artista_id")
private Artista artista;
```

---

## `@ManyToMany`

Representa um relacionamento em que ambas as entidades podem possuir diversas associações entre si.

Normalmente é criada uma tabela intermediária para armazenar essas relações.

**Exemplo:**

Uma playlist possui várias músicas e uma música pode estar presente em diversas playlists.

```java
@ManyToMany
private List<Musica> musicas;
```

---

## `@JoinColumn`

Define qual coluna será utilizada como chave estrangeira no relacionamento.

É normalmente utilizada em relacionamentos `@ManyToOne` e `@OneToOne`.

**Exemplo:**

```java
@ManyToOne
@JoinColumn(name = "categoria_id")
private Categoria categoria;
```

---

## `@JoinTable`

Permite configurar a tabela intermediária utilizada em relacionamentos `@ManyToMany`.

É possível definir seu nome e as colunas responsáveis pela ligação entre as entidades.

**Exemplo:**

```java
@ManyToMany
@JoinTable(
    name = "playlist_musica"
)
private List<Musica> musicas;
```

---

## `mappedBy`

O atributo `mappedBy` informa qual entidade é responsável pelo relacionamento.

Seu objetivo é evitar que o Hibernate crie duas chaves estrangeiras ou duas tabelas de relacionamento desnecessariamente.

**Exemplo:**

```java
@OneToMany(mappedBy = "artista")
private List<Album> albuns;
```

Nesse exemplo, o relacionamento é controlado pelo atributo `artista` presente na classe `Album`.

---

## Cascade

O **Cascade** define quais operações realizadas em uma entidade devem ser propagadas para as entidades relacionadas.

As principais opções são:

| Tipo | Função |
|-------|--------|
| `PERSIST` | Salva automaticamente as entidades relacionadas. |
| `MERGE` | Atualiza também as entidades relacionadas. |
| `REMOVE` | Remove as entidades relacionadas. |
| `REFRESH` | Atualiza os dados da entidade a partir do banco. |
| `DETACH` | Remove as entidades do contexto de persistência. |
| `ALL` | Aplica todas as operações anteriores. |

**Exemplo:**

```java
@OneToMany(
    mappedBy = "artista",
    cascade = CascadeType.ALL
)
private List<Album> albuns;
```

---

## FetchType.LAZY

Os dados relacionados são carregados **somente quando forem acessados**.

Essa estratégia melhora o desempenho da aplicação ao evitar consultas desnecessárias.

```java
@OneToMany(fetch = FetchType.LAZY)
private List<Album> albuns;
```

---

## FetchType.EAGER

Os dados relacionados são carregados automaticamente junto com a entidade principal.

Embora facilite o acesso às informações, pode gerar consultas maiores e impactar o desempenho quando utilizado em excesso.

```java
@ManyToOne(fetch = FetchType.EAGER)
private Artista artista;
```

> De forma geral, recomenda-se utilizar `LAZY` sempre que possível e recorrer ao `EAGER` apenas quando o carregamento imediato realmente for necessário.

---

# 🌱 7. Spring IoC e Injeção de Dependência

Um dos principais recursos do Spring Framework é seu gerenciamento automático de objetos, tornando o código mais organizado, reutilizável e desacoplado.

## IoC (Inversion of Control)

A **Inversão de Controle (IoC)** é um princípio no qual a responsabilidade de criar e gerenciar os objetos deixa de ser da aplicação e passa para o **Container do Spring**.

Em vez de instanciar classes manualmente com `new`, o Spring cria, configura e disponibiliza esses objetos quando necessário.

---

## DI (Dependency Injection)

A **Injeção de Dependência (Dependency Injection)** é o mecanismo utilizado pelo Spring para fornecer automaticamente os objetos de que uma classe necessita.

Isso reduz o acoplamento entre as classes e facilita testes, manutenção e reutilização do código.

---

## `@Autowired`

A anotação `@Autowired` informa ao Spring que uma dependência deve ser injetada automaticamente pelo container de IoC.

**Exemplo:**

```java
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

}
```

Nesse exemplo, o Spring cria uma instância de `ProdutoRepository` e a disponibiliza para a classe `ProdutoService`, sem que seja necessário instanciá-la manualmente.

> Atualmente, a forma mais recomendada de realizar a injeção de dependência é por **construtor**, pois torna as dependências explícitas, facilita a criação de testes e incentiva classes mais imutáveis. Entretanto, durante o curso foi utilizada a anotação `@Autowired`, que continua sendo amplamente encontrada em diversos projetos Spring.

# 📦 8. Repositories

No Spring Data JPA, a camada de acesso ao banco de dados é representada pelos **Repositories**.

Um Repository é uma interface responsável por realizar operações de persistência, como salvar, consultar, atualizar e remover registros, sem a necessidade de escrever implementações manualmente.

Para criar um Repository, basta criar uma interface que herde de `JpaRepository`.

```java
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
```

Os parâmetros informados representam:

- **Produto** → entidade que será gerenciada.
- **Long** → tipo da chave primária (`@Id`) da entidade.

Ao estender `JpaRepository`, diversos métodos já ficam disponíveis automaticamente.

## Principais métodos herdados

| Método | Descrição |
|---------|-----------|
| `save()` | Salva uma nova entidade ou atualiza uma existente. |
| `findAll()` | Retorna todos os registros da tabela. |
| `findById()` | Busca um registro pelo seu identificador. |
| `delete()` | Remove uma entidade do banco de dados. |
| `existsById()` | Verifica se um registro existe através do seu ID. |
| `count()` | Retorna a quantidade total de registros da tabela. |

### `save()`

Salva uma nova entidade ou atualiza uma já existente.

```java
Produto produto = new Produto();
produto.setNome("Notebook");

produtoRepository.save(produto);
```

---

### `findAll()`

Retorna todos os registros da tabela.

```java
List<Produto> produtos = produtoRepository.findAll();
```

---

### `findById()`

Busca um registro pelo identificador.

Como nem sempre o registro existe, o retorno é um `Optional`.

```java
Optional<Produto> produto = produtoRepository.findById(1L);
```

---

### `delete()`

Remove um registro do banco de dados.

```java
produtoRepository.delete(produto);
```

---

### `existsById()`

Verifica se um determinado registro existe.

```java
boolean existe = produtoRepository.existsById(1L);
```

---

### `count()`

Retorna a quantidade de registros existentes.

```java
long quantidade = produtoRepository.count();
```

---

# 🔍 9. Derived Queries

Uma das principais funcionalidades do Spring Data JPA é a criação automática de consultas através do nome dos métodos.

Essas consultas são conhecidas como **Derived Queries**, pois o Spring interpreta o nome do método e gera automaticamente a instrução SQL correspondente.

Por exemplo:

```java
List<Produto> findByNome(String nome);
```

Nesse caso, o Spring entende que deve buscar todos os produtos cujo atributo `nome` corresponda ao valor informado.

## Estrutura básica

A maioria das consultas segue o padrão:

```text
findBy + Atributo + Operador
```

Exemplo:

```java
findByTitulo(String titulo)
```

Também existem outros prefixos que podem ser utilizados:

| Prefixo | Função |
|----------|--------|
| `findBy` | Busca registros. |
| `readBy` | Equivalente ao `findBy`. |
| `queryBy` | Outra forma de realizar consultas. |
| `getBy` | Obtém um registro conforme o critério informado. |
| `countBy` | Retorna a quantidade de registros encontrados. |

## Principais operadores

| Categoria | Operadores |
|------------|------------|
| Igualdade | `Is`, `Equals`, `IsNot`, `IsNull` |
| Texto | `Containing`, `StartingWith`, `EndingWith` |
| Comparação | `LessThan`, `GreaterThan`, `Between` |
| Outros | `IgnoreCase`, `Distinct`, `Top`, `First` |

## Operadores de igualdade

Permitem realizar buscas por igualdade ou verificar valores nulos.

```java
findByNome(String nome)
```

```java
findByNomeEquals(String nome)
```

```java
findByDescricaoIsNull()
```

---

## Operadores para texto

São utilizados para localizar partes de um texto.

```java
findByTituloContaining(String titulo)
```

Retorna registros que contenham o texto informado.

---

```java
findByTituloStartingWith(String titulo)
```

Retorna registros cujo texto inicia com o valor informado.

---

```java
findByTituloEndingWith(String titulo)
```

Retorna registros cujo texto termina com o valor informado.

---

## Operadores de comparação

Permitem realizar consultas utilizando valores numéricos ou datas.

```java
findByPrecoLessThan(Double preco)
```

Retorna produtos com preço menor que o informado.

---

```java
findByPrecoGreaterThan(Double preco)
```

Retorna produtos com preço maior que o informado.

---

```java
findByPrecoBetween(Double minimo, Double maximo)
```

Retorna produtos dentro de uma determinada faixa de valores.

---

## Outros operadores

### `IgnoreCase`

Ignora diferenças entre letras maiúsculas e minúsculas.

```java
findByTituloContainingIgnoreCase(String titulo)
```

---

### `Distinct`

Retorna apenas resultados distintos.

```java
findDistinctByCategoria(String categoria)
```

---

### `Top`

Limita a quantidade de registros retornados.

```java
findTop5ByOrderByPrecoDesc()
```

Retorna os cinco produtos mais caros.

---

### `First`

Retorna apenas o primeiro registro encontrado.

```java
findFirstByOrderByPrecoAsc()
```

Retorna o produto com menor preço.

> As **Derived Queries** permitem criar consultas complexas apenas utilizando a convenção de nomenclatura do Spring Data JPA, eliminando a necessidade de escrever SQL para muitos cenários comuns.

---

# 📝 10. Consultas Personalizadas

Embora as Derived Queries sejam bastante poderosas, algumas consultas exigem maior flexibilidade.

Nesses casos, o Spring Data JPA permite escrever consultas personalizadas utilizando **JPQL** ou **SQL Nativo** através da anotação `@Query`.

## JPQL (Java Persistence Query Language)

A **JPQL** é a linguagem de consultas da JPA.

Diferentemente do SQL tradicional, ela trabalha com **entidades e seus atributos**, e não diretamente com tabelas e colunas do banco de dados.

**Exemplo:**

```java
@Query("SELECT p FROM Produto p WHERE p.preco > :preco")
List<Produto> buscarProdutosCaros(Double preco);
```

Nesse exemplo:

- `Produto` representa a entidade Java.
- `preco` representa o atributo da classe.
- O Hibernate converte automaticamente a consulta para SQL.

---

## SQL Nativo (Native Query)

Também é possível escrever consultas SQL diretamente, utilizando a sintaxe específica do banco de dados.

Para isso, basta informar `nativeQuery = true`.

**Exemplo:**

```java
@Query(
    value = "SELECT * FROM produtos ORDER BY preco DESC LIMIT 5",
    nativeQuery = true
)
List<Produto> buscarTop5ProdutosMaisCaros();
```

Nesse caso, a consulta é enviada ao banco exatamente como foi escrita.

---

## JPQL × SQL Nativo

| JPQL | SQL Nativo |
|------|------------|
| Utiliza entidades e atributos da aplicação. | Utiliza tabelas e colunas do banco de dados. |
| É independente do banco de dados utilizado. | Pode depender da sintaxe específica de cada SGBD. |
| É convertida automaticamente em SQL pelo Hibernate. | É executada diretamente pelo banco de dados. |
| Mais indicada para consultas comuns da aplicação. | Ideal quando é necessário utilizar recursos específicos do banco ou otimizar consultas complexas. |

> Sempre que possível, prefira utilizar **Derived Queries** ou **JPQL**, pois tornam a aplicação mais portável e desacoplada do banco de dados. Utilize **SQL Nativo** apenas quando houver necessidade de recursos específicos ou otimizações que não possam ser alcançadas pelas outras abordagens.

# 🏷️ 11. Enum

Em Java, um **Enum** (Enumeration) é um tipo especial utilizado para representar um conjunto fixo de constantes.

Ele é ideal para modelar **dados categóricos**, ou seja, informações que possuem um número limitado de valores possíveis.

Em vez de armazenar valores como `String`, que podem conter erros de digitação ou valores inválidos, utiliza-se um Enum para garantir maior segurança e legibilidade no código.

**Exemplo:**

```java
public enum Categoria {

    ROCK,
    POP,
    JAZZ,
    MPB
}
```

Nesse caso, um objeto poderá possuir apenas uma das categorias definidas acima.

## Vantagens do uso de Enums

- Evitam valores inválidos.
- Tornam o código mais legível.
- Facilitam a manutenção da aplicação.
- Centralizam todos os valores possíveis em um único local.
- Podem ser utilizados em estruturas como `switch` e em consultas do Spring Data JPA.

---

## Persistindo Enums com a JPA

Quando uma entidade possui um atributo do tipo Enum, é necessário informar ao Hibernate como esse valor será armazenado no banco de dados.

Para isso, utiliza-se a anotação `@Enumerated`.

```java
@Enumerated(EnumType.STRING)
private Categoria categoria;
```

### `EnumType.STRING`

Armazena o **nome da constante** no banco de dados.

**Exemplo:**

| Java | Banco de Dados |
|-------|----------------|
| `Categoria.ROCK` | `ROCK` |
| `Categoria.POP` | `POP` |

Essa é a estratégia mais recomendada, pois torna os dados mais legíveis e evita problemas caso novos valores sejam adicionados ou a ordem do Enum seja alterada.

---

### `EnumType.ORDINAL`

Armazena a **posição** da constante dentro do Enum.

Considerando o exemplo:

```java
public enum Categoria {

    ROCK,
    POP,
    JAZZ
}
```

Os valores seriam persistidos da seguinte forma:

| Java | Banco de Dados |
|-------|----------------|
| `ROCK` | `0` |
| `POP` | `1` |
| `JAZZ` | `2` |

Embora ocupe menos espaço, essa abordagem não é recomendada. Caso a ordem das constantes seja modificada ou novos valores sejam inseridos no meio do Enum, os registros existentes poderão representar categorias incorretas.

> Por esse motivo, a estratégia `EnumType.STRING` é a mais utilizada em aplicações Spring Boot.

---

# 🤖 12. Integração com a API do ChatGPT

Além da persistência de dados utilizando o Spring Data JPA, o projeto também realizou a integração com a **API do ChatGPT**, permitindo enviar solicitações para um modelo de Inteligência Artificial e armazenar suas respostas no banco de dados.

O fluxo da aplicação ocorre da seguinte forma:

```text
Aplicação Java
      │
      ▼
Requisição HTTP
      │
      ▼
API do ChatGPT
      │
      ▼
Resposta em JSON
      │
      ▼
Conversão para Objetos Java
      │
      ▼
Persistência com Spring Data JPA
      │
      ▼
PostgreSQL
```

Inicialmente, a aplicação envia uma requisição HTTP contendo o prompt desejado para a API.

Após o processamento, a API retorna uma resposta em formato **JSON**, que é convertida em objetos Java para facilitar sua manipulação.

Esses objetos podem então ser persistidos no banco de dados utilizando os **Repositories** do Spring Data JPA, permitindo consultar posteriormente as perguntas realizadas e as respostas geradas.

Essa integração demonstra como o Spring Boot pode combinar diferentes tecnologias em uma única aplicação, utilizando APIs externas para obtenção de dados e o Spring Data JPA para armazená-los de forma estruturada no banco de dados.
