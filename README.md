# Gabazar-editoras
[![Build](https://github.com/gabazar/gabazar-editoras/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/gabazar/gabazar-editoras/actions/workflows/build.yml)
[![codecov](https://codecov.io/gh/gabazar/gabazar-editoras/branch/main/graph/badge.svg?token=6INNSA35FZ)](https://codecov.io/gh/gabazar/gabazar-editoras)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=gabazar_gabazar-editoras&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=gabazar_gabazar-editoras) 
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=gabazar_gabazar-editoras&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=gabazar_gabazar-editoras) 
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=gabazar_gabazar-editoras&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=gabazar_gabazar-editoras) 
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=gabazar_gabazar-editoras&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=gabazar_gabazar-editoras)

Esse serviço faz parte do projeto [Gabazar](https://github.com/gabazar/gabazar), esse serviço atende o dominio de Editoras.

## Quickstart

Para testar a ultima versão:
```bash
$ cd gabazar-editoras\infra\dev
$ docker-compose up
```

Endpoints:

`[POST]` /editoras \
`[GET]` /editoras \
`[GET]` /editoras/{id} \
`[PUT]` /editoras/{id} \
`[DELETE]` /editoras/{id}

Model:
```json
{
    "id": "6a340ac1-c164-4575-a105-97e9bb7665e1",
    "nome": "Editora Teste Ltda",
    "cnpj": "11.111.111/0001-01",
    "site": "https://www.google.com.br/",
    "usuarioCriacao": "Bob",
    "usuarioAlteracao": null,
    "dataCriacao": "25/01/2022 15:00:00",
    "dataAlteracao": null
}
```

## Configuração

### Desenvolvimento

Para rodar localmente é necessario configurar as seguintes variaveis:

| Variavel          | Mandatória | Descrição | Exemplo |
| --                | --         | --        | --      |
| POSTGRES_URL      | S | URL JDBC  | jdbc:postgresql://localhost:5432/dev |
| POSTGRES_USER     | S | Usuario para acesso banco de dados     | postgres  | 
| POSTGRES_PASSWORD | S | Senha para acesso banco de dados       | p0$tgr3s  |
| DB_TIMEOUT        | N | Timout para conexão com banco da dados | default: 20000 |
| DB_MAX_POOL       | N | Tamanho do pool de conexão             | default: 5 |

Para execução de testes é utilizado o `application-test.properties`, o mesmo esta configurado para conexão com o H2 (banco dados em memória).

As variaveis citadas também podem ser setadas hard code no arquivo `application-local.properties` ou informados via parametros na criação do container.

Para trocar o tipo de arquivo utilizado configure a seguinte variavel na IDE:

```
spring.profiles.active=local
```

### Container

Para criar uma image do código atual basta comentar a tag `skip` no arquivo POM (ou alterar o valor para false):
```xml
<plugin>
    <groupId>com.spotify</groupId>
    <artifactId>dockerfile-maven-plugin</artifactId>
    <version>${dockerfile-maven-version}</version>
    <executions>
        <execution>
            <id>default</id>
            <goals>
                <goal>build</goal>
                <goal>push</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <repository>${docker.image.prefix}/${project.artifactId}</repository>
        <tag>${project.version}</tag>
        <!-- <skip>true</skip> -->
    </configuration>
</plugin>
```

Após comentar essa tag é só rodar um build que no final ele vai gerar uma imagem local (~5min.):
```
mvn clean install
```

Para confirmar se a imagem foi gerada execute o seguinte comando:
```
docker images
```

Para subir a nova imagem, vá até a pasta /infra/dev e execute:
```
docker-compose up
```

## Testes

Os testes devem possuir o mesmo pacote das classes que estão testando com o adição do sufixo do tipo de teste que sera realizado.

### *UT - Unit Test
Os teste unitarios testam apenas o conteudo da classe, suas regras de negocio e as chamadas externas são mockadas.

Ex.: ApagarEditoraUseCaseImpl**UT**.java

### *IT - Integration Test
Os testes de integração testam a comunicação entre as classes, realizando chamadas reais para validar comportamentos mais abrangentes. Esse teste não valida todos os comportamentos das classes envolvidas, o foco é o fluxo para execução dos casos de uso.

Ex.: EditoraController**IT**.java
