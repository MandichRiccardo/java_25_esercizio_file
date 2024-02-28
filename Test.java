public class Test{
    public static void main(String[] args) {
        int valoreTotMagazzino = readFile();
        System.out.println("il valore totale del tuo magazzino è di " + valoreTotMagazzino + "€");
    }

    public static int getValoreTotaleRiga(String[] row){
        return Integer.parseInt(row[0]) * Integer.parseInt(row[1]);
    }

    protected static int readFile() {
        try{
            System.out.println("inserisci il nome del file sorgente");
            return getValoreTotaleMagazzino(new java.util.Scanner(System.in).nextLine());
        }catch (java.io.FileNotFoundException e){
            System.out.println("questo file non esiste");
        }
        readFile();
        return -1;
    }
    public static int getValoreTotaleMagazzino(String file) throws java.io.FileNotFoundException {
        java.io.BufferedReader reader = null;
        int valoreTotMagazzino = 0;
        try {
            reader = new java.io.BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("#");
                row = row[1].split("@");
                valoreTotMagazzino += getValoreTotaleRiga(row);
            }
        }catch (java.io.FileNotFoundException e){
            throw e;
        }catch (java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (java.io.IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        return valoreTotMagazzino;
    }
}
