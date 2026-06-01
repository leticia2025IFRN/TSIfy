# TSIfy, Tocador de Música em Java

Este projeto é para a atividade da disciplina de Análise e Projetos de Sistemas Web, com o objetivo de finalizar a implementação feita em sala de aula, ajustar o projeto para a utilização da fachada de Front-end e dos controladores, e atualizar o diagrama de classes com todas as funcionalidades implementadas.

## Detalhes

**Data de entrega:** 01/06/2026 às 13:00.
**Aluno(a):** Letícia Geovana Lopes dos Santos.

## Scaffolding do Projeto

```
./Tsfy
├── diagrams
│   └── classes-uml.md
├── LICENSE
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   └── java
│   │       └── br
│   │           └── edu
│   │               └── ifpar
│   │                   └── tsi3
│   │                       └── tsfy
│   │                           ├── controladores
│   │                           │   ├── MusicaControlador.java
│   │                           │   ├── PlaylistControlador.java
│   │                           │   └── UsuarioControlador.java
│   │                           ├── dominio
│   │                           │   ├── Musica.java
│   │                           │   ├── Playlist.java
│   │                           │   └── Usuario.java
│   │                           ├── main
│   │                           │   └── Main.java
│   │                           └── UI
│   │                               ├── fachada
│   │                               │   └── FachadaFrontend.java
│   │                               ├── TsfyUIDesktop.java
│   │                               └── TsfyUI.java
│   └── test
│       └── java
└── target
    ├── classes
    │   └── br
    │       └── edu
    │           └── ifpar
    │               └── tsi3
    │                   └── tsfy
    │                       ├── controladores
    │                       │   ├── MusicaControlador.class
    │                       │   ├── PlaylistControlador.class
    │                       │   └── UsuarioControlador.class
    │                       ├── dominio
    │                       │   ├── Musica.class
    │                       │   ├── Playlist.class
    │                       │   └── Usuario.class
    │                       ├── main
    │                       │   └── Main.class
    │                       ├── servicos
    │                       │   ├── MusicaServico.class
    │                       │   ├── PlaylistServico.class
    │                       │   └── UsuarioServico.class
    │                       └── UI
    │                           ├── fachada
    │                           │   └── FachadaFrontend.class
    │                           ├── TsfyUI.class
    │                           └── TsfyUIDesktop.class
    ├── generated-sources
    │   └── annotations
    ├── maven-status
    │   └── maven-compiler-plugin
    │       └── compile
    │           └── default-compile
    │               ├── createdFiles.lst
    │               └── inputFiles.lst
    └── test-classes
```

### Dependências

> [!IMPORTANT]
> - [ ] Realizar o mapeamento das depedências do projeto (se necessário).
