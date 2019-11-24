L'architecture du projet est basée sur la clean architecture exposée [ici](https://proandroiddev.com/how-to-implement-a-clean-architecture-on-android-2e5e8c8e81fe) et [ici](https://developer.android.com/jetpack/docs/guide?hl=en#overview).

De le but de cesser d'utiliser RxJava, j'ai été enthousiaste lorsque j'ai appris que l'on pouvait désormais suivre cette approche : https://developer.android.com/topic/libraries/architecture/coroutines.

## interface utilisateur
L'activité principale affiche une recycler view d'items espacés d'une journée
Un click sur cet item affichera l'objet data Day sélectionné via Day.toString()

## aller plus loin
* Je voulais aller plus loin avec mes injections de dépendances et les test unitaires mais il n'y avait pas assez de logique métier pour le justifier (mise à jour, j'ai pushé un exemple plus abouti de test unitaires sur la branche storage)
* Chez Europcar j'avais programmé l'upload offline avec la bibliothèque [android-priority-jobqueue](https://github.com/yigit/android-priority-jobqueue) mais cette bibliothèque est deprecated et à été remplacée par [android-workManager](https://developer.android.com/topic/libraries/architecture/workmanager?hl=en). Vous pouvez voir le travail que j'ai fait avec dans la branche **prefetch** mais elle ne compilera pas à cause d'un problème avec proguard.
* Vous pouvez ignorer le warning "3rd party plugin might be the cause" qui apparait lors de la synchronisation gradle

## conflit dans les versions de kotlin.stdlib
La bibliothèque androidx.lifecycle:lifecycle-runtime-ktx:2.2.0 utilise la version 1.3.50. Cependant, ma version d'Andrdoid Studio est en version 3.1.4 et j'ai un bug lorsque je tente de mettre à jour l'IDE. Ceci implique que le  projet fait cohabiter la version stdlib 1.3.21 et la version 1.3.50. Celà abouti parfois à des problèmes de fichier progard définis 2 fois pour les coroutines.  
<br/>
[screen shot 1 Google Drive](https://drive.google.com/file/d/1l6DK8eygIRMCXAo1Z6SmYgos7--glkAL/view?usp=sharing) <br/>
[screen shot 2 Google Drive](https://drive.google.com/file/d/1c8eEh4AJxUfSKnEUeeBTTMYWbw_gBpeR/view?usp=sharing)
