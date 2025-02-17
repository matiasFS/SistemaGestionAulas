<a id="readme-top"></a>
<br />
<div align="center">
<h1 align="center">Sistema de gestión de aulas</h1>

</div>



<!-- TABLA DE CONTENIDOS -->
<details>
  <summary>Tabla de contenidos</summary>
  <ol>
    <li>
      <a href="#acerca-del-proyecto">Acerca del proyecto</a>
      <ul>
        <li><a href="#tecnologías-utilizadas">Tecnologías utilizadas</a></li>
      </ul>
    </li>
    <li><a href="#instalación">Instalación</a></li>
    <li><a href="#funciones-de-la-plataforma">Funciones de la plataforma</a></li>
    <li><a href="#contacto">Contacto</a></li>
   </ol>
</details>



<!-- ABOUT THE PROJECT -->
## Acerca del proyecto

Sistema para gestionar las aulas de la universidad. Permite solicitar aulas para exámenes finales o para cursada, dependiendo de la necesidad de cada docente. Se realizó un login, se asignaron roles de asistente, administrador general y administrador.

Funciones comunes a los roles asistente y administrador general: Modificar sus datos personales, ver los pedidos realizados, ver las aulas y edificios de la universidad, ver los espacios disponibles.

Funciones solo del role "asistente": Realizar pedidos de aulas.

Funciones solo del role "administrador general": Asignar un espacio a un pedido.

Funciones del role "administrador": Ver lista de usuarios. Agregar, borrar y editar el role de los usuarios.

<p align="right">(<a href="#readme-top">Volver arriba</a>)</p>



### Tecnologías utilizadas

* JAVA
* SPRING
* MySQL
* HIBERNATE
  
<p align="right">(<a href="#readme-top">Volver arriba</a>)</p>



<!-- INSTALACION -->
## Instalación

Asegurarse de tener Java 8+ y MySQL instalados.

1. Clonar el repositorio
  ```sh
  git clone https://github.com/matiasFS/SistemaGestionAulas.git
  ```

2. Crear base de datos con nombre "gestionaulas" sin las comillas.
   
3. En el archivo application.properties, que se encuentra en la carpeta "src/main/resources", realizar los siguientes cambios:

   spring.datasource.username="usuario"
 
    spring.datasource.password="contraseña"

    Reemplazar "usuario" y "contraseña" con la información correspondiente a su configuración de MySQL, sin las comillas.

4. Ejecución:

   Desde la IDE de su preferencia, buscar la clase "GestionAulasApplication.java", que se encuentra en la carpeta "src/main/java/com/sistema/GestionAulas", y ejecutarla como una aplicación Java.


5. Carga de datos:

    Ejecutar el script SQL que se encuentra dentro de la carpeta "...\GestionAulasBackend\SCRIPTSQL" 

6. Acceso a la aplicación:

    Una vez que la aplicación haya iniciado correctamente, utilizar postman o la aplicación que usted utilice para hacer las pruebas. La dirección es localhost:8080, donde 8080 es el puerto. El puerto puede variar    dependiendo de tu configuración.

 7. Credenciales:

    Admin general:
        Usuario: admingeneral
        Contraseña: admingeneral

    Admin:
        Usuario: admin
        Contraseña: admin

    Assistant/Asistente:
        Usuario: assistant
        Contraseña: asisstant

 8. Direcciones para testear:

    Todas poseen el formato "localhost:8080/api/..." exceptuando el login que utiliza "localhost:8080/auth"

    
    
<p align="right">(<a href="#readme-top">Volver arriba</a>)</p>


<!-- FUNCIONES -->
## Funciones de la plataforma

   Las principales funciones de la plataforma son:

   1. Login. "localhost:8080/auth", method: POST.
  
      ![Login](https://github.com/user-attachments/assets/3f876ad1-e7bc-4bf2-9e79-7c1ba4e8a36b)

   2. Listar los edificios. "localhost:8080/api/edificios", method: GET.
      
      ![ListarEdificios](https://github.com/user-attachments/assets/4239836f-6e6e-4475-9fc6-8c078e87fe56)

   3. Listar las aulas. "localhost:8080/api/aulas", method: GET.

      ![ListarAulas](https://github.com/user-attachments/assets/8b38f91c-be63-4781-a710-0abdc85cf683)

   4. Listar las aulas de un edificio en específico. "localhost:8080/api/aulasdeledificio/{id}", method: GET. Donde {id} es el id del edificio deseado.
         
      ![ListarAulasDelEdificio](https://github.com/user-attachments/assets/884f8c69-ed07-40f5-81a7-cbff80475a77)

   5. Listar los espacios. "localhost:8080/api/espacios", method: GET.

      ![ListEspacios](https://github.com/user-attachments/assets/bc16f024-be4c-4d9f-824a-fe8930150283)

   7. Buscar espacio por fecha, turno y aula. "localhost:8080/api/buscarespacio/{id}?fecha={fecha}&turno={turno}", method: GET. Donde {id} es el id del aula. Fecha es la fecha del espacio, y turno es M o T (Mañana o tarde).

      ![EspacioPorFechaYTurno](https://github.com/user-attachments/assets/07caf1f6-6672-4246-9aa1-c0c26252393a)

   8. Realizar pedido para curso. "localhost:8080/api/pedidoparacurso", method: POST.

      ![PedidoCurso](https://github.com/user-attachments/assets/9ded64a6-f91d-48aa-8cc2-8bb73f1dd614)

   9. Realizar pedido para examen final. "localhost:8080/api/pedidoparafinal", method: POST.

      ![PedidoFinal](https://github.com/user-attachments/assets/1d176b5f-f8e0-48ce-b570-cfe703170793)

   10. Listar pedidos para curso. "localhost:8080/api/listpedidoscurso", method: GET.

       ![ListPedidosCurso](https://github.com/user-attachments/assets/d3fedb30-9cd7-4520-8157-2e71607365f5)

   11. Listar pedidos para final. "localhost:8080/api/listpedidosfinal", method: GET.

       ![ListPedidosFinal](https://github.com/user-attachments/assets/cc3f3725-0772-4426-afae-177b51df0d58)

   12. Asignar un espacio a un pedido. Devuelve los datos del espacio y cambia el libre de true a false. "localhost:8080/api/asignarespacio/{id}?idNotaPedido={id1}", method: POST. Donde {id} es el id del espacio e {id1} es id del pedido.

       ![AsignarEspacio](https://github.com/user-attachments/assets/5dbe6129-c3a9-4f2f-9bf6-76db0743d0f4)

   13. El pedido muestra el espacio asignado previamente. 
       
       ![PedidoMuestraEspacioAsignado](https://github.com/user-attachments/assets/5686a0fb-d5c3-4b20-9012-7063c5cd5bb7)

   14. Borrar pedido. "localhost:8080/api/pedidoparafinal/{id}", method: DELETE. "localhost:8080/api/pedidoparacurso/{id}", method: DELETE. Donde {id} es el id del pedido a borrar.
  
       ![DeletePedido](https://github.com/user-attachments/assets/3733c12d-ada5-4ef7-891e-0f0c93f9ef0a)

<!-- CONTACT -->
## Contacto

Matias Silvestri - [Linkedin](https://www.linkedin.com/in/matiasfrancosilvestri/) - matias.f.silvestri1@gmail.com

<p align="right">(<a href="#readme-top">Volver arriba</a>)</p>
