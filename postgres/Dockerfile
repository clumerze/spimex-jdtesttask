FROM ubuntu
ENV TZ=Europe/Moscow
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN apt-get update
RUN echo "deb http://apt.postgresql.org/pub/repos/apt/ precise-pgdg main" > /etc/apt/sources.list.d/pgdg.list
RUN apt-get install -y postgresql-14

USER postgres
RUN echo "host all  all    0.0.0.0/0  md5" >> /etc/postgresql/14/main/pg_hba.conf
RUN /etc/init.d/postgresql start &&\
    psql -c "CREATE USER jdtesttask WITH SUPERUSER PASSWORD 'jdtesttask';" &&\
    createdb -O jdtesttask jdtesttask
RUN echo "listen_addresses='*'" >> /etc/postgresql/14/main/postgresql.conf


EXPOSE 5432

CMD ["/usr/lib/postgresql/14/bin/postgres", "-D", "/var/lib/postgresql/14/main", "-c", "config_file=/etc/postgresql/14/main/postgresql.conf"]
