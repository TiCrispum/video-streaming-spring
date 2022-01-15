# video-streaming-spring

A simple video streaming service written in Spring

## bare-bones (hardware):

To install dependencies and generate the deployable jar: `mvn clean install`

To run in development (using devtools, live reloads): `mvn spring-boot:run`

To run in prod: `java -Xmx200m -jar target/video-streaming-spring-0.0.1.jar`

Please set the environment variable PORT with the desired port you want the application to listen on before running the application, otherwise it'll fail (even `mvn clean install` won't run unless you disable maven tests).

e.g. use `export PORT=3000`

## In a container:

Build the image: `docker build -t video-streaming-spring --file Dockerfile .`

Run in a container: `docker run -d -p $PORT:$PORT -e PORT video-streaming-spring`
