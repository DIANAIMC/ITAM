@echo off

rem Eliminamos stopwords y almacenamos el set de palabras (vocabulario)
python limpia_libros.py
rem Ejecutamos versión serial
serial.exe
rem Ejecutamos versión paralela
mpiexec -n 6 ceros.exe
rem Graficamos tiempos de ejecución
python grafica.py