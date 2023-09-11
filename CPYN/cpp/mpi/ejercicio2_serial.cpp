#include <iostream>
#include <cmath>
#include <chrono>
using namespace std;


// Función para verificar si un número es primo
bool esPrimo(int num) {
  for (int i = 2; i <= std::sqrt(num); i++) {
    if (num % i == 0) {
      return false;
    }
  }
  return true;
}

int contarNumerosPrimos(int num) {
    int count = 0;
    for (int i = 2; i <= num; i++) {
        if (esPrimo(i)) {
            count++;
        }
    }
    return count;
}

int main() {
    int n = 10;
    double start = 0.0;

    while(n<=100000000){
            auto start = chrono::high_resolution_clock::now();  // set the initial time
            int cantidadPrimos = contarNumerosPrimos(n);
            std::cout << "Datos: " << n;
            std::cout << " Primos: " << cantidadPrimos;
            auto end = chrono::high_resolution_clock::now(); 
            auto duration = chrono::duration_cast<chrono::microseconds>(end - start);
            cout << " Tiempo: " << (float)duration.count()/1000000 << std::endl; 
            n = n*10;
        }
    return 0;

}
