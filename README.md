# Sergipe-Vagas

O projeto Sergipe-Vagas consiste no desenvolvimento de uma API Rest que se baseia nos conceitos de Integração Contínua utilizando ferramenta Docker.


# Documentação da API

```
http://localhost:8080/usuarios
```

| Método | Nome do endpoint | Body Request     | Body Response | Path Variable     | Route                              |
|--------|------------------|------------------|---------------|-------------------|------------------------------------|
| POST | post             | application/json | application/json |                   |                                    |
| GET | get              |                  |  application/json |                   |                                    |
| POST | postCurso          | application/json |  application/json | ```{idUsuario}``` | ```/{idUsuario}/adicionar-curso``` |

```
Resquest
{
    "cpf": "String",
    "email": "String ",
    "cursos":[
        {
            "nome": "String",
            "duracao": Integer
        }
    ]
}
```
```
Response
{
    "id": Integer,
    "cpf": "String",
    "email": "String ",
    "cursos":[
        {
            "id": Integer,
            "nome": "String",
            "duracao": Integer
        }
    ]
}
```
