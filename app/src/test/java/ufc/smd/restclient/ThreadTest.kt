package ufc.smd.restclient

import org.junit.Test

class ThreadTest {

    @Test
    fun executeAsThreadsTest() {
        println("Início - Thread: ${Thread.currentThread().name}")
        val thread1 = Thread {
            for (i in 1..100) {
                println("Thread1: $i")
                Thread.sleep(10)
            }
        }
        val thread2 = Thread {
            for (i in 1..100) {
                println("Thread2: $i")
                Thread.sleep(10)
            }
        }
        thread1.start()
        thread2.start()

        for (i in 1..100) {
            println("Código Main: $i")
        }

        // Aguarda as threads finalizarem para não encerrar o teste antes da hora
        thread1.join()
        thread2.join()

        println("Fim - Thread: ${Thread.currentThread().name}")
    }
}
