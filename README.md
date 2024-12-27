# Sergipe-Vagas

O projeto Sergipe-Vagas consiste no desenvolvimento de uma API Rest que se baseia nos conceitos de Integração Contínua utilizando ferramenta Docker.


## Início Rápido

Para estartar a aplicação, no diretório raiz do projeto, execute o comando:

```$ docker-compose up ```


## Alterações no Projeto

Para empacotar alterações na aplicação, execute o script:

``` $ bash compile.sh ```


## Excluir Containers e Imagens

Para excluir containers e imagens, sem excluir os volumes do banco de dados, execute o script:

``` $ bash clean.sh ```



## Documentação da API

### Endpoints de Usuarios
```
http://localhost:8080/usuarios
```

| Método | Body Request     | Body Response | Path Variable | Route            |
|--------|------------------|---------------|---------------|------------------|
| POST | application/json | application/json |               |                  |
| GET |                 |  application/json |               |                  |
| GET |                 |  application/json | Integer       | ```/{id}```      |


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
### Endpoints de Cursos
```
http://localhost:8080/usuarios/{id}/adicionar-curso
```

| Método | Body Request     | Body Response | Path Variable     | Route                       |
|--------|------------------|---------------|-------------------|-----------------------------|
| POST | application/json |  application/json | Integer         | ```/{id}/adicionar-curso``` |

```
Resquest
{
    "nome": "String",
    "duracao": Integer
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

### Endpoints de Empresas

```
http://localhost:8080/empresas
```


| Método | Body Request     | Body Response | Path Variable | Route            |
|--------|------------------|---------------|---------------|------------------|
| POST | application/json | application/json |               |                  |
| GET |                 |  application/json |               |                  |
| GET |                 |  application/json | Integer       | ```/{id}```      |


```
Resquest
{
    "cnpj": "String",
    "email": "String ",
    "vagas":[
        {
            "nome": "String",
            "atribuicao": Integer
        }
    ]
}
```
```
Response
{
    "id": Integer,
    "cnpj": "String",
    "email": "String ",
    "vagas":[
        {
            "id": Integer,
            "nome": "String",
            "atribuicao": Integer
        }
    ]
}
```
### Endpoints de Vagas
```
http://localhost:8080/empresas/{id}/adicionar-vaga
```

| Método | Body Request     | Body Response | Path Variable     | Route                      |
|--------|------------------|---------------|-------------------|----------------------------|
| POST | application/json |  application/json | Integer         | ```/{id}/adicionar-vaga``` |

```
Resquest
{
    "nome": "String",
    "atribuicao": Integer
}
```
```
Response
{
    "id": Integer,
    "cnpj": "String",
    "email": "String ",
    "vagas":[
        {
            "id": Integer,
            "nome": "String",
            "atribuicao": Integer
        }
    ]
}
```