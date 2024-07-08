# DOO_ProyectoFinal
- Desarrollo Orientado a Objeto
- Proyecto: Simulador de zoológico interactivo
- Junio / Julio 2024

## Estudiantes (Grupo 14):
- Chloe Yáñez Lavín
- Emily Osvaldo Gaete Bobadilla

## Funcionamiento:

### 1. Puntos previos:

- **1. Zoológico:** En el centro de la pantalla se encuentra su zoológico, el cual cuenta con 6 habitas y 36 animales distintos para adoptar.
- **2. Menu:** En la parte derecha de la pantalla se encuentra el menu. Aquí puede ver su dinero, adoptar animales y comprar comida para ellos.
- **3. Dinero:** En la parte superior del menu se encuentra el dinero que cuenta el zoológico para comprar distintas cosas, desde habitats hasta comida.
- **4. Ganancias:** Debajo del dinero se encuentran las ganancias del zoológico. Cada 5 segundos se va a agregar el número escrito en ganancias a su dinero actual. Si presiona "Ganancias" puede ver las ganancias específicas, como también las multas.
- **5. Info Zoo**: Dentro del juego existe un botón llamado "Info Zoo" en la parte inferior del zoológico, en el cual están las informaciones de ganancias, bonus, multas y rescate animal.
Además de leer este documento, se recomienda también leer la información entregada al presionar "Info Zoo".
- **6. Botón OP:** Para hacer el juego (y la revisión) más rápida existe el botón "OP" en la parte superior derecha, antes del menu. Este botón entrega +1000$ al dinero del zoológico al apretarlo. Dinero gratis.

### 2. Habitats:

En la pantalla se encuentran 6 botones para cada habitat del zoológico.
- **1. Comprar un habitat:** Al presionar un habitat bloqueado podrás comprarlo si se tiene el dinero suficiente. El precio se encuentra en el mismo botón.
- **2. Abrir un habitat:** Al presionar un habitat desbloqueado *(comprado)* podrás entrar al mismo. En el encontrarás 6 recintos parar los 6 animales de ese habitat. Para salir del habitat presione el botón "Volver" en la parte superior izquierda.
- **3. Ganancias:** Al comprar un habitat obtendrá una ganancia del 1% del precio del habitat *(+$10, +20$, +30$ ó +40$)*. Para más detalle ver "Info Zoo" *(Punto 1.5)*.
- **4. Mejora de temperatura:** Al entrar a un habitat, en la parte inferior, encontrará el botón para la mejora de temperatura. Esta mejora, luego de comprarla, te dara una mayor ganancia por recinto comprado.  Para más detalle ver "Info Zoo" *(Punto 1.5)*.

### 3. Recintos:

Dentro de un habitat se encuentran 6 recintos para 6 distintos animales, exclusivos de ese habitat.
- **1. Comprar un recinto:** Al presionar el botón *"Comprar Recinto"*, podrás desbloquearlo y tener animales en el mismo si se tiene el dinero suficiente. El precio se encuentra en el mismo botón.
- **2. Seleccionar un animal:** Al comprar un recinto se le dará la opción de elegir un animal. Solo debe presionar el botón del animal que quiere. 
Si se compra otro recinto, el animal anteriormente seleccionado ya no estará disponible (no es posible tener un mismo animal en dos recintos distintos).
- **3. Ganancias:** Al comprar un recinto obtendrá una ganancia de +10$. Si tienes la mejora de temperatura del habitat obtienes +20$. Para más detalle ver "Info Zoo" *(Punto 1.5)*.
- **4. Información sobre el animal:** Luego de comprar un recinto, encontrará un botón con el símbolo "i" en la parte inferior derecha del recinto.
Al presionarlo le aparecerá un panel con la información sobre el animal del recinto, como su nombre, habitat, alimentación y descripción. Para cerrar el panel presióne "Cerrar".

### 4. Animales:

En la parte derecha de la pantalla tienes el menu, donde se pueden adoptar animales.
- **1. Selección del animal:** Dentro de un habitat, y si tiene un recinto comprado, podrá seleccionar el animal que quiere adoptar en "Seleccione Animal:". Solo presióne con clic izquierdo y aparecerá un menu con las opciones de animales.
- **2. Nombre del animal:** Justo abajo de la selección existe una zona para escribir el nombre del animal. Por predeterminado está el nombre común del animal, para cambiarlo bórre el nombre predeterminado. Nombre el animal como quiera, desde Maria hasta Cristóbal Colón.
- **3. Ver los nombres:** En el panel de información *(Punto 3.4)* en la parte inferior podrá ver los nombres de los animales adoptados en el recinto.
- **4. Adoptar un animal:** Para adoptar un animal tiene que, luego de seleccionarlo, presionar el botón "ADOPTAR". Una adopción tiene un precio y una ganancia, ambas información están justo arriba del botón "ADOPCIÓN" (Solo se ven si hay un animal seleccionado).
- **5. Ganancias:** La adopción de un animal también entrega ganancias, esta es el 5% del precio del animal (+5$, +10$ ó +15$). Para más detalle ver "Info Zoo" *(Punto 1.5)*.
- **6. Animal adoptado:** Luego de adoptarlo en animal aparecerá en el recinto correspondiente, dando vueltas.

### 5. Alimentar Animales:

En un recinto comprado, en la parte superior izquierda se encuentran dos botones y un texto. Estos son para la alimentación del animal.
- **1. Hambre de un animal:** Durante el juego los animales les da hambre, mientras más animales más rápido les da hambre.
- **2. Comida para animales:** Para ver la cantidad de comida que tienes se tiene que ir al menu, en la parte inferior del mismo. Aquí están la cantidad de comida que tienes y los botones para comprar más. Son 7 comidas distintas.
- **3. Comprar comida:** Para comprar comida se presionan los botones en el menu. El botón sin ningún número (el primero) comprará un alimento. El botón con el x10 comprará 10 alimentos. El precio de un alimento está abajo de la cantidad que tienes.
- **4. Alimentar a los animales:** Cuando tienes el alimento indicado para el animal puedes alimentarlo. Utilizando los botones en el recinto podrá llenar el recinto con comida. Con el primer botón entregas un alimento al recinto, y con el x10 entregas 10 alimentos.
- **5. Cantidad por recinto:** Usted puede almacenar alimentos, así los animales podrá comer y no te tendrás que preocupar por darles comida en cada momento. A la derecha de los botones en el recinto está la cantidad de comida que está almacenada en el recinto. 
A medida que pasa el tiempo los animales van comiendo y la cantidad va disminuyendo.
- **6. Hambre y almacén vacío:** Si el recinto está sin comida (llega a 0) los animales les dará hambre y obtendrá una multa por maltrato. Esta multa disminuye las ganancias. Para más detalle ver "Info Zoo" *(Punto 1.5)*.

### 6. Multas y rescate Animal:

Si un recinto tiene animales hambrientos y sin comida se le dará una multa, si pasa mucho tiempo para el evento "rescate animal"
- **1. Multas:** Las multas son un descuento en las ganancias totales que sucede cuando un recinto no tiene comida. Cuando esto pasa va a aparecer un icono de advertencia en el habitat y en los botones de para alimentar del recinto.
- **2. Descuento:** Dependiendo del tiempo que pasan los animales sin comer tendrá una mayo multa (-5$, -10$ ó -15$).
- **3. Rescate animal:** Si un recinto pasa más de 30 segundos sin ser alimentado los animales van a ser rescatados de tu zoológico por fuerzas mayores. Esto significa que perderá los animales y las ganancias que estos te daban. El recinto quedará vació. Para más detalle ver "Info Zoo" *(Punto 1.5)*.
- **4. Especificaciones:** Para ver en detalle las multas y el rescate animal tiene que ver el panel del botón "Info Zoo" en la parte inferior del zoológico *(Punto 1.5)*.

### 7. Tiendas:

En el centro del zoológico se encuentran 4 tiendas que se pueden comprar.
- **1. Compra de una tienda:** Para comprar una tienda solo debe presionarla (los botones en el centro del zoológico). Si tiene el dinero suficiente se desbloqueará.
- **2. Precio de las tiendas:** El precio de las tiendas se encuentra en la parte inferior del zoológico, al lado del botón "Info Zoo". El precio de las tiendas aumenta a medida que compras tiendas.
- **3. Bonus de las tiendas:** Cuando se compra una tienda las ganancias del zoológico son multiplicadas por un número dependiendo de la cantidad de tiendas.
  - **3.1** Con una tienda tus ganancias de multiplícan por 1.25 (125% de la ganancia total).
  - **3.2** Con dos tiendas tus ganancias de multiplícan por 1.50 (150% de la ganancia total).
  - **3.3** Con tres tiendas tus ganancias de multiplícan por 1.75 (175% de la ganancia total).
  - **3.4** Con cuatro tiendas tus ganancias de multiplícan por 2.00 (200% de la ganancia total).
  - **3.5** Para más detalle de las tiendas puede ver el panel del botón "Info Zoo" en la parte inferior del zoológico *(Punto 1.5)*.
- **4. Tiendas y multas:** Las multas se descuentan del total ya multiplicado, por lo que las multas no son afectadas por el bonus de las tiendas.
