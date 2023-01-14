package controller;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

import java.util.concurrent.ForkJoinPool;

public class ThreadHandler {

    // Graphical tool to check if java is correct: Java VisualVM
    // Also, considerations:
    // https://stackoverflow.com/questions/24149834/choosing-optimal-number-of-threads-for-parallel-processing-of-data
    // https://stackoverflow.com/questions/1718465/optimal-number-of-threads-per-core
    // https://stackoverflow.com/questions/42015714/how-to-get-an-ideal-number-of-threads-in-parallel-programs-in-java
    // https://www.youtube.com/watch?v=0hQvWIdwnw4&list=PL0P3lVoxEIkglz_aoU9KHcGgYpF2H79k8&index=6&t=4173s
    // https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html
    // e.g.: 8 core = THEORETICALLY 16 threads, 16-active threads (e.g. 10) = number to use: max 6
    // or Number of Threads <= (Number of cores) / (1 - blocking factor), where 0 <= blocking factor < 1
    // Get number of Thread to parallelism: ForkJoinPool.commonPool(), the number parallelism is Number of Core of your machine - 1 (e.g. 7)

    // Get number of processors, e.g.: 8
    public void getNumberOfProcessors(){
        System.out.println("Number of available processors (cores): " + Runtime.getRuntime().availableProcessors());
    }

    //Get number of active threads (e.g.: 10), by thread group
    public void getThreadGroupInfo(){
        System.out.println("Current Thread Group: " + Thread.currentThread().getThreadGroup().getName());
        System.out.println("Number of active threads: " + Thread.activeCount()); //activeCount() only returns the number of threads in the same ThreadGroup
    }

    // Get the number of Thread to parallelism
    public void getNumThreadToParallelism(){
        System.out.println("Number of Thread to parallelism:" + ForkJoinPool.commonPool());
    }

    public void setNumberOfThreads(ComboBox<Integer> cbThreads, int defaultNumber){ //default number is 0, that will set the ComboBox to 1
        int maxthreads = (Runtime.getRuntime().availableProcessors() * 2);
        int availthreads = (maxthreads - Thread.activeCount());

        Integer[] array = new Integer[availthreads];

        for (int i = 1; i <= array.length; i++) {
            array[i-1] = i;
        }

        cbThreads.getItems().addAll(FXCollections.observableArrayList(array));
        cbThreads.getSelectionModel().select(defaultNumber);
    }

    public int getNumberOfThreads(){
        int maxthreads = (Runtime.getRuntime().availableProcessors() * 2);
        return (maxthreads - Thread.activeCount());
    }
}
