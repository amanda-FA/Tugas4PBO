public class transaksi extends item{
    private String noFaktur;
    private int jumlahBeli;
    private double total;

    public transaksi(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang);
        this.noFaktur = noFaktur;
        this.jumlahBeli = jumlahBeli;
        this.total = calculateTotal();
    }

    // Method untuk menghitung total harga
    private double calculateTotal() {
        return hargaBarang * jumlahBeli;
    }

    // Method untuk menampilkan informasi transaksi
    public void displayTransactionInfo() {
        System.out.println("No Faktur: " + noFaktur);
        displayItemInfo();
        System.out.println("Jumlah Beli: " + jumlahBeli);
        System.out.println("Total: " + total);
    }

    // Method untuk mengecek input dan menangani exception
    public static void main(String[] args) {
        try {
            transaksi transaksi = new transaksi("F123", "B001", "Laptop", 5000000, -3);
            if (transaksi.jumlahBeli <= 0) {
                throw new IllegalArgumentException("Jumlah beli harus lebih dari 0.");
            }
            transaksi.displayTransactionInfo();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
