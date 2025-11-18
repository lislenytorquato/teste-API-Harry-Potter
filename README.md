# Teste da API de Livros do Harry Potter
Este é um projeto de testes automatizado da API [fedeperin/potterapi](https://github.com/fedeperin/potterapi) no github. 
Ela é uma API com endpoints que retornam os livros, personagens, feitiços e as casas:

<code>GET /[lang]/books</code>

<code>GET /[lang]/characters</code>

<code>GET /[lang]/spells</code>

<code>GET /[lang]/house</code>


- Você pode buscar todos  
- ou você pode bucar apenas um por <code>index</code>
  * em books, <code>index</code> é de 0 - 7
  * em characters, o <code>index</code> é de 0 - 24
  * em spells, o <code>index</code> é de 0 - 71
  * em house, o <code>index</code> é de 0 - 3
- Você pode buscar até um número máximo com <code>max</code>
- O <code>page</code> só deve ser usado junto com o max, para formar grupos.
- você pelo texto do titulo com <code>search</code>
----------------

## Planejamento de Teste

### Calendário
Data de início: 14/11/25
<br>Data de término: 17/11/25

### Escopo

<code>GET /[lang]/books</code>

<code>GET /[lang]/characters</code>

<code>GET /[lang]/spells</code>

<code>GET /[lang]/house</code>

Lang = en,es,fr,it,pt,uk,
<br>Os testes serão feitos usando uma variável lang para testes que repetem para todos os idioma e haverá testes para verificar a tradução. 

### Abordagem
Testes Automatizados

## Casos de Testes
### GET /[lang]/books
- __<p style = "color: lightgreen"> CT01 Cenário: Ao buscar livros, a quantidade de livros listados deve ser 8 no idioma escolhido__</p>
  1. Dado que quero listar todos os livros do Harry Potter na URL https://potterapi-fedeperin.vercel.app
  2. Quando enviar GET /[lang]/books
  3. E lang = en,es,fr,it,pt,uk
  3. Então é retornado código 200, e uma lista de 8 livros
- __<p style="color:#6495ED">Resultado Esperado:__</p>
  -  É esperado que retorne 200,e a lista de 8 livros
- __<p style="color: #F08080"> Resultado Obtido:__</p>
  * retornou 200,e a lista de 8 livros
- __<p style="color: #FFB6C1"> Status: SUCESSO__</p>
- __<p style="color: LightSkyBlue"> Observação:__</p>
----------------------------------------------------------

- __<p style = "color: lightgreen"> CT02 Cenário:Ao buscar livros, a quantidade de livros listados deve ser maior que 0 no idioma escolhido__</p>
  1. Dado que quero listar todos os livros do Harry Potter na URL https://potterapi-fedeperin.vercel.app
  2. Quando enviar GET /[lang]/books
  3. E lang = en,es,fr,it,pt,uk
  3. Então é retornado código 200, e uma lista maior que 0 livros
- __<p style="color:#6495ED">Resultado Esperado:__</p>
  -  É esperado que retorne 200,e uma lista maior que 0 livros
- __<p style="color: #F08080"> Resultado Obtido:__</p>
  * codigo 200 e uma lista maior que 0 livros
- __<p style="color: #FFB6C1"> Status: SUCESSO__</p>
- __<p style="color: LightSkyBlue"> Observação:__</p>
----------------------------------------------------------

- __<p style = "color: lightgreen"> CT03 Cenário: Ao buscar livros usando index vàlido no idioma escolhido deve retornar o livro com o index escolhido__</p>
  1. Dado que quero listar todos os livros do Harry Potter na URL https://potterapi-fedeperin.vercel.app
  2. Quando enviar GET /[lang]/books
  3. E lang = en,es,fr,it,pt,uk
  4. E query param index = 2
  5. Então é retornado código 200, e o 3º livro
- __<p style="color:#6495ED">Resultado Esperado:__</p>
  * código 200, e o 3º livro
- __<p style="color: #F08080"> Resultado Obtido:__</p>
  * código 200, e o 3º livro
- __<p style="color: #FFB6C1"> Status: SUCESSO__</p>
- __<p style="color: LightSkyBlue"> Observação:__</p>
----------------------------------------------------------

- __<p style = "color: lightgreen"> CT04 Cenário: Ao buscar livros usando index invàlido no idioma escolhido deve retornar mensagem de erro__</p>
  1. Dado que quero listar todos os livros do Harry Potter na URL https://potterapi-fedeperin.vercel.app
  2. Quando enviar GET /[lang]/books
  3. E lang = en,es,fr,it,pt,uk
  4. E query param index = 8
  5. Então é retornado código 404, e "error":"Invalid Index"
- __<p style="color:#6495ED">Resultado Esperado:__</p>
  * código 404, e "error":"Invalid Index"
- __<p style="color: #F08080"> Resultado Obtido:__</p>
  * Expected status code <404> but was <200>.
- __<p style="color: #FFB6C1"> Status:FALHOU__</p>
- __<p style="color: LightSkyBlue"> Observação:__</p>
----------------------------------------------------------

- __<p style = "color: lightgreen"> CT05 Cenário: Ao buscar livros usando max válido no idioma escolhido deve retornar os livros com o number até o max escolhido__</p>
  1. Dado que quero listar todos os livros do Harry Potter na URL https://potterapi-fedeperin.vercel.app
  2. Quando enviar GET /[lang]/books
  3. E lang = en,es,fr,it,pt,uk
  4. max = 2
  5. Então é retornado código 200, e o 1º e 2º livro
- __<p style="color:#6495ED">Resultado Esperado:__</p>
- __<p style="color: #F08080"> Resultado Obtido:__</p>
  *
- __<p style="color: #FFB6C1"> Status:__</p>
- __<p style="color: LightSkyBlue"> Observação:__</p>
----------------------------------------------------------

- __<p style = "color: lightgreen"> CT06 Cenário: Ao buscar livros usando max e page válidos no idioma escolhido deve retornar os livros do grupo indicado__</p>
  1. Dado que quero listar todos os livros do Harry Potter na URL https://potterapi-fedeperin.vercel.app
  2. Quando enviar GET /[lang]/books
  3. E lang = en,es,fr,it,pt,uk
  4. max = 2
  5. page = 2
  6. Então é retornado código 200, e o 3º e 4º livro
- __<p style="color:#6495ED">Resultado Esperado:__</p>
- __<p style="color: #F08080"> Resultado Obtido:__</p>
  *
- __<p style="color: #FFB6C1"> Status:__</p>
- __<p style="color: LightSkyBlue"> Observação:__</p>
----------------------------------------------------------

__<p style = "color: lightgreen"> CT07 Cenário: Ao buscar livros usando max e page inválidos no idioma escolhido deve retornar mensagem de erro__</p>
1. Dado que quero listar todos os livros do Harry Potter na URL https://potterapi-fedeperin.vercel.app
2. Quando enviar GET /[lang]/books
3. E lang = en,es,fr,it,pt,uk
4. E max = 2
5. page = 6
6. Então é retornado código 404, error: "Invalid Params"
- __<p style="color:#6495ED">Resultado Esperado:__</p>
- __<p style="color: #F08080"> Resultado Obtido:__</p>
  *
- __<p style="color: #FFB6C1"> Status:__</p>
- __<p style="color: LightSkyBlue"> Observação:__</p>
----------------------------------------------------------


__<p style = "color: lightgreen"> CT08 Cenário: Ao buscar livros usando search no idioma escolhido deve retornar os livros do Titulo buscado__</p>
1. Dado que quero listar todos os livros do Harry Potter na URL https://potterapi-fedeperin.vercel.app
2. Quando enviar GET /[lang]/books
3. E lang = en,es,fr,it,pt,uk
4. search = Harry
5. Então é retornado código 200, e todos os livros
- __<p style="color:#6495ED">Resultado Esperado:__</p>
- __<p style="color: #F08080"> Resultado Obtido:__</p>
  *
- __<p style="color: #FFB6C1"> Status:__</p>
- __<p style="color: LightSkyBlue"> Observação:__</p>
----------------------------------------------------------