# EstoNews - Application Android de News

## Description
Application Android qui affiche des articles de news en utilisant l'API JSONPlaceholder. Les articles sont affichés dans un RecyclerView avec des images générées dynamiquement.

## Technologies utilisées
- **Android SDK** (API 24+)
- **RecyclerView** - Pour afficher la liste des articles
- **Volley** - Pour les requêtes HTTP
- **GSON** - Pour parser le JSON
- **Glide** - Pour charger les images

## Architecture du projet

### Packages
- `models/` - Contient la classe Article
- `helpers/` - Contient VolleyHelper et GsonHelper
- `adapters/` - Contient ArticleAdapter pour le RecyclerView
- `ui/` - Contient HomeActivity

### Classes principales

#### Article.java
Modèle de données représentant un article avec :
- `id` : Identifiant unique
- `title` : Titre de l'article
- `body` : Contenu de l'article
- `getImageUrl()` : Génère une URL d'image basée sur l'ID

#### VolleyHelper.java
Singleton qui gère la file d'attente des requêtes HTTP Volley.

#### GsonHelper.java
Classe utilitaire pour parser le JSON reçu de l'API en liste d'objets Article.

#### ArticleAdapter.java
Adaptateur pour le RecyclerView qui affiche chaque article avec :
- Une image (chargée via Glide)
- Le titre (en gras)
- Le début du contenu (2 lignes max)

#### HomeActivity.java
Activité principale qui :
1. Initialise le RecyclerView
2. Effectue une requête HTTP vers JSONPlaceholder
3. Parse la réponse JSON
4. Affiche les articles dans le RecyclerView

## API utilisée
**Endpoint** : https://jsonplaceholder.typicode.com/posts
- Renvoie 100 articles fictifs
- Format JSON avec les champs `id`, `title`, `body`, `userId`

## Images
Les images sont générées dynamiquement via picsum.photos avec un seed basé sur l'ID de l'article pour avoir des images cohérentes.

## Installation

1. Cloner le projet
2. Ouvrir dans Android Studio
3. Synchroniser Gradle (les dépendances seront téléchargées automatiquement)
4. Lancer l'application sur un émulateur ou un appareil physique

## Dépendances

```gradle
dependencies {
    implementation 'androidx.recyclerview:recyclerview:1.3.2'
    implementation 'com.android.volley:volley:1.2.1'
    implementation 'com.google.code.gson:gson:2.10.1'
    implementation 'com.github.bumptech.glide:glide:4.16.0'
}
```

## Permissions
L'application nécessite la permission Internet :
```xml
<uses-permission android:name="android.permission.INTERNET" />
```

## Fonctionnalités
✅ Récupération des articles depuis une API REST  
✅ Affichage dans un RecyclerView  
✅ Chargement d'images asynchrone avec Glide  
✅ Gestion des erreurs réseau  
✅ Interface utilisateur responsive  

## Auteur
TP réalisé dans le cadre du cours Android
