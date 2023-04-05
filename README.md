# API do Clima
Base URL: [http://api.weatherapi.com/v1](https://www.weatherapi.com/docs/#)
<br>
<h2> Tipos de retorno </h2>
A API Weather retorna objetos nos seguintes formatos: 

**Objeto Location:** Retorna informações sobre a localização, incluindo pontos geográficos, nome, região, informações de país e fuso horário
<table class="table table-bordered">
                                <tbody><tr>
                                    <th _msttexthash="59371" _msthash="1878">Campo</th>
                                    <th _msttexthash="153296" _msthash="1879">Tipo de dado</th>
                                    <th _msttexthash="177697" _msthash="1880">Descrição</th>
                                </tr>
                                <tr>
                                    <td _msttexthash="30576" _msthash="1881">Lat</td>
                                    <td _msttexthash="93808" _msthash="1882">decimal</td>
                                    <td _msttexthash="485199" _msthash="1883">Latitude em grau decimal</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="31330" _msthash="1884">Lon</td>
                                    <td _msttexthash="93808" _msthash="1885">decimal</td>
                                    <td _msttexthash="524030" _msthash="1886">Longitude em grau decimal</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="47437" _msthash="1887">name</td>
                                    <td _msttexthash="60762" _msthash="1888">string</td>
                                    <td _msttexthash="177944" _msthash="1889">Nome do local</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="96356" _msthash="1890">region</td>
                                    <td _msttexthash="60762" _msthash="1891">string</td>
                                    <td _msttexthash="1698723" _msthash="1892">Região ou estado da localização, se disponívela</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="62959" _msthash="1893">country</td>
                                    <td _msttexthash="60762" _msthash="1894">string</td>
                                    <td _msttexthash="433004" _msthash="1895">País de localização</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="62309" _msthash="1896">tz_id</td>
                                    <td _msttexthash="60762" _msthash="1897">string</td>
                                    <td _msttexthash="390143" _msthash="1898">Nome do fuso horário</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="286221" _msthash="1899">localtime_epoch</td>
                                    <td _msttexthash="34567" _msthash="1900">inteiro</td>
                                    <td _msttexthash="659295" _msthash="1901">Data e hora locais na hora unix</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="135161" _msthash="1902">localtime</td>
                                    <td _msttexthash="60762" _msthash="1903">string</td>
                                    <td _msttexthash="284362" _msthash="1904">Data e hora locais</td>
                                </tr>
                            </tbody></table>

<br></br>
**Alertas Meteorológicos:** Este formato retorna alertas e avisos emitidos por agências governamentais como uma matriz, se disponível, para o local fornecido.
Por padrão, os alertas não são retornados. Para receber alertas de volta na resposta devemos passar o parâmetro  **alerts=yes**.
**Observação:** alguns dos alertas podem estar no idioma local do local.

<table class="table table-bordered table-correct">
                                <tbody><tr>
                                    <th _msttexthash="59371" _msthash="1909">Campo</th>
                                    <th class="new-width" _msttexthash="153296" _msthash="1910">Tipo de dado</th>
                                    <th _msttexthash="177697" _msthash="1911">Descrição</th>
                                </tr>
                                <tr>
                                    <td _msttexthash="114361" _msthash="1912">manchete</td>
                                    <td _msttexthash="60762" _msthash="1913">string</td>
                                    <td _msttexthash="273364" _msthash="1914">Título de alerta</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="96694" _msthash="1915">msgType</td>
                                    <td _msttexthash="60762" _msthash="1916">string</td>
                                    <td _msttexthash="203944" _msthash="1917">Tipo de alerta</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="155649" _msthash="1918">severidade</td>
                                    <td _msttexthash="60762" _msthash="1919">string</td>
                                    <td _msttexthash="344175" _msthash="1920">Gravidade do alerta</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="131547" _msthash="1921">urgência</td>
                                    <td _msttexthash="60762" _msthash="1922">string</td>
                                    <td _msttexthash="128635" _msthash="1923">Urgência</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="70291" _msthash="1924">Áreas</td>
                                    <td _msttexthash="60762" _msthash="1925">string</td>
                                    <td _msttexthash="293176" _msthash="1926">Áreas abrangidas</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="135135" _msthash="1927">categoria</td>
                                    <td _msttexthash="60762" _msthash="1928">string</td>
                                    <td _msttexthash="132223" _msthash="1929">Categoria</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="97799" _msthash="1930">certeza</td>
                                    <td _msttexthash="60762" _msthash="1931">string</td>
                                    <td _msttexthash="94887" _msthash="1932">Certeza</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="235729" _msthash="1933">acontecimento</td>
                                    <td _msttexthash="60762" _msthash="1934">string</td>
                                    <td _msttexthash="232817" _msthash="1935">Acontecimento</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="47736" _msthash="1936">nota</td>
                                    <td _msttexthash="60762" _msthash="1937">string</td>
                                    <td _msttexthash="44824" _msthash="1938">Nota</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="77857" _msthash="1939">eficaz</td>
                                    <td _msttexthash="45370" _msthash="1940">date</td>
                                    <td _msttexthash="74945" _msthash="1941">Eficaz</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="76947" _msthash="1942">Expira</td>
                                    <td _msttexthash="60762" _msthash="1943">string</td>
                                    <td _msttexthash="76947" _msthash="1944">Expira</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="43017" _msthash="1945">Desc</td>
                                    <td _msttexthash="60762" _msthash="1946">string</td>
                                    <td _msttexthash="177697" _msthash="1947">Descrição</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="186082" _msthash="1948">instrução</td>
                                    <td _msttexthash="60762" _msthash="1949">string</td>
                                    <td _msttexthash="183170" _msthash="1950">Instrução</td>
                                </tr>
                                
**Exemplo:** Retorna um alerta
```json    
{
  "alerts": {
    "alert": [
      {
        "headline": "Flood Warning issued January 05 at 9:47PM EST until January 07 at 6:15AM EST by NWS",
        "msgtype": "Alert",
        "severity": "Moderate",
        "urgency": "Expected",
        "areas": "Calhoun; Lexington; Richland",
        "category": "Met",
        "certainty": "Likely",
        "event": "Flood Warning",
        "note": "Alert for Calhoun; Lexington; Richland (South Carolina) Issued by the National Weather Service",
        "effective": "2021-01-05T21:47:00-05:00",
        "expires": "2021-01-07T06:15:00-05:00",
        "desc": "...The Flood Warning continues for the following rivers in South\nCarolina...\nCongaree River At Carolina Eastman affecting Richland, Calhoun\nand Lexington Counties.\nCongaree River At Congaree National Park-Gadsden affecting\nCalhoun and Richland Counties.\nNorth Fork Edisto River At Orangeburg affecting Orangeburg County.\n...The Flood Warning is now in effect until Thursday morning...\nThe Flood Warning continues for\nthe Congaree River At Carolina Eastman.\n* Until Thursday morning.\n* At 9:28 PM EST Tuesday the stage was 115.6 feet.\n* Flood stage is 115.0 feet.\n* Minor flooding is occurring and minor flooding is forecast.\n* Recent Activity...The maximum river stage in the 24 hours ending\nat 9:28 PM EST Tuesday was 118.2 feet.\n* Forecast...The river will rise to 115.7 feet just after midnight\ntonight. It will then fall below flood stage tomorrow morning to\n114.2 feet and begin rising again tomorrow evening. It will rise\nto 114.3 feet early Thursday morning. It will then fall again and\nremain below flood stage.\n* Impact...At 115.0 feet, Flooding occurs in low lying areas of the\nCarolina Eastman Facility and at the Congaree National Park.\n* Flood History...This crest compares to a previous crest of 116.3\nfeet on 12/03/2020.\n&&",
        "instruction": "A Flood Warning means that flooding is imminent or occurring. All\ninterested parties should take necessary precautions immediately.\nMotorists should not attempt to drive around barricades or drive\ncars through flooded areas.\nCaution is urged when walking near riverbanks.\nAdditional information is available at www.weather.gov.\nThe next statement will be issued Wednesday morning at 1000 AM EST."
      },
      {
        "headline": "Flood Warning issued January 05 at 9:47PM EST until January 09 at 4:00AM EST by NWS",
        "msgtype": "Alert",
        "severity": "Moderate",
        "urgency": "Expected",
        "areas": "Calhoun; Richland",
        "category": "Met",
        "certainty": "Likely",
        "event": "Flood Warning",
        "note": "Alert for Calhoun; Richland (South Carolina) Issued by the National Weather Service",
        "effective": "2021-01-05T21:47:00-05:00",
        "expires": "2021-01-09T04:00:00-05:00",
        "desc": "...The Flood Warning continues for the following rivers in South\nCarolina...\nCongaree River At Carolina Eastman affecting Richland, Calhoun\nand Lexington Counties.\nCongaree River At Congaree National Park-Gadsden affecting\nCalhoun and Richland Counties.\nNorth Fork Edisto River At Orangeburg affecting Orangeburg County.\n...The Flood Warning is now in effect until early Saturday morning...\nThe Flood Warning continues for\nthe Congaree River At Congaree National Park-Gadsden.\n* Until late Friday night.\n* At 9:00 PM EST Tuesday the stage was 16.5 feet.\n* Flood stage is 15.0 feet.\n* Minor flooding is occurring and minor flooding is forecast.\n* Recent Activity...The maximum river stage in the 24 hours ending\nat 9:00 PM EST Tuesday was 17.2 feet.\n* Forecast...The river is expected to fall below flood stage early\nFriday morning and continue falling to 12.4 feet Sunday evening.\n* Impact...At 15.0 feet, Flooding begins in the Congaree National\nPark. This will begin to produce flooding of portions of the lower\nboardwalk.\n* Impact...At 17.0 feet, The access road to the Sandy Run\nsubdivision becomes flooded. The lower boardwalk in the Congaree\nNational Park becomes flooded by Cedar Creek.\n* Impact...At 18.0 feet, Several homes in the Sandy Run subdivision\nalong the river become flooded. At 18 feet the river covers the\nWeston Lake overlook in the Congaree National Park. Between 18 and\n18.5 feet the river begins to cover sections of the elevated\nboardwalk.\n* Flood History...This crest compares to a previous crest of 16.3\nfeet on 12/03/2020.\n&&",
        "instruction": "A Flood Warning means that flooding is imminent or occurring. All\ninterested parties should take necessary precautions immediately.\nMotorists should not attempt to drive around barricades or drive\ncars through flooded areas.\nCaution is urged when walking near riverbanks.\nAdditional information is available at www.weather.gov.\nThe next statement will be issued Wednesday morning at 1000 AM EST."
      }
    ]
  }
}                  
```
<br></br>
**Dados de qualidade do ar:** Os dados de Qualidade do Ar são retornados na API em Tempo Real para o local determinado em json e xml.
Por padrão, os dados de qualidade do ar não são retornados. Para obter dados de qualidade devemos passar o parâmetro  **aqi=yes**.

<table class="table table-bordered table-correct">
                                <tbody><tr>
                                    <th _msttexthash="59371" _msthash="5192">Campo</th>
                                    <th class="new-width" _msttexthash="153296" _msthash="5193">Tipo de dado</th>
                                    <th _msttexthash="177697" _msthash="5194">Descrição</th>
                                </tr>
                                <tr>
                                    <td _msttexthash="20553" _msthash="5195">co</td>
                                    <td _msttexthash="100412" _msthash="5196">float</td>
                                    <td _msttexthash="816712" _msthash="5197">Monóxido de carbono (μg/m3)</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="15405" _msthash="5198">o3</td>
                                    <td _msttexthash="100412" _msthash="5199">float</td>
                                    <td _msttexthash="302289" _msthash="5200">Ozono (μg/m3)</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="62348" _msthash="5201">podar</td>
                                    <td _msttexthash="100412" _msthash="5202">float</td>
                                    <td _msttexthash="675883" _msthash="5203">Dióxido de azoto (μg/m3)</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="71279" _msthash="5204">assim2</td>
                                    <td _msttexthash="100412" _msthash="5205">float</td>
                                    <td _msttexthash="767624" _msthash="5206">Dióxido de enxofre (μg/m3)</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="47307" _msthash="5207">pm2_5</td>
                                    <td _msttexthash="100412" _msthash="5208">float</td>
                                    <td _msttexthash="273689" _msthash="5209">PM2,5 (μg/m3)</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="33501" _msthash="5210">pm10</td>
                                    <td _msttexthash="100412" _msthash="5211">float</td>
                                    <td _msttexthash="249002" _msthash="5212">PM10 (μg/m3)</td>
                                </tr>
                                <tr>
                                    <td _msttexthash="191516" _msthash="5213">us-epa-index</td>
                                    <td _msttexthash="99255" _msthash="5214">inteiro</td>
                                    <td><font _mstmutation="1" _msttexthash="226707" _msthash="5215">EUA - padrão EPA. </font><ul>
                                            <li _msttexthash="217516" _msthash="5216">1 significa Bom</li>
                                            <li _msttexthash="367471" _msthash="5217">2 significa Moderado</li>
                                            <li _msttexthash="1362517" _msthash="5218">3 significa insalubre para o grupo sensível</li>
                                            <li _msttexthash="406445" _msthash="5219">4 significa Insalubre</li>
                                            <li _msttexthash="607126" _msthash="5220">5 significa Muito insalubre</li>
                                            <li _msttexthash="376142" _msthash="5221">6 significa Perigoso</li>
                                        </ul>
                                    </td>
                                </tr>
                                <tr>
                                    <td _msttexthash="239577" _msthash="5222">gb-defra-index</td>
                                    <td _msttexthash="99255" _msthash="5223">inteiro</td>
                                    <td _msttexthash="1480440" _msthash="5224">Índice Defra do Reino Unido (Veja a tabela abaixo) </td>
                                </tr>

<br></br>                
**Tabela - UK DEFRA INDEX:** Índice Defra do Reino Unido
<table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th _msttexthash="85358" _msthash="6844">Índice</th>
                                        <th _msttexthash="4459" _msthash="6845">1</th>
                                        <th _msttexthash="4550" _msthash="6846">2</th>
                                        <th _msttexthash="4641" _msthash="6847">3</th>
                                        <th _msttexthash="4732" _msthash="6848">4</th>
                                        <th _msttexthash="4823" _msthash="6849">5</th>
                                        <th _msttexthash="4914" _msthash="6850">6</th>
                                        <th _msttexthash="5005" _msthash="6851">7</th>
                                        <th _msttexthash="5096" _msthash="6852">8</th>
                                        <th _msttexthash="5187" _msthash="6853">9</th>
                                        <th _msttexthash="9451" _msthash="6854">10</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th _msttexthash="55835" _msthash="6855">Banda</th>
                                        <td class="bg_low1" _msttexthash="59852" _msthash="6856">Baixo</td>
                                        <td class="bg_low2" _msttexthash="59852" _msthash="6857">Baixo</td>
                                        <td class="bg_low3" _msttexthash="59852" _msthash="6858">Baixo</td>
                                        <td class="bg_moderate4" _msttexthash="111917" _msthash="6859">Moderado</td>
                                        <td class="bg_moderate5" _msttexthash="111917" _msthash="6860">Moderado</td>
                                        <td class="bg_moderate6" _msttexthash="111917" _msthash="6861">Moderado</td>
                                        <td class="bg_high7" _msttexthash="45149" _msthash="6862">Alto</td>
                                        <td class="bg_high8" _msttexthash="45149" _msthash="6863">Alto</td>
                                        <td class="bg_high9" _msttexthash="45149" _msthash="6864">Alto</td>
                                        <td class="bg_very_high10" _msttexthash="138554" _msthash="6865">Muito alto</td>
                                    </tr>
                                    <tr>
                                        <th><font _mstmutation="1" _msttexthash="110461" _msthash="6866">μgm</font><sup _msttexthash="9399" _msthash="6867">-3</sup></th>
                                        <td class="bg_low1" _msttexthash="21151" _msthash="6868">0-11</td>
                                        <td class="bg_low2" _msttexthash="28717" _msthash="6869">12-23</td>
                                        <td class="bg_low3" _msttexthash="29432" _msthash="6870">24-35</td>
                                        <td class="bg_moderate4" _msttexthash="29289" _msthash="6871">36-41</td>
                                        <td class="bg_moderate5" _msttexthash="29822" _msthash="6872">42-47</td>
                                        <td class="bg_moderate6" _msttexthash="30004" _msthash="6873">48-53</td>
                                        <td class="bg_high7" _msttexthash="30394" _msthash="6874">54-58</td>
                                        <td class="bg_high8" _msttexthash="30472" _msthash="6875">59-64</td>
                                        <td class="bg_high9" _msttexthash="29705" _msthash="6876">65-70</td>
                                        <td class="bg_very_high10" _msttexthash="107692" _msthash="6877">71 ou mais</td>
                                    </tr>
                                </tbody>
                            </table>
                              



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
