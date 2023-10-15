# NFL Standings

El Gestor de Clasificación de la NFL es una aplicación de escritorio diseñada para simplificar la gestión y visualización de la clasificación de la NFL y listas de equipos.  Ofrece una variedad de características clave para ayudarte a agilizar la gestión de datos de la NFL.

## Características Clave

### Creador de Clasificaciones

Genera y personaliza fácilmente tablas de clasificación de la NFL para diferentes temporadas. La aplicación ofrece una interfaz fácil de usar para crear y gestionar clasificaciones.

###  Gestión de Equipos

Mantén bases de datos detalladas de los equipos de la NFL, todo ello dentro de un entorno de escritorio. Haz un seguimiento del rendimiento de los equipos y de los datos de manera eficiente.

## Instalación

### Instalar un Archivo JAR

  1. Descargar el Archivo JAR:
Puedes descargar el archivo JAR desde <a href="https://github.com/nao-f-lll/NFL-Standings/releases/download/v0.4-beta/Standings_0.4_x64.jar" target="_blank" rel="noopener noreferrer">standings.jar</a>


  2. Abrir una Terminal o Símbolo del Sistema:
Dirígete al directorio donde descargaste el archivo JAR utilizando tu terminal o símbolo del sistema.

  4. Ejecutar el Archivo JAR:
Para ejecutar el archivo JAR, utiliza el comando
```bash
java -jar standings.jar
```

### Instalar Usando Docker

1. Descargar la Imagen de Docker:
Para ejecutar la aplicación con Docker, debes descargar la imagen de [Docker](https://hub.docker.com/r/naooff/nfl-standings) desde el termenal

```bash
docker pull naooff/nfl-standings:[version]
```
2. Ejecutar el Contenedor Docker:
   Puedes ejecutar el contenedor Docker utilizando el comando
   
```bash
sudo docker run -e DISPLAY=$DISPLAY -v /tmp/.X11-unix:/tmp/.X11-unix -d naooff/nfl-standings:[version]
```
## Contribuciones

Las contribuciones a este repositorio están limitadas a empleados internos de la NFL.

## Licencia

Esta aplicación de escritorio interna está sujeta a las políticas y regulaciones internas de la NFL. Está destinada para uso interno y no está disponible para uso o distribución pública.
