public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        Switchable projPower = reg.getFirstCapable(Switchable.class);
        projPower.powerOn();
        reg.getFirstCapable(InputConnectable.class).connectInput("HDMI-1");

        reg.getFirstCapable(Dimmable.class).setBrightness(60);

        reg.getFirstCapable(TemperatureControllable.class).setTemperatureC(24);

        System.out.println("Attendance scanned: present=" + reg.getFirstCapable(AttendanceScannable.class).scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        for (Switchable s : reg.getAllCapable(Switchable.class)) {
            s.powerOff();
        }
    }
}
