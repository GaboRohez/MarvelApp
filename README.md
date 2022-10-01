# MarvelApp Android

MarvelApp es una App para Android la cual consume la API publica de [Marvel Developer Portal](https://developer.marvel.com/)
### Requisitos mínimos
[![Android Studio](https://img.shields.io/badge/Android_Studio-4.2-blue.svg?longCache=true&style=popout-square)](https://developer.android.com/studio)
[![Android](https://img.shields.io/badge/Android%20Version-8.0-orange)](https://www.android.com)

### Tecnologias usadas en este desarrollo
* Kotlin
* MVVM Pattern
* RxJava
* viewBinding
* Navigation Components
* Glide
* [API Marvel Developer Portal](https://developer.marvel.com/)
* Retrofit

### Estructura de navegación
* Se uso una estructura de diferentes paquetes para poder ubicar de manera mas sencilla y rapida cada componente del proyecto

![alt text](https://github.com/GaboRohez/MarvelApp/blob/master/app/src/main/res/drawable/packages.png?raw=true)



### Se descargan los primeros 20 items del servicio web y al llegar al tope final del scroll, se lanza una nueva peticion para obtener los siguientes 20 items

<img src="https://github.com/GaboRohez/MarvelApp/blob/master/app/src/main/res/drawable/secuence.gif" width="300" />

