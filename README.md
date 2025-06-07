# 🍔 Projeto Java de Consumo de API com Thymeleaf

Este projeto simula um site de delivery utilizando Java, onde os dados de comidas, restaurantes e usuários são consumidos de uma API e injetados dinamicamente em templates HTML com Thymeleaf.

## 🛠 Tecnologias Utilizadas

- Java  
- Thymeleaf  
- HTML/CSS  
- Consumo de API via Java   

## 📄 Descrição do Projeto

O sistema é composto por dois arquivos principais HTML:

- `index.html`: Simula a página inicial do site de delivery.  
- `food.html`: Simula a página de detalhes de comidas, com base na escolha do usuário.  

Esses HTMLs utilizam tags Thymeleaf, que são processadas pelo backend Java para gerar arquivos HTML finais com os dados da API já inseridos.

## 🎯 Objetivo

Demonstrar como consumir uma API em Java, processar os dados e renderizar páginas HTML com conteúdo dinâmico pré-carregado, diferindo de abordagens client-side como React ou Angular.

## 📦 Estrutura do Projeto

- `App.java`: Arquivo principal que coordena o processamento das três entidades principais e a geração dos arquivos HTML finais com os dados da API.  
- `Food.java`, `Restaurant.java`, `User.java`: Classes que representam os modelos de dados.  
- `FoodService.java`, `RestaurantService.java`, `UserService.java`: Responsáveis por fazer as requisições à API e retornar os dados estruturados.  

## ⚙️ Funcionamento

1. O programa inicia com o `App.java`.  
2. São feitas as requisições para a API através das classes `*Service`.  
3. Os dados retornados são usados para preencher os templates HTML via Thymeleaf.  
4. Dois arquivos HTML de saída são gerados, já com todo o conteúdo renderizado.  

> 🔄 Diferente de aplicações em tempo real, como React ou AngularJS, este projeto gera os templates prontos no backend. Assim, o usuário já recebe todo o conteúdo estruturado ao acessar a página, sem requisições dinâmicas após o carregamento.

## 📁 Saídas Geradas

- `index_output.html`  
- `food_output.html`  

Esses arquivos representam as páginas completas, já com os dados da API embutidos.

## 🚀 Como Executar

1. Compile o projeto Java.  
2. Execute `App.java`.  
3. Acesse os arquivos de saída para visualizar o resultado final.

## 👤 Autor

    Gabriel – Estudante de Informática
    Projeto desenvolvido como prática de utilização de Java para web.

## Link de Acesso

    https://gabrielkazak.github.io/DeliveryJava/
