# magic-maze

	Pentru construirea labirintului am realizat clasa abstracta Cell si cate 
un tip de clasa pentru fiecare tip de celula: WallCell, PathCell, EntranceCell, 
ExitCell, care extind clasa abstracta Cell, si am construit si clasa Maze care 
salveaza harta labirintului sub forma unei matrice de Cell. In cazul in care in 
parcurgearea labirintului in cautarea portalului de iesire vom da peste un 
perete(o celula ce este instanta a clasei WallCell) vom arunca exceptia 
CannotMoveIntoWallsException, iar in cazul in care eroul incearca sa paseasca in 
afara labirintului exceptia HeroOutOfGroundException.

	Pentru rezolvarea labirintului si a celor 2 cerinte am realizat cate o 
clasa pentru fiecare dintre ele:
	Clasa Task1 contine metoda findPath care va returna drumul pe care eroul 
il urmeaza in cautarea portalului de iesire din labirint. Cautand calea spre 
iesire acesta va incerca sa mearga prin toate celule care sunt libere(nu sunt 
perete si nu in afara labirintului), alegandu-le in ordinea dreapta(R), fata(F), 
stanga(L), spate(B) in functie de orientarea lui in labirint, si o va alege pe 
cea mai putin vizitata dintre acestea. Ca eroul nostru sa faca acest lucru 
pentru fiecare celula prin care acesta va trece vom construi o lista in care 
vom adauga vecinii liberi ai acesteia in ordinea R,F,L,B, iar apoi aceasta 
lista o vom ordona cu un Comparator in functie de numarul de vizite ale 
fiecareia. Eroul va alege de fiecare data sa mearga pe prima celula din lista, 
aceasta fiind cel mai putin vizitata si avand astfel prioritatea cea mai mare. 
Aceasta celula va fi adaugata in lista cu drumul parcurs si va fi marcata ca 
vizitata inca o data. De asemenea, la fiecare pas se verifica daca am gasit 
portalul de iesire, iar in caz afirmativ vom returna lista cu drumul parcurs.

	Clasa Task2 are metoda findShortestPath care determina cu ajutorul 
algoritmului BFS drumul cel mai scurt de la portalul de intrare la portalul de 
iesire pe care eroul nostru va trebui sa il urmeze. In realizarea algoritmului 
eroul foloseste o coada in care va pastra, in ordinea R,F,L,B, toate celulele 
vecine libere(care nu au mai fost visitate, nu sunt perete si nu sunt in afara 
labirintului) pe care va urma sa le verifice in cautarea iesirii. Urmatoarea 
celula care va fi verificata va fi copilul celulei curente, astfel drumul va fi 
alcatuit din copilul copilului copilului...samd. al celulei de start. Eroul va 
marca fiecare celula pe care o incearca ca fiind vizitata pentru a nu o mai lua 
in calcul la urmatorul pas. Aceasta coada va fi alcatuita din elemente de tip 
Direction care ne vor da pozitiile celulor si care fiecare au cate un parinte. 
In momentul in care a fost gasita celula portalului de iesire se va construi o 
stiva cu parintii celulei ExitCell parcurgandu-i. Elementele stivei formeaza cel 
mai scurt drum.
	
	
