package Model;

public class Morder {

    private int id_order;
    private int id_pelanggan;
    private int id_menu;
    private int jumlah;
    private int total_bayar;
    private String status;
    
    public void Morder(){
        
    }

    public Morder(int id_order, int id_pelanggan, int id_menu, int jumlah, int total_bayar, String status) {
        this.id_order = id_order;
        this.id_pelanggan = id_pelanggan;
        this.id_menu = id_menu;
        this.jumlah = jumlah;
        this.total_bayar = total_bayar;
        this.status = status;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(int id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotal_bayar() {
        return total_bayar;
    }

    public void setTotal_bayar(int total_bayar) {
        this.total_bayar = total_bayar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
