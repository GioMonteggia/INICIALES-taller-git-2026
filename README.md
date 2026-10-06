# Taller Git 2026 - API de Armas de Counter-Strike 2

## Descripción

Proyecto desarrollado en Java con Spring Boot para representar diferentes armas de Counter-Strike 2 mediante una API REST.

El proyecto aplica conceptos de programación orientada a objetos, incluyendo:

- Encapsulamiento.
- Herencia.
- Clases abstractas.
- Polimorfismo.
- Sobrecarga de métodos (overloading).
- Sobrescritura de métodos (overriding).
- Constructores simples y sobrecargados.
- Validación de invariantes del dominio.

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Maven
- Git
- GitHub
- JUnit 5

## Estructura del proyecto

El proyecto separa las clases del dominio de los controladores REST.

```text
src/
├── main/
│   └── java/
│       └── com/
│           └── gio/
│               └── cs2api/
│                   ├── Cs2ApiApplication.java
│                   │
│                   ├── domain/
│                   │   ├── Arma.java
│                   │   ├── Pistola.java
│                   │   ├── Subfusil.java
│                   │   ├── Rifle.java
│                   │   ├── Escopeta.java
│                   │   ├── Francotirador.java
│                   │   ├── Granada.java
│                   │   ├── GranadaFlash.java
│                   │   ├── GranadaHumo.java
│                   │   ├── GranadaIncendiaria.java
│                   │   └── GranadaSenuelo.java
│                   │
│                   └── rest/
│                       └── controller/
│                           ├── IndexController.java
│                           ├── ArmaController.java
│                           └── RifleController.java
│
└── test/
    └── java/
        └── com/
            └── gio/
                └── cs2api/
                    ├── Cs2ApiApplicationTests.java
                    └── domain/
                        └── RifleTests.java
