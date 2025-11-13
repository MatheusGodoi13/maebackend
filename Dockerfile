# Stage 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar pom.xml primeiro para aproveitar cache do Docker
COPY pom.xml .

# Baixar dependências (cache layer)
RUN mvn dependency:go-offline -B

# Copiar código fonte
COPY src ./src

# Compilar e gerar o JAR
RUN mvn clean package -DskipTests

# Stage 2: Imagem final de execução
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Criar usuário não-root para segurança
RUN addgroup -S spring && adduser -S spring -G spring

# Copiar o JAR da etapa de build
COPY --from=build /app/target/BuscarRemedios-*.jar app.jar

# Mudar para usuário não-root
USER spring:spring

# Expor a porta da aplicação
EXPOSE 53919

# Variáveis de ambiente para JVM
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Comando para executar a aplicação
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

