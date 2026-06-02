# Diseño y Desarrollo de Microservicios en un Sistema Bancario

El equipo de desarrollo de un banco está migrando su sistema legado a una arquitectura basada en microservicios. Tu tarea es diseñar y desarrollar un microservicio que maneje las transacciones de los clientes. Este microservicio debe ser capaz de registrar transacciones, consultar el historial de transacciones de un cliente y manejar errores comunes como transacciones duplicadas o intentos de transacciones con saldo insuficiente.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Microservicios con Spring Boot |
| **Nivel** | junior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 4-6 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: Un IDE o editor de código.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Verifica que el proyecto arranca sin errores.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición del Microservicio

**Objetivo:** Definir las funcionalidades y los endpoints que el microservicio debe exponer.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Identifica las operaciones que el microservicio debe soportar (registrar transacción, consultar historial de transacciones).
- Define los endpoints y los métodos HTTP que utilizarás para cada operación.

**Entregable:** Descripción escrita de las funcionalidades y endpoints del microservicio.

<details>
<summary>Pistas de conocimiento</summary>

- Considera los verbos HTTP y su significado en el contexto de tu microservicio.
- Piensa en cómo modelar los datos de las transacciones.

</details>

### Fase 2: Implementación del Microservicio

**Objetivo:** Implementar el microservicio con las funcionalidades definidas.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Crea las clases y métodos necesarios para implementar las funcionalidades del microservicio.
- Implementa la lógica para registrar transacciones y consultar el historial de transacciones de un cliente.

**Entregable:** Código fuente del microservicio implementado.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo persistir las transacciones de manera eficiente.
- Piensa en cómo manejar errores comunes como transacciones duplicadas o intentos de transacciones con saldo insuficiente.

</details>

### Fase 3: Pruebas y Mejoras

**Objetivo:** Realizar pruebas unitarias y mejorar el microservicio.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Escribe pruebas unitarias para las funcionalidades implementadas.
- Identifica y corrige cualquier error o ineficiencia en el código.

**Entregable:** Código fuente del microservicio con pruebas unitarias y mejoras aplicadas.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza herramientas de testing para escribir pruebas unitarias efectivas.
- Revisa el código en busca de ineficiencias o errores y corrígelos.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un microservicio y por qué se utilizan en sistemas bancarios?
- **paraQueSirve**: ¿Para qué sirve el microservicio que estás desarrollando y cómo beneficia al sistema bancario?
- **comoSeUsa**: ¿Cómo se usa el microservicio para registrar y consultar transacciones?
- **erroresComunes**: ¿Qué errores comunes puede encontrar el microservicio y cómo los maneja?
- **queDecisionesImplica**: ¿Qué decisiones implica la implementación del microservicio y cómo afectan su diseño y funcionamiento?

## Criterios de Evaluacion

- Definición clara de las funcionalidades y endpoints del microservicio.
- Implementación correcta del microservicio con las funcionalidades definidas.
- Manejo adecuado de errores comunes en el microservicio.
- Pruebas unitarias efectivas para las funcionalidades implementadas.
- Mejoras aplicadas al código para corregir errores o ineficiencias.

---

*Reto generado automaticamente por Challenge Generator - Pragma*
