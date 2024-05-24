# Projet ”Plate-formes de développement” - SporterZ

---
## Descriptif du projet
SporterZ est une plateforme sociale conçue spécifiquement pour les passionnés de football. Elle offre un espace interactif où les fans peuvent échanger leurs idées, recevoir des notifications sur les matches de leurs équipes préférées, et participer à des discussions en direct avec d’autres fans dans des salles dédiées aux équipes ou aux matches. Les utilisateurs ont la possibilité de voter sur les résultats des matches, de partager des publications sur leur profil et de créer leurs propres salles de discussion. De plus, SporterZ propose une fonction de messagerie privée et de partage externe. L’interface de la plateforme est organisée de manière à présenter du contenu suggéré ainsi que du contenu suivi par l’utilisateur.


---

## Diagramme de cas d’utilisation
![Figure 1: Diagramme de cas d’utilisation](https://www.plantuml.com/plantuml/png/ZPB1QlCm48JlUeh5b_-K5_W98QNGGo6jQTfBRq9UnwAojaZhb53wxgsbn7ZHHRVix7oHPgnzP1ru6fros3CmGR2dWQ6p0GrRyaeRfW1l4GFe2Ctyer5gtcf_SWZ7JmgCuVrR0KmHZOu8pJrvZoRzN-iqznJ6PiQl-arR8qVq7RJ1dZKZ7316VSAOe7bp4mJ1-W9FnBQts44VQ8G7VQPW6U4LzPZfsNKphUb7iXwa_n-y45snUPqc4Mj0ym4jHSwcDATHt6lG0LUkD1UknAPZi5kTc-Ii5iSVgBFz1Tf0lNMOx5cwAaMyEyEJTd3GR0OiukLjNigh1TICyFpbLqGM_xHyBGNvJMmsE_61X2wgNtJHxIAABXTrwKvwPKbY9nfPBOh8WYhIYL3P8jyk_8VjrdhZfWvtEmKYROr_QQ76lBHJvKwjrRgBDciOqN85KBPV0uclKa6e7xL7tqsZ-mK0)

---

## Besoins Fonctionnels

### Authentification et Connexion
- Création de compte
- Connexion SSO (Single Sign On)

### Messagerie
- Envoi et réception de messages privés
- Notifications de nouveaux messages

### Suivi des Équipes
- Rester informé des équipes favorites
- Notifications sur les actualités et événements
- Consultation des résultats des matchs

### Accès aux salons dédiés aux équipes
- Participation aux discussions
- Affichage des messages des autres utilisateurs
- Rejoindre les salons des matchs en cours et des équipes favorites
- Interaction avec les autres utilisateurs

### Consultation des publications des autres utilisateurs
- Likes et commentaires
- Partager des publications

### Partage des publications
- Partager sur son profil
- Partager des publications vers d'autres réseaux sociaux
- Partager des publications vers les discussions privées
- Partager des publications vers les salons rejoints

### Affichage de la liste des salons rejoints
- Possibilité de quitter un salon

### Modifier son profil
- Modification de la photo, du nom, de la bio, etc.
- Modification des préférences (langue, notifications)

### Création de salons de discussion
- Créer ses propres salons
- Choix du sujet
- Invitation d'autres utilisateurs


---

## Besoins Non Fonctionnels

### Sécurité
- Garantie de la sécurité des données des utilisateurs
- Connexion sécurisée à la plate-forme
- Authentification et autorisation des utilisateurs
- Cryptage des données sensibles
- Protection contre les attaques XSS, CSRF, SQL injection, etc.

### Performance
- Temps de réponse rapide pour les actions utilisateur
- Capacité à gérer un grand nombre d'utilisateurs

### Évolutivité
- Adaptation à la croissance du nombre d'utilisateurs

### Maintenance
- Facilité de maintenance et de mise à jour

### Disponibilité
- Plateforme accessible 24h/24 et 7j/7
- Taux de disponibilité élevé (supérieur à 99,9%)

### Rate limiting
- Limitation du nombre de requêtes par utilisateur pour éviter les abus

### Logging et monitoring
- Enregistrement des événements et des erreurs (Prometheus, Grafana)
- Surveillance des performances de la plateforme

---
## Maquette 
![Figure 2: Acceuil et navigation](https://i.ibb.co/R6bqMR0/HOME.png)

---
