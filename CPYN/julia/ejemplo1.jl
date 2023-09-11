# Vamos a crear una función que va a "aventar" una moneda y va a contar el número de caras
# Ouput: Total de caras

using Distributed

# Sin paralelizar
function azar_normal(lanzamientos)
    num_caras = 0
    for i=1:lanzamientos # Es inclusivo
        num_caras += Int(rand(Bool))
    end 
    num_caras
end 

# Paralelizando
function azar_paralela(lanzamientos)
    num_caras = @distributed (+) for i=1:lanzamientos
    Int(rand(Bool))
    end
    num_caras 
end


using Plots

#guarda los tiempos de ejecución en un arreglo
tiempos = []
procesos = []
contador = 1
for i=1:2*(Threads.nthreads())
    addprocs(1)
    print(contador)
    for j=1:10
        tiempo = @elapsed azar_paralela(10000000000)
        push!(tiempos, tiempo)
        push!(procesos, i)
        contador +=1
    end
end

#crea el gráfico
plot(tiempos, label = "Tiempo de ejecución", xlabel = "Número de procesadores", ylabel = "Tiempo (s)")
bar(procesos, tiempos, label = "Tiempo de ejecución", xlabel = "Número de procesadores", ylabel = "Tiempo (s)")
