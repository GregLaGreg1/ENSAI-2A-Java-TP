FERTON GREGOIRE

---

## Questions

### 2.1 Simulation setup | OK

- Les probabilités ont été directement fixées dans le fichier 
applications.yml du dossier ressource, dans la section :
"hotel.spawn-probability"

- Création de deux boucles for dans le fichier Main, pour automatiser la création
d'étages et d'ascenceurs pour un nombre prédéfini dans le fichier applications.yml

- Le nombre d'ascenceurs est également fixé dans le fichier applications.yml, puis est utilisé via la commande :Config.getInt("hotel.floors.number")
(de même pour les quetions précédentes)

- Pour la méthode isFull(), on regarde juste la capacité maximale de 
l'ascenceur par rapport au nombre de personne dedans.

- On utilise cette méthode dans la méthode loadPassengers, qui ajoute, si l'ascenceur n'est pas plein, les passagers qui attendent.
---

### 2.2 Request an elevator | OK

- L'idée ici était que si aucun ascenceur n'est censé arriver à l'étage en question, alors on regarde le nombre de personnes de chaque ascenceur, puis on retient l'indice de l'ascenceur qui en contient le moins, et on ajoute dans la queue des destinations de l'ascenceur en question, l'étage où on se trouve.

---

### 2.3 Target Floor | OK

- L'idée un peu simpliste ici était que on pioche aléatoirement un étage parmis ceux de l'hotêl. Si cet étage est déjà celui où la personne se trouve, alors on repioche alétaoirement (avec remise) jusqu'à obtenir un étage différent.
---

### 2.4 Unit tests | OK

- Il est compliqué de tester la méthode isFull() car on ne peut pas facilemen mettre des passagers dans l'ascenseur sans passer par un Mock où il faudrait définir tous les passagers. La méthode addPassengersElevator() règle ce problème en permettant d'ajouter directement un nombre définides passagers pour les tests.

---

### 2.5 Crazy Elevator | OK

- Crée un héritage de la classe Elevator avec aucun nouveaux attributs

- On pioche avec équiproba égale à 1/3 une des situations au choix avec la même manière dont on avait choisi les étages des passagers dans la classe Person. Puis soit on ne fait rien, soit on enlève le prochain arrêt de l'ascenceur puis on applique la méthode move de la classe mère Elevator (qui prend juste le prochain, donc ici le second), soit on est simplement dans le même ca que la classe mère.

- On tire avec équiproba égale à 1/2, soit on fait rien, soit on utilise la méthode de la classe mère qui ne change pas ici.

- Si l'ascenceur est plein, les passagers "disparaissent" alors, on vide simplement la liste des passagers; sinon tout se passe normalement comme implémenté dans la classe mère.

- Le fichier Main a été adapté pour avoir 1 ascenceur lambda et un crazy ascenceur( qui est l'état final du Main en fin de compte).
---

### 2.6 Elevator Direction | PAS FINI

- Création d'une classe ENUM, adaptée dans cette situation même si on ne possède que trois directions. La méthode de calcul est simple pour déterminer les directions mais diffèrent entre les passagers et les ascenceurs. Pour le passager, c'est simplement le signe de la différence entre la position actuelle et l'étage voulue. Pour l'ascenceur, l'étage actuel et le prochain étage.