/*

Este código cuenta la frecuencia de ocurrencia de un conjunto de 
palabras en varios libros. El programa lee las palabras del archivo "palabras.csv" y los nombres
de los libros del vector "files". Luego, para cada libro, cuenta la frecuencia de ocurrencia de
cada palabra en el vocabulario y almacena los resultados en una matriz. Finalmente, escribe la
matriz en un archivo CSV y también calcula el tiempo promedio que toma el programa para 
ejecutarse en varias iteraciones y lo guarda en otro archivo CSV.

*/

#include <map>
#include <string>
#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <algorithm>
#include <mpi.h>
#include <iterator>
#include <cctype>

using namespace std;

int main (int argc, char *argv[]) {
    std::cout << "Empezamos" << "\n";
    // Inicialización de MPI
    MPI_Init(&argc, &argv);
    int world_size, world_rank;
    // Obtención del tamaño del mundo (número de procesos) y el rango del proceso actual
    MPI_Comm_size(MPI_COMM_WORLD, &world_size);
    MPI_Comm_rank(MPI_COMM_WORLD, &world_rank);
    std::cout << "Inicializa mpi" << "\n";
    // Número de ejecuciones para calcular el tiempo promedio
    const int ejecuciones = 10; 
    double total_time = 0.0;
    for (int i = 0; i < ejecuciones; i++){
        double start_time, end_time = 0.0;
        // El proceso maestro carga el archivo csv con el vocabulario y lo almacena en un vector
        std::vector<std::string> vocabulary;
        if (world_rank == 0) {
            // Se inicializa el tiempo
            start_time = MPI_Wtime();
            std::string vocabFile = "data/palabras.csv";
            std::ifstream vocabStream(vocabFile);
            std::string line;
            while (std::getline(vocabStream, line))
            {
                std::istringstream ss(line);
                std::string word;
                while (std::getline(ss, word, ','))
                {
                    vocabulary.push_back(word);
                }
            }
            if (vocabulary.empty()) {
                cerr << "El archivo de palabras está vacío" << endl;
                return 1;
            } else {
                std::cout << "Vocabulario procesado correctamente" << "\n";
            }
        }
        // Se define la lista de libros a procesar
        std::vector<std::string> files = {
            "data/libro1.csv",
            "data/libro2.csv",
            "data/libro3.csv",
            "data/libro4.csv",
            "data/libro5.csv",
            "data/libro6.csv"
        };
        // Se crea un diccionario para contar las ocurrencias de cada palabra en los archivos
        map<string, int> dictionary;
        if (world_rank < files.size()) {
            for (const string& word : vocabulary) {
                dictionary.insert({word, 0});
            }
        }
        int vocab_size = vocabulary.size();

        // Envíamos el vocabulario a todos los procesos
        MPI_Bcast(&vocab_size, 1, MPI_INT, 0, MPI_COMM_WORLD);
        if (world_rank != 0) {
            vocabulary.resize(vocab_size);
        }
        for (int i = 0; i < vocab_size; i++) {
            int len;
            if (world_rank == 0) {
                len = vocabulary[i].length();
            }
            MPI_Bcast(&len, 1, MPI_INT, 0, MPI_COMM_WORLD);
            if (world_rank != 0) {
                vocabulary[i].resize(len);
            }
            MPI_Bcast(const_cast<char *>(vocabulary[i].data()), len, MPI_CHAR, 0, MPI_COMM_WORLD);
        }
       
        // Verificamos que el proceso actual es menor que el tamaño del vector de archivos
        // y luego cuenta las palabras de su respectivo libro
        if (world_rank < files.size()) {
            std::ifstream vocabStream(files[world_rank]);
            std::string line;
            while (std::getline(vocabStream, line))
            {
                std::istringstream ss(line);
                std::string word;
                while (std::getline(ss, word, ','))
                {
                        dictionary[word]++;
                }
            }
        }
        // El proceso copia los valores del diccionario a un vector local
        std::vector<int> local(vocabulary.size());
        for (int j = 0; j < vocabulary.size(); j++) {
            string palabra = vocabulary[j];
            if (dictionary.count(palabra) > 0) {
                local[j] = dictionary[palabra];
            }
        }
        // Creamos el vector que va a almacenar todos los vectores temporales
        std::vector<int> all(vocabulary.size() * world_size);

        //MPI_Barrier(MPI_COMM_WORLD);
        // Recolectamos los resultados en el proceso maestro
        MPI_Gather(local.data(), vocabulary.size(), MPI_INT, all.data(), vocabulary.size(), MPI_INT, 0, MPI_COMM_WORLD);
        // Proceso maestro escribe los resultados en un archivo CSV
        if (world_rank == 0) {
            vector<vector<string>> matriz(7, vector<string>(vocabulary.size()));
            copy(vocabulary.begin(), vocabulary.end(), matriz[0].begin());
            for (int rank = 0; rank < world_size; rank++) {
                for (int j = 0; j < vocabulary.size(); j++) {
                    matriz[1 + rank][j] = std::to_string(all[rank * vocabulary.size() + j]);
                }
            }
            ofstream csvFile("data/resultados_paralelo.csv");
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < vocabulary.size(); j++) {
                    csvFile << matriz[i][j];
                    if (j != vocabulary.size() - 1) {
                        csvFile << ",";
                    }
                }
                csvFile << std::endl;
            }
            csvFile.close();
            
            end_time = MPI_Wtime();
            double exec_time = end_time - start_time; 
            total_time += exec_time;
        }

    }  
    // Se calcula el tiempo promedio
    if (world_rank == 0) {
        double avg_time = total_time / ejecuciones; 
        std::cout << "Promedio de tiempo de ejecucion: " << avg_time << " segundos" << std::endl;
        std::ofstream csv_file("data/tiempo_paralelo.csv");
        if (csv_file.is_open()){
            csv_file << avg_time;
            csv_file.close();
        }
    }
    MPI_Finalize();
    return 0;
}