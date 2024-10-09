mvn clean install
docker build -t berndruecker/claim-handling-fakes:SNAPSHOT .
docker push berndruecker/claim-handling-fakes:SNAPSHOT