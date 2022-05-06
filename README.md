# Houseportal backend

## Sommaire

- [Houseportal backend](#houseportal-backend)
  - [Sommaire](#sommaire)
  - [Getting started to develop](#getting-started-to-develop)
    - [Requirements](#requirements)
    - [Build container](#build-container)
    - [Start the hot-reload server](#start-the-hot-reload-server)

## Getting started to develop

### Requirements

You need a working config of

- [Docker](https://www.docker.com/)
- [VS Code](https://code.visualstudio.com/) (recomended)
- [Remote-Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) extension

### Build container

Theorically, you juste need to exec the following command in the command palette (`Shift` + `Ctrl` + `P`) :

```shell
Remote-Containers: Reopen in container
```

### Start the hot-reload server

Then in the integrated terminal type :

```shell
mvn wildfly-jar:dev-watch
```

## Tests

Just run :

```shell
mvn test
```

## Database

For the moment we use a MySql database hosted here : [https://remotemysql.com/](https://remotemysql.com/)
