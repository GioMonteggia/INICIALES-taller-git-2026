# Especificaciones: API REST de armas de Counter-Strike 2

**Alumno:** Sergio Monteggia\
**Asignatura:** Lenguaje de Programación 3 --- ejercicio POO-06\
**Proyecto:** SMONTEGGIA-taller-git-2026\
**Repositorio:**
https://github.com/GioMonteggia/SMONTEGGIA-taller-git-2026\
**Commit de la solución verificado:**
`28cebd6cac05d9a992adcee88ccba990733a37ff`\
**Tecnologías:** Java 21, Spring Boot, Maven, Git, GitHub, JUnit 5\
**Licencia:** Apache 2.0

> **Nota:** este documento describe el estado de la solución
> correspondiente al commit indicado arriba. Si este archivo se agrega
> posteriormente al repositorio, GitHub generará un nuevo commit; en ese
> caso, para la entrega final debe utilizarse el hash completo del nuevo
> commit que contenga este documento.

------------------------------------------------------------------------

## 1. Objetivo

Publicar un servicio HTTP propio utilizando Spring Boot para modelar
armas de Counter-Strike 2 y demostrar los principales conceptos de
programación orientada a objetos solicitados en el ejercicio:

-   Organización de paquetes.
-   Encapsulamiento e invariantes del dominio.
-   Herencia.
-   Clase abstracta.
-   Sobreescritura (`overriding`) de métodos.
-   Sobrecarga (`overloading`) de métodos y constructores.
-   Uso de `super(...)` en constructores de clases hijas.
-   Polimorfismo.
-   Servicios REST.
-   Validación de valores recibidos mediante parámetros de URL.
-   Pruebas automatizadas.

------------------------------------------------------------------------

## 2. Dominio

La clase base del dominio es `Arma`, que es abstracta y define el
comportamiento común de las armas.

### Jerarquía principal

``` text
Arma (abstracta)
├── Pistola
├── Subfusil
├── Rifle
├── Escopeta
├── Francotirador
└── Granada (abstracta)
    ├── GranadaFlash
    ├── GranadaHumo
    ├── GranadaIncendiaria
    └── GranadaSenuelo
```

La clase `Arma` declara el método abstracto:

``` java
public abstract String disparar();
```

Las clases concretas proporcionan sus propias implementaciones de
`disparar()`.

------------------------------------------------------------------------

## 3. Organización de paquetes

Las clases se encuentran separadas de acuerdo con su responsabilidad:

``` text
src/main/java/com/gio/cs2api/
├── Cs2ApiApplication.java
├── domain/
│   ├── Arma.java
│   ├── Pistola.java
│   ├── Subfusil.java
│   ├── Rifle.java
│   ├── Escopeta.java
│   ├── Francotirador.java
│   ├── Granada.java
│   ├── GranadaFlash.java
│   ├── GranadaHumo.java
│   ├── GranadaIncendiaria.java
│   └── GranadaSenuelo.java
└── rest/
    └── controller/
        ├── IndexController.java
        ├── ArmaController.java
        └── RifleController.java
```

El paquete `domain` contiene las reglas y objetos del dominio, mientras
que `rest.controller` contiene los controladores HTTP.

------------------------------------------------------------------------

## 4. Consignas y cómo se cumplen

  --------------------------------------------------------------------------------------
  \#                      Consigna                Dónde se cumple
  ----------------------- ----------------------- --------------------------------------
  1                       Separación entre        `com.gio.cs2api.domain` y
                          dominio y REST          `com.gio.cs2api.rest.controller`

  2                       Clase base abstracta    `Arma` es abstracta

  3                       Método abstracto        `Arma.disparar()`

  4                       Dos clases hijas        `Rifle` y `Pistola`, entre otras
                          independientes que      
                          sobrescriben el método  

  5                       Servicio `GET /`        `IndexController`

  6                       Controller que          `ArmaController`
                          construye objetos desde 
                          parámetros de URL       

  7                       Respuesta JSON con      `ArmaController` y endpoint
                          comportamiento de las   `/polimorfismo`
                          clases hijas            

  8                       Constructores simples   Por ejemplo
                                                  `Rifle(String nombre, float precio)`

  9                       Constructores           `Rifle`, `Pistola` y `Escopeta` poseen
                          sobrecargados           constructores con argumentos
                                                  adicionales

  10                      Uso de `super(...)`     Los constructores de las clases hijas
                                                  inicializan la clase base mediante
                                                  `super(...)`

  11                      Sobrecarga de un        `disparar()` y
                          mensaje del dominio     `disparar(int distancia)`

  12                      Validación de estados   Validaciones en los constructores y
                          inválidos               métodos del dominio

  13                      Polimorfismo            `Arma rifle = new Rifle(...)` y
                                                  `Arma pistola = new Pistola(...)`

  14                      README actualizado      `README.md` contiene licencia,
                                                  diagrama Mermaid y explicación de POO

  15                      Bitácora de IA          `BITACORA.md` registra ChatGPT,
                                                  OpenAI, GPT-5.6 Luna y los prompts
                                                  utilizados

  16                      Licencia                `LICENSE` contiene Apache License 2.0
  --------------------------------------------------------------------------------------

------------------------------------------------------------------------

## 5. Encapsulamiento e invariantes

Los atributos principales de `Arma` son privados.

Entre las reglas verificadas se encuentran:

-   El nombre no puede ser nulo ni vacío.
-   El precio no puede ser negativo.
-   El daño no puede ser negativo.
-   El peso debe ser mayor que cero.
-   La munición máxima debe ser mayor que cero.
-   Los parámetros específicos de cada arma también se validan.
-   La distancia de disparo no puede ser negativa.

Cuando se recibe un valor inválido, el dominio lanza
`IllegalArgumentException`.

El consumo de munición se realiza mediante comportamiento del dominio y
no mediante setters públicos.

------------------------------------------------------------------------

## 6. Herencia y overriding

`Arma` define el método abstracto:

``` java
public abstract String disparar();
```

Las clases hijas sobrescriben este método mediante `@Override`.

Por ejemplo, el mismo mensaje `disparar()` puede producir
comportamientos diferentes dependiendo del objeto concreto:

``` java
Arma rifle = new Rifle("AK-47", 2700f);
Arma pistola = new Pistola("Glock", 700f);

rifle.disparar();
pistola.disparar();
```

Esto demuestra polimorfismo: ambas referencias son del tipo `Arma`, pero
se ejecuta la implementación correspondiente al objeto concreto.

------------------------------------------------------------------------

## 7. Constructores y overloading

Se utilizan constructores simples para crear objetos con valores
predeterminados.

Ejemplo:

``` java
Rifle rifle = new Rifle("AK-47", 2700f);
```

También se utilizan constructores sobrecargados que permiten especificar
valores adicionales:

``` java
Rifle rifle = new Rifle("M4A4", 3100f, 33, 20);
```

Los constructores de las clases hijas utilizan `super(...)` para
inicializar la parte correspondiente a `Arma`.

Las validaciones se realizan para evitar que un constructor deje al
objeto en un estado inválido.

------------------------------------------------------------------------

## 8. Sobrecarga de métodos

Se implementó la misma acción con diferentes listas de argumentos.

En `Rifle` existe:

``` java
public String disparar()
```

y también:

``` java
public String disparar(int distancia)
```

La versión sin argumentos utiliza una distancia predeterminada, mientras
que la versión sobrecargada permite indicar la distancia del disparo.

`Pistola` también posee una versión sobrecargada:

``` java
disparar()
disparar(int distancia)
```

Esto corresponde a **overloading**, porque el nombre del método es el
mismo pero cambia su lista de parámetros.

------------------------------------------------------------------------

## 9. Servicios REST

### Índice

``` text
GET /
```

Verifica que el servicio esté funcionando.

Respuesta:

``` text
API de armas de Counter-Strike 2 funcionando
```

### Creación de armas

``` text
GET /armas/{tipo}
```

El controller crea una instancia del dominio según el tipo indicado.

Ejemplos:

``` text
GET /armas/rifle
GET /armas/pistola
GET /armas/escopeta
GET /armas/subfusil
GET /armas/francotirador
GET /armas/humo
GET /armas/flash
GET /armas/incendiaria
GET /armas/senuelo
```

También se pueden enviar parámetros como:

``` text
GET /armas/rifle?nombre=AK-47&precio=2700&dano=36&cargador=30
```

### Polimorfismo

``` text
GET /polimorfismo
```

Este endpoint crea objetos `Rifle` y `Pistola` utilizando referencias
del tipo padre `Arma` y devuelve en JSON el comportamiento de cada
objeto.

### Controller específico de Rifle

``` text
GET /rifles/{nombre}
GET /rifles/{nombre}/disparar
```

El segundo endpoint permite indicar opcionalmente una distancia:

``` text
GET /rifles/AK-47/disparar?distancia=50
```

------------------------------------------------------------------------

## 10. Validaciones REST

Los valores inválidos son rechazados y se devuelve HTTP 400.

Ejemplos:

``` text
GET /armas/rifle?dano=0&cargador=30
```

produce un error indicando que el daño debe ser mayor que cero.

También se rechazan casos como:

-   Nombre vacío.
-   Precio negativo.
-   Daño inválido.
-   Cargador inválido.
-   Distancia negativa.
-   Parámetros `dano` y `cargador` enviados de forma incompleta.

El controller transforma estas excepciones en respuestas HTTP 400.

------------------------------------------------------------------------

## 11. Ejemplo de polimorfismo

El endpoint:

``` text
GET /polimorfismo
```

utiliza referencias del tipo padre:

``` java
Arma rifle = new Rifle("AK-47", 2700f);
Arma pistola = new Pistola("Glock", 700f);
```

y ejecuta:

``` java
rifle.disparar();
pistola.disparar();
```

La respuesta JSON contiene el tipo concreto y el mensaje producido por
cada implementación.

Ejemplo conceptual:

``` json
{
  "rifle": {
    "tipo": "Rifle",
    "mensaje": "AK-47 dispara a 100 m y causa 15 de daño."
  },
  "pistola": {
    "tipo": "Pistola",
    "mensaje": "Glock dispara."
  }
}
```

------------------------------------------------------------------------

## 12. Cómo probar

### Requisitos

-   Java 21.
-   Git.
-   Maven Wrapper incluido en el proyecto.

### Ejecutar pruebas

Desde la raíz del proyecto:

``` bash
./mvnw test
```

Resultado verificado:

``` text
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

### Iniciar el servicio

``` bash
./mvnw spring-boot:run
```

El servicio queda disponible por defecto en:

``` text
http://localhost:8080
```

### Verificar endpoints

``` text
GET /
GET /armas/rifle
GET /armas/rifle?nombre=AK-47&precio=2700&dano=36&cargador=30
GET /polimorfismo
GET /rifles/AK-47/disparar?distancia=50
```

También se comprobó el rechazo de valores inválidos mediante respuestas
HTTP 400.

------------------------------------------------------------------------

## 13. Pruebas automatizadas

Las pruebas del dominio se encuentran en:

``` text
src/test/java/com/gio/cs2api/domain/RifleTests.java
```

Se verifican:

-   Constructor simple.
-   Constructor sobrecargado.
-   Rechazo de valores inválidos.
-   Consumo de munición.
-   Efecto de la distancia sobre el daño.
-   Límite mínimo del daño a grandes distancias.

Resultado:

``` text
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

------------------------------------------------------------------------

## 14. Documentación del proyecto

El repositorio contiene:

### README.md

Incluye:

-   Licencia Apache 2.0.
-   Diagrama de clases Mermaid.
-   Estructura del proyecto.
-   Explicación de overriding y overloading.
-   Constructores.
-   Invariantes.
-   Endpoints.
-   Pruebas.
-   Forma de ejecución.

### BITACORA.md

Registra el uso de inteligencia artificial durante el desarrollo,
incluyendo:

-   Asistente: ChatGPT.
-   Proveedor: OpenAI.
-   Modelo: GPT-5.6 Luna.
-   Resumen de los principales prompts utilizados.
-   Participación del estudiante.

### LICENSE

Contiene la licencia Apache License 2.0.

------------------------------------------------------------------------

## 15. Archivos principales

``` text
src/main/java/com/gio/cs2api/
├── Cs2ApiApplication.java
├── domain/
│   ├── Arma.java
│   ├── Pistola.java
│   ├── Subfusil.java
│   ├── Rifle.java
│   ├── Escopeta.java
│   ├── Francotirador.java
│   ├── Granada.java
│   ├── GranadaFlash.java
│   ├── GranadaHumo.java
│   ├── GranadaIncendiaria.java
│   └── GranadaSenuelo.java
└── rest/
    └── controller/
        ├── IndexController.java
        ├── ArmaController.java
        └── RifleController.java

src/test/java/com/gio/cs2api/
├── Cs2ApiApplicationTests.java
└── domain/
    └── RifleTests.java
```

------------------------------------------------------------------------

## 16. Commit de la solución

El commit de la solución verificado en GitHub es:

``` text
28cebd6cac05d9a992adcee88ccba990733a37ff
```

Enlace:

https://github.com/GioMonteggia/SMONTEGGIA-taller-git-2026/commit/28cebd6cac05d9a992adcee88ccba990733a37ff

Este commit contiene el estado final de la solución correspondiente al
README actualizado.

> Si `ESPECIFICACIONES.md` se incorpora después de este commit, el
> enlace anterior continúa identificando el commit original de la
> solución, pero el estado más reciente del repositorio tendrá un nuevo
> commit que también deberá considerarse para la entrega final si la
> consigna exige que el documento forme parte del commit entregado.

------------------------------------------------------------------------

## 17. Relación con la rúbrica

  -----------------------------------------------------------------------
  Criterio                            Evidencia en el proyecto
  ----------------------------------- -----------------------------------
  Entrega y ejecución                 Repositorio público y servicio
                                      Spring Boot ejecutable con
                                      `./mvnw spring-boot:run`

  Paquetes                            `domain` y `rest.controller`
                                      separados

  Encapsulamiento e invariantes       Atributos privados y validaciones
                                      en el dominio

  Herencia y overriding               `Arma` abstracta y clases hijas con
                                      `@Override`

  Constructores y overloading         Constructores simples,
                                      sobrecargados y
                                      `disparar(int distancia)`

  Comportamiento observable           Endpoints REST y `/polimorfismo`

  Git                                 Historial de commits y commit de
                                      solución

  Documentación                       `README.md`, `BITACORA.md`,
                                      `LICENSE` y este documento
  -----------------------------------------------------------------------

------------------------------------------------------------------------

## 18. Cierre

La implementación final organiza el dominio y la capa REST de forma
separada, utiliza una clase abstracta con herencia, demuestra
overriding, overloading y polimorfismo, mantiene invariantes mediante
validaciones y expone el comportamiento mediante una API REST.

Las pruebas automatizadas finalizan correctamente con `BUILD SUCCESS`, y
la documentación del proyecto permite identificar cómo se cumplen los
requisitos del ejercicio.
