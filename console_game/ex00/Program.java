package ex00;

import com.beust.jcommander.JCommander;

import java.io.*;
import java.util.concurrent.ExecutionException;

public class Program {
    public static void main(String[] args) {
        int i = 0;
        char  enemy_char = ' ';
        char player_char= ' ';
        char wall_char= ' ';
        char goal_char= ' ';
        char empty_char= ' ';
        String enemy_color= " ";
        String player_color= " ";
        String wall_color= " ";
        String  goal_color= " ";
        String  empty_color= " ";

        Converter conv;

        Args arges = new Args();



        JCommander jc = new JCommander();
        jc.addObject(arges);
        try {
            jc.parse(args);
        }
        catch (Exception e)
        {
            throw new IllegalParametersException();
        }

        if (args.length != 4)
        {
            System.out.println("Wrong input");
            System.exit(1);
        }
        try {
            File file = new File("./src/ex00/application-production.properties");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line;
            while (i < 10) {
                line = reader.readLine();
                if (line.regionMatches(0, "enemy.char=", 0, 11))
                    enemy_char = line.charAt(11);
                else if (line.regionMatches(0, "player.char=", 0, 12))
                    player_char = line.charAt(12);
                else if (line.regionMatches(0, "wall.char=", 0, 10))
                    wall_char = line.charAt(10);
                else if (line.regionMatches(0, "empty.char=", 0, 11))
                {
                    if (line.length() == 11)
                    {
                        empty_char = ' ';
                    }
                    else
                        empty_char = line.charAt(11);
                }
                else if (line.regionMatches(0, "goal.char=", 0, 10))
                    goal_char = line.charAt(10);
                else if (line.regionMatches(0, "enemy.color=", 0, 12))
                    enemy_color = line.substring(12);
                else if (line.regionMatches(0, "player.color=", 0, 13))
                    player_color = line.substring(13);
                else if (line.regionMatches(0, "wall.color=", 0, 11))
                    wall_color = line.substring(11);
                else if (line.regionMatches(0, "goal.color=", 0, 11))
                    goal_color = line.substring(11);
                else if (line.regionMatches(0, "empty.color=", 0, 12))
                    empty_color = line.substring(12);
                else
                {
                    System.out.println("Wrong conf");
                    System.exit(1);
                }
                i++;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        conv = new Converter();
        conv.take_chars(enemy_char, player_char, wall_char, goal_char, empty_char);
        conv.take_parav(Integer.parseInt(arges.getEn_count()), Integer.parseInt(arges.getWalls_count()), Integer.parseInt(arges.getSizee()));
        conv.take_colors(enemy_color, player_color, wall_color, goal_color, empty_color);
        conv.take_mode(arges.getProfile());
        conv.checkpatameters();
        conv.create_enemy_arr();

        try {
            conv.seeBMPImage();
        }
        catch (IOException ex)
        {
            System.out.println("bad convert");
            System.exit(1);
        }
    }
}
