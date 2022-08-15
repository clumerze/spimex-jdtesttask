FROM ubuntu
ENV TZ=Europe/Moscow
EXPOSE 4444

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN apt-get update
RUN apt-get install -y openjdk-17-jre

RUN apt-get install -y postgresql-client


WORKDIR /app
COPY ./build/libs/api-0.0.1-SNAPSHOT.jar ./api.jar
COPY ./startup.sh ./

RUN chmod +x startup.sh
CMD ["./startup.sh"]
