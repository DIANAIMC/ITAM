#include <mpi.h>
#include <iostream>
#include <cmath>
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

int contarNumerosPrimos(int num, int idProceso, int num_procesos) {
    int count = 0;
    for (int i = idProceso + 2; i <= std::sqrt(num); i += num_procesos) {
        if (esPrimo(i)) {
            count++;
        }
    }
    return count;
}

int main(int argc, char** argv) {
    int n = 10;
    double start = 0.0;
    double end = 0.0;
    int idProceso, num_procesos = 0;
    int count = 0;

    MPI_Init(&argc, &argv); // Initialize MPI
    MPI_Comm_rank(MPI_COMM_WORLD, &idProceso); // Get the rank of the current process
    MPI_Comm_size(MPI_COMM_WORLD, &num_procesos);

    while(n<=100000000){
        int local_count = 0;
        if (idProceso == 0) {
            start = MPI_Wtime();  // set the initial time
        }

        int cantidadPrimos = contarNumerosPrimos(n, idProceso, num_procesos);

        MPI_Reduce(&cantidadPrimos, &count, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

        if (idProceso == 0) {
            end = MPI_Wtime();
            cout << "Datos: " << n;
            cout << " Primos: " << count;
            cout << " Tiempo: " << end - start << std::endl; 
        }
        // Sincronizar todos los procesos antes de continuar
        MPI_Barrier(MPI_COMM_WORLD);
        n = n*10;
    }

    MPI_Finalize();
    return 0;
}