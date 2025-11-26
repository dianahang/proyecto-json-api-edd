# Proyecto: Lector de API de Rick and Morty

<!--toc:start-->
-   [Guía rápida](#guía-rápida)
    -   [Introducción](#introducción)
        -   [Objetivo](#objetivo)
        -   [Prerrequisitos](#prerrequisitos)
        -   [Stack](#stack)
    -   [Contenido](#contenido)
    -   [Detalles](#detalles)
    -   [Autores](#autores)
    -   [Créditos](#créditos)

<!--toc:end-->

## Introducción

Este proyecto consiste en un programa desarrollado en Java, configurado con el gestor de dependencias Maven, cuyo propósito es consumir una API (de Rick and Morty), interpretar el contenido JSON y mostrar los resultados en consola de manera clara y formateada.

El sistema se conecta a un endpoint remoto mediante el protocolo HTTP, descarga los datos de los personajes, los procesa utilizando las clases `JSONObject` y `JSONArray`, y posteriormente los imprime con orden visual para facilitar su lectura.


> \[¡NOTA!\] Este proyecto tiene fines educativos y está pensado para quienes desean aprender:
> - Cómo funciona Maven
> - Cómo consumir una API desde Java
> - Cómo manipular estructuras JSON

### Objetivo

El objetivo principal es ofrecer una guía práctica y sencilla para comprender cómo:

- Consumir una API REST desde Java
- Manejar flujos de datos desde una conexión HTTP
- Interpretar JSON utilizando objetos nativos (`JSONObject`, `JSONArray`)

Este proyecto sirve como introducción al desarrollo backend básico.

### Prerrequisitos

Para ejecutar este proyecto, asegúrese de contar con:

-   Java 11 o superior instalado y configurado.
- Apache Maven instalado (versión 3.8+ recomendada).
- Un IDE compatible, como:
    - **Eclipse**
    - **IntelliJ IDEA**
    - **VS Code** con extensión de Java
- Acceso a internet (la API es remota).
- Archivo pom.xml correctamente configurado con las dependencias:
    - `org.json`
    - `okhttp` (para peticiones más avanzadas)

### Stack

Este proyecto utiliza:

-   Java 11+
- Maven como sistema de gestión del proyecto
- HttpURLConnection para conectarse a la API
- InputStream para la lectura de datos desde la conexión HTTP
- JSONObject para interpretar objetos en formato JSON
- JSONArray para navegar listas de elementos dentro de la respuesta JSON
- Endpoint:

            https://rickandmortyapi.com/api/character

## Contenido

Este repositorio incluye:

-   **Archivo Principal**\
    Archivo de Java `LectorJSON.java` que realiza la conexión HTTP, lee el flujo de bytes y se interpreta con JSON para después obtener y mostrar los datos de la API con un formato amigable.

-   **Árbol del proyecto Maven**\
    RickAndMortyAPI/ \
    └─ src/ \
            ├─ main/ \
            │   ├─ java/ \
            │   │   └─ api/ \
            │   │       └─ LectorJSON.java \
            │   └─ resources/ \
            └─ test/ \
    └─ pom.xml

-   **Manual (README.md)**\
    Archivo `README.md` (documentación) con explicaciones, notas y estructura interna del
    proyecto.

## Detalles

El proyecto está diseñado para entender conceptos fundamentales:

- **¿Qué es una API?**

    Una API (Application Programming Interface) es una interfaz que permite solicitar información desde un servidor.
En este caso, se realizó una petición GET a la API de Rick and Morty y se reciben datos en formato JSON.

- **¿Por qué usar JSONObject y JSONArray?**

La estructura de la API tiene:

- Un objeto JSON
- Un arreglo "results" que contiene cada personaje en forma de objeto

Debido a esto se utilizó `JSONObject`, pues interpreta estructuras de datos en `{clave : valor}` y a su vez `JSONArray`, que interpreta las listas de estos objetos JSON.

**¿Por qué se utiliza InputStream?**

Al realizar una petición HTTP, el servidor envía bytes, así que la superclase abstracta `InputStream` permite recibir estos bytes y transformarlos a texto, para que sea legible.


> \[TIP!\] Se puede ampliar el proyecto añadiendo una interfaz gráfica que despliegue la información de los personajes con sus debidas imágenes (frontend).

  *Se puede acceder al proyecto a través de:* [Consume API with JSON](https://github.com/DianaHang/proyecto-json-api-edd)

## Autores

-   García Melgarejo Diana Karina.

## Referencias

Este proyecto hace uso de la API pública:

- Rick and Morty API — https://rickandmortyapi.com/api/character

Y fue desarrollado con fines académicos utilizando Java y Maven.

- Otras referencias:
    - [Consumir una API y deserealizar objeto en JSON en Java](https://youtu.be/9KbsEVZ405Y)
    - [Oracle: Abstract class InputStream ](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html)
    - [Class ObjectMapper](https://fasterxml.github.io/jackson-databind/javadoc/2.7/com/fasterxml/jackson/databind/ObjectMapper.html)
    - [Stack Overflow: Correct set of dependencies for using jackson mapper](https://stackoverflow.com/questions/18429468/correct-set-of-dependencies-for-using-jackson-mapper)

