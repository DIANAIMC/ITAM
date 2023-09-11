function disminucion1(n)
    valor = 10000000
    @threads for i in 1:n
        valor -= 1 
    end
end

@time disminucion1(10000000)

using .Threads
function disminucion2(n)
    valor = 10000000
    lk = ReentrantLock()
    @threads for i in 1:n
        lock(lk) do
            valor -= 1 
        end
    end
end

@time disminucion2(10000000)

function disminucion3(n)
    @threads for i in 1:n
        10000000 - i
    end
end

@time disminucion3(10000000)

