# Spring Boot utilizando Redis para Cache


As anotações de cacheamento foram adicionadas no serviço  `PessoaService` devido a um problema de armazenamento no Redis de objetos do tipo `ResponseEntity`, pois este não implementa a Interface `Serializable`.

Trata-se de um problema já conhecido, aparentemente ainda sem solução [veja mais aqui](https://github.com/spring-projects/spring-boot/issues/19401) e [aqui](https://stackoverflow.com/questions/57393650/is-there-any-way-to-store-response-entity-in-redis-cache)

## Subindo a aplicação

Para subir a aplicação, será necessário criar duas instâncias no Docker. Seguem os comandos para criá-las.

### MYSQL
```
$ docker pull mysql/mysql-server:latest
$ docker run -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_ROOT_HOST=% -p 3306:3306 -d mysql/mysql-server
```

### Redis
```
$ docker pull redis:latest
$ docker run -p 6379:6379 -d redis
```
