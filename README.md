
<h1 align="center">  NFL Standings </h1>
<p align="center">
 <!-- <img src=".github/readme-images/app-icon.png" alt="app icon" width="200"> -->

   <img src="https://github.com/nao-f-lll/NFL-Standings/blob/main/.github/readme-images/app-icon.png" alt="app icon" width="200">
</p>


 | Windows                                                                                                       |  Linux                           | Docker | Stable Release| Preview Release |
|------------------------------------------------------------------------------------------------------------|-------------------------------------------------------|-------|-----| ----------|
| [![Static Badge](https://img.shields.io/badge/Stable-Download-0078D4?logo=Windows)](https://github.com/nao-f-lll/NFL-Standings/releases/download/v0.1-beta/standings_0.1_x64_windows_.exe) |  [![Static Badge](https://img.shields.io/badge/Stable-Download-FCC624?logo=Linux)](https://github.com/nao-f-lll/NFL-Standings/releases/download/v0.3-beta/Standings_0.3_x64_linux_portable.tar) |    [![Static Badge](https://img.shields.io/badge/Docker-Download-2496ED?logo=Docker)](https://hub.docker.com/r/naooff/nfl-standings) |      [![Static Badge](https://img.shields.io/badge/Stable-Release-21B352?logo=sellfy)]( )           |            [![Static Badge](https://img.shields.io/badge/Preview-Release-DA552F?logo=producthunt)](https://github.com/nao-f-lll/NFL-Standings/releases/tag/v0.4-beta)       


<p>
El Gestor de Clasificación de la NFL es una aplicación de escritorio diseñada para simplificar la gestión y visualización de la clasificación de la NFL y listas de equipos.  
</p>


## Características Clave

* ### Creador de Clasificaciones

Genera y personaliza fácilmente tablas de clasificación de la NFL para diferentes temporadas. La aplicación ofrece una interfaz fácil de usar para crear y gestionar clasificaciones.

* ###  Gestión de Equipos

Mantén bases de datos detalladas de los equipos de la NFL, todo ello dentro de un entorno de escritorio. Haz un seguimiento del rendimiento de los equipos y de los datos de manera eficiente.

## Instalación

### Instalar un Archivo JAR

  1. Descargar el Archivo JAR:
Puedes descargar el archivo JAR desde <a href="https://github.com/nao-f-lll/NFL-Standings/releases/download/v0.3-beta/Standings_0.3_x64.jar" target="_blank" rel="noopener noreferrer">standings.jar</a>

  2. Descargar y instalar el Java runtime enviarment: puedes descargar java desde <a href="https://javadl.oracle.com/webapps/download/AutoDL?BundleId=249185_b291ca3e0c8548b5a51d5a5f50063037" target="_blank" rel="noopener noreferrer">Java Runtime</a>

  3. Abrir una Terminal o Símbolo del Sistema:
Dirígete al directorio donde descargaste el archivo JAR utilizando tu terminal o símbolo del sistema.

  4. Ejecutar el Archivo JAR:
Para ejecutar el archivo JAR, utiliza el comando
```bash
java -jar standings_[version]_x64.jar
```

### Instalar Usando Docker

1. Descargar la Imagen de Docker:
Para ejecutar la aplicación con Docker, debes descargar la imagen de [Docker](https://hub.docker.com/r/naooff/nfl-standings) desde el terminal

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
