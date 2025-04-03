# 🔥 Simulador Arduino API - Java

Este projeto simula a leitura de sensores de um **Arduino físico** ou através de uma **API local**, permitindo capturar e exibir dados de temperatura e gás no terminal.

## 📌 Funcionalidades

✅ **Modo Simulado:** Permite inserir manualmente os dados de sensores sem precisar de um Arduino físico.  
✅ **Modo API:** Lê dados de sensores via uma API local.  
✅ **Modo Físico:** Conecta-se a um Arduino real via **porta serial (USB)** para leitura de dados.  
✅ **Alerta de Gás:** Caso o valor do gás ultrapasse `500`, exibe um alerta no terminal.  
✅ **Execução contínua:** Lê os dados a cada `3 segundos` e exibe no console.  

---

## 🚀 Como Configurar e Rodar

### 1️⃣ **Pré-requisitos**
- **Java 8+** instalado ([Baixar aqui](https://www.oracle.com/java/technologies/javase-downloads.html))
- **Git** instalado ([Baixar aqui](https://git-scm.com/downloads))
- **Arduino IDE** instalado ([Baixar aqui](https://www.arduino.cc/en/software)) (caso use um Arduino real)
- **Bibliotecas Java:** `jSerialComm` (caso conecte ao Arduino físico)
