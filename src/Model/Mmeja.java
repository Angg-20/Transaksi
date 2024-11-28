package Model;

public class Mmeja {

    int id_meja, no_meja, kapasitas;
    
    public void Mmeja(){
        
    }

    public Mmeja(int id_meja, int no_meja, int kapasitas) {
        this.id_meja = id_meja;
        this.no_meja = no_meja;
        this.kapasitas = kapasitas;
    }    

    public int getId_meja() {
        return id_meja;
    }

    public void setId_meja(int id_meja) {
        this.id_meja = id_meja;
    }

    public int getNo_meja() {
        return no_meja;
    }

    public void setNo_meja(int no_meja) {
        this.no_meja = no_meja;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }
        
    
    
}
