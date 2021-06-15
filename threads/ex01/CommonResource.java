public class CommonResource {
    private boolean flag = true;
    public synchronized void msg1() {
        while (flag == true) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        System.out.println("Hen");
        flag = true;
        notify();
    }

    public synchronized void msg2() {
        while (flag == false) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        System.out.println("Egg");
        flag = false;
        notify();
    }
}
