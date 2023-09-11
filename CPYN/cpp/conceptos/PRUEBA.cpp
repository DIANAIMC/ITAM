#include <iostream> // Para poder usar cout
#include <vector> // para usar vectores
#include <string> // para poder usar strings

using namespace std; // para no tener que escribir std

int main() 
{
    vector<string> msg {"Hello", "C++", "World", "from", "VS Code", "and the C++ extension!"};
    /*
    const string& word es la definición de la variable de iteración. En este caso, 
    estamos declarando una referencia constante a un objeto de tipo string, y la 
    llamamos word.

    : es el operador de rango que separa la variable de iteración de la colección.
    msg es la colección a través de la cual iterar. En este caso, suponemos que es un 
    objeto que puede ser iterado, como un vector o una matriz.

    Al agregar const y una referencia (&) a la definición de word, estamos diciendo 
    que word no se puede modificar dentro del bucle, y que en cambio se accede a cada
    elemento de msg a través de una referencia a su ubicación en memoria
    */
    for (const string& word : msg)
    {
        cout << word << " ";
    }
    cout << endl; // es un enter como un \n
    for (int i = 0; i < 6; i++) {
        cout << msg[i] << " ";
    }
    cout << endl; // es un enter como un \n
}
