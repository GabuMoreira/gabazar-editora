# Gabazar-editoras [![Build Status](https://app.travis-ci.com/gabazar/gabazar-editoras.svg?branch=main)](https://app.travis-ci.com/gabazar/gabazar-editoras) [![codecov](https://codecov.io/gh/gabazar/gabazar-editoras/branch/main/graph/badge.svg?token=6INNSA35FZ)](https://codecov.io/gh/gabazar/gabazar-editoras)
Gabazar MS Editoras

## Contexto
Esse serviço faz parte do projeto [Gabazar](https://github.com/gabazar/gabazar), esse serviço atende o dominio de Editoras.

## Arquitetura
O serviço utiliza arquitetura hexagonal, todas a integrações externas (controllers, clients, repositories...) estão no pacote de adapters e as regras de negocio estão isoladas no pacote core. 

Contratos externos (ex.: APIs e eventos) não devem ter interação com as regras de negocio, eles devem ser mapeados para uma entidade do dominio e consequentemente enviados para o serviço / caso de uso correspondente.
