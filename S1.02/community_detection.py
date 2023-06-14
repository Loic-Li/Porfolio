##############
# SAE S01.01 #
##############

def liste_amis(amis, prenom):
    """
        Retourne la liste des amis de prenom en fonction du tableau amis.
    """
    prenoms_amis = []
    i = 0
    while i < len(amis)//2:
        if amis[2 * i] == prenom:
            prenoms_amis.append(amis[2*i+1])
        elif amis[2*i+1] == prenom:
            prenoms_amis.append(amis[2*i])
        i += 1
    return prenoms_amis

def nb_amis(amis, prenom):
    """ Retourne le nombre d'amis de prenom en fonction du tableau amis. """
    return len(liste_amis(amis, prenom))


def personnes_reseau(amis):
    """ Retourne un tableau contenant la liste des personnes du réseau."""
    people = []
    i = 0
    while i < len(amis):
        if amis[i] not in people:
            people.append(amis[i])
        i += 1
    return people

def taille_reseau(amis):
    """ Retourne le nombre de personnes du réseau."""
    return len(personnes_reseau(amis))

def lecture_reseau(path):
    """ Retourne le tableau d'amis en fonction des informations contenues dans le fichier path."""
    f = open(path, "r")
    l = f.readlines()
    f.close()
    amis = []
    i = 0
    while i < len(l):
        fr = l[i].split(";")
        amis.append(fr[0].strip())
        amis.append(fr[1].strip())
        i += 1
    return amis

def dico_reseau(amis):
    """ Retourne le dictionnaire correspondant au réseau."""
    dico = {}
    people = personnes_reseau(amis)
    i = 0
    while i < len(people):
        dico[people[i]] = liste_amis(amis, people[i])
        i += 1
    return dico

def nb_amis_plus_pop (dico_reseau):
    """ Retourne le nombre d'amis des personnes ayant le plus d'amis."""
    personnes = list(dico_reseau)
    maxi = len(dico_reseau[personnes[0]])
    i = 1
    while i < len(personnes):
        if maxi < len(dico_reseau[personnes[i]]):
            maxi = len(dico_reseau[personnes[i]])
        i += 1
    return maxi


def les_plus_pop (dico_reseau):
    """ Retourne les personnes les plus populaires, c'est-à-dire ayant le plus d'amis."""
    max_amis = nb_amis_plus_pop(dico_reseau)
    most_pop = []
    personnes = list(dico_reseau)
    i = 1
    while i < len(personnes):
        if len(dico_reseau[personnes[i]]) == max_amis:
            most_pop.append(personnes[i])
        i += 1
    return most_pop

##############
# SAE S01.02 #
##############

def create_network(list_of_friends):
    """ Cette fonction va parcourir une liste d'amis et retourner un réseau d'amis ."""
    network = {} #Initialisation du réseau
    i = 0
    #Boucle qui va prendre deux personnes de la liste a chaque fois
    while i < len(list_of_friends):
        #Variable qui va stocker les 2 personnes
        person1, person2 = list_of_friends[i], list_of_friends[i+1]

        #condition pour vérifier si la personne 1 se situe dans le réseau
        if person1 in network:
            #si c'est le cas, on va ajouter la personne 2 dans la liste de valeur
            network[person1].append(person2)
        #sinon, la fonction créer une nouvelle clé avec la personne 2 en tant que valeur et la personne 1 en tant que clé
        else:
            network[person1] = [person2]
        #vérifie la personne 2 si elle est dans le réseau
        if person2 in network:
            #si oui, alors la fonction ajoute la personne 1 à sa liste de valeur
            network[person2].append(person1)
        #sinon créer une nouvelle clé qui est la personne 2 et lui associe une valeur la personne 1
        else:
            network[person2] = [person1]
        #augmente 'i' de 2 pour passer au binome suivant dans la liste
        i += 2
    #retourne le réseau
    return network

"""
Question 2 : Comparer théoriquement et expériementalement les fonctions `dico_reseau` et `create_network`.

Théoriquement la fonction 'dico_reseau' est quadratique alors que 'create_network' est linéaire, donc théoriquement
la fonction 'create_network' est plus rapide que la fonction 'dico_reseau'.
Et après experimentation, sur une moyenne de 10000 fois pour chaque fonction,
pour 'dico_reseau' on obtient un temps de 0.24 ms.
Alors que pour la fonction 'create_network', on obtient un temps de 0.06 ms pour les 10000 tentatives.

"""

def get_people(network):
    """ La fonction permet de retourner une liste contenant toute les clés d'un dictionnaire """
    return list(network)

def are_friends(network, person1, person2):
    """ Cette fonction permet de vérifier si deux personne sont amis entre eux ."""

    #Conditions pour vérifier si person2 et une valeur de person1 dans le réseau
    if person2 not in network[person1]:
        #si person2 ne se situe pas dans les valeur de person1 alors ça retourne Faux
        return False
    #Sinon ça retourne Vrai
    return True


def all_his_friends(network, person, group):
    """ Cette permet de verifier si une personne est amis avec tout les autres personne d'un groupe .
    La fonction va prendre la personne en paramètre et vérifier si chacune des personnes dans le groupe est son amis.
    """

    #Initialise une boule qui va parcourir le groupe
    i = 0
    while i < (len(group)):
        #Conditions, si la personne est amis avec une personne du groupe, ca passe au suivant
        if are_friends(network, person, group[i]):
            i += 1
        else:
            #si la condition non respecter, retourne Faux directement
            return False
    #Et retourne Vrai, si les conditions sont atteinte et sort de la boucle
    return True

def is_a_community(network, group):
    """ 
    Cette fonction va vérifier si un groupe est une communauté, c'est-à-dire que les personne du groupe sont tous amis entre eux .

    Cette fonction va vérifier les groupe selon la taille du groupe,
        -Si la taille du groupe est supérieur à 3 :
            on prend une première personne et on regarde si cette personne est amis avec les autre personne du groupe
            et ainsi de suite avec les autres personnes
        -Si la taille du groupe est inférieur à 3 donc égale à 2 (un groupe c'est minimum 2):
            -on vérifie juste si les 2 personne sont amis entre eux

    Et la fonction va dire si c'est une communauté ou pas.
    """
    #Vérifie si la taille du groupe est supérieur à 3
    if len(group) >= 3:
        #Parcour le groupe
        for i in range(len(group)):
            #Deuxième boucle pour vérifier si la personne séléctionner avec i est amis avec les autres personne du groupe
            n = 0
            #Les conditions de la boucle sont : tant que n est inférieur a la taille du groupe et qu'on comapare pas les memes personnes
            while n < len(group) and group[i] != group[n]:
                #Si les deux personne comparer sont pas amis alors la fonction retourne Faux
                if not are_friends(network, group[i], group[n]):
                    return False 
                n+=1
        #Sinon retourne vrai
        return True
    #Dans le cas ou le groupe à une taille de 2
    else:
        #retourne vrai ou faux en fonction de si les 2 personne sont amis.
        if are_friends(network, group[0], group[1]):
            return True
        return False

def find_community(network, group):
    """ Cette fonction permet de chercher une communauté au sein d'un groupe, 
    et cette communauté se fera en fonction de la première personne du groupe .
    """

    #Initialisation de la communauté et ajout de la première personne du group
    community = []
    community.append(group[0])

    #Boucle qui va parcourir le groupe en commencent par la deuxième personne du groupe
    i = 1
    while i < (len(group)):
        #La fonction va vérifier si la personne du groupe est amis avec toute les personnes qui sont déjà dans la communauté
        if all_his_friends(network, group[i], community):
            #Si c'est le cas, la fonction ajoute cette personne dans la communauté
            community.append(group[i])
        i+=1
    return community

def order_by_decreasing_popularity(network, group):
    """" Cette fonction permet de trié un groupe en fonction de qui la personne qui a le plus d'amis ."""
    #On copie le groupe pour pouvoir faire les modifications dessus
    tab = group.copy()

    #Initialisation de la boucle qui va parcourir le groupe
    i = 0
    while i < len(group)-1:
        #La fonction va vérifier deux par deux pour voir qui a le plus d'amis entre les deux personne
        #Si la première personne à le plus d'amis on change pas l'ordre, et on passe a la deuxème personne et troisième personne du groupe
        if len(network[group[i]]) > len(network[group[i+1]]):
            i+=1
        #Sinon, on swap la position dans la table pour les 2 personnes
        else:
            tmp = group[i] #Variable temporaire pour stocker la personne puis la réutiliser
            #Déroulement du swap
            tab[i] = group[i+1]
            tab[i+1] = tmp
            i+=1
    #La fonction retourne le tableau copier et modifier
    return tab

def find_community_by_decreasing_popularity(network):
    """ Cette fonction va permettre de rechercher une communauté au sein d'un réseau et trier cette communauté en fonction de qui a la plus d'amis ."""
    #La fonction va prendre les personnes distinct du réseau
    person = get_people(network)
    #Chercher une communauté a l'intérieur de ce groupe
    community = find_community(network, person)
    #Et le trier en fonction du nombre d'amis, le plus populaire au moins populaire
    community_by_decreasing_popularity = order_by_decreasing_popularity(network, community)
    #retourne la table de communauté
    return community_by_decreasing_popularity

def find_community_from_person(network, person):
    """ Cette fonction peromet de trouver une communauté en fonction de la personne donnée en paramètre ."""
    #Initialise la communauté en fonction des cahiers de charge
    community = []
    #Ajoute la personne qui sera prit pour trouver la communauté, donc qui sera basé sur cette personne
    community.append(person)

    #Avant de commencer a faire la communauté, 
    # #la fonction trie d'abord la liste d'amis de la personne pour qu'elle soit déja trié
    for i in range(len(network[person])):
        community_order = order_by_decreasing_popularity(network, network[person])

    #Et dans cette boucle on va prendre les personne dans la liste d'amis de la personne donnée en paramètre 
    for i in range(len(community_order)):
        #vérifier s'ils sont amis avec tout les autres personnes qu'on va ajouter au fur et a mesure.
        if all_his_friends(network, community_order[i], community):
            community.append(community_order[i])
    #retourne la communauté en fonction de la personne
    return community


"""

Question 11 : Comparer théoriquement et expérimentalement les deux heuristiques de construction, celle donnée par la 
fonction `find_community_by_decreasing_popularity` et celles donnée par la fonction `find_community_from_person` appliquée à 
une personne la plus populaire (la recherche de la personne la plus populaire sera prise en compte dans la complexité).

Théoriquement, la fonction 'find_community_from_person' est quadratique et 'find_community_by_decreasing_popularity' est linéaire, donc logiquement 
'find_community_by_decreasing_popularity' serai plus rapide que la fonction 'find_community_from_person'.


Donc pour l'experimentation, j'ai choisie la communaute1.csv dans le repertoire files en prenant le pire cas pour la fonction 'find_community_from_person', le dernier de la liste
qui est "Cain", obtenue en utilisant 'get_people'.
Donc finalement, la fonction 'find_community_from_person' est plus rapide avec 0.13 ms comparer a la fonction 'find_community_by_decreasing_popularity'
pourtant le premier étant quadratique et le second linéaire.
Cette rapidité est justifier par ce que la fonction fait car dans la fonction 'find_community_by_decreasing_popularity',
elle va chercher une communauté dans tout le network et puis le trier par popularité.
Alors que la fonction 'find_community_from_person', va juste parcourir la liste de personne, puis trouver la communauté en fonction de cette personne en vérifiant s'ils sont amis.

"""

def find_max_community(network):
    """ Cette fonction permet de trouver la communauté la plus grande au sein d'un réseau """
    #Stocke les différentes personne du réseau dans la variable person
    person = get_people(network)
    #On dit que la communauté de la première personne de la liste person est la plus grande par défaut
    max = find_community_from_person(network, person[0])

    #Boucle qui va parcourir la liste person
    for i in range(len(person)):
        #Vérifier si la communauté la plus grande par défaut et plus grand ou non que les suivantes
        if max < find_community_from_person(network, person[i]):
            #Si c'est le cas, alors on va changer la communauté la plus grande
            max = find_community_from_person(network, person[i])

    #Retourne la communauté la plus grande après qu'on la trouver
    return max
