package controller;

import javafx.application.Platform;
import javafx.scene.control.Label;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class SystemLoadCPU extends Thread {

    private SystemInfo si;
    private HardwareAbstractionLayer hal;
    private CentralProcessor cpu;
    private Label lb;
    private boolean exit;

    public SystemLoadCPU(Label label) {
        this.lb = label;
        this.si = new SystemInfo();
        this.hal = this.si.getHardware();
        this.cpu = this.hal.getProcessor();
        this.exit = false;

    }

    @Override
    public void run(){

        while(!exit) {

            double cpu_load_raw = cpu.getSystemCpuLoad(2000); // delay - Milliseconds to wait.
            //System.out.println(cpu_load_raw);

            double cpu_load_perc = (cpu_load_raw * 100);
            //System.out.println(cpu_load_perc);

            String cpu_load = Double.toString(cpu_load_perc);
            if(cpu_load.length() <= 3){
                cpu_load = cpu_load+"0000";
                //System.out.println("Potolt: "+cpu_load);
            }

            String cpu_load2 = cpu_load.substring(0,4)+"%";
            //System.out.println("Levagott: "+cpu_load2);

            Platform.runLater(() -> {
                this.lb.setText(cpu_load2);
            });
        }
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
