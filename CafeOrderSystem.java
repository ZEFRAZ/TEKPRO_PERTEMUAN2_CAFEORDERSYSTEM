import java.util.Scanner; // Import Scanner untuk membaca input dari pengguna

// Class utama yang mengelola interaksi dengan pengguna
public class CafeOrderSystem {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk mengambil input dari pengguna
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Selamat Datang di Cafe Java Varata ===");

        // Mengambil input nama dan nomor telepon pelanggan
        System.out.print("Masukkan nama pelanggan: ");
        String name = scanner.nextLine(); // Membaca input nama pelanggan
        System.out.print("Masukkan nomor HP pelanggan: ");
        String phone = scanner.nextLine(); // Membaca input nomor HP pelanggan

        // Membuat objek Customer berdasarkan input pengguna
        Customer customer = new Customer(name, phone);

        // Membuat daftar menu yang tersedia di kafe
        MenuItem[] menu = {
            new MenuItem("Kopi Latte", 25000),
            new MenuItem("Americano", 38000),
            new MenuItem("Espresso", 15000),
            new MenuItem("Sandwich", 30000),
            new MenuItem("Donat", 15000),
            new MenuItem("Nasi Goreng", 22000)
        };

        // Menampilkan daftar menu kepada pelanggan
        System.out.println("\n===== Menu Cafe =====");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i].getName() + " - Rp " + menu[i].getPrice());
        }

        // Meminta pelanggan untuk memilih menu berdasarkan nomor
        System.out.print("\nPilih menu (masukkan nomor): ");
        int choice = scanner.nextInt();

        // Validasi input untuk memastikan pelanggan memilih nomor yang benar
        while (choice < 1 || choice > menu.length) {
            System.out.print("Pilihan tidak valid! Silakan pilih lagi: ");
            choice = scanner.nextInt();
        }

        // Mengambil objek MenuItem yang dipilih berdasarkan input pelanggan
        MenuItem selectedMenu = menu[choice - 1];

        // Meminta pelanggan untuk memasukkan jumlah pesanan
        System.out.print("Masukkan jumlah pesanan: ");
        int quantity = scanner.nextInt();

        // Membuat objek Order berdasarkan input pelanggan
        Order order = new Order(customer, selectedMenu, quantity);

        // Menampilkan detail pesanan
        System.out.println("\n===== Detail Pesanan =====");
        order.printOrderDetails();

        // Menutup Scanner untuk mencegah kebocoran sumber daya
        scanner.close();
    }
}

// Class Customer merepresentasikan pelanggan kafe
class Customer {
    private String name; // Nama pelanggan
    private String phoneNumber; // Nomor telepon pelanggan

    // Constructor untuk menginisialisasi objek Customer
    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Method untuk mendapatkan nama pelanggan
    public String getName() {
        return name;
    }

    // Method untuk mendapatkan nomor telepon pelanggan
    public String getPhoneNumber() {
        return phoneNumber;
    }
}

// Class MenuItem merepresentasikan item menu di kafe
class MenuItem {
    private String name; // Nama menu
    private double price; // Harga menu dalam rupiah

    // Constructor untuk menginisialisasi objek MenuItem
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Method untuk mendapatkan nama menu
    public String getName() {
        return name;
    }

    // Method untuk mendapatkan harga menu
    public double getPrice() {
        return price;
    }
}

// Class Order merepresentasikan pesanan pelanggan di kafe
class Order {
    private Customer customer; // Objek Customer yang melakukan pemesanan
    private MenuItem menuItem; // Objek MenuItem yang dipesan
    private int quantity; // Jumlah item yang dipesan

    // Constructor untuk menginisialisasi objek Order
    public Order(Customer customer, MenuItem menuItem, int quantity) {
        this.customer = customer;
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    // Method untuk menghitung total harga pesanan
    public double calculateTotal() {
        return menuItem.getPrice() * quantity;
    }

    // Method untuk menampilkan detail pesanan pelanggan
    public void printOrderDetails() {
        System.out.println("Pesanan untuk: " + customer.getName());
        System.out.println("Nomor HP: " + customer.getPhoneNumber());
        System.out.println("Menu: " + menuItem.getName());
        System.out.println("Jumlah: " + quantity);
        System.out.println("Total Harga: Rp " + calculateTotal());
        System.out.println("\n===== Terima kasih telah memesan! =====");
    }
}
