package rep2.application.model;

public class Vare {
    private Varekategori kategori;
    private String navn;
    private int udbudspris;
    boolean solgt;
    private Salgsannonce salgsannonce;

    public Vare(Varekategori kategori, String navn, int udbudspris) {
        this.kategori = kategori;
        this.navn = navn;
        this.udbudspris = udbudspris;
        this.solgt = false;
    }

    public Salgsannonce getSalgsannonce() {
        return salgsannonce;
    }

    public Varekategori getKategori() {
        return kategori;
    }

    public String getNavn() {
        return navn;
    }

    public int getUdbudspris() {
        return udbudspris;
    }

    public boolean getSolgt() {
        return solgt;
    }

    public void setSalgsannonce(Salgsannonce salgsannonce) {
        if(this.salgsannonce!=salgsannonce){
            Salgsannonce oldSalgsannonce = this.salgsannonce;
            if(oldSalgsannonce!=null){
                oldSalgsannonce.removeVare(this);
            }
            this.salgsannonce = salgsannonce;
            if (salgsannonce!=null){
                salgsannonce.addVare(this);
            }
        }

    }

    public void setSolgt() {
        solgt=true;

    }

    @Override
    public String toString() {
        String result;

        if(solgt){
            result =navn+" "+udbudspris+" solgt";
        }else{
            result =navn+" "+udbudspris+" til salg";
        }

        return result;
    }
}
