/*
0. Forzar a que sea un número par de procesos
1. Determinar a quién le vas a enviar el mensaje
    mi identificador + procesos/""

Si eres de los iniciales
    enviar      id + num_proc/2
    recibir     
Si no (eres de los finales)
    recibes     id - num_proc/4
    renvías
*/

#include <mpi.h>
#include <iostream>

using namespace std;

int main (int argc, char *argv[]) {
    long long int num_proc = atoll(argv[1]);
    if (num_proc % 2 != 0){
        return 0;
    }
    int num_processes = 0;
    int process_id = 0; 
    int name_length = 0;
    char host_name[MPI_MAX_PROCESSOR_NAME];
    /* Puse el partner 0 asumiendo que el sender.exe se ejecutara despues de
    receiver.exe */
    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &num_processes);
    MPI_Comm_rank(MPI_COMM_WORLD, &process_id);
    MPI_Get_processor_name(host_name, &name_length);

    if(process_id < num_proc/2){
        int partner = process_id + num_proc/2; 
        int numero_de_enteros_a_enviar = 1;
        int mensaje[1] = {partner};
        int etiqueta = 101;
        cout << "Hola soy proceso " << process_id << " en " << host_name << "\n";
        MPI_Send(&mensaje, numero_de_enteros_a_enviar, MPI_INT, partner, etiqueta, MPI_COMM_WORLD);
        for (int i = 0; i < numero_de_enteros_a_enviar; i++) 
            cout << "Proceso " << process_id << " envio el mensaje " << mensaje[i] << endl;
        
        int numero_de_enteros_a_recibir = 1;
        int mensaje_recibir[1] = {0};
        cout << "Hola soy proceso " << process_id << " en " << host_name << "\n";
        MPI_Status status;
        MPI_Recv(   &mensaje_recibir, 
                    numero_de_enteros_a_recibir,
                    MPI_INT, partner,
                    etiqueta,
                    MPI_COMM_WORLD, &status);
        for (int i = 0; i < numero_de_enteros_a_recibir; i++) 
            cout << "Proceso " << process_id << " recibió el mensaje " << mensaje_recibir[i] << endl;
        
    } else if (process_id >= num_proc/2){
        int partner = process_id - num_proc/2; 
        int numero_de_enteros_a_recibir = 1;
        int mensaje_recibir[1] = {0};
        int etiqueta = 101;
        cout << "Hola soy proceso " << process_id << " en " << host_name << "\n";
        MPI_Status status;
        MPI_Recv(   &mensaje_recibir, 
                    numero_de_enteros_a_recibir,
                    MPI_INT, partner,
                    etiqueta,
                    MPI_COMM_WORLD, &status);
        for (int i = 0; i < numero_de_enteros_a_recibir; i++) 
            cout << "Proceso " << process_id << " recibió el mensaje " << mensaje_recibir[i] << endl;

        int numero_de_enteros_a_enviar = 1;
        int mensaje_enviar[1] = {partner};
        cout << "Hola soy proceso " << process_id << " en " << host_name << "\n";
        MPI_Send(&mensaje_enviar, numero_de_enteros_a_enviar, MPI_INT, partner, etiqueta, MPI_COMM_WORLD);
        for (int i = 0; i < numero_de_enteros_a_enviar; i++) 
            cout << "Proceso " << process_id << " envio el mensaje " << mensaje_enviar[i] << endl;
    }

   MPI_Finalize();
   return 0;
}