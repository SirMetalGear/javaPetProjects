public class MyThread extends Thread {
    private String msg;
    private int times;
    private CommonResource res;
    public MyThread(CommonResource res, String msg, int times)
    {
        this.msg = msg;
        this.times = times;
        this.res = res;
    }
    public void run()
    {
        if (msg.equals("Hen")) {
            for (int i = 0; i < times; i++) {
                res.msg1();
            }
        }
        else {
            for (int i = 0; i < times; i++)
                res.msg2();
        }
    }
}
