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

### Permissões de acesso

Sistema de autenticação statelles com token jwt


*Não Autenticado:*
- Listar empresas e vagas cadastradas
- Efetuar Login
- Ativação de Cadastro
- Cadastrar Usuário (Desativado)
- Cadastrar Empresa (Desativado)

Para simplificar a lógica do sistema, ao invés de enviar o código de ativação de cadastro via email, a aplicação imprime o código de ativação no console.

*Login Autenticado como Usuário:*
- Visualizar dados pessoais do usuário
- Adicionar curso ao próprio cadastro

*Login Autenticado como Empresa:*
- Listar usuarios e cursos
- Visualizar dados pessoais da empresa
- Adicionar e desativar vaga ao próprio cadastro


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
    "senha": "String ",
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
http://localhost:8080/usuarios
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
| GET |                 |  application/json |                |                  |
| GET |                 |  application/json | Integer        | ```/{id}```      |


```
Resquest
{
    "cnpj": "String",
    "email": "String ",
    "senha": "String ",
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
http://localhost:8080/empresas
```

| Método | Body Request     | Body Response    | Path Variable     | Route                      |
|--------|------------------|------------------|-------------------|----------------------------|
| POST   | application/json | application/json | Integer           | ```/{id}/adicionar-vaga``` |
| DELETE |                  |                  | Integer           | ```/vagas/{idVaga}```      |

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

### Endpoints de Login
```
http://localhost:8080/login
```
| Método | Body Request     | Body Response    | Path Variable | Route |
|--------|------------------|------------------|---------------|-------|
| POST   | application/json | application/json |               |       |

```
Resquest
{
    "email": "String",
    "senha": "String"
}
```
```
Response
{
    "token": "String"
}
```

### Endpoints de Ativação de cadastro
```
http://localhost:8080/ativar
```

| Método | Body Request     | Body Response    | Path Variable | Route           |
|--------|------------------|------------------|---------------|-----------------|
| GET    |                  |                  | UUID          | ```/{código}``` |

