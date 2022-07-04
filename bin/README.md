Pour lancer ce projet dans votre machine locale veillez suivre la procedure suivante:
1- rendez-vous sur le lien suivant: https://github.com/riki89/AssoManager
2- Cliquez sur "code", puis copiez lien sous HTTPS
3- Rendez-vous sur votre machine, puis ouvrir un terminal
4- Deplacer vous dans le dossier sur lequel vous voulez copier le projet
5- Tapez la commande suivante: git clone "coller le contenu de ce que vous avez copier auparavant"
6- Attendez que le projet termine le clonage
7- Ouvrir le projet avec votre editeur, IntelliJ par exemple
8- Une fois le projet ouvert, rendez-vous dans le fichier "resources/application.yml"
9- Si vous utilisez MAMP, XAMP ou LAMP configurez l fichier comme suit:
url: jdbc:mysql://localhost:8889/association
username: root
password: root //changer ce mot de passe si cela ne marche pas avec le votre, parfois laisser vide

Si vous utilisez un MySql interne, changez juste le mot de passe
10- Lancez le projet et rendez-vous sur un client comme Postman, REst Client de google chrome, etc, puis saisissez l'URL suivant:
POST http://localhost:8080/member
{
  "id": 123,
  "name": "My Name"
}

puis lancer le client, si tout se passe bien, vous aurez un message succes avec le meme mebre cree dans votre base de donnes
-- Vous pouvez aussi tester le lien suivant:
GET http://localhost:8080/member/123

