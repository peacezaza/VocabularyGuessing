package Program;
public class Word {
    private String eng;
    private String thai;
    public Word(String eng, String thai){
        this.eng = eng;
        this.thai = thai;
    }

    public String getEng() {
        return this.eng;
    }

    public String getThai() {
        return this.thai;
    }

    public Word getWord(){return new Word(this.eng, this.thai);}
}
