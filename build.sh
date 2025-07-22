#!/bin/bash

# Script de compilação e execução para o projeto TADS-EDL

echo "=== SCRIPT DE COMPILAÇÃO E EXECUÇÃO - TADS-EDL ==="
echo

# Navegar para o diretório src
cd src

# Limpar arquivos compilados anteriores
echo "🧹 Limpando arquivos .class..."
find . -name "*.class" -delete

# Compilar todas as classes
echo "⚙️ Compilando estruturas lineares..."
javac estruturas/lineares/*.java

echo "⚙️ Compilando estruturas não-lineares..."
javac estruturas/nao_lineares/*.java

echo "⚙️ Compilando exemplos..."
javac exemplos/ExemplosUso.java

echo "✅ Compilação concluída!"
echo

# Opção de executar exemplos
read -p "🚀 Deseja executar os exemplos? (s/n): " resposta

if [[ $resposta == "s" || $resposta == "S" ]]; then
    echo
    echo "=== EXECUTANDO EXEMPLOS ==="
    java exemplos.ExemplosUso
    echo
    echo "=== EXECUÇÃO CONCLUÍDA ==="
fi

echo "✨ Script finalizado!"
