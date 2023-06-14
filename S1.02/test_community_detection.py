# Make your tests here
from community_detection import * 

def test_create_network():
    assert create_network(lecture_reseau('files/communaute0.csv')) == {'Alice': ['Bob', 'Dominique'], 'Bob': ['Alice', 'Charlie', 'Dominique'], 'Charlie': ['Bob'], 'Dominique': ['Alice', 'Bob']}
    liste_of_friends = ["Alice", "Bob", "Alice", "Charlie", "Bob", "Denis"]
    assert create_network(liste_of_friends) == {'Alice': ['Bob', 'Charlie'], 'Bob': ['Alice', 'Denis'], 'Charlie': ['Alice'], 'Denis': ['Bob']}
    print('test : OK')

def test_get_people():
    assert get_people(create_network(lecture_reseau('files/communaute0.csv'))) == ['Alice', 'Bob', 'Charlie', 'Dominique']
    assert get_people(create_network(lecture_reseau('files/communaute1.csv'))) == ['Giedrius', 'Mady', 'Kirsa', 'Vittore', 'Barbra', 'Faizel', 'Vittorio', 'Louis', 'Placide', 'Cloe', 'BjÃ¶rn', 'Rufino', 'Olavi', 'Teodor', 'Idelle', 'Illtyd', 'Glenys', 'Jakob', 'Marwa', 'Cain']
    print('test : OK')

def test_are_friend():
    assert are_friends(create_network(lecture_reseau('files/communaute0.csv')), 'Alice', 'Bob') == True
    assert are_friends(create_network(lecture_reseau('files/communaute0.csv')), 'Charlie', 'Bob') == True
    assert are_friends(create_network(lecture_reseau('files/communaute0.csv')), 'Dominique', 'Charlie') == False
    print('test : OK')

def test_all_his_friends():
    assert all_his_friends(create_network(lecture_reseau('files/communaute0.csv')), 'Alice', ['Bob', 'Dominique']) == True
    assert all_his_friends(create_network(lecture_reseau('files/communaute0.csv')), 'Alice', ['Charlie']) == False
    assert all_his_friends(create_network(lecture_reseau('files/communaute0.csv')), 'Charlie', ['Bob', 'Dominique']) == False
    print('test : OK')

def test_is_a_community():
    assert is_a_community(create_network(lecture_reseau('files/communaute0.csv')), ["Alice", "Bob", "Dominique"]) == True
    assert is_a_community(create_network(lecture_reseau('files/communaute0.csv')), ["Alice", "Bob", "Charlie"]) == False
    assert is_a_community(create_network(lecture_reseau('files/communaute0.csv')), ['Charlie', 'Bob']) == True
    print('test : OK')

def test_find_community():
    assert find_community(create_network(lecture_reseau('files/communaute0.csv')), ["Alice", "Bob", "Charlie", "Dominique"]) == ["Alice", "Bob", "Dominique"]
    assert find_community(create_network(lecture_reseau('files/communaute0.csv')), ["Charlie", "Alice", "Bob", "Dominique"]) == ['Charlie', 'Bob']
    assert find_community(create_network(lecture_reseau('files/communaute0.csv')), ["Charlie", "Alice", "Dominique"]) == ['Charlie']
    print('test : OK')

def test_order_by_decreasing_popularity():
    assert order_by_decreasing_popularity(create_network(lecture_reseau('files/communaute0.csv')), ["Alice", "Bob", "Charlie"]) == ['Bob', 'Alice','Charlie']
    assert order_by_decreasing_popularity(create_network(lecture_reseau('files/communaute0.csv')), ["Alice", "Bob", "Charlie", "Dominique"]) == ['Bob', 'Alice', 'Dominique', 'Charlie']
    print('test : OK')

def test_find_community_by_decreasing_popularity():
    assert find_community_by_decreasing_popularity(create_network(lecture_reseau('files/communaute0.csv'))) == ['Bob', 'Alice', 'Dominique']
    assert find_community_by_decreasing_popularity(create_network(lecture_reseau('files/communaute1.csv'))) == ['Mady', 'Vittorio', 'Rufino', 'Vittorio']
    liste_of_friends = ["Alice", "Bob", "Alice", "Charlie", "Bob", "Denis"]
    assert find_community_by_decreasing_popularity(create_network(liste_of_friends)) == ['Bob', 'Alice']
    print('test : OK')

def test_find_community_from_person():
    assert find_community_from_person(create_network(lecture_reseau('files/communaute0.csv')), 'Alice') == ["Alice", "Bob", "Dominique"]
    assert find_community_from_person(create_network(lecture_reseau('files/communaute0.csv')), 'Charlie') == ["Charlie", "Bob"]
    assert find_community_from_person(create_network(lecture_reseau('files/communaute0.csv')), 'Bob') == ['Bob', 'Alice', 'Dominique']
    print('test : OK')

def test_find_max_community():
    assert find_max_community(create_network(lecture_reseau('files/communaute0.csv'))) == ['Dominique', 'Bob', 'Alice']
    assert find_max_community(create_network(lecture_reseau('files/communaute1.csv'))) == ['Vittorio', 'Barbra', 'Vittore', 'Louis']
    print('test : OK')


"""
########################
## TEST EXPERIMENTALE ##
########################


from time import time
tab = []
for i in range(10000):
    t1 = time()
    dico_reseau(lecture_reseau('files/communaute1.csv'))
    t2 = time()
    tab.append(((t2-t1)*1000))

tab1 = []
for i in range(10000):
    t3 = time()
    create_network(lecture_reseau('files/communaute1.csv'))
    t4 = time()
    tab1.append(((t4-t3)*1000))

somme_tab = 0
for i in range(len(tab)):
    somme_tab += tab[i]
print('Le temps en ms pour la fonction "dico_reseau" : ',round(somme_tab/len(tab), 2))

somme_tab1 = 0
for i in range(len(tab1)):
    somme_tab1 += tab1[i]
print('Le temps en ms pour la fonction "create_network" : ',round(somme_tab1/len(tab1), 2))

tab3 = []
for i in range(10000):
    t5 = time()
    find_community_by_decreasing_popularity(create_network(lecture_reseau('files/communaute1.csv')))
    t6 = time()
    tab3.append(((t6-t5)*1000))

tab4 = []
for i in range(10000):
    t7 = time()
    find_community_from_person(create_network(lecture_reseau('files/communaute1.csv')), 'Cain')
    t8 = time()
    tab4.append(((t8-t7)*1000))

somme_tab3 = 0
for i in range(len(tab)):
    somme_tab += tab[i]
print('Le temps en ms pour la fontion "find_community_by_decreasing_popularity" : ',round(somme_tab/len(tab3), 2))

somme_tab4 = 0
for i in range(len(tab1)):
    somme_tab1 += tab1[i]
print('Le temps en ms pour la fonction "find_community_from_person" : ', round(somme_tab1/len(tab4), 2))"""

if __name__ == '__main__':
    test_create_network()
    test_get_people()
    test_are_friend()
    test_all_his_friends()
    test_is_a_community()
    test_find_community()
    test_order_by_decreasing_popularity()
    test_find_community_by_decreasing_popularity()
    test_find_community_from_person()
    test_find_max_community()