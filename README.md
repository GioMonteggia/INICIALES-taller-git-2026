# Taller Git 2026 - API de Armas de Counter-Strike 2

## Descripción

Proyecto desarrollado en Java con Spring Boot para representar diferentes armas de Counter-Strike 2 mediante una API REST.

El proyecto utiliza programación orientada a objetos, herencia, clases abstractas y polimorfismo.

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Maven
- Git
- GitHub

## Estructura

Las armas se encuentran dentro del paquete:

`py.edu.uc.lp3.vr.cs2.modelo`

Entre las clases existentes se encuentran:

- Arma
- ArmaDeFuego
- Pistola
- Subfusil
- Rifle
- Escopeta
- Francotirador
- Granada
- GranadaFlash
- GranadaHumo
- GranadaIncendiaria

## Contribución realizada

Como parte del Taller Git 2026 se agregó una nueva clase hija:

### Revolver

La clase `Revolver` extiende de `ArmaDeFuego`.

Se implementaron:

- Constructor propio.
- Método `factorDistancia()`.
- Método `getTipo()`.

El revólver posee un comportamiento de daño por distancia diferente al de la clase `Pistola`.

## Git

La contribución fue realizada mediante una rama independiente:

`gm-contribucion-lp3`

Luego se realizó el commit y el Pull Request correspondiente para incorporar la modificación al proyecto principal.

## Autor de la contribución

**Gio Monteggia**

GitHub: [GioMonteggia](https://github.com/GioMonteggia)
