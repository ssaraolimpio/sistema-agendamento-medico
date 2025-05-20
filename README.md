## Sistema de Agendamento Médico

O Sistema de Agendamento Médico tem como objetivo facilitar o processo de marcação de consultas entre pacientes e profissionais da saúde. A aplicação oferece funcionalidades para cadastro de médicos, pacientes, especialidades e horários disponíveis, permitindo o agendamento, cancelamento e gerenciamento de consultas de forma eficiente e segura.
### Funcionalidades principais
- Cadastro de medicos: Nome, especialidade, CRM, horarios de atendimento
- Cadastro de pacientes: Nome, CPF, data de nascimento, endereco (CEP via API externa)
- Agendamento de consultas: Verifica disponibilidade e conflitos de horario
- Cancelamento de consultas: Com justificativa e regra de antecedencia minima
- Listagem de consultas: Com filtros por paciente, medico, data, e paginacao

### Regras de negocio
- Medico só pode ter uma consulta por vez;
- Agendamento não pode ser retroativo;
- Consulta deve estar dentro do horário de atendimento do medico;
- Duração fixa das consultas (ex: 30 minutos);
- Cancelamentos com no minimo 24h de antecedência;
- Endereço do paciente buscado via API ViaCEP;

### Tecnologias utilizadas
- Java 21
- Spring Boot 3.x
- MySQL
- Swagger --- estudar e criar esse swagger
- JUnit + Mockito --- estudar melhor e implementar
- Lombok

## Como executar a API 
```bash
./mvnw spring-boot:run
