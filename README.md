## architecture
L'architecture du projet est basée sur la clean architecture exposée ici.
https://developer.android.com/jetpack/docs/guide?hl=en#overview
https://proandroiddev.com/how-to-implement-a-clean-architecture-on-android-2e5e8c8e81fe

## interface utilisateur
L'activité principale affiche une recycler view d'items espacés d'une journée Un click sur cet item affichera l'objet data Day sélectionné via Day.toString()

## tests
J'ai créé des test unitaires mais pas de test d'intégrations car je pense que n'importe quel appli Android peut avoir des test d'intégration. mais avoir des test unitaire impose plus de rigueur dans la séparation des responsabilités.
aller plus loin

* Je voulais aller plus loin avec mes injections de dépendances et les test unitaires mais il n'y a pas encore assez de logique métier pour le justifier
* Chez Europcar j'avais programmé l'upload offline avec la bibliothèque android-priority-jobqueue mais cette bibliothèque est deprecated et à été remplacée par android-workManager. Vous pouvez voir le travail que j'ai fait avec dans la branche prefetch mais elle ne compilera pas à cause d'un problème avec proguard.
* Vous pouvez ignorer le warning "3rd party plugin might be the cause" qui apparait lors de la synchronisation gradle
* Le bouton back n'a pas été codé sur le fragment detail
