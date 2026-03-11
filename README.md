# Taller: Concurrencia y Paralelismo en Java

# Autores

- **Jaider Andres Ortiz Alvarado**
- **Juan Sebastian Camacho Reyes**

---

## 1. ¿Qué diferencia existe entre paralelismo y concurrencia?

El **paralelismo** consiste en ejecutar múltiples tareas **al mismo tiempo**, generalmente utilizando varios núcleos del procesador.

La **concurrencia**, en cambio, se refiere a la capacidad de un sistema para **gestionar múltiples tareas que progresan de forma simultánea**, aunque no necesariamente se ejecuten exactamente al mismo tiempo.

---

## 2. ¿Qué problema ocurre cuando varios hilos acceden al mismo recurso?

Cuando varios hilos acceden al mismo recurso compartido al mismo tiempo sin control, pueden generarse **inconsistencias en los datos**.

Esto ocurre porque los hilos pueden **leer o modificar el recurso al mismo tiempo**, provocando resultados incorrectos o inesperados.

---

## 3. ¿Qué es una condición de carrera (Race Condition)?

Una **condición de carrera** ocurre cuando **dos o más hilos acceden y modifican un mismo recurso compartido al mismo tiempo**, y el resultado final depende del orden en que se ejecutan las operaciones.

Esto puede provocar errores como:

- datos incorrectos
- valores inesperados
- comportamientos impredecibles en el programa

---

## 4. ¿Por qué es importante sincronizar el acceso a recursos compartidos?

La **sincronización** es importante porque permite controlar el acceso a recursos compartidos para que **solo un hilo pueda modificarlos a la vez**.

Esto ayuda a:

- evitar condiciones de carrera
- mantener la consistencia de los datos
- garantizar que el programa funcione correctamente en entornos concurrentes
