📘 README.md — Modelo Ajustado
# 🧠 API Saúde Mental – Plataforma de Monitoramento de Bem-Estar

## 👥 Integrantes
- Augusto Mendonça — RM 558371
- Gabriel Vasquez — RM 557056
- Gustavo Oliveira — RM 559163

---

## 📝 Resumo da Solução
Esta API RESTful permite o cadastro de pacientes e o registro diário de informações de humor, ansiedade e sono, oferecendo suporte ao monitoramento de bem-estar emocional. A solução contribui para iniciativas relacionadas ao futuro do trabalho e ao ODS 8, promovendo ambientes mais saudáveis e produtivos.

---

## 🛠 Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3.5.8**
- Maven
- Spring Web
- Spring Data JPA
- Lombok
- Banco H2 (em memória)
- Springdoc OpenAPI (Swagger)

---

## 🚀 Como Executar o Projeto

### ✔ Pré-requisitos
- Java **21** instalado
- Maven 3.8+ instalado

### ✔ Rodando a aplicação

Via Maven:

```bash
mvn spring-boot:run


Via IDE (IntelliJ/Eclipse):

Run → Run Application

✔ Porta padrão

A API estará disponível em:

http://localhost:8080

📘 Swagger – Documentação da API

Acesse:

http://localhost:8080/swagger-ui/index.html

📌 Exemplos de Requisições
🧑‍⚕️ Criar Paciente (POST)

URL:

POST /pacientes


JSON de exemplo:

{
  "nome": "João da Silva",
  "email": "joao.silva@email.com",
  "dataNascimento": "1990-05-10"
}

📄 Listar Pacientes (GET)

URL:

GET /pacientes

🔍 Buscar Paciente por ID (GET)

URL:

GET /pacientes/1

✏️ Atualizar Paciente (PUT)

URL:

PUT /pacientes/1


JSON de exemplo:

{
  "nome": "João da Silva Atualizado",
  "email": "joao.atualizado@email.com",
  "dataNascimento": "1990-05-10"
}

🧾 Criar Registro Diário (POST)

URL:

POST /registros-diarios


JSON de exemplo:

{
  "pacienteId": 1,
  "dataRegistro": "2025-11-22",
  "nivelHumor": 4,
  "nivelAnsiedade": 2,
  "horasSono": 7
}

📄 Listar Registros Diários (GET)

URL:

GET /registros-diarios

🗄 Banco de Dados H2

Console do H2:

http://localhost:8080/h2-console


Configurações:

JDBC URL: jdbc:h2:mem:saudementaldb
User: sa
Password: (vazio)

📚 ODS 8 — Trabalho Decente e Crescimento Econômico

A solução contribui para o ODS 8 ao fornecer uma ferramenta que apoia o monitoramento de saúde mental no ambiente de trabalho, promovendo qualidade de vida, prevenção de adoecimento emocional e melhoria na produtividade.

👨‍💻 Desenvolvido para fins acadêmicos

API criada como exercício prático de desenvolvimento com Spring Boot seguindo boas práticas de arquitetura, validação, versionamento e documentação.