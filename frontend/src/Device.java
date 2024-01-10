public class Device {
    private String imagePath;
    private String devname;
    private String os;
    private String cpu;
    private String ram;
    private String status;

    public Device(String imagePath, String devname, String os, String cpu, String ram, String status) {
        this.imagePath = imagePath;
        this.devname = devname;
        this.os = os;
        this.cpu = cpu;
        this.ram = ram;
        this.status = status;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getDevname() {
        return devname;
    }

    public String getOs() {
        return os;
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getStatus() {
        return status;
    }
}
