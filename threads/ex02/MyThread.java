public class MyThread extends Thread {
    private int[] array;
    private int start;
    private int end;
    private int turn;
    private CommonResource res;
    public MyThread(int turn, int[] array, int start, int end, CommonResource res)
    {
        this.array = array;
        this.start = start;
        this.end = end;
        this.res = res;
        this.turn = turn + 1;
    }
    public void run()
    {
        int sum = 0;
        int begin = start;
        while (begin < end) {
            sum += array[begin];
            begin++;
        }
        res.result += sum;
        System.out.println("Thread " + turn +  ": from " + start + " to " + end + " sum is " + sum);
    }
}
