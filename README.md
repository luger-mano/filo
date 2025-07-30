# 🧶 Projeto Filo

**Filo** é um sistema de vendas criado com o propósito de ajudar minha avó a divulgar e vender seus produtos de crochê artesanal. Trata-se de um projeto pessoal de estudo, construído com foco em boas práticas de arquitetura de software, escalabilidade e tecnologias modernas.

O projeto terá uma versão Web e Mobile, com funcionalidades como cadastro de produtos, gestão de clientes e acompanhamento de vendas em tempo real através de um painel simples e intuitivo.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**  
- **Spring Boot**  
- **MySQL**  
- **RabbitMQ**  
- **Docker / Docker Compose**  
- **MapStruct**  
- **GitHub Actions (CI/CD)**  
- **Figma (protótipo)**

---

## 🧱 Arquitetura

O projeto segue a **Arquitetura Hexagonal (Ports and Adapters)**, com foco em separação de responsabilidades, testabilidade e flexibilidade para troca de tecnologias externas (frameworks, banco de dados, mensageria etc).

### Estrutura de pacotes

src
└── main
└── java
└── com.retalho.ba
├── adapter
│ ├── inbound
│ │ ├── controller # Entrada da aplicação (HTTP)
│ │ ├── request # DTOs de entrada
│ │ └── response # DTOs de saída
│ └── outbound
│ ├── entities # Entidades persistidas
│ └── repositories # Interfaces de persistência (JPA, etc.)
│
├── domain
│ ├── enums # Enums da aplicação
│ ├── ports
│ │ ├── in # Interfaces que representam casos de uso (entrada)
│ │ └── out # Interfaces para gateways externos (saída)
│ ├── usecase # Lógica central da aplicação (casos de uso)
│ └── user # Modelos e lógica relacionada ao usuário
│
├── infrastructure
│ ├── config # Configurações do projeto (Beans, Security, etc.)
│ └── exceptions # Tratamento de exceções
│
└── utils
└── mappers # Mapeamentos com MapStruct


---

## 🐳 Docker

### 🧱 Arquivos Docker

- `Dockerfile`: Gera a imagem da aplicação Spring Boot  
- `docker-compose.yml`: Sobe o ambiente com:
  - App Java
  - RabbitMQ
  - MySQL

### ▶️ Rodando com Docker

```bash
docker-compose up --build
🔜 Próximos passos
Desenvolvimento do front-end em Angular

Substituição do MySQL por MongoDB

Aplicação de arquitetura de microsserviços

Deploy completo na AWS (VPC, NAT Gateway, sub-redes, etc.)

Balanceamento com Nginx e proxy reverso

JMeter para testes de performance

Aplicativo mobile com Kotlin

📌 Status
🚧 Projeto em desenvolvimento. Acompanhe os updates e novas features em breve!

🤝 Contribuições
Este é um projeto de estudo e desenvolvimento pessoal, mas feedbacks e sugestões são sempre bem-vindos!

📄 Licença
Este projeto é de uso pessoal e está aberto para fins educacionais.
