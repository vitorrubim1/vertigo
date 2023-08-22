# **Vertigo**

### Vertigo é uma plataforma que exibirá quais serão as próximas partidas/competições de equipes de e-sports e estatísticas de times e jogadores

## Teste
- `GET`: `/`: Lista todos os campeonatos

``` bash 
# Exemplo de retorno
{
    "nome_campeonato": "CBLOL",
    "quantidade_partida": 3,
    "proxima_partida": [
        {
            "time": [],
            "data_partida": "Mon Aug 21 2023 21:21:56"
        }
    ]
}
```