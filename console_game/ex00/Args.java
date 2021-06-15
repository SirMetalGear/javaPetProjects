package ex00;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Args {

    @Parameter(names = {"--enemiesCount"})
    private String en_count;
    @Parameter(names = {"--wallsCount"})
    private String walls_count;
    @Parameter(names = {"--size"})
    private String size;
    @Parameter(names = {"--profile"})
    private String profile;


    public void run()
    {
        System.out.println(en_count + " " + walls_count + " " + size);
    }

    public String getEn_count() {
        return en_count;
    }

    public String getWalls_count() {
        return walls_count;
    }

    public String getSizee() {
        return size;
    }

    public String getProfile() {
        return profile;
    }
}
