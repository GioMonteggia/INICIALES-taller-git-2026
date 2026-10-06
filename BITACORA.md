# Bitácora de uso de Inteligencia Artificial

## Herramienta utilizada

Durante el desarrollo de este proyecto se utilizó:

- **Asistente:** ChatGPT
- **Proveedor:** OpenAI
- **Modelo:** GPT-5.6 Luna

## Objetivo del uso de IA

La inteligencia artificial fue utilizada como asistente durante el desarrollo y revisión del proyecto de API REST de armas de Counter-Strike 2.

La IA se utilizó principalmente para:

- Revisar la estructura del proyecto.
- Organizar correctamente los paquetes `domain` y `rest.controller`.
- Revisar y mejorar las clases del dominio.
- Implementar y revisar herencia y clases abstractas.
- Implementar overriding y overloading.
- Revisar constructores simples y sobrecargados.
- Incorporar validaciones para mantener invariantes del dominio.
- Revisar los controladores REST.
- Probar los endpoints de la API.
- Revisar y corregir errores de organización del proyecto.
- Elaborar la documentación del proyecto.
- Preparar el README y el diagrama de clases.

## Resumen de los prompts utilizados

Los principales pedidos realizados al asistente estuvieron relacionados con:

1. Revisar las clases Java existentes y determinar si cumplían los requisitos de programación orientada a objetos.
2. Corregir la organización de los paquetes para que las clases del dominio estuvieran dentro de `com.gio.cs2api.domain`.
3. Revisar la clase abstracta `Arma` y sus clases derivadas.
4. Verificar el uso correcto de `super(...)` en los constructores.
5. Agregar validaciones para evitar estados inválidos en clases como `Pistola`, `Rifle` y `Escopeta`.
6. Verificar la implementación de overriding mediante el método `disparar()`.
7. Verificar la implementación de overloading mediante métodos como `disparar()` y `disparar(int distancia)`.
8. Revisar los controladores REST y los endpoints disponibles.
9. Ejecutar y comprobar las pruebas automatizadas con Maven.
10. Probar manualmente los endpoints HTTP y verificar las respuestas JSON.
11. Revisar y actualizar la documentación del proyecto.
12. Elaborar el diagrama de clases utilizando Mermaid.

## Participación del estudiante

La IA fue utilizada como herramienta de apoyo y revisión. Las decisiones sobre los cambios realizados en el proyecto fueron revisadas y aplicadas por el estudiante.

El código fue probado mediante Maven y mediante solicitudes HTTP a la aplicación Spring Boot.
## Evidencia de pruebas

Se ejecutaron las pruebas automatizadas mediante:

./mvnw test

El resultado obtenido fue:

Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS

También se verificaron manualmente los endpoints principales de la API:

GET /
GET /armas/rifle
GET /armas/rifle?nombre=AK-47&precio=2700&dano=36&cargador=30
GET /rifles/AK-47/disparar?distancia=50

Además, se comprobó el rechazo de valores inválidos mediante:

GET /armas/rifle?dano=0&cargador=30

que produjo una respuesta HTTP 400 con el mensaje:

El daño no puede ser 0 o negativo
