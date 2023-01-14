package controller;

import javafx.application.Platform;
import javafx.scene.control.Label;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

public class SystemLoadMEM extends Thread {

    private SystemInfo si;
    private HardwareAbstractionLayer hal;
    private GlobalMemory gm;
    private final int THREAD_SLEEP;
    private Label lb;
    private boolean exit;

    public SystemLoadMEM(Label label) {
        this.lb = label;
        this.si = new SystemInfo();
        this.hal = this.si.getHardware();
        this.gm = this.hal.getMemory();
        this.THREAD_SLEEP = 1000;
        this.exit = false;

    }

    @Override
    public void run(){

        while(!exit) {

            try {

            //total memory, e.g. 17066909696 Bytes = 15.8948 Gigabytes [16 GB RAM used]
            long mem_load_total = gm.getTotal(); // The amount of actual physical memory, in bytes.
            //System.out.println(mem_load_total);

            //free memory at the moment, e.g. 1594216448 Bytes = 1.4847 Gigabytes
            long mem_load_avail = gm.getAvailable(); // The amount of available physical memory, in bytes.
            //System.out.println(mem_load_avail);

            double diffperc = (100 - ((((double) mem_load_avail * 1.0 ) / (double) mem_load_total) * 100));
            String mem_load = String.valueOf(diffperc).substring(0,4)+"%";
            //System.out.println("Percentage: "+mem_load);

            Platform.runLater(() -> {
                this.lb.setText(mem_load);
            });

                Thread.sleep(THREAD_SLEEP);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
