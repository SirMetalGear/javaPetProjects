public class MyThread extends Thread {
    String msg;
    int times;
    public MyThread(String msg, int times)
    {
        this.msg = msg;
        this.times = times;
    }
    public void run()
    {
        for (int i = 0; i < times; i++)
            System.out.println(msg);
    }
}
