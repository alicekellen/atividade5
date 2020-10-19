# atividade5
Atividade 5 de Web UEPB

# Configurações Postgres
superuser: postgres
senha: 123
porta: 5432

# Script para criação do banco de dados
-- Database: alunos-api

-- DROP DATABASE "alunos-api";

CREATE DATABASE "alunos-api"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE "alunos-api"
    IS 'banco de dados de alunos e cursos';

# O arquivo do banco encontra-se na raiz do projeto para importar no pgAdmin
alunos-api
