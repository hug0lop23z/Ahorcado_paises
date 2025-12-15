# 🌍 Ahorcado de Países (Java)
# 🌍 Ahorcado de Países (Java)

![Java](https://img.shields.io/badge/Language-Java-ed8b00?style=for-the-badge&logo=java&logoColor=white)
![Version](https://img.shields.io/badge/Version-1.0.0-blue?style=for-the-badge)
![Author](https://img.shields.io/badge/Author-Hugo%20López-lightgrey?style=for-the-badge)

Un juego de consola clásico del **Ahorcado** programado en Java, centrado en adivinar nombres de países. Este proyecto demuestra el uso de estructuras de control, manejo de Strings y lógica de juegos básica.

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Demo del Juego](#-demo-del-juego)
- [Requisitos](#-requisitos)
- [Instalación y Ejecución](#-instalación-y-ejecución)
- [Cómo Jugar](#-cómo-jugar)
- [Estructura del Código](#-estructura-del-código)
- [Autor](#-autor)

---

## 🎮 Características

* **Base de Datos Extensa:** Selección aleatoria entre cientos de países (desde *Afganistán* hasta *Zimbabue*) definidos en el código.
* **Arte ASCII:** Visualización progresiva del ahorcado en 7 estados diferentes (desde vacío hasta el dibujo completo).
* **Gestión de Errores:**
    * Muestra las letras que ya has fallado para evitar repeticiones.
    * Permite un máximo de **6 fallos** antes de terminar la partida.
* **Entrada Flexible:** El usuario puede intentar adivinar letra por letra o arriesgarse escribiendo el nombre completo del país.
* **Menú Interactivo:** Sistema de menú simple para iniciar juego o salir.

---

## 📸 Demo del Juego

Así se ve el juego en la consola cuando estás a punto de perder:

```text
     -----
     |   |
     O   |
    /|\  |
    /    |
         |
    =========
_ s p _ _ _ a

Letras falladas: [r, t, m, u, i]
