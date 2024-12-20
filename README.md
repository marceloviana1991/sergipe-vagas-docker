# Sergipe-Vagas

O projeto Sergipe-Vagas consiste no desenvolvimento de uma API Rest que se baseia nos conceitos de Integração Contínua utilizando ferramenta Docker.


# Documentação da API

```
http://localhost:8080/usuarios
```

| Método | Nome do endpoint |Body Request | Body Response | Path Variable
|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------| -----------------------------------------------------------------------------------------------------------------|
| POST | post |application/json | application/json | |
| GET | get | |  application/json | |

```
Resquest
{
    "cpf": "String",
    "email": "String "
}
```
```
Response
{
    "id": Integer,
    "cpf": "String",
    "email": "String "
}
```
