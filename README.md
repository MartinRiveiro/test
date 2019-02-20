# test
Es en principio el codigo fuente que responde a los puntos 1,2 y 3 de la test. Tambien subi la base de datos de mysql. Lo que no pude hacer todavia es implementar el patron strategy, y crear unit test para la capa de servicios.

Servicios:

1-COTIZACION:

GET

http://localhost:8080(o el host que se utilice)/JavaAPI/rest/Cotizacion/Dolar consume la cotizacion de la url del banco provincia

http://localhost:8080*/JavaAPI/rest/Cotizacion/Pesos devuelve error not implemented

http://localhost:8080*/JavaAPI/rest/Cotizacion/Real devuelve error not implemented

2-USER:

GET

http://localhost:8080/JavaAPI/rest/user/usuarios es el que devuelve todos los usuarios de la base de datos

POST(application form urlencoded)

http://localhost:8080*/JavaAPI/rest/user/eliminar se debe enviar el id del usuario a eliminar

http://localhost:8080*/JavaAPI/rest/user/registrar se deben enviar los datos de nombre, apellido, email y password

http://localhost:8080*/JavaAPI/rest/user/modificar se deben enviar los datos de id(del usuario a modificar), nombre, apellido, email y password los tres responden al ABM de usuarios.

Con respecto a empaquetar todos los datos necesarios tendria que investigar bien si es que es necesario, porque hay cosas especialmente el tema de la base de datos, que cambia depende donde se ejecute. Me refiero que en mi caso por ej la conexion con la base de datos se hace a una url y puerto especifico donde esta el server y si se ejecutara en otro lado tal vez se deberia cambiar esa direccion de conexion que se debe especificar en el codigo fuente.

Tecnologias que utilice:

Eclipse

Jersey

Apache Tomcat

Wampserver, mysql
