# Desarrollo de un microservicio de gestión de productos

Una empresa de venta de productos en línea necesita un microservicio para gestionar su catálogo de productos. Cada producto tiene un nombre, precio, stock y categoría. El sistema no debe permitir precios negativos ni nombres duplicados. El objetivo es desarrollar un microservicio que permita crear, leer, actualizar y eliminar productos, asegurando la consistencia de los datos.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Microservicios con Spring Boot |
| **Nivel** | junior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 3-4 horas |

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

### Fase 1: Modelado del dominio

**Objetivo:** Definir las reglas y restricciones del dominio para los productos.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Identifica las reglas de negocio para los productos (nombre, precio, stock, categoría).
- Define las restricciones que deben cumplir los productos (precio no negativo, nombre único).

**Entregable:** Documento que describe las reglas y restricciones del dominio.

<details>
<summary>Pistas de conocimiento</summary>

- Considera los atributos y relaciones entre los productos.
- Piensa en cómo garantizar la unicidad del nombre y la validez del precio.

</details>

### Fase 2: Implementación de endpoints

**Objetivo:** Crear endpoints para crear, leer, actualizar y eliminar productos.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Implementa los endpoints REST para las operaciones CRUD de productos.
- Asegura que los endpoints validen las reglas y restricciones definidas en la fase anterior.

**Entregable:** Microservicio con endpoints funcionales para CRUD de productos.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza métodos HTTP apropiados para cada operación (POST, GET, PUT, DELETE).
- Implementa validaciones en los endpoints para asegurar la consistencia de los datos.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un microservicio y por qué se usa en este contexto?
- **paraQueSirve**: ¿Para qué sirve cada endpoint implementado en este microservicio?
- **comoSeUsa**: ¿Cómo se usan las validaciones en los endpoints para garantizar la consistencia de los datos?
- **erroresComunes**: ¿Qué errores comunes pueden ocurrir al implementar los endpoints y cómo los evitarías?

## Criterios de Evaluacion

- Definición clara de reglas y restricciones del dominio.
- Implementación correcta de endpoints REST para operaciones CRUD.
- Validación adecuada de datos en los endpoints.

---

*Reto generado automaticamente por Challenge Generator - Pragma*
