import java.io.FileWriter;
import java.io.IOException;
public class Scrittore_csv {
    FileWriter writer;

    public Scrittore_csv(Lettore_csv reader, String fileIn, String fileOut) {
        try {
            writer = new FileWriter(fileIn);
            reader.aggiungiRiga(fileOut);
            reader.orderAndCompact();

            String info = "";
            for (int i = 0; i < reader.tabel.length; i++) {
                info = info.concat(reader.tabel[i] + "\n");
            }
            writer.write(info);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close();
        }
    }
    public Scrittore_csv(String file){
        try {
            writer = new FileWriter(file);

            String info = "";
            info += "nome";
            info += "," + "iniziativa";
            info += puntiFeritaToCsv();
            info += "," + "classeArmatura";
            info += "," + "competenza";
            info += "," + "puntiEsperienza";
            info += "," + "livello";
            info += "," + "dannoIniziale";
            info += "," + "amico";
            info += "," + "morto";
            info += forzaToCsv();
            info += destrezzaToCsv();
            info += costituzioneToCsv();
            info += intelligenzaToCsv();
            info += saggezzaToCsv();
            info += carismaToCsv();

            info += "," + "ispirazione";
            info += "," + "bonusSalvezza";
            info += tiriControMorteToCsv();
            writer.write(info + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String puntiFeritaToCsv(){
        String info = "";
        info += ",punti ferita attuali";
        info += ",punti ferita totali";
        return info;
    }
    public String caratteristicaToCsv(String caratteristica){
        String info = "";
        info += ",punteggio " + caratteristica;
        info += ",bonus salvezza " + caratteristica;
        return info;
    }
    public String forzaToCsv(){
        return caratteristicaToCsv("forza");
    }
    public String destrezzaToCsv(){
        return caratteristicaToCsv("destrezza");
    }
    public String costituzioneToCsv(){
        return caratteristicaToCsv("costituzione");
    }
    public String intelligenzaToCsv(){
        return caratteristicaToCsv("intelligenza");
    }
    public String saggezzaToCsv(){
        return caratteristicaToCsv("saggezza");
    }
    public String carismaToCsv(){
        return caratteristicaToCsv("carisma");
    }
    public String tiriControMorteToCsv(){
        String info = "";
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                info = info.concat(tiroControMorteToCsv(i, j));
            }
        }
        return info;
    }
    public String tiroControMorteToCsv(int i, int j){
        return "," + (j+1) + ((i==0) ? " successo" : " fallimento") + " tiri contro morte";
    }
    public void addCsv(String stringa) {
        try {
            writer.append(stringa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addFileName(String file){
        try {
            writer.write(file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}