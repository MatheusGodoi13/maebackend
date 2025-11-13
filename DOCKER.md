# Guia de Docker para BuscarRemedios

Este guia explica como containerizar e executar a aplicação BuscarRemedios usando Docker.

## Pré-requisitos

- Docker instalado (versão 20.10 ou superior)
- Docker Compose instalado (opcional, mas recomendado)

## Construindo a Imagem Docker

### Opção 1: Usando Docker diretamente

```bash
docker build -t buscar-remedios:latest .
```

### Opção 2: Usando Docker Compose

```bash
docker-compose build
```

## Executando a Aplicação

### Opção 1: Usando Docker diretamente

```bash
docker run -d \
  --name buscar-remedios-app \
  -p 53919:53919 \
  buscar-remedios:latest
```

### Opção 2: Usando Docker Compose (Recomendado)

```bash
docker-compose up -d
```

Para ver os logs:

```bash
docker-compose logs -f
```

## Configuração de Variáveis de Ambiente

Se precisar sobrescrever configurações do banco de dados, você pode:

1. **Editar o docker-compose.yml** e adicionar as variáveis de ambiente:

```yaml
environment:
  - SPRING_DATASOURCE_URL=jdbc:sqlserver://seu-servidor:1433;database=seu-banco;...
  - SPRING_DATASOURCE_USERNAME=seu-usuario
  - SPRING_DATASOURCE_PASSWORD=sua-senha
```

2. **Ou criar um arquivo .env** e referenciá-lo no docker-compose.yml

3. **Ou passar variáveis na linha de comando**:

```bash
docker run -d \
  --name buscar-remedios-app \
  -p 53919:53919 \
  -e SPRING_DATASOURCE_URL="jdbc:sqlserver://..." \
  -e SPRING_DATASOURCE_USERNAME="usuario" \
  -e SPRING_DATASOURCE_PASSWORD="senha" \
  buscar-remedios:latest
```

## Comandos Úteis

### Ver logs da aplicação
```bash
docker logs -f buscar-remedios-app
```

### Parar a aplicação
```bash
docker stop buscar-remedios-app
# ou com docker-compose:
docker-compose down
```

### Reiniciar a aplicação
```bash
docker restart buscar-remedios-app
# ou com docker-compose:
docker-compose restart
```

### Remover o container
```bash
docker rm buscar-remedios-app
# ou com docker-compose:
docker-compose down
```

### Remover a imagem
```bash
docker rmi buscar-remedios:latest
```

### Acessar o shell do container
```bash
docker exec -it buscar-remedios-app sh
```

## Verificando se está funcionando

Após iniciar o container, acesse:
- **Aplicação**: http://localhost:53919
- **Logs**: `docker logs buscar-remedios-app`

## Troubleshooting

### Porta já em uso
Se a porta 53919 já estiver em uso, altere no `docker-compose.yml`:
```yaml
ports:
  - "8080:53919"  # Porta externa:porta interna
```

### Problemas de conexão com o banco
Certifique-se de que:
1. O firewall do Azure SQL permite conexões do IP do container
2. As credenciais estão corretas nas variáveis de ambiente
3. A URL de conexão está correta

### Rebuild após mudanças no código
```bash
docker-compose build --no-cache
docker-compose up -d
```

## Estrutura dos Arquivos Docker

- **Dockerfile**: Define como construir a imagem
- **docker-compose.yml**: Facilita o gerenciamento do container
- **.dockerignore**: Exclui arquivos desnecessários da imagem

