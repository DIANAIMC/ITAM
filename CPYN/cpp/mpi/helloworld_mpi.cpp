#include <mpi.h>
#include <iostream>

using namespace std;

int main (int argc, char *argv[]) {
   const int MASTER = 0;
   // inicialización
   int num_processes = 0;
   int process_id = 0; 
   int name_length = 0;
   char host_name[MPI_MAX_PROCESSOR_NAME];
   
   MPI_Init(&argc, &argv);
   // Tamaño del grupo de comunicación
   MPI_Comm_size(MPI_COMM_WORLD, &num_processes); //número de procesos
   // Identificador de cada uno de los hilos, arranca desde 0
   MPI_Comm_rank(MPI_COMM_WORLD, &process_id);
   // definir el nombre del arreglo para el procesador
   MPI_Get_processor_name(host_name, &name_length);

   cout << "Hi from processos " << process_id << " on " << host_name << "\n";

   if (process_id == MASTER) 
      cout << "MASTER: The number of MPI processes is " << num_processes << "\n";
   
   MPI_Finalize();

   return 0;
}

// ejecutarlo con 4 procesos
// mpiexec -n 4 .\helloworld_mpi.exe