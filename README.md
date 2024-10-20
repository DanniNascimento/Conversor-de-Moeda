# Conversor de Moedas

Este projeto é um conversor de moedas desenvolvido em Java, que permite ao usuário realizar conversões entre diferentes moedas de forma dinâmica, utilizando uma API externa para obter as taxas de câmbio em tempo real. O programa oferece uma interface simples via console, onde o usuário pode inserir as moedas de origem e destino, além do valor a ser convertido.

## Funcionalidades

- **Conversão entre qualquer moeda**: O usuário pode escolher livremente as moedas de origem e destino.
- **Taxas de câmbio em tempo real**: As taxas são obtidas através da [ExchangeRate-API](https://www.exchangerate-api.com/).
- **Interface amigável**: Interação fácil por meio de um menu no console.
- **Suporte a múltiplas conversões**: Após cada conversão, o usuário pode escolher se deseja realizar uma nova conversão ou sair do programa.

## Como o projeto funciona

1. O programa exibe um menu inicial dando boas-vindas ao usuário.
2. O usuário é solicitado a inserir o código da moeda de origem (ex.: "USD", "EUR", "BRL").
3. Em seguida, o usuário deve inserir o código da moeda de destino.
4. O usuário insere o valor que deseja converter.
5. O programa se conecta a uma API para buscar a taxa de câmbio entre as moedas e calcula o valor convertido.
6. O valor convertido é exibido na tela.
7. O usuário pode optar por realizar outra conversão ou encerrar o programa.

## Como executar o projeto

### Pré-requisitos

- **Java JDK 8** ou superior instalado em seu sistema.
- Conexão com a internet para buscar as taxas de câmbio em tempo real.

### Passos para executar:

1. Clone o repositório para sua máquina local:
   ```bash
   git clone https://github.com/DanniNascimento/conversor-moedas.git

2. Navegue até o diretório do projeto:
   ```bash
   cd conversor-moedas

3. Compile o projeto:
    ```bash
        javac ConversorMoeda.java
 
4. Execute o programa:
   ```bash
       java ConversorMoeda

  ## Exemplo de uso:
  ```plaintext
    
      Bem-vindo ao seu Conversor de Moedas!
      Você pode converter qualquer moeda.
      Digite '0' a qualquer momento para sair.

      Digite o código da moeda de origem (ou 0 para sair): USD
      Digite o código da moeda de destino (ou 0 para sair): BRL
      Digite o valor que deseja converter: 100
      O valor de 100.00 USD corresponde a 495.20 BRL

      Digite 1 para fazer outra conversão ou 0 para sair: 0
      Obrigado por usar nosso Conversor de Moedas.
```
### Tecnologias Utilizadas

    Java: Linguagem de programação principal.
    ExchangeRate-API: API utilizada para obter as taxas de câmbio.
    Gson: Biblioteca para parseamento de JSON, usada para interpretar os dados da API.
    
###  Estrutura do Projeto

    O projeto é composto por três classes principais:

    Menu: Exibe as instruções e orienta o usuário sobre como usar o conversor.
    Conversao: Responsável por obter as taxas de câmbio da API e calcular o valor convertido.
    ConversorMoeda: Classe principal que orquestra a interação com o usuário e a execução das conversões.
    
   ### Api Utilizada

     Este projeto utiliza a ExchangeRate-API para obter taxas de câmbio. Para isso, você precisa de uma chave de API,
     que pode ser obtida gratuitamente no site oficial.
     Na classe Conversao, substitua a chave de API pelo valor que você receber ao se cadastrar no site:
    
   ```java
    private static final String API_KEY = "sua_chave_de_api";
