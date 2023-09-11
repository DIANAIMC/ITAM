# n= cantidad de números que estarán en el arreglo
# Un solo hilo que está metiendo todos los elementos en el programa

# Crear hilos no están pesado como crear hilos, pues el crear un proceso requiere memoria
function suma_desprotegida(n)
    arreglo = Int[]
    for i in 1:n
        push!(arreglo,i)
    end
    print(arreglo)
    return sum(arreglo)
end

suma_desprotegida(10)

# El punto significa que no es parte de la librería estándar
# Si se usaran paquetes propios igual se tiene que usar el puntito

# El orden de ejecución de los hilos no se puede controlar, por ello la función es no determinista
using .Threads
function suma_desprotegida2(n)
    arreglo = Int[]
    @threads for i in 1:n   # a partir de aquí se van a crear hilos. Paralelo de forma concurrente.
        push!(arreglo,i)
        println("Soy hilo: ", Threads.threadid(), " agregando ", i)
    end
    print(arreglo)
    return sum(arreglo)
end

suma_desprotegida2(100)

function suma_protegida(n)
    arreglo = Int[]
    lk = ReentrantLock()
    @threads for i in 1:n   # a partir de aquí se van a crear hilos. Paralelo de forma concurrente.
        lock(lk) do
            push!(arreglo,i)
            println("Soy hilo: ", Threads.threadid(), " agregando ", i)
        end
    end
    print(arreglo)
    return sum(arreglo)
end

suma_protegida(100)
