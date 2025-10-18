# ----------------------------------
# STAGE 1: Build the Application
# ----------------------------------
FROM eclipse-temurin:17-jdk-focal AS builder

WORKDIR /app

# Instalar SBT
ENV SBT_VERSION=1.9.8
RUN curl -sL "https://github.com/sbt/sbt/releases/download/v${SBT_VERSION}/sbt-${SBT_VERSION}.tgz" \
  | tar xz -C /usr/share/ && \
  ln -s /usr/share/sbt/bin/sbt /usr/bin/sbt

RUN apt-get update && apt-get install -y unzip && rm -rf /var/lib/apt/lists/*

# Copiar archivos del proyecto
COPY build.sbt .
COPY project/ project/
COPY app/ app/
COPY conf/ conf/

# Compilar y crear el paquete
RUN sbt clean compile dist

# Descomprimir el paquete generado
RUN unzip target/universal/graphql-test-*.zip -d target/universal/ && \
    mv target/universal/graphql-test-1.0-SNAPSHOT target/universal/stage


# ----------------------------------
# STAGE 2: Runtime Image
# ----------------------------------
FROM eclipse-temurin:17-jre-focal

WORKDIR /opt/app

# Copiar la aplicación compilada desde el builder
COPY --from=builder /app/target/universal/stage/ /opt/app/

# Instalar openssl para generar el secreto seguro
RUN apt-get update && apt-get install -y openssl && rm -rf /var/lib/apt/lists/*

# Generar un secreto seguro automáticamente al iniciar
# Nota: este valor se usará si no se pasa APPLICATION_SECRET desde docker run
ENV APPLICATION_SECRET="changeme"
ENTRYPOINT ["sh", "-c", "if [ \"$APPLICATION_SECRET\" = 'changeme' ]; then export APPLICATION_SECRET=$(openssl rand -base64 64); fi; /opt/app/bin/graphql-test -Dhttp.port=9000 -Dplay.http.secret.key=$APPLICATION_SECRET"]

EXPOSE 9000
