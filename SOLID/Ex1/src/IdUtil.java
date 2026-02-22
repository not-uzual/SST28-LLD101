public class IdUtil {
    public static int IDCount = 1;

    public static String nextStudentId() {
        String num = String.format("%04d", IDCount);
        IDCount++;
        return "SST-2026-" + num;
    }
}
