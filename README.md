# Gabazar-editoras
[![Build](https://github.com/gabazar/gabazar-editoras/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/gabazar/gabazar-editoras/actions/workflows/build.yml)
[![codecov](https://codecov.io/gh/gabazar/gabazar-editoras/branch/main/graph/badge.svg?token=6INNSA35FZ)](https://codecov.io/gh/gabazar/gabazar-editoras)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=gabazar_gabazar-editoras&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=gabazar_gabazar-editoras) 
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=gabazar_gabazar-editoras&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=gabazar_gabazar-editoras) 
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=gabazar_gabazar-editoras&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=gabazar_gabazar-editoras) 
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=gabazar_gabazar-editoras&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=gabazar_gabazar-editoras)

## Contexto
Esse serviço faz parte do projeto [Gabazar](https://github.com/gabazar/gabazar), esse serviço atende o dominio de Editoras.

## Arquitetura
O serviço utiliza arquitetura hexagonal, todas a integrações externas (controllers, clients, repositories...) estão no pacote de adapters e as regras de negocio estão isoladas no pacote core. 

Contratos externos (ex.: APIs e eventos) não devem ter interação com as regras de negocio, eles devem ser mapeados para uma entidade do dominio e consequentemente enviados para o serviço / caso de uso correspondente.
