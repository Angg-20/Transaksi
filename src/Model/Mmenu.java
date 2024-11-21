package Model;

public class Mmenu {

    private int id_menu,harga;
    String nama_menu;
    
    public void Mmenu(){
        
    }

    public Mmenu(int id_menu, int harga, String nama_menu) {
        this.id_menu = id_menu;
        this.harga = harga;
        this.nama_menu = nama_menu;
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }
}
