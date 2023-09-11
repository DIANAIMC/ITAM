#include <iostream>
using namespace std; 

// PENDIENTE

int main() {
    // Reservar memoria para el arreglo
    int* arreglo {new int[5]{1, 2, 3, 4, 5}};
    // Liberar memoria previamente asignada
    for (int i = 0; i < 5; i++) {
        cout << arreglo[i] << " ";
    }
    delete[] arreglo;
    cout << *arreglo << " arreglo" << "\n";
    int col = 4;
    int ren = 2;
    // Reservar memoria para la matriz
    int** matriz {new int*[ren]}; 
    for (int i=0; i<ren; i++){
        matriz[i] = new int[col];
    }
    // Imprimimos los contenidos de la matriz
    for (int i=0; i<ren; i++) {
        cout << matriz[i] << "\n";
        for (int j=0; j<col; j++){
            cout << &matriz[i][j] << " ";
        }
        cout << "\n";
    }
    cout << *matriz << " matriz" << "\n";
    // Liberar la memoria previamente asignada
    for (int i=0; i<ren; i++){
        delete[] matriz[i];
    }
    delete[] matriz; 
    // Ya no va a regresar nada porque ya liberamos la memoria
    cout << *matriz << " matriz después" << "\n";
    for (int i=0; i<ren; i++) {
        cout << matriz[i] << "\n";
        for (int j=0; j<col; j++){
            cout << &matriz[i][j] << " ";
        }
        cout << "\n";
    }
    return 0;
    }