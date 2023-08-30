# Documentação das Classes

## Classe `Usuario`

Representa um usuário do sistema.

**Atributos:**
- `nome` (String): Nome do usuário.
- `email` (String): Endereço de e-mail do usuário.
- `senha` (String): Senha do usuário.

## Classe `Time`

Representa um time de jogadores.

**Atributos:**
- `vitorias` (int): Número de vitórias do time.
- `derrotas` (int): Número de derrotas do time.
- `empates` (int): Número de empates do time.
- `imagem` (String): URL da imagem do time.
- `nome` (String): Nome do time.

## Classe `Mapa`

Representa um mapa onde as partidas ocorrem.

**Atributos:**
- `nome_mapa` (String): Nome do mapa.

## Classe `Partida`

Representa uma partida entre times.

**Atributos:**
- `times` (array de Time): Times participantes da partida.
- `data_partida` (LocalDateTime): Data e hora da partida.
- `nome_campeonato` (Campeonato): Campeonato ao qual a partida pertence.
- `mortes` (int): Número de mortes na partida.
- `mapa` (Mapa): Mapa onde a partida ocorreu.

## Classe `Campeonato`

Representa um campeonato com várias partidas.

**Atributos:**
- `nome_campeonato` (String): Nome do campeonato.
- `quantidade_partida` (int): Quantidade total de partidas no campeonato.
- `proximas_partidas` (array de Partida): Próximas partidas no campeonato.

## Classe `Jogador`

Representa um jogador que faz parte de um time.

**Atributos:**
- `nome_jogador` (String): Nome do jogador.
- `numero_partida` (int): Número da partida do jogador.
- `kill` (int): Número de eliminações feitas pelo jogador.
- `death` (int): Número de vezes que o jogador foi eliminado.
- `time` (Time): Time ao qual o jogador pertence.

---

### Exemplos de Requisições HTTP

Aqui estão exemplos de como interagir com a API usando os métodos HTTP (GET, POST, PUT, DELETE):

---
## Endpoint **Campeonato**


#### `GET /campeonatos`

Lista todos os campeonatos.

**Exemplo de retorno:**
```json
[
    {
        "nome_campeonato": "CBLOL",
        "quantidade_partida": 3,
        "proximas_partidas": [
            {
                "times": [
                    { 
                        "vitorias": 12,
                        "derrotas": 6,
                        "empates": 3,
                        "imagem":  "https://img.png.com",
                        "nome": "Loud",
                    },
                    { 
                        "vitorias": 14,
                        "derrotas": 4,
                        "empates": 7,
                        "imagem":  "https://img.png.com",
                        "nome": "Pain",
                    }
                ],
                "data_partida": "Mon Aug 21 2023 21:21:56"
            }
        ]
    }
]
```


#### `POST /campeonato`

Cadastra um campeonato.

**Exemplo do body da requisição:**
```json
{ 
    "nome_campeonato": "CBLOL"
}
```

#### `UPDATE /campeonato/{id}`

Atualiza um campeonato.

**Exemplo do body da requisição:**
```json
{ 
    "nome_campeonato": "CBLOL",
    "quantidade_partida": 3,
}
```

#### `DELETE /campeonato/{id}`

Deleta um campeonato.

---

---
## Endpoint **Time**


#### `GET /times`

Lista todos os times.

**Exemplo de retorno:**
```json
[
    {
        "vitorias": 12,
        "derrotas": 6,
        "empates": 3,
        "imagem": "https://img.png.com",
        "nome": "Loud"
    },
    {
        "vitorias": 14,
        "derrotas": 4,
        "empates": 7,
        "imagem": "https://img.png.com",
        "nome": "Pain"
    }
]
```


#### `POST /time`

Cadastra um time.

**Exemplo do body da requisição:**
```json
{ 
    "vitorias": 10,
    "derrotas": 5,
    "empates": 2,
    "imagem": "https://img.png.com",
    "nome": "INTZ"
}
```

#### `UPDATE /time/{id}`

Atualiza um time.

**Exemplo do body da requisição:**
```json
{ 
    "vitorias": 13,
    "derrotas": 6,
    "empates": 3,
    "imagem": "https://img.png.com",
    "nome": "Loud"
}
```

#### `DELETE /time/{id}`

Deleta um time.

---

---
## Endpoint **Partida**


#### `GET /partidas`

Lista todas as partidas.

**Exemplo de retorno:**
```json
[
    {
        "times": [
            { 
                "vitorias": 12,
                "derrotas": 6,
                "empates": 3,
                "imagem":  "https://img.png.com",
                "nome": "Loud"
            },
            { 
                "vitorias": 14,
                "derrotas": 4,
                "empates": 7,
                "imagem":  "https://img.png.com",
                "nome": "Pain"
            }
        ],
        "data_partida": "Mon Aug 21 2023 21:21:56",
        "nome_campeonato": "CBLOL",
        "mortes": 40,
        "mapa": {
            "nome_mapa": "Summoner's Rift"
        }
    }
]
```


#### `POST /Partida`

Cadastra uma partida.

**Exemplo do body da requisição:**
```json
{ 
    "times": [
        { 
            "vitorias": 9,
            "derrotas": 7,
            "empates": 6,
            "imagem":  "https://img.png.com",
            "nome": "KEYD"
        },
        { 
            "vitorias": 10,
            "derrotas": 5,
            "empates": 2,
            "imagem":  "https://img.png.com",
            "nome": "INTZ"
        }
    ],
    "data_partida": "Mon Aug 21 2023 22:21:56",
    "nome_campeonato": "CBLOL",
    "mortes": 40,
    "mapa": {
        "nome_mapa": "Summoner's Rift"
    }
}
```

#### `UPDATE /partida/{id}`

Atualiza uma partida.

**Exemplo do body da requisição:**
```json
{ 
    "times": [
        { 
            "vitorias": 15,
            "derrotas": 5,
            "empates": 4,
            "imagem":  "https://img.png.com",
            "nome": "Loud"
        },
        { 
            "vitorias": 16,
            "derrotas": 3,
            "empates": 8,
            "imagem":  "https://img.png.com",
            "nome": "Pain"
        }
    ],
    "data_partida": "Tue Aug 22 2023 22:22:56",
    "nome_campeonato": "CBLOL",
    "mortes": 45,
    "mapa": {
        "nome_mapa": "Summoner's Rift"
    }
}
```

#### `DELETE /partida/{id}`

Deleta uma partida.

---

## Endpoint **Jogador**


#### `GET /jogadores`

Lista todos os jogadores.

**Exemplo de retorno:**
```json
[
    {
        "nome_jogador": "Robo",
        "numero_partida": 250,
        "kill": 300,
        "death": 286,
        "time": {
            "vitorias": 200,
            "derrotas": 40,
            "empates": 10,
            "imagem":  "https://img.png.com",
            "nome": "Loud"
        }
    },
    {
        "nome_jogador": "BrTT",
        "numero_partida": 400,
        "kill": 256,
        "death": 110,
        "time": {
            "vitorias": 250,
            "derrotas": 100,
            "empates": 50,
            "imagem":  "https://img.png.com",
            "nome": "Pain"
        }
    }
]
```


#### `POST /jogador`

Cadastra um jogador.

**Exemplo do body da requisição:**
```json
{ 
    "nome_jogador": "Titan",
    "numero_partida": 189,
    "kill": 250,
    "death": 145,
    "time": {
        "vitorias": 129,
        "derrotas": 50,
        "empates": 10,
        "imagem":  "https://img.png.com",
        "nome": "RED CANIDS"
    }
}
```

#### `UPDATE /jogador/{id}`

Atualiza um jogador.

**Exemplo do body da requisição:**
```json
{ 
    "nome_jogador": "Robo",
    "numero_partida": 260,
    "kill": 310,
    "death": 296,
    "time": {
        "vitorias": 208,
        "derrotas": 42,
        "empates": 10,
        "imagem":  "https://img.png.com",
        "nome": "Loud"
    }
}
```

#### `DELETE /jogador/{id}`

Deleta um jogador.

---

---

## Endpoint **Usuario**


#### `GET /usuarios`

Lista todos os usuários.

**Exemplo de retorno:**
```json
[
    {
        "nome": "João",
        "email": "joao@example.com",
        "senha": "********"
    },
    {
        "nome": "Maria",
        "email": "maria@example.com",
        "senha": "******"
    }
]
```


#### `POST /usuario`

Cadastra um novo usuário.

**Exemplo do body da requisição:**
```json
{ 
    "nome": "Pedro",
    "email": "pedro@example.com",
    "senha": "********"
}
```

#### `UPDATE /usuario/{id}`

Atualiza um usuário.

**Exemplo do body da requisição:**
```json
{ 
    "nome": "Pedro",
    "email": "pedro2@example.com",
    "senha": "********"
}
```

#### `DELETE /usuario/{id}`

Deleta um usuário.

---

---

## Endpoint **Mapa**


#### `GET /mapas`

Lista todos os mapas.

**Exemplo de retorno:**
```json
[
    {
        "nome_mapa": "Summoner's Rift"
    },
    {
        "nome_mapa": "Twisted Treeline"
    }
]
```


#### `POST /mapa`

Cadastra um novo mapa.

**Exemplo do body da requisição:**
```json
{ 
    "nome_mapa": "Howling Abyss"
}
```

#### `UPDATE /mapa/{id}`

Atualiza um mapa.

**Exemplo do body da requisição:**
```json
{ 
    "nome_mapa": "Crystal Scar"
}

```

#### `DELETE /mapa/{id}`

Deleta um mapa.

---

## Possíveis status code das requisições

| Código | Descrição
|-|-
| 200 | Requisição bem-sucedida
| 201 | Cadastrado com sucesso
| 204 | A requisição foi bem-sucedida, mas não há conteúdo para retornar.
| 400 | Os campos enviados são inválidos
| 404 | Página não encontrada
| 405 | Método não permitido
| 500 | Erro interno do servidor