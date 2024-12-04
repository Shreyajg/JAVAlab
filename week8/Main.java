
class BMSThread extends Thread {
    private int count;

    public BMSThread(int count) {
        this.count = count;
    }

  
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("BMS College of Engineering");
            try {
                Thread.sleep(10000); // Sleep for 10 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class CSEThread extends Thread {
    private int count;

    public CSEThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("CSE");
            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int printCount = 5; // Number of times each message should be printed


        BMSThread bmsThread = new BMSThread(printCount);
        CSEThread cseThread = new CSEThread(printCount);


        bmsThread.start();
        cseThread.start();


        try {
            bmsThread.join();
            cseThread.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }


        System.out.println("My name is ArchieJain.");
        System.out.println("My usn is 1BM23CS049.");
    }
}
