#include <iostream> // para usar cout

int main() {
    int dato = 20;
    // int* es un apuntador a un entero
    int* apuntador= &dato; //&dato es dirección de memoria
    std::cout << "Dato " << dato << std::endl;
    std::cout << "Dirección de Dato " << &dato << std::endl;
    // *apuntador accedes a lo que está guardado en esa dirección de memoria
    std::cout << "Dato " << *apuntador << std::endl;
    std::cout << "Dirección de dato " << apuntador << std::endl;
    std::cout << "Dirección de apuntador " << &apuntador << std::endl;
    return 0;
}
