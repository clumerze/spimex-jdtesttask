./gradlew clean build -Dorg.gradle.java.home=/opt/java/17_0_2 -x test
docker-compose -f ./api/docker-compose.yml up --force-recreate --build
