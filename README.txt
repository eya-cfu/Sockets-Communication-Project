-- Auteur : Eya Zaoui, RT2-1
-- Version 1.0 : La version 1.2 utilise une Base de Données SQLite au lieu de MySQL pour une meilleur portabilitee. Les programmes client et serveur sont egalement compilee en fichier .jar pour une plus simple execution. Voir dossier "Derniere version executable" 

Projet Java de communication socket Client-Serveur, avec implementation de Base de Données.

------------ IMPORTANT ------------
 * Pour la bonne execution des programmes Client et Serveur, il faut importer tout le dossier du Projet Java
   intitulée "Etudiants_EyaZaoui" l'IDE Eclipse.
 * La BD est faite sur MySql. Il faut activer le serveur MySql sur localhost:3306 (adresse par defaut) et 
   importer la BD "etudiants.sql" trouvée dans le dossier "db".
 * Pour voir le script SQL il suffit d'ouvrir "etudiants.sql".
 
 ---------- COMMENT CA MARCHE ----------
 
 - Importer la base de donnees dans MySql Server et mettre celui-ci EN MARCHE.(sur localhost:3306)
 - Executer le programme Server.java (dans l'IDE)
 - Executer le programme ClientUI.java (dans l'IDE)

 ---------- TROUBLESHOOTING -----------
 * Si le DriverManager n'est pas reconnu, ajouter mysql-connector-javaxx dans le Build Path:
 		1- Clic droit sur le projet "BD_Etudiant_1.1" ouvert dans Eclipse.
 		2- Build Path > Configure Build Path..
 		3- Ouvrer le tab "Libraries" et cliquez sur "Module Path"
 		4- Cliquer sur "Add Jars...", selectionner le projet "BD_Etudiant_1.1"
 		   et cliquer sur mysql-connector-java-xx. (xx est la version)
 		5- Ok > Apply.
