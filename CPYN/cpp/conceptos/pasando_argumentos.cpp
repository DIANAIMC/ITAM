#include <iostream>
using namespace std;

/*
argc: es el número de argumentos en la línea de comandos, incluyendo el nombre 
    del programa como el primer argumento.
argv: es un arreglo de cadenas de caracteres que contienen los argumentos de la
    línea de comandos. El primer elemento argv[0] es el nombre del programa, y 
    los elementos siguientes contienen los argumentos restantes.
*/

int main(int argc, char** argv) {
    if (argc == 1){
        cout << "No se pasaron argumentos " << argv[0];
        return 0;
    } else {
        cout << " Ingresaste " << argc - 1 << " argumentos" << "\n";
        for (int i = 1; i < argc; i++) {
            cout << argv[i] << "\n";
        }
    }
    cout << "hola";
    return 0;
}