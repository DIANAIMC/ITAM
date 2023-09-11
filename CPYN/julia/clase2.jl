#  --- CLASE 2 ---
# El import de Python es 'using'
# 'Distributed' permite agregar y quitar cores, utilizar todas las librerías de paralelización
using Distributed
# Número máximo de núcleos de la computadora que se podrían asignar
Sys.CPU_THREADS
# Número de cores asignados a Julia, ahora está en AUTO y toma el máximo en automático
Threads.nthreads()
# Cuántos procesos hay activos
procs()
# Cuántos trabajadores hay activos
workers()
# Agrega un nuevo proceso/hilo y para borrar rmprocs()
addprocs(3)
# Para eliminar varios procesos, hacerlos como un rango
rmprocs(4:6)