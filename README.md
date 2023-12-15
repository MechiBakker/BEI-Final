# Examen Especialización BackEnd 1

Se clonó el repositorio y se creo un repositorio privado para el proyecto. 

Se abrió el proyecto con IntelliJ y se intalaron los modulos, para poder acceder a la base de datos se utilizó docker para correr la imagen de mysql.

![WhatsApp Image 2023-08-17 at 19 09 26](https://github.com/ayellopez/esp-back1/assets/93293839/19cefa4e-d26d-4b44-b169-715aa6f8e3b9)


Luego con postman se corroboró que al correr el microservicio movie funcione de manera correcta.

![WhatsApp Image 2023-08-17 at 19 58 48](https://github.com/ayellopez/esp-back1/assets/93293839/4526976b-e4c1-42ff-b58c-9c9ce5ab28bd)


Se instaló y se configuro Eureka Server y luego se registro el microservicio Movie en Eureka

![WhatsApp Image 2023-08-17 at 21 00 30](https://github.com/ayellopez/esp-back1/assets/93293839/515f1042-82c4-46e9-937b-686fc0ebef9e)

cONFIGURACIONES
![image](https://github.com/ayellopez/esp-back1/assets/93297328/ba827ff4-ecba-4e28-a17b-9cb8a9ce6cc6)

![image](https://github.com/ayellopez/esp-back1/assets/93297328/c9da5272-8fe0-41d6-afe6-61beb169336b)

Durante el desarrollo del proyecto se tuvieron errores al momento de centralizar las configuraciones y agregar el microservicio catalog-service. Se rehizo el proyecto, se centralizaron dos veces las configuraciones en dos repositorios publicos de github distintos y se logro correr el config-server, eureka-server y el microservicio de movie. No se logro levantar el microservicio de catálogos. A continuacion se adjuntan imagenes que comprueban lo anterios.

![image](https://github.com/ayellopez/esp-back1/assets/93293839/f85630ea-18cd-4bef-8124-e1045e16b716)

error al correr el catalogo-service 
![image](https://github.com/ayellopez/esp-back1/assets/93293839/b3ea7fe5-0f27-4c41-8317-a2af3936f152)

![image](https://github.com/ayellopez/esp-back1/assets/93293839/f63fab57-ce19-4342-baf5-142380a24bb4)

Se levantaron todos los microservicios anteriores y se agregó el miroservicio de serie-service. (agregar captura) Se implementó rabbit en los ms de catálogo, movie y serie. Adicional se implementó zipkin en cada microservicio para ver la trazabilidad y Resilence4j.

### - Circuit Braker 

Para configurar el circuit breaker, realizamos las anotaciones en el applicatio.yml del ms de catálogo, donde le seteamos dos intancias una para movie y la otra para serie al momento de hacer llamados por genero. En cada una se definió tiempo de espera de 15000 milisegundos en estado abierto, para ver si el servicio se recuperó esperará 3 llamadas para poder decir, pasarlo a estado cerrado. Se podrá ver la informacion del servicio en actuator al momento que el servicio se abra. 

Además con retry se definió cuanto tiempo queremos esperar entre cada uno de los reintentos: se le configuro un tiempo de 1000 milisegundos y la cantidad de reintentos a 3.

