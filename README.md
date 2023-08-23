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