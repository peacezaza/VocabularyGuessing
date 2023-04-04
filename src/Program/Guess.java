package Program;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class Guess{
    private Scanner scan = new Scanner(System.in);
    private ArrayList<Word> words = new ArrayList<>();
    private ArrayList<Word> usingWords = new ArrayList<>();
    private Random random = new Random();
    private Level level = new Level();
    private int indexOfRightWord;

    public Guess(){
        int sheetNumber = 0;
        if(level.getLevel()<=5){
            sheetNumber = 0;
        }
        else if(level.getLevel()<=10){
            sheetNumber = 1;
        }
        else if(level.getLevel()<15){
            sheetNumber=2;
        }
    getData(sheetNumber);

    }

    public void getData(int sheetNumber){

        try
        {
            File file = new File("src\\database\\Vocabulary.xlsx");   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
            //creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(sheetNumber);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file


            for(int i = 0 ; i<=sheet.getLastRowNum(); i++){
                Row r = sheet.getRow(i);
                Cell c = r.getCell(0);
                Cell c1 = r.getCell(1);
                this.words.add(new Word(c.getStringCellValue(), c1.getStringCellValue()));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }



    public Word rightWord(){
        this.indexOfRightWord = random.nextInt(0,words.size());
        this.usingWords.add(this.words.get(this.indexOfRightWord));
        return this.words.get(this.indexOfRightWord);
    }

    public Word wrongWord(){
        int guess = random.nextInt(0, words.size());
        while(guess == this.indexOfRightWord){
            guess = random.nextInt(0, words.size());
        }
        this.usingWords.add(this.words.get(guess));
        return this.words.get(guess);
    }

    public void shuffleWords(){
        long seed = System.nanoTime();
        Collections.shuffle(usingWords, new Random(seed));
    }

    public void clearWords(){
        usingWords.clear();
    }

    public Word getUsingWord(int index){
        return usingWords.get(index);
    }







}
