# DemoMicroservicios

Se realizan 4 ejemplos que paso a detallar:

- Proyecto 1 --> Publicación de microservicio simple. Recoge información de una BBDD (H2) y la publica en un servicio REST.
- Proyecto 2 --> 2 microservicios. Uno es exactamente igual al del proyecto 1, pero el otro consume este servicio mediante RestTemplate, añade información extra y lo publica en un nuevo servicio REST. Es decir, el 2º actúa como cliente y servidor.
- Proyecto 3 --> Exactamente igual al proyecto 2, pero usa Feign en lugar de RestTemplate.
- Proyecto 4 --> Estructura (simple) de microservicios. Se utiliza los dos servicios del proyecto 3, pero se añade Eureka como servidor de nombres, Hystrix para la tolerancia a fallos y Zuul como puerta de enlace a los microservicios.
