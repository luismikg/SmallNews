# 📰 NewsApp

Una aplicación Android moderna que muestra las **últimas noticias** usando la API pública de [NewsAPI.org](https://newsapi.org).

---

## 🚀 Funcionalidad

La app consume el endpoint:  
`GET https://newsapi.org/v2/top-headlines?country=us&apiKey=TU_API_KEY`

Permite visualizar los **titulares más recientes de Estados Unidos**, mostrando el título, descripción e imagen de cada noticia en una interfaz limpia y fluida desarrollada con **Jetpack Compose**.

---

## 🧱 Arquitectura

El proyecto está desarrollado bajo el enfoque de **Clean Architecture** y **MVVM**, asegurando un código modular, mantenible y escalable.

Estructura principal:
- **Data layer:** manejo de API y modelos remotos.  
- **Domain layer:** casos de uso y lógica de negocio.  
- **Presentation layer:** UI reactiva con Jetpack Compose.

---

## 🛠️ Tecnologías Utilizadas

- **Kotlin**
- **Jetpack Compose** — UI declarativa moderna  
- **Retrofit** — consumo de API REST  
- **Hilt (Dagger)** — inyección de dependencias  
- **Coil** — carga eficiente de imágenes  
- **Coroutines & Flow** — programación asíncrona reactiva  

---

## ⚙️ Configuración

1. Crea una cuenta en [https://newsapi.org](https://newsapi.org)  
2. Obtén tu **API Key**  
3. Reemplaza `TU_API_KEY` en tu archivo `Constants.kt` de la capa de DATA

---

✨ _Desarrollado con pasión en Kotlin_
