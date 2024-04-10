## Explicación del Código LibraryManager

### Lógica del Programa:
- **Inicialización de Datos:**
  - En el constructor `LibraryManager()`, se inicializan las listas de documentos, autores y relaciones, así como un `Scanner` para la entrada del usuario.

- **Menú Principal (`displayMenu()`):**
  - El método `displayMenu()` muestra un menú interactivo para que el usuario elija diferentes opciones de gestión de biblioteca.
  - Utiliza un bucle do-while para repetir el menú hasta que el usuario decida salir (`choice == 7`).
  - Cada opción del menú corresponde a un método específico (`addDocument()`, `addAuthor()`, `associateAuthorWithDocument()`, etc.) que realiza una operación en función de la selección del usuario.

- **Operaciones de Gestión de Documentos y Autores:**
  - `addDocument()`: Permite al usuario agregar un nuevo documento con información como ID, título, año de publicación y tipo.
  - `addAuthor()`: Permite al usuario agregar un nuevo autor con ID y nombre completo.
  - `associateAuthorWithDocument()`: Asocia un autor existente con un documento existente mediante sus IDs.
  - `searchDocumentById()`: Busca un documento por su ID e imprime sus detalles junto con los autores asociados.
  - `searchAuthorById()`: Busca un autor por su ID e imprime sus detalles junto con los documentos asociados.
  - `listAllDocuments()`: Lista todos los documentos existentes junto con sus autores asociados.

- **Búsquedas por ID y Obtención de Asociaciones:**
  - `getAuthorsByDocumentId()`: Obtiene una lista de autores asociados a un documento específico utilizando la lista `authorDocuments`.
  - `getDocumentsByAuthorId()`: Obtiene una lista de documentos asociados a un autor específico utilizando la lista `authorDocuments`.
  - `getDocumentById()`: Busca un documento por su ID dentro de la lista de documentos.
  - `getAuthorById()`: Busca un autor por su ID dentro de la lista de autores.

### Método `main()`:
- El método `main()` crea una instancia de `LibraryManager` y llama a `displayMenu()` para iniciar el sistema de gestión de biblioteca.

### Notas Finales:
- Se utilizan estructuras de datos como listas (`ArrayList`) para almacenar documentos, autores y relaciones entre ellos.
- El código utiliza la entrada del usuario a través de un `Scanner` para recibir datos y opciones del menú.
- Cada método implementa una funcionalidad específica dentro del sistema de gestión de bibliotecas, facilitando la interacción y administración de documentos y autores.
- Este programa proporciona una base sólida para un sistema de gestión de bibliotecas simple en Java, permitiendo operaciones básicas como agregar, buscar y asociar documentos y autores. Además, demuestra conceptos clave como el uso de listas, iteración sobre colecciones y manejo de entrada del usuario.
