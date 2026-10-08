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
- Generalización mediante una clase padre.
- Inventario polimórfico.
- Control interno de munición.
- Control interno de cooldown para granadas.

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Maven
- Git
- GitHub
- JUnit 5
- Mermaid

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
│                   │   ├── Inventario.java
│                   │   ├── Jugador.java
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
│                           ├── RifleController.java
│                           └── JugadorController.java
│
└── test/
    └── java/
        └── com/
            └── gio/
                └── cs2api/
                    ├── Cs2ApiApplicationTests.java
                    └── domain/
                        └── RifleTests.java

Diseño orientado a objetos
La clase Arma es la clase abstracta principal de la jerarquía.
Todas las armas concretas heredan de ella:
Arma
├── Pistola
├── Subfusil
├── Rifle
├── Escopeta
├── Francotirador
└── Granada
    ├── GranadaFlash
    ├── GranadaHumo
    ├── GranadaIncendiaria
    └── GranadaSenuelo

Además, el jugador posee un inventario que trabaja con el tipo general Arma:
Jugador
   │
   ▼
Inventario
   │
   ▼
List<Arma>

Esto permite almacenar diferentes tipos de armas y ejecutar sus comportamientos mediante polimorfismo.
Diagrama de clases
#chatgpt-mermaid-_r_bpc_{font-family:-apple-system-body,ui-sans-serif,-apple-system,system-ui,"Segoe UI",Helvetica,"Apple Color Emoji",Arial,sans-serif,"Segoe UI Emoji","Segoe UI Symbol";font-size:16px;fill:rgb(237, 237, 237);}@keyframes edge-animation-frame{from{stroke-dashoffset:0;}}@keyframes dash{to{stroke-dashoffset:0;}}#chatgpt-mermaid-_r_bpc_ .edge-animation-slow{stroke-dasharray:9,5!important;stroke-dashoffset:900;animation:dash 50s linear infinite;stroke-linecap:round;}#chatgpt-mermaid-_r_bpc_ .edge-animation-fast{stroke-dasharray:9,5!important;stroke-dashoffset:900;animation:dash 20s linear infinite;stroke-linecap:round;}#chatgpt-mermaid-_r_bpc_ .error-icon{fill:rgb(48, 48, 48);}#chatgpt-mermaid-_r_bpc_ .error-text{fill:rgb(237, 237, 237);stroke:rgb(237, 237, 237);}#chatgpt-mermaid-_r_bpc_ .edge-thickness-normal{stroke-width:1px;}#chatgpt-mermaid-_r_bpc_ .edge-thickness-thick{stroke-width:3.5px;}#chatgpt-mermaid-_r_bpc_ .edge-pattern-solid{stroke-dasharray:0;}#chatgpt-mermaid-_r_bpc_ .edge-thickness-invisible{stroke-width:0;fill:none;}#chatgpt-mermaid-_r_bpc_ .edge-pattern-dashed{stroke-dasharray:3;}#chatgpt-mermaid-_r_bpc_ .edge-pattern-dotted{stroke-dasharray:2;}#chatgpt-mermaid-_r_bpc_ .marker{fill:rgb(175, 175, 175);stroke:rgb(175, 175, 175);}#chatgpt-mermaid-_r_bpc_ .marker.cross{stroke:rgb(175, 175, 175);}#chatgpt-mermaid-_r_bpc_ svg{font-family:-apple-system-body,ui-sans-serif,-apple-system,system-ui,"Segoe UI",Helvetica,"Apple Color Emoji",Arial,sans-serif,"Segoe UI Emoji","Segoe UI Symbol";font-size:16px;}#chatgpt-mermaid-_r_bpc_ p{margin:0;}#chatgpt-mermaid-_r_bpc_ g.classGroup text{fill:rgb(31, 78, 148);stroke:none;font-family:-apple-system-body,ui-sans-serif,-apple-system,system-ui,"Segoe UI",Helvetica,"Apple Color Emoji",Arial,sans-serif,"Segoe UI Emoji","Segoe UI Symbol";font-size:10px;}#chatgpt-mermaid-_r_bpc_ g.classGroup text .title{font-weight:bolder;}#chatgpt-mermaid-_r_bpc_ .cluster-label text{fill:rgb(237, 237, 237);}#chatgpt-mermaid-_r_bpc_ .cluster-label span{color:rgb(237, 237, 237);}#chatgpt-mermaid-_r_bpc_ .cluster-label span p{background-color:transparent;}#chatgpt-mermaid-_r_bpc_ .cluster rect{fill:rgb(48, 48, 48);stroke:rgba(255, 255, 255, 0.15);stroke-width:1px;}#chatgpt-mermaid-_r_bpc_ .cluster text{fill:rgb(237, 237, 237);}#chatgpt-mermaid-_r_bpc_ .cluster span{color:rgb(237, 237, 237);}#chatgpt-mermaid-_r_bpc_ .nodeLabel,#chatgpt-mermaid-_r_bpc_ .edgeLabel{color:rgb(237, 237, 237);}#chatgpt-mermaid-_r_bpc_ .noteLabel .nodeLabel,#chatgpt-mermaid-_r_bpc_ .noteLabel .edgeLabel{color:rgb(237, 237, 237);}#chatgpt-mermaid-_r_bpc_ .edgeLabel .label rect{fill:rgb(9, 23, 44);}#chatgpt-mermaid-_r_bpc_ .label text{fill:rgb(237, 237, 237);}#chatgpt-mermaid-_r_bpc_ .labelBkg{background:rgb(9, 23, 44);}#chatgpt-mermaid-_r_bpc_ .edgeLabel .label span{background:rgb(9, 23, 44);}#chatgpt-mermaid-_r_bpc_ .classTitle{font-weight:bolder;}#chatgpt-mermaid-_r_bpc_ .node rect,#chatgpt-mermaid-_r_bpc_ .node circle,#chatgpt-mermaid-_r_bpc_ .node ellipse,#chatgpt-mermaid-_r_bpc_ .node polygon,#chatgpt-mermaid-_r_bpc_ .node path{fill:rgb(9, 23, 44);stroke:rgb(31, 78, 148);stroke-width:1;}#chatgpt-mermaid-_r_bpc_ .divider{stroke:rgb(31, 78, 148);stroke-width:1;}#chatgpt-mermaid-_r_bpc_ g.clickable{cursor:pointer;}#chatgpt-mermaid-_r_bpc_ g.classGroup rect{fill:rgb(9, 23, 44);stroke:rgb(31, 78, 148);}#chatgpt-mermaid-_r_bpc_ g.classGroup line{stroke:rgb(31, 78, 148);stroke-width:1;}#chatgpt-mermaid-_r_bpc_ .classLabel .box{stroke:none;stroke-width:0;fill:rgb(9, 23, 44);opacity:0.5;}#chatgpt-mermaid-_r_bpc_ .classLabel .label{fill:rgb(31, 78, 148);font-size:10px;}#chatgpt-mermaid-_r_bpc_ .relation{stroke:rgb(175, 175, 175);stroke-width:1;fill:none;}#chatgpt-mermaid-_r_bpc_ .dashed-line{stroke-dasharray:3;}#chatgpt-mermaid-_r_bpc_ .dotted-line{stroke-dasharray:1 2;}#chatgpt-mermaid-_r_bpc_ [id$="-compositionStart"],#chatgpt-mermaid-_r_bpc_ .composition{fill:rgb(175, 175, 175)!important;stroke:rgb(175, 175, 175)!important;stroke-width:1;}#chatgpt-mermaid-_r_bpc_ [id$="-compositionEnd"],#chatgpt-mermaid-_r_bpc_ .composition{fill:rgb(175, 175, 175)!important;stroke:rgb(175, 175, 175)!important;stroke-width:1;}#chatgpt-mermaid-_r_bpc_ [id$="-dependencyStart"],#chatgpt-mermaid-_r_bpc_ .dependency{fill:rgb(175, 175, 175)!important;stroke:rgb(175, 175, 175)!important;stroke-width:1;}#chatgpt-mermaid-_r_bpc_ [id$="-dependencyEnd"],#chatgpt-mermaid-_r_bpc_ .dependency{fill:rgb(175, 175, 175)!important;stroke:rgb(175, 175, 175)!important;stroke-width:1;}#chatgpt-mermaid-_r_bpc_ [id$="-extensionStart"],#chatgpt-mermaid-_r_bpc_ .extension{fill:transparent!important;stroke:rgb(175, 175, 175)!important;stroke-width:1;}#chatgpt-mermaid-_r_bpc_ [id$="-extensionEnd"],#chatgpt-mermaid-_r_bpc_ .extension{fill:transparent!important;stroke:rgb(175, 175, 175)!important;stroke-width:1;}#chatgpt-mermaid-_r_bpc_ [id$="-aggregationStart"],#chatgpt-mermaid-_r_bpc_ .aggregation{fill:transparent!important;stroke:rgb(175, 175, 175)!important;stroke-width:1;}#chatgpt-mermaid-_r_bpc_ [id$="-aggregationEnd"],#chatgpt-mermaid-_r_bpc_ .aggregation{fill:transparent!important;stroke:rgb(175, 175, 175)!important;stroke-width:1;}#chatgpt-mermaid-_r_bpc_ [id$="-lollipopStart"],#chatgpt-mermaid-_r_bpc_ .lollipop{fill:rgb(9, 23, 44)!important;stroke:rgb(175, 175, 175)!important;stroke-width:1;}#chatgpt-mermaid-_r_bpc_ [id$="-lollipopEnd"],#chatgpt-mermaid-_r_bpc_ .lollipop{fill:rgb(9, 23, 44)!important;stroke:rgb(175, 175, 175)!important;stroke-width:1;}#chatgpt-mermaid-_r_bpc_ .edgeTerminals{font-size:11px;line-height:initial;}#chatgpt-mermaid-_r_bpc_ .classTitleText{text-anchor:middle;font-size:18px;fill:rgb(237, 237, 237);}#chatgpt-mermaid-_r_bpc_ .edgeLabel[data-look="neo"]{background-color:rgb(0, 0, 0);text-align:center;}#chatgpt-mermaid-_r_bpc_ .edgeLabel[data-look="neo"] p{background-color:rgb(0, 0, 0);}#chatgpt-mermaid-_r_bpc_ .edgeLabel[data-look="neo"] rect{opacity:0.5;background-color:rgb(0, 0, 0);fill:rgb(0, 0, 0);}#chatgpt-mermaid-_r_bpc_ .label-icon{display:inline-block;height:1em;overflow:visible;vertical-align:-0.125em;}#chatgpt-mermaid-_r_bpc_ .node .label-icon path{fill:currentColor;stroke:revert;stroke-width:revert;}#chatgpt-mermaid-_r_bpc_ .node .neo-node{stroke:rgb(31, 78, 148);}#chatgpt-mermaid-_r_bpc_ [data-look="neo"].node rect,#chatgpt-mermaid-_r_bpc_ [data-look="neo"].cluster rect,#chatgpt-mermaid-_r_bpc_ [data-look="neo"].node polygon{stroke:url(#chatgpt-mermaid-_r_bpc_-gradient);filter:drop-shadow( 1px 2px 2px rgba(185,185,185,1));}#chatgpt-mermaid-_r_bpc_ [data-look="neo"].swimlane.cluster rect{filter:none;}#chatgpt-mermaid-_r_bpc_ [data-look="neo"].node path{stroke:url(#chatgpt-mermaid-_r_bpc_-gradient);stroke-width:1px;}#chatgpt-mermaid-_r_bpc_ [data-look="neo"].node .outer-path{filter:drop-shadow( 1px 2px 2px rgba(185,185,185,1));}#chatgpt-mermaid-_r_bpc_ [data-look="neo"].node .neo-line path{stroke:rgb(31, 78, 148);filter:none;}#chatgpt-mermaid-_r_bpc_ [data-look="neo"].node circle{stroke:url(#chatgpt-mermaid-_r_bpc_-gradient);filter:drop-shadow( 1px 2px 2px rgba(185,185,185,1));}#chatgpt-mermaid-_r_bpc_ [data-look="neo"].node circle .state-start{fill:#000000;}#chatgpt-mermaid-_r_bpc_ [data-look="neo"].icon-shape .icon{fill:url(#chatgpt-mermaid-_r_bpc_-gradient);filter:drop-shadow( 1px 2px 2px rgba(185,185,185,1));}#chatgpt-mermaid-_r_bpc_ [data-look="neo"].icon-shape .icon-neo path{stroke:url(#chatgpt-mermaid-_r_bpc_-gradient);filter:drop-shadow( 1px 2px 2px rgba(185,185,185,1));}#chatgpt-mermaid-_r_bpc_ :root{--mermaid-font-family:-apple-system-body,ui-sans-serif,-apple-system,system-ui,"Segoe UI",Helvetica,"Apple Color Emoji",Arial,sans-serif,"Segoe UI Emoji","Segoe UI Symbol";}«abstract»Arma-String nombre-float precio-int dano-float peso-int municionMax-int municionActual+Arma(nombre, precio, dano, peso, municionMax)+disparar() : String+recargar() : String+obtenerPrecio() : String+obtenerNombre() : String+getNombre() : String+getPrecio() : float+getDano() : int+getPeso() : float+getMunicionMax() : int+getMunicionActual() : int#consumirMunicion() : voidPistola-String modoDisparo-int cargador+Pistola(nombre, precio)+Pistola(nombre, precio, dano, cargador)+disparar() : String+disparar(distancia) : StringSubfusil-String modoDisparo-int cargador+Subfusil(nombre, precio)+disparar() : StringRifle-int cargador-float precision+Rifle(nombre, precio)+Rifle(nombre, precio, dano, cargador)+disparar() : String+disparar(distancia) : StringEscopeta-int cartuchos-float dispersion+Escopeta(nombre, precio)+Escopeta(nombre, precio, dano, cartuchos, dispersion)+disparar() : StringFrancotirador-int zoom+Francotirador(nombre, precio)+disparar() : String+activarZoom() : String«abstract»Granada-String tipoGranada-float radioExplosion-long cooldownMilisegundos-long ultimoLanzamiento+Granada(nombre, precio, tipoGranada, radioExplosion)+disparar() : String+lanzar() : String#efectoLanzamiento() : String+getTipoGranada() : String+getRadioExplosion() : float+getCooldownMilisegundos() : long+getCooldownRestante() : longGranadaFlash+GranadaFlash(nombre, precio)#efectoLanzamiento() : StringGranadaHumo+GranadaHumo(nombre, precio)#efectoLanzamiento() : StringGranadaIncendiaria+GranadaIncendiaria(nombre, precio)#efectoLanzamiento() : StringGranadaSenuelo+GranadaSenuelo(nombre, precio)#efectoLanzamiento() : StringInventario-List<Arma> armas+Inventario()+agregarArma(arma) : void+dispararArma(posicion) : String+recargarArma(posicion) : String+dispararTodas() : List<String>+recargarTodas() : List<String>+mostrarTienda() : List<String>+cantidadArmas() : int+obtenerArma(posicion) : Arma+getArmas() : List<Arma>Jugador-String nombre-Inventario inventario+Jugador(nombre)+agregarArma(arma) : void+dispararArma(posicion) : String+recargarArma(posicion) : String+dispararTodas() : List<String>+recargarTodas() : List<String>+mostrarTienda() : List<String>+cantidadArmas() : int+getNombre() : String+getInventario() : Inventario




Herencia y polimorfismo
Arma es una clase abstracta que define el contrato general de las armas mediante:
public abstract String disparar();

Las clases hijas implementan este comportamiento de acuerdo con sus características.
Por ejemplo:
Arma rifle = new Rifle("AK-47", 2700f);
Arma pistola = new Pistola("Glock", 700f);

Aunque ambas variables utilizan el tipo padre Arma, Java ejecuta la implementación correspondiente a la clase concreta.
rifle.disparar();
pistola.disparar();

Esto demuestra polimorfismo y overriding.
Inventario polimórfico
El inventario utiliza:
private final List<Arma> armas;

Por lo tanto, puede contener diferentes tipos de armas sin necesitar un if o switch para cada tipo.
Por ejemplo, el jugador puede tener:
Arma rifle = new Rifle("AK-47", 2700f);
Arma pistola = new Pistola("Glock", 700f);
Arma escopeta = new Escopeta("Nova", 1050f);
Arma francotirador = new Francotirador("AWP", 4750f);
Arma granada = new GranadaFlash("Flash", 200f);

Todas pueden agregarse al mismo inventario:
jugador.agregarArma(rifle);
jugador.agregarArma(pistola);
jugador.agregarArma(escopeta);
jugador.agregarArma(francotirador);
jugador.agregarArma(granada);

Después el inventario puede solicitar:
jugador.dispararTodas();

sin preguntar qué clase concreta tiene cada objeto.
Cada instancia ejecuta automáticamente su propia implementación de disparar().
Esto evita duplicación de lógica y demuestra el uso del polimorfismo.
Encapsulamiento y control de estado
Los datos importantes de Arma se mantienen privados:
private final String nombre;
private final float precio;
private final int dano;
private final float peso;
private final int municionMax;
private int municionActual;

El estado interno no se modifica directamente desde los controladores.
La munición se consume mediante comportamiento de la propia jerarquía:
protected void consumirMunicion()

La recarga también está definida en la clase padre:
public String recargar()

De esta manera, el control de munición permanece dentro del modelo de dominio.
Granadas y cooldown
La clase Granada concentra el comportamiento común de las granadas.
El control de:
- Munición.
- Cooldown.
- Tiempo transcurrido desde el último lanzamiento.
se mantiene dentro de la clase Granada.
Las clases concretas solamente especializan el efecto de lanzamiento:
protected abstract String efectoLanzamiento();

Por ejemplo:
@Override
protected String efectoLanzamiento() {
    return obtenerNombre() + " lanza una flash.";
}

Esto permite que GranadaFlash, GranadaHumo, GranadaIncendiaria y GranadaSenuelo tengan diferentes comportamientos sin duplicar el control de munición y cooldown.
Overriding
El overriding ocurre cuando una clase hija proporciona su propia implementación de un método heredado.
Ejemplo:
@Override
public String disparar() {
    return obtenerNombre() + " realiza un disparo de precisión.";
}

En el proyecto, las diferentes armas especializan disparar() según su comportamiento.
En las granadas, la clase Granada concentra el lanzamiento y las clases hijas especializan:
protected String efectoLanzamiento()

De esta forma, la clase padre concentra el contrato y el comportamiento común, mientras las clases hijas aportan su especialización.
Overloading
El overloading ocurre cuando una misma clase posee métodos con el mismo nombre pero diferente lista de parámetros.
En Rifle existe:
public String disparar()

y:
public String disparar(int distancia)

También Pistola dispone de las dos formas:
public String disparar()

y:
public String disparar(int distancia)

La diferencia es:
- Overriding: una clase hija redefine un método heredado.
- Overloading: una clase tiene varios métodos con el mismo nombre y diferentes parámetros.
Constructores e invariantes
Las clases del dominio utilizan constructores simples y sobrecargados.
Por ejemplo, Rifle posee:
public Rifle(String nombre, float precio)

y:
public Rifle(
        String nombre,
        float precio,
        int dano,
        int cargador)

El constructor sobrecargado utiliza super(...) para inicializar la parte correspondiente a Arma.
Las clases también validan los datos recibidos para evitar estados inválidos.
Entre las validaciones implementadas se encuentran:
- El nombre no puede estar vacío.
- El precio no puede ser negativo.
- El daño debe ser válido.
- El peso debe ser mayor que cero.
- La munición máxima debe ser mayor que cero.
- El cargador debe ser mayor que cero.
- La distancia de disparo no puede ser negativa.
- El radio de explosión no puede ser negativo.
- El tipo de granada no puede estar vacío.
- El nombre del jugador no puede estar vacío.
- No se permite agregar un arma null al inventario.
API REST
Página principal
GET /

Devuelve:
API de armas de Counter-Strike 2 funcionando

Crear un arma
GET /armas/{tipo}

Ejemplo:
GET /armas/rifle?nombre=AK-47&precio=2700&dano=36&cargador=30

La respuesta contiene información del arma y el resultado de ejecutar su comportamiento.
Demostrar polimorfismo
GET /polimorfismo

Este endpoint demuestra el polimorfismo utilizando referencias del tipo padre Arma para objetos de diferentes clases hijas.
Disparar un rifle
GET /rifles/{nombre}/disparar

Ejemplo:
GET /rifles/AK-47/disparar?distancia=50

Permite utilizar la sobrecarga:
disparar(int distancia)

Inventario de un jugador
GET /jugadores/demo

Muestra un jugador de demostración con diferentes tipos de armas dentro de su inventario.
Ejemplo de respuesta:
{
  "jugador": "Jugador Demo",
  "cantidadArmas": 5,
  "armas": [
    {
      "tipo": "Rifle",
      "nombre": "AK-47",
      "precio": 2700.0,
      "municion": 30
    },
    {
      "tipo": "Pistola",
      "nombre": "Glock",
      "precio": 700.0,
      "municion": 12
    }
  ]
}

Disparar todas las armas
GET /jugadores/demo/disparar

Solicita a todas las armas del inventario que ejecuten disparar().
No es necesario utilizar un if por cada tipo de arma porque el método se resuelve polimórficamente.
Recargar todas las armas
GET /jugadores/demo/recargar

Solicita a todas las armas del inventario que ejecuten:
recargar()

Mostrar tienda
GET /jugadores/demo/tienda

Muestra los productos del inventario junto con sus precios.
Disparar un arma por posición
GET /jugadores/demo/disparar/{posicion}

Ejemplo:
GET /jugadores/demo/disparar/0

Permite seleccionar un arma del inventario por su posición y ejecutar su comportamiento mediante la referencia general Arma.
Validación de errores
Los valores inválidos son rechazados mediante validaciones del dominio y de los controladores.
Entre los casos considerados se encuentran:
- Daño igual a cero o negativo.
- Cargadores iguales a cero o negativos.
- Distancias negativas.
- Nombres vacíos.
- Precios negativos.
- Parámetros incompletos.
- Posiciones inexistentes dentro del inventario.
- Armas nulas.
- Tipo de granada vacío.
- Radio de explosión negativo.
Pruebas
Las pruebas automatizadas se ejecutan mediante:
./mvnw test

Resultado actual:
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS

Las pruebas automatizadas verifican principalmente:
- Constructor simple de Rifle.
- Constructor sobrecargado de Rifle.
- Validación de estados inválidos.
- Consumo de munición.
- Comportamiento de disparar(int distancia).
- Atenuación del daño según la distancia.
También se realizaron pruebas manuales de los endpoints de la API, incluyendo:
GET /
GET /armas/rifle?nombre=AK-47&precio=2700&dano=36&cargador=30
GET /polimorfismo
GET /rifles/AK-47/disparar?distancia=50
GET /jugadores/demo
GET /jugadores/demo/disparar
GET /jugadores/demo/recargar
GET /jugadores/demo/tienda

Los endpoints del jugador fueron probados con un inventario que contiene:
- Rifle.
- Pistola.
- Escopeta.
- Francotirador.
- GranadaFlash.
Ejecución del proyecto
Para iniciar el servicio:
./mvnw spring-boot:run

La aplicación se ejecuta en:
http://localhost:8080

Bitácora de uso de Inteligencia Artificial
El proyecto contiene el archivo BITACORA.md en la raíz del repositorio.
La bitácora documenta:
- Asistente utilizado.
- Proveedor.
- Modelo de LLM.
- Objetivo del uso de IA.
- Resumen de los principales prompts utilizados.
- Participación del estudiante.
- Evidencia de pruebas realizadas.
La herramienta utilizada fue ChatGPT, de OpenAI, utilizando el modelo GPT-5.6 Luna.
Licencia
Este proyecto está distribuido bajo la licencia Apache License 2.0.
El texto completo de la licencia se encuentra en el archivo LICENSE del repositorio.
Repositorio
https://github.com/GioMonteggia/SMONTEGGIA-taller-git-2026
Commit de la solución
El commit definitivo de la solución se actualizará al finalizar la implementación y las verificaciones de la entrega.
Autor
Sergio Monteggia
