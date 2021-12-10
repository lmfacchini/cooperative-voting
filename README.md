EXECUTE

mvn clean install

docker build . -t cooperative-voting

docker-compose up


TESTE

http://localhost:8080/cooperative-voting/swagger-ui.html