public class MegaBytesconverter {

    public static void main(String[] args) {
        printMegaBytesAndKiloBytes(2500);
    }

    public static void printMegaBytesAndKiloBytes(int KiloBytes){
        if (KiloBytes<0) {
            System.out.println("Invalid Value");
        }
        else {
            int megebytes = KiloBytes / 1024;
            int remainingkilobytes = KiloBytes - (megebytes * 1024);
            System.out.println(KiloBytes + " KB = " + megebytes + " MB and " + remainingkilobytes + " KB");
        }
    }
}
