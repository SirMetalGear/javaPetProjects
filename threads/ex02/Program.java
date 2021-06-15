public class Program {
    public static void main(String[] args) {
        if (args.length == 2)
        {
            String splitted[] = args[0].split("=");
            String splitted2[] = args[1].split("=");
            if (splitted.length == 2 && splitted[0].equals("--arraySize")
                    && splitted2.length == 2 && splitted2[0].equals("--threadsCount"))
            {
                try
                {
                    int arraySize = Integer.parseInt(splitted[1]);
                    int threadCount = Integer.parseInt(splitted2[1]);
                    int[] array = new int[arraySize];
                    int shoulBe = 0;
                    for (int i = 0; i < arraySize; i++) {
                        array[i] = (int)(Math.random() * (1000 - 1) + 1);
                        shoulBe += array[i];
                    }
                    System.out.println("Sum: " + shoulBe);
                    int step = arraySize / threadCount;
                    int lastStep = step;
                    if (arraySize % threadCount != 0)
                        lastStep = step + (arraySize % threadCount);
                    CommonResource res = new CommonResource();
                    int index = 0;
                    MyThread[] calc = new MyThread[threadCount];
                    for (int i = 0; i < threadCount; i++)
                    {
                        if (i + 1 == threadCount)
                            step = lastStep;
                        calc[i] = new MyThread(i, array, index, index += step, res);
                        calc[i].start();
                    }
                    for (int i = 0; i < threadCount; i++)
                        calc[i].join();
                    System.out.println("Sum by threads: " + res.result);
                    return ;
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Wrong argument");
        System.exit(-1);
    }
}