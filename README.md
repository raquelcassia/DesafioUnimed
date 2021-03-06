# Desafio 01 - Site Unimed
>Desafio de Testes Automatizados no site Unimed

---
 
Criar um projeto de automação utilizando BDD e em linguagem de programação de sua
preferência os cenários para as duas funcionalidades abaixo:

1. No site https://www.unimed.coop.br/ validar a seguinte sequência de ações:

```
• Acessar Guia Médico 
• Realizar uma pesquisa de médicos no Rio de Janeiro. (Busca rápida)
• Validar a apresentação dos resultados com a Especialidade e Cidade.
 ```
 
2. No mesmo site, validar:

```
• Acessar Guia Médico 
• Realizar uma pesquisa de médicos no Rio de Janeiro. 
• Validar nas páginas 1, 2, e 3 do resultado, NÃO apresentação do resultado com cidade São Paulo  
```

---
 
## Resumo do Projeto

- Dentro da pasta principal `DesafioUnimed` temos os pages, utilitário e os cenarios de teste. 
- Em `unimedpages` ficam nossos elementos e métodos da página.
- Em `testspages` ficam os cenários de teste.
- Em `utils` ficam os métodos auxiliáres que podemos usar dentro de todo o projeto.

---

## Casos de Teste

```
1. Validação da apresentação dos resultados com a Especialidade e Cidade.
2. Validação da apresentação dos resultados com a Especialidade e Cidade (bug).
3. Validação da não apresentação de resultados com cidade SP ao pesquisar por Rio de janeiro nas 1ª, 2ª e 3ª paginas, navegando pelas setas.
4. Validação da não apresentação de resultados com cidade SP ao pesquisar por Rio de janeiro nas 1ª, 2ª e 3ª paginas, navegando pela numeração.

```
---

## Requisitos

- [JDK install +8](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Eclipse IDE install](http://www.eclipse.org/downloads/)
- [Cucumber e Selenium](https://automacaoforadacaixa.wordpress.com/2017/05/01/1-configuracao-ambiente-selenium-e-cucumber/)
