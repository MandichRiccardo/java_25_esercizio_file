public class Lettore_csv {
    public String[] tabel;
    public void getFile(String file) throws java.io.FileNotFoundException {
        java.io.BufferedReader reader = null;
        String line;
        tabel = new String[0];
        try{
            reader = new java.io.BufferedReader(new java.io.FileReader(file));
            while((line = reader.readLine()) != null){
                aggiungiRiga(line);
            }
        }
        catch (java.io.FileNotFoundException e){
            throw new java.io.FileNotFoundException();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            catch (NullPointerException e){
                System.out.println("reader non è stato instanziato");
            }
        }
    }
    public void orderAndCompact(){
        boolean scambio;
        do{
            scambio = false;
            for(int i=0;i<tabel.length-1;i++){
                if(tabel[i].compareTo(tabel[i+1])>0){
                    scambio = true;
                    scambio(i);
                }
            }
        }while (scambio);
        for(int i=1;i<tabel.length;i++){
            if(tabel[i].compareTo(tabel[i-1]) == 0){
                delete(i--);
            }
        }
    }

    private void scambio(int i) {
        String temp = tabel[i];
        tabel[i] = tabel[i +1];
        tabel[i +1] = temp;
    }

    public void delete(int h){
        String[] newTabel = new String[tabel.length-1];
        for(int i=0, j=0;j<newTabel.length;j++, i++){
            if(i==h) i++;
            newTabel[j] = tabel[i];
        }
        tabel = newTabel;
    }

    public void aggiungiRiga(String row){
        String[] newTabel;
        newTabel = new String[tabel.length+1];
        for(int i=0;i<tabel.length;i++){
            newTabel[i] = tabel[i];
        }
        newTabel[tabel.length] = row;
        tabel = newTabel;
    }

    public void outElencoPersonaggi(){
        System.out.println("personaggi presenti nel file:");
        for(int i=0;i<tabel.length;i++){
            System.out.print(i + ")\t");
            String[] row = tabel[i].split(",");
            for(int j=0;j<row.length;j++){
                System.out.printf("%-35s", row[j]);
            }
            System.out.println();
        }
    }
    public void outElencoNomiFile(){
        System.out.println("file csv:");
        for(int i=0;i<tabel.length;i++){
            System.out.println(i + ")\t" + tabel[i]);
        }
    }
}