REM to build local docker file named Dockerfile
REM docker build .

REM if docker file name is something else then Dockerfile then use -f flag with docker file path and name
REM docker build -f Dockerfile .

REM to give a name to docker image getting created with Dockerfile give tag using -t imagename:version[optional]
docker build -t samplespringbootservice -f Dockerfile .

REM to list locally available images
docker ps

REM to run docker image
REM docker run samplespringbootservice

REM to be able to connect to running service from local we can bind the port using -p <host ip>[optional]:<host port>:<container port>
docker run -p 6060:8080 samplespringbootservice

REM to check if service is running
REM curl http://localhost:6060/