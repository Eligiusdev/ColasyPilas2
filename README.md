# Sistema Bancario en Java (Consola)

Este proyecto simula un sistema bancario sencillo utilizando estructuras de datos como **colas** (para gestionar clientes en espera) y **pilas** (para manejar el historial de transacciones de cada cliente). Todo el sistema se ejecuta desde consola, sin interfaz gráfica ni base de datos externa.

---

## 🧱 Estructura del Proyecto

El sistema está organizado en paquetes con clases bien separadas y documentadas:

### 📁 Paquetes y Clases

#### `modelo`
- **Cliente**: Representa a un cliente bancario con nombre, cédula, saldo y un historial de transacciones (pila).
- **Transaccion**: Representa una transacción bancaria (depósito, retiro o transferencia), con tipo, monto y fecha.

#### `utils`
- **Validacion**: Contiene métodos utilitarios para leer texto y números validados desde consola.

#### `servicio`
- **Exportar**: Permite exportar o importar clientes y transacciones desde/ hacia archivos de texto.

#### `vista`
- **MenuBanco**: Contiene la clase principal `main()` que gestiona el menú y las operaciones de interacción con el usuario.

---

## 🔄 Funcionalidades

1. **Agregar Cliente**: Se solicita nombre, cédula y saldo inicial.
2. **Ver Clientes**: Muestra la cola de clientes con sus datos.
3. **Atender Cliente**: Permite realizar múltiples transacciones (depósitos, retiros, transferencias) al cliente actual sin salir del proceso. Luego vuelve al menú general.
4. **Ver Historial del Último Cliente Atendido**: Muestra todas sus transacciones desde la pila.
5. **Guardar Clientes y Transacciones**: Exporta la información a archivos.
6. **Importar Clientes y Transacciones**: Recupera la información desde archivos previamente exportados.
7. **Buscar Cliente por Cédula**: Busca y muestra la información de un cliente específico.

---

## 💾 Estructuras de Datos Utilizadas

- `Queue<Cliente>` (cola): para representar la fila de espera de los clientes.
- `Stack<Transaccion>` (pila): para representar el historial de transacciones de cada cliente.

---

## 📂 Ejemplo de Uso

```bash
[1] Agregar Cliente
[2] Ver Clientes
[3] Atender Cliente (Realizar Transacciones)
[4] Ver Historial del Último Cliente Atendido
[5] Guardar Clientes y Transacciones
[6] Importar Clientes y Transacciones
[7] Buscar Cliente por Cédula
[0] Salir
```

---

## 📝 Detalles Técnicos y Validaciones

- Se valida que los montos ingresados sean válidos.
- No se permite retirar más dinero del disponible.
- Las transferencias requieren una búsqueda del destinatario.
- Cada transacción se registra con tipo, monto y fecha actual.

---

## 📚 Comentarios del Código

Cada clase y método está documentado con `JavaDoc` para facilitar su comprensión. Se puede generar documentación automática si se desea.

---

## 🚀 Futuras Mejoras

- Agregar seguridad por PIN o clave del cliente.
- Implementar interfaz gráfica (JavaFX).
- Persistencia con base de datos (MySQL o SQLite).
- Generación de reportes por cliente.

---

## 🧠 Autores y Créditos

Desarrollado por Stivenlings con asistencia de IA para aprender programación avanzada paso a paso.

---

¿Listo para comenzar? ¡Ejecuta `MenuBanco` y prueba el sistema!
# ColasyPilas2