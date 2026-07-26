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

Durante o desenvolvimento também foram abordados diversos recursos do ecossistema Spring, como:

- Configuração de um banco PostgreSQL;
- Integração entre Spring Boot e JPA;
- Mapeamento Objeto-Relacional (ORM);
- Relacionamentos entre entidades;
- Operações CRUD;
- Consultas utilizando JPQL;
- Derived Queries;
- Native Queries;
- Estratégias de carregamento de dados;
- Operações em cascata;
- Injeção de Dependências;
- Variáveis de ambiente;
- Integração com a API da OpenAI.

Além da implementação prática, este material busca funcionar como um **guia de consultas futuras**, contendo explicações detalhadas sobre cada conceito estudado, exemplos comentados e boas práticas.



---

# 📚 Conteúdo Estudado

## Fundamentos

- Bancos de Dados
- Bancos Relacionais
- Bancos Não Relacionais
- PostgreSQL
- Configuração do Ambiente
- Variáveis de Ambiente

## Persistência de Dados

- JDBC
- JPA
- Hibernate
- EntityManager
- ORM
- Entidades
- CRUD

## Modelagem

- Enum
- Estratégias de geração de IDs
- Relacionamentos
- Operações em Cascata
- Fetch Types

## Spring Data JPA

- Repositories
- JpaRepository
- Derived Queries
- JPQL
- Native Queries
- SQL

## Spring Framework

- Inversão de Controle (IoC)
- Injeção de Dependência (DI)
- @Autowired

## Integrações

- API da OpenAI

# 📑 Sumário

- [1. Introdução](#1-introdução)
- [2. Bancos de Dados](#2-bancos-de-dados)
  - [2.1 Bancos de Dados Relacionais (RDBMS)](#21-bancos-de-dados-relacionais-rdbms)
  - [2.2 Bancos de Dados Não Relacionais](#22-bancos-de-dados-não-relacionais)
  - [2.3 Bancos Orientados a Documentos](#23-bancos-orientados-a-documentos)

- [3. Configurando o Ambiente](#3-configurando-o-ambiente)
  - [3.1 Instalando o PostgreSQL](#31-instalando-o-postgresql)
  - [3.2 pgAdmin](#32-pgadmin)
  - [3.3 PSQL](#33-psql)
  - [3.4 Dependências do Projeto](#34-dependências-do-projeto)
  - [3.5 Configurando o application.properties](#35-configurando-o-applicationproperties)

- [4. Variáveis de Ambiente](#4-variáveis-de-ambiente)
  - [4.1 O que são Variáveis de Ambiente](#41-o-que-são-variáveis-de-ambiente)
  - [4.2 Criando Variáveis](#42-criando-variáveis)
  - [4.3 Utilizando no Spring Boot](#43-utilizando-no-spring-boot)

- [5. Persistência de Dados em Java](#5-persistência-de-dados-em-java)
  - [5.1 JDBC](#51-jdbc)
  - [5.2 ORM](#52-orm-object-relational-mapping)
  - [5.3 JPA](#53-jpa-java-persistence-api)
  - [5.4 Hibernate](#54-hibernate)
  - [5.5 EntityManager](#55-entitymanager)

- [6. Modelagem de Entidades](#6-modelagem-de-entidades)
  - [6.1 Entidades](#61-entidades)
  - [6.2 Enums](#62-enums)
  - [6.3 Estratégias de Geração de IDs](#63-estratégias-de-geração-de-ids)

- [7. Principais Anotações da JPA e Hibernate](#7-principais-anotações-da-jpa-e-hibernate)
  - [7.1 Anotações de Entidade](#71-anotações-de-entidade)
  - [7.2 Relacionamentos](#72-relacionamentos)
  - [7.3 Objetos Embutidos](#73-objetos-embutidos)
  - [7.4 Consultas Nomeadas](#74-consultas-nomeadas)
  - [7.5 Campos Transitórios](#75-campos-transitórios)

- [8. Relacionamentos entre Entidades](#8-relacionamentos-entre-entidades)
  - [8.1 One-to-One](#81-one-to-one)
  - [8.2 One-to-Many](#82-one-to-many)
  - [8.3 Many-to-One](#83-many-to-one)
  - [8.4 Many-to-Many](#84-many-to-many)
  - [8.5 JoinColumn](#85-joincolumn)
  - [8.6 JoinTable](#86-jointable)

- [9. Operações em Cascata](#9-operações-em-cascata)

- [10. Estratégias de Carregamento](#10-estratégias-de-carregamento)
  - [10.1 FetchType.LAZY](#101-fetchtypelazy)
  - [10.2 FetchType.EAGER](#102-fetchtypeeager)

- [11. Spring Data JPA](#11-spring-data-jpa)
  - [11.1 Repositories](#111-repositories)
  - [11.2 JpaRepository](#112-jparepository)
  - [11.3 Operações CRUD](#113-operações-crud)

- [12. Consultas com Spring Data JPA](#12-consultas-com-spring-data-jpa)
  - [12.1 Derived Queries](#121-derived-queries)
  - [12.2 JPQL](#122-jpql)
  - [12.3 SQL Nativo](#123-sql-nativo)
  - [12.4 LIKE e ILIKE](#124-like-e-ilike)

- [13. Injeção de Dependências](#13-injeção-de-dependências)
  - [13.1 Inversão de Controle (IoC)](#131-inversão-de-controle-ioc)
  - [13.2 Dependency Injection (DI)](#132-dependency-injection-di)
  - [13.3 @Autowired](#133-autowired)

- [14. Métodos Estáticos](#14-métodos-estáticos)

- [15. Integração com a API da OpenAI](#15-integração-com-a-api-da-openai)

- [16. Conclusão](#16-conclusão)
