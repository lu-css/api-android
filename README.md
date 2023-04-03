# Documentação da API Advice Slip

Base URL: https://api.adviceslip.com/

A API Advice Slip retorna objetos nos formatos Slip, Search ou Message. A seguir, explicamos como cada um deles é estruturado.

**Slip**
Representa uma mensagem. Contém os seguintes campos:
|  campo |  tipo  |               descrição              |
|:------:|:------:|:------------------------------------:|
|   id   |   inteiro  |      O identiticador da mensagem     |
| advice | String | A mensagem em si |
| date | Date | Opcional. Data de publicação da mensagem?|

**Search**
A resultado de uma busca, contendo uma lista das mensagens com encontradas pela busca.
|     campo     |   tipo  |                              descrição                              |
|:-------------:|:-------:|:-------------------------------------------------------------------:|
| total_results |   inteiro   |                  O número de resultados encontrados                 |
|     query     |  String |                      A pesquisa que foi usada.                      |
|     slips     | Array de Slip | Uma lista de Slips, contendo as mensagens relacionadas à pesquisa. |

**Message**
Em caso de erro, este objeto é retornado
| campo |   tipo  |                               descrição                              |
|:-----:|:-------:|:--------------------------------------------------------------------:|
|  type |  String | O tipo da mensagem. Pode ser "warning" para avisos ou "error" para erros |
|  text |  String |                         O corpo da mensagem.                         |

### ### Endpoints disponíveis

**GET** /advice

Retorna uma mensagem aleatória em formato Slip.

**Exemplo:**

```bash
curl https://api.adviceslip.com/advice/
```

```json
{
  "slip": {
    "id": 101,
    "advice": "Alway do anything for love, but don't do that."
  }
}
```

**GET** /advice/{slip-id}

Retorna a mensagem específica com o identificador {slip-id} em formato Slip.

**Exemplo:**

```bash
curl https://api.adviceslip.com/advice/213
```

```json
{
  "slip": {
    "id": 213,
    "advice": "Quality beats quantity."
  }
}
```

**GET** /advice/search/{query}

Retorna uma lista de mensagens relacionadas à pesquisa em formato Search.

**Exemplo:**

```bash
curl https://api.adviceslip.com/advice/search/food
```

```json
{
  "total_results": "3",
  "query": "food",
  "slips": [
    {
      "id": 72,
      "advice": "Don't eat anything your grandparents wouldn't recognise as food.",
      "date": "2016-11-06"
    },
    {
      "id": 73,
      "advice": "Eat food. Not too much, mostly plants.",
      "date": "2016-04-22"
    },
    {
      "id": 206,
      "advice": "Don't waste food.",
      "date": "2016-09-01"
    }
  ]
}
```
