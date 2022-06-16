# Integrantes
- Avila, Agustin Alejo

- Bailaque, Ivan Nicolas

- Florentin Fajardo, Leandro

- Hittaller, Ramiro

# Decisiones de diseño tomadas
En lo referenciado a las decisiones de diseño, pusimos en práctica una forma de trabajar basada en la implementación base de alguna característica, realizar los test debidos para comprobar su funcionamiento, y luego, intentar mejorar la implementación de la misma. 
Nos valimos de varias estructuras vistas durante el desarrollo de la materia para lograr una implementación exitosa e intentar obtener la mayor eficiencia posible. Algunas de las estructuras usadas son: Mapas, Colas de prioridad, Set, Listas.
Además, hemos utilizado diferentes recursos que nos brindó la materia, empezando con patrones de diseño, específicamente el patrón Composite, conjuntamente con herencia y polimorfismo, manejo de excepciones y la implementación de comparadores, entre otras cosas.
Esto, nos llevó a tener varias versiones, todas funcionales, de diversas características del código.

A continuación, mencionamos algunas de las decisiones importantes tomadas durante el desarrollo:

>1-    El principal cambio, fue una reestructuración de la lógica con la que funcionaba el método competir, que es el “corazón” del trabajo, y como se guardaban las características de cada competidor.

>2-    Otra decisión importante, fue la decisión de como decidir si un competidor es un héroe o un villano, y la manera de que una liga también pueda decidir que tipo de liga es. Culminando con una implementación de un booleano que define si un competidor (o liga) es Héroe o Villano.

>3-    Finalmente, otra gran decisión fue la forma en como el usuario se trasladaría por el menú.  Llegando a la conclusión de que la implementación más simple era el ingreso de opciones numéricas por parte del usuario.


# Descripción de cada archivo *.java comprendido en solución del problema

**Clases**
 >Atributo: archivo Atributo.java, dentro de esta clase encontramos datos que necesitan nuestros competidores para poder ser utilizados.

 >Caracteristica: archivo Caracteristica.java, esta clase es un enumerado que tiene parametros que van a ser utilizados dentro de otra clase para determinada informacion.

 >ComparatorDestreza: archivo ComparatorDestreza.java, dentro de esta clase se comparan nuestra caracterista destreza entre un un objeto competidor y otro.

 >ComparatorFuerza: archivo ComparatorFuerza.java, dentro de esta clase se comparan nuestra caracterista fuerza entre un un objeto competidor y otro.

 >ComparatorResistencia: archivo ComparatorResistencia.java, dentro de esta clase se comparan nuestra caracterista resistencia entre un un objeto competidor y otro. 

 >ComparatorVelocidad: archivo ComparatorVelocidad.java, dentro de esta clase se comparan nuestra caracterista velocidad entre un un objeto competidor y otro.

 >Competidor: archivo Competidor.java, es la clase principal que va a utilizar el usuario, es el foco de todo el proyecto, dentro de esta clase utilizaremos la mayoria de las demas clases.

 >Heroe: archivo Heroe.java, es una instancia de nuestro competidor, un tipo que debe ser seleccionado por nuestro usuario.

 >Liga: archivo Liga.java, es un conjunto de nuestros competidores que puede ser de un tipo u el otro (heroe/villano) que tambien es seleccionado por nuestro usuario.

 >Villano: archivo Villano.java, es una instancia de nuestro competidor, un tipo que debe ser seleccionado por nuestro usuario.

 **Excepciones**
 >CaracteristicaInvalidaEx: archivo CaracteristicaInvalidaEx.java, permite verificar que se introduzcan datos correctos para la caracteristica de los competidores.

 >LineaErroneaEx: archivo LineaErroneaEx.java, permite verificar que los usuarios introduzcan los datos correctamente para la creación de competidores.

 >MismoTipoCompetidorEx: archivo MismoTipoCompetidorEx.java, controla que no se concreten acciones que no se pueden hacer entre competidores del mismo tipo.

 >NoExistenCompetidoresEx: archivo NoExistenCompetidoresEx.java, avisa al usuario que se deben cargar o crear competidores antes de ingresar a ciertas opciones de nuestro menu.

 >NombreInvalidoEx: archivo NombreInvalidoEx.java, se asegura que el usuario introduzca un nombre valido a la hora de setear el nombre de un competidor.

 >TipoCompetidorInvalidoEx: archivo TipoCompetidorInvalidoEx.java, se asegura que los competidores sean del mismo tipo en cada Liga.

**Main**
>Menu: archivo Menu.java, le brinda a nuestros usuarios la comodidad para poder acceder y disfrutar de las opciones que ofrecemos.

>OrdenadorCaracteristicaAscendente: archivo OrdenadorCaracteristicaAscendente.java, ofrece una forma para poder ordenar a los competidores de forma ascendente respecto a la o las caracteristicas que se escojan.

>OrdenadorCaracteristicaDescendente:archivo OrdenadorCaracteristicaDescendente.java, ofrece una forma para poder ordenar a los competidores de forma descendente respecto a la o las caracteristicas que se escojan.

**Tests**
>Tests: archivo Tests.java, verifica el correcto funcionamiento de nuestros métodos e implementaciones


# Conclusiones 

Este ha sido un trabajo que puso a prueba nuestra capacidad de desarrollar y aplicar los conceptos aprendidos durante la materia, y, sobre todo, trabajar en equipo. Le hemos dedicado mucho esfuerzo a la resolución del mismo y estamos más que conformes con el resultado final.