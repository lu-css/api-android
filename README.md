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

# Documentação da API Kucoin

Base URL: https://api.kucoin.com

Documentação: https://docs.kucoin.com/

# Tipos de Retorno

Ao menos que seja especificado, todos os timestamps (data e hora) são retornados em milissegundos (exemplo, **1546658861000**), ou seja, grandes números inteiros.

Números são retornados como String, com a intenção de preservar precisar entre plataformas. Ao fazer requisições, é recomendando converter os números em Strings, para evitar problemas de precisão.

# Endpoints

## Dados do Mercado

Esses Endpoints não precisam de nenhum método de autenticação.

#### Get Lista de Mercado

Request via this endpoint to get the transaction currency for the entire trading market.

**GET** /api/v1/markets

**Parâmetros:**
N/A

**Exemplo:**

```bash
curl "https://api.kucoin.com/api/v1/markets"
```

```json
{
  "code": "200000",
  "data": [
    "USDS",
    "Hong-Kong",
    "BTC",
    "KCS",
    "ALTS",
    "NFT-ETF",
    "FIAT",
    "Arbitrum",
    "DeFi",
    "Shanghai-Upgrade",
    "AI",
    "NFT",
    "Metaverse",
    "Polkadot",
    "ETF"
  ]
}
```


#### Get Symbols List

**GET** /api/v2/symbols

Retorna uma lista de símbolos monetários para serem usados em outras requisições.

**Parâmetros:**
| Parâmetro |  Tipo  |                               descrição                              |
|:---------:|:------:|:--------------------------------------------------------------------:|
|   market (opcional)  | String | O Mercado que está sendo usado. |

**Exemplo**:

```bash
curl "https://api.kucoin.com/api/v2/symbols?market=BTC"
```

```json
{
    "code": "200000",
    "data": [
        {
            "symbol": "GALAX-USDT",
            "name": "GALA-USDT",
            "baseCurrency": "GALAX",
            "quoteCurrency": "USDT",
            "feeCurrency": "USDT",
            "market": "USDS",
            "baseMinSize": "10",
            "quoteMinSize": "0.001",
            "baseMaxSize": "10000000000",
            "quoteMaxSize": "99999999",
            "baseIncrement": "0.0001",
            "quoteIncrement": "0.00001",
            "priceIncrement": "0.00001",
            "priceLimitRate": "0.1",
            "minFunds": "0.1",
            "isMarginEnabled": true,
            "enableTrading": true
        },
        {
            "symbol": "XLM-USDT",
            "name": "XLM-USDT",
            "baseCurrency": "XLM",
            "quoteCurrency": "USDT",
            "feeCurrency": "USDT",
            "market": "USDS",
            "baseMinSize": "0.1",
            "quoteMinSize": "0.01",
            "baseMaxSize": "10000000000",
            "quoteMaxSize": "99999999",
            "baseIncrement": "0.0001",
            "quoteIncrement": "0.000001",
            "priceIncrement": "0.000001",
            "priceLimitRate": "0.1",
            "minFunds": "0.1",
            "isMarginEnabled": true,
            "enableTrading": true
        }
    ]
}
```

#### Get Ticker

Request via this endpoint to get Level 1 Market Data. The returned value includes the best bid price and size, the best ask price and size as well as the last traded price and the last traded size.

**GET** /api/v1/market/orderbook/level1

**Parâmetros:**
| Parâmetro |  Tipo  |                               descrição                              |
|:---------:|:------:|:--------------------------------------------------------------------:|
|   symbol  | String | O Símbolo monetário |


**Exemplo:**

```bash
curl "https://api.kucoin.com/api/v1/market/orderbook/level1?symbol=BTC-USDT"
```

```json
{
  "code": "200000",
  "data": {
    "time": 1680641029328, 
    "sequence": "7122717002",
    "price": "28267.6",
    "size": "0.14831924",
    "bestBid": "28268.1",
    "bestBidSize": "0.33550136",
    "bestAsk": "28268.2", 
    "bestAskSize": "0.34865313"
  }
}
```


#### Get All Tickers

Este Endpoint fornece informações sobre o melhor preço e tamanho de oferta, melhor preço e tamanho de compra, e também sobre o último preço e tamanho negociado.

**GET** /api/v1/market/allTickers

**Parâmetros:**
N/A

**Exemplo:**

```bash
curl "https://api.kucoin.com/api/v1/market/allTickers"
```

```json
{
  "code": "200000",
  "data": {
    "time": 1680641481002,
    "ticker": [
      {
        "symbol": "NKN-USDT",
        "symbolName": "NKN-USDT",
        "buy": "0.110964",
        "sell": "0.11118",
        "changeRate": "0.0339",
        "changePrice": "0.003646",
        "high": "0.111957",
        "low": "0.104983",
        "vol": "610825.8948",
        "volValue": "66754.3733545845",
        "last": "0.11112",
        "averagePrice": "0.10857437",
        "takerFeeRate": "0.001",
        "makerFeeRate": "0.001",
        "takerCoefficient": "1",
        "makerCoefficient": "1"
      }
    ]
 }
```

#### Get Estatísticas 24 horas

Esse endpoint retorna as estatísticas especificadas no ticker nas últimas 24 horas.

**GET**  /api/v1/market/stats

**Parâmetros:**
| Parâmetro |  Tipo  |                               descrição                              |
|:---------:|:------:|:--------------------------------------------------------------------:|
|   symbol  | String | O Símbolo monetário |

**Exemplo:**

```bash
curl "https://api.kucoin.com/api/v1/market/stats?symbol=BTC-USDT"
```

```json
{
  "code": "200000",
  "data": {
    "time": 1680641996141,
    "symbol": "BTC-USDT",
    "buy": "28246.4",
    "sell": "28246.5",
    "changeRate": "0.0233",
    "changePrice": "643.4",
    "high": "28445.5",
    "low": "27241.6",
    "vol": "5172.53363077",
    "volValue": "144865620.50190121",
    "last": "28246.5",
    "averagePrice": "27964.10905285",
    "takerFeeRate": "0.001",
    "makerFeeRate": "0.001",
    "takerCoefficient": "1",
    "makerCoefficient": "1"
  }
}
```

## Informação da margem

Os Endpoints desta sessão não precisam de nenhuma forma de autenticação.

#### Get preço da margem

Request via this endpoint to get the index price of the specified symbol.

**GET** /api/v1/mark-price/{symbol}/current

**Parâmetros:**
| Parâmetro |  Tipo  |                               descrição                              |
|:---------:|:------:|:--------------------------------------------------------------------:|
|   symbol  | String | O Símbolo monetário |

**Exemplo:**

```bash
curl "https://api.kucoin.com/api/v1/mark-price/USDT-BTC/current"
```

```json
{
  "code": "200000",
  "data": {
    "symbol": "USDT-BTC",
    "timePoint": 1680643062000,
    "value": 3.544E-5
  }
}
```


#### Get Margin Configuration Info

Request via this endpoint to get the configure info of the margin.

**GET** /api/v1/margin/config

**Parâmetros:**
N/A

**Exemplo:**

```bash
curl "https://api.kucoin.com/api/v1/margin/config"
```

```json
{
  "code": "200000",
  "data": {
    "currencyList": [
            "XEM",
            "MATIC",
            "VRA",
            ...
        ],
    "maxLeverage": 5,
    "warningDebtRatio": "0.95",
    "liqDebtRatio": "0.97"
  }
}
```
