# 🏗️ Clean Architecture — Scheduling Core Refactoring

**Entities • Gateways • Use Cases**

Este repositório consolida a migração estratégica de um mini-sistema de agendamento — antes estruturado em arquitetura tradicional em camadas — para um modelo robusto baseado em Clean Architecture, conforme os princípios definidos por Robert C. Martin (Uncle Bob).

A iniciativa prioriza desacoplamento, governança arquitetural e escalabilidade sustentável, garantindo que o domínio opere blindado contra detalhes tecnológicos.

## 🎯 Objetivo Estratégico da Arquitetura

A Clean Architecture visa isolar totalmente a regra de negócio dos detalhes externos (frameworks, banco, controllers, libs).
O Core deve operar 100% em Java puro:

Sem anotações.

Sem dependências de frameworks.

Sem acoplamentos de infraestrutura.

O resultado é um domínio estável, resiliente e tecnologicamente independente, permitindo troca de tecnologias sem impacto na lógica central.

## 🧩 Estrutura Arquitetural

1. **Core** (Domínio — Blindado)

Camada de alto valor agregado, responsável por toda inteligência da aplicação.
Contém:

**Entities** — Modelos de negócio puros.

**Use Cases** — Casos de uso com regras de orquestração.

**Gateways** — Interfaces de contrato (Ports).

Diretrizes:

Zero anotações do Spring, JPA ou frameworks.

Nada que amarre o domínio a tecnologia.

Regra de dependência controlada: o Core não depende de ninguém.

2. **Infrastructure** (Adaptadores Externos)

Camada operacional, responsável por todas as dependências externas.
Contém:

**Controllers / Web Adapters**

**Persistence (JPA, Repositories, queries)**

**DTOs, Mappers**

**Configurações, Beans, Security, JWT**

Diretrizes:

Pode usar frameworks livremente (Spring, JPA, MapStruct, etc.).

Implementa os Gateways definidos no Core.

Depende do Core, nunca o contrário.

## 🔌 Gateways — O Backbone da Comunicação

Gateways são interfaces definidas no Core que descrevem operações críticas do sistema.
Exemplo:

**AgendamentoGateway**

**criarAgendamento(...)**

**buscarPorId(...)**

A Infrastructure implementa essas interfaces, garantindo:

inversão de dependência (DIP)

isolamento do domínio

flexibilidade para trocar tecnologias sem retrabalho no Core

## ⚙️ Como o Projeto Isola as Regras de Negócio

✔ Core blindado sem qualquer dependência externa

✔ Infrastructure plugada via implementação de Gateways

✔ Use Cases invocam contratos e não implementações

✔ Controllers chamam Use Cases → que chamam Gateways → que delegam à tecnologia

✔ Qualquer troca tecnológica (JPA → JDBC, REST → gRPC, banco A → banco B) impacta apenas Infrastructure

## 🧠 Benefícios Corporativos

Baixo custo de manutenção

Elevada testabilidade (Use Cases testáveis sem banco ou Spring)

Escalabilidade arquitetural

Governança clara de responsabilidades

Tecnologia substituível sem refatoração de domínio

## 📹 Origem do Projeto

Baseado em tutorial prático que demonstra a migração de uma arquitetura tradicional para Clean Architecture, com foco na construção de um Core autônomo e organizado em entidades, gateways e casos de uso.
A próxima etapa é a implementação da camada Infrastructure, plugando persistência, exposição web e adapters externos.

## 📁 Estrutura Geral (Sugestão de Organization Target)
/core

   /entity
   
   /usecase
   
   /gateway

/infrastructure

   /controller
   
   /persistence
   
   /mapper
   
   /config

## 🚀 Status do Projeto

Core implementado com base nos princípios de Clean Architecture.
Próximo passo operacional: implementação completa da Infrastructure e integração dos Gateways.
