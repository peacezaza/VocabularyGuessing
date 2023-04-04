package Program;
import java.io.*;

public class Level {
    private int experience;
    private int level = 1;
    private int gapLevel = 40;
    private File file = new File("src/database/Experiences.txt");
    private File levelFile = new File("src/database/Levels.txt");
    public Level() {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            this.experience = Integer.valueOf(bufferedReader.readLine());
            FileReader fileReader1 = new FileReader(levelFile);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            this.level = Integer.valueOf(bufferedReader1.readLine());

        } catch (IOException e) {

        }
    }

    public void addExperience(){
        this.experience += 5;
        while(this.experience >= this.gapLevel){
            calculateLevel();
            this.experience -= this.gapLevel;
            this.gapLevel *= 2;
        }
        try{
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(String.valueOf(this.experience));
            fileWriter.close();
            System.out.println(String.valueOf(this.experience));
        }
        catch (IOException e){

        }
    }

    public int getExperience(){return this.experience;}

    public int getLevel(){return this.level;}

    public void calculateLevel(){
        this.level += 1;
        try{
            FileWriter fileWriter = new FileWriter(levelFile);
            fileWriter.write(String.valueOf(this.level));
            fileWriter.close();
        }
        catch (IOException e){

        }
    }

    public int getGapLevel(){
        return this.gapLevel;
    }

}
