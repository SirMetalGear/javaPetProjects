public class Program {
    public static void main(String[] args) {
        if (args.length == 1)
        {
            String splitted[] = args[0].split("=");
            if (splitted.length == 2 && splitted[0].equals("--count"))
            {
                try
                {
                    int count = Integer.parseInt(splitted[1]);
                    if (count > 0) {
                        MyThread hen = new MyThread("Hen", count);
                        MyThread egg = new MyThread("Egg", count);
                        hen.start();
                        egg.start();
                        hen.join();
                        egg.join();
                        for (int i = 0; i < count; i++)
                            System.out.println("Human");
                        return ;
                    }
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
