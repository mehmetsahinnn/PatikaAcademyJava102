package PatikaStore;

import java.util.*;

public class PatikaStore {
    static Scanner scanner = new Scanner(System.in);
    static LinkedList<Notebooks> notebooks = new LinkedList<>();
    static LinkedList<SmartPhones> phones = new LinkedList<>();
    static TreeSet<Brand> brands = new TreeSet<>();
    static int count = 0;

    public static void main(String[] args) {

        while (count < 1) {
            notebooks.add(new Notebooks(1, "Asus TUF Gaming FX505GT", 9999, 100, 50, "Asus", 15, 16, 8, "Siyah"));
            notebooks.add(new Notebooks(2, "Lenovo IdeaPad Gaming 3", 9999, 100, 50, "Lenovo", 15, 16, 8, "Siyah"));
            notebooks.add(new Notebooks(3, "Apple MacBook Pro", 9999, 100, 50, "Apple", 15, 16, 8, "Siyah"));
            notebooks.add(new Notebooks(4, "MSI GF63 Thin 10SCSR", 9999, 100, 50, "MSI", 15, 16, 8, "Siyah"));

            phones.add(new SmartPhones(1, "Samsung Galaxy M31", 9999, 100, 50, "Samsung", 6, 6, 6000, "Siyah", 128));
            phones.add(new SmartPhones(2, "Xiaomi Redmi Note 10 Pro", 9999, 100, 50, "Xiaomi", 6, 6, 5020, "Siyah", 128));
            phones.add(new SmartPhones(3, "Apple iPhone 12 Pro Max", 9999, 100, 50, "Apple", 6, 6, 3687, "Siyah", 128));
            phones.add(new SmartPhones(4, "Huawei P40 Lite", 9999, 100, 50, "Huawei", 6, 6, 4200, "Siyah", 128));
            count++;
        }

        System.out.println("""
                PatikaStore Ürün Yönetim Paneli !
                 1 - Notebook İşlemleri
                2 - Cep Telefonu İşlemleri
                3 - Marka Listele
                0 - Çıkış Yap""");
        int selection = scanner.nextInt();
        System.out.println("Seçiminiz: " + selection);

        if (selection == 1) {
            notebookOperations();
        } else if (selection == 2) {
            phoneOperations();
        } else if (selection == 3) {
            listBrands();
        } else if (selection == 0) {
            System.exit(0);
        } else {
            System.out.println("Yanlış bir seçim yaptınız.");
        }
    }

    public static void notebookOperations() {
        System.out.println("""
                1 - Notebook Listele
                2 - Notebook Ekle
                3 - Notebook Sil
                4 - Ana Menü
                0 - Çıkış Yap""");
        int selection = scanner.nextInt();
        if (selection == 1) {
            printNotebooks();
        } else if (selection == 2) {
            addNotebooks();
            printNotebooks();
            main(null);
        } else if (selection == 3) {
            System.out.println("Silmek istediğiniz ürünün sırasını giriniz.");
            int sira = scanner.nextInt();
            notebooks.remove(sira - 1);
            printNotebooks();
            main(null);
        } else if (selection == 4) {
            main(null);
        } else if (selection == 0) {
            System.exit(0);
        } else {
            System.out.println("Yanlış bir seçim yaptınız.");
        }
    }

    public static void phoneOperations() {
        System.out.println("""
                1 - Cep Telefonu Listele
                2 - Cep Telefonu Ekle
                3 - Cep Telefonu Sil
                4 - Ana Menü
                0 - Çıkış Yap""");
        int selection = scanner.nextInt();
        if (selection == 1) {
            printPhones();
        } else if (selection == 2) {
            addPhones();
            printPhones();
            main(null);
        } else if (selection == 3) {
            System.out.println("Silmek istediğiniz ürünün sırasını giriniz.");
            int sira = scanner.nextInt();
            phones.remove(sira - 1);
            printPhones();
            main(null);
        } else if (selection == 4) {
            main(null);
        } else if (selection == 0) {
            System.exit(0);
        } else {
            System.out.println("Yanlış bir seçim yaptınız.");
        }
    }

    public static void printPhones() {
        if (phones.isEmpty()) {
            System.out.println("Telefon Listesi");
            System.out.println("Üzgünüz, mağazada mevcut telefon ürünü bulunmamaktadır.");
        } else {
            System.out.println("Telefon Listesi");
            System.out.println(" ---------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-3s | %-30s | %-10s | %-10s | %-10s | %-10s | %-8s | %-8s | %-8s |\n",
                    "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Pil", "RAM", "Renk");
            System.out.println(" ---------------------------------------------------------------------------------------------------------------------------");
            for (SmartPhones phone : phones) {
                System.out.printf("| %-3d | %-30s | %-10d | %-10s | %-10d | %-10d | %-8d | %-8d | %-8s |\n",
                        phone.getId(), phone.getName(), phone.getPrice(), phone.getBrand(),
                        phone.getStorage(), phone.getScreenSize(), phone.getBatteryPower(),
                        phone.getRam(), phone.getColor());
            }
            System.out.println(" ---------------------------------------------------------------------------------------------------------------------------");
        }
        listPhones();
    }

    public static void listPhones() {
        System.out.println("""
                1 - Cep Telefonu Ekle
                2 - Cep Telefonu Sil
                3 - Ana Menü
                0 - Çıkış Yap""");
        int selection = scanner.nextInt();
        if (selection == 1) {
            addPhones();
            printPhones();
            main(null);
        } else if (selection == 2) {
            System.out.println("Silmek istediğiniz ürünün sırasını giriniz.");
            int sira = scanner.nextInt();
            phones.remove(sira - 1);
            printPhones();
            main(null);
        } else if (selection == 3) {
            main(null);
        } else if (selection == 0) {
            System.exit(0);
        } else {
            System.out.println("Yanlış bir seçim yaptınız.");
        }
    }

    public static void printNotebooks() {
        if (notebooks.isEmpty()) {
            System.out.println("Notebook Listesi");
            System.out.println("Üzgünüz, mağazada mevcut notebook ürünü bulunmamaktadır.");
        } else {
            System.out.println("Notebook Listesi");
            System.out.println(" -----------------------------------------------------------------------------------------------");
            System.out.printf("| %-2s | %-30s | %-10s | %-10s | %-10s | %-8s | %-5s |\n",
                    "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
            System.out.println(" -----------------------------------------------------------------------------------------------");
            for (Notebooks notebook : notebooks) {
                System.out.printf("| %-2d | %-30s | %10d | %-10s | %-10d | %-8d | %-5d |\n",
                        notebook.getId(), notebook.getName(), notebook.getPrice(),
                        notebook.getBrand(), notebook.getStock(), notebook.getScreenSize(),
                        notebook.getRam());
            }
            System.out.println(" -----------------------------------------------------------------------------------------------");
        }
        listNotebooks();
    }

    public static void listNotebooks() {
        System.out.println("""
                1 - Notebook Ekle
                2 - Notebook Sil
                3 - Ana Menü
                0 - Çıkış Yap""");
        int selection = scanner.nextInt();
        if (selection == 1) {
            addNotebooks();
            listNotebooks();
            main(null);
        } else if (selection == 2) {
            System.out.println("Silmek istediğiniz ürünün sırasını giriniz.");
            int sira = scanner.nextInt();
            notebooks.remove(sira - 1);
            printNotebooks();
            main(null);
        } else if (selection == 3) {
            main(null);
        } else if (selection == 0) {
            System.exit(0);
        } else {
            System.out.println("Yanlış bir seçim yaptınız.");
        }
    }

    public static void addNotebooks() {
        System.out.println("Adı ne?");
        String name = scanner.next();
        System.out.println("Fiyatı ne?");
        int price = scanner.nextInt();
        System.out.println("Kaç tane var?");
        int stock = scanner.nextInt();
        System.out.println("İndirim yüzdesi?");
        int discount = scanner.nextInt();
        System.out.println("Marka?");
        String brand = scanner.next();
        System.out.println("Ekran boyutu?");
        int screenSize = scanner.nextInt();
        System.out.println("RAM?");
        int ram = scanner.nextInt();
        System.out.println("Batarya?");
        int battery = scanner.nextInt();
        System.out.println("Renk?");
        String color = scanner.next();
        notebooks.add(new Notebooks(notebooks.getLast().id + 1, name, price, stock, discount, brand, screenSize, ram, battery, color));
    }

    public static void addPhones() {
        System.out.println("Adı ne?");
        String name = scanner.next();
        System.out.println("Fiyatı ne?");
        int price = scanner.nextInt();
        System.out.println("Kaç tane var?");
        int stock = scanner.nextInt();
        System.out.println("İndirim yüzdesi?");
        int discount = scanner.nextInt();
        System.out.println("Marka?");
        String brand = scanner.next();
        System.out.println("Ekran boyutu?");
        int screenSize = scanner.nextInt();
        System.out.println("RAM?");
        int ram = scanner.nextInt();
        System.out.println("Batarya?");
        int battery = scanner.nextInt();
        System.out.println("Renk?");
        String color = scanner.next();
        System.out.println("Depolama?");
        int storage = scanner.nextInt();
        phones.add(new SmartPhones(phones.getLast().id + 1, name, price, stock, discount, brand, screenSize, ram, battery, color, storage));

    }

    public static void addBrands() {
        brands.add(new Brand(1, "Apple"));
        brands.add(new Brand(2, "Samsung"));
        brands.add(new Brand(3, "Huawei"));
        brands.add(new Brand(4, "Xiaomi"));
        brands.add(new Brand(5, "Oppo"));
        brands.add(new Brand(6, "Nokia"));
        brands.add(new Brand(7, "Casper"));
        brands.add(new Brand(8, "Monster"));
        brands.add(new Brand(9, "Lenovo"));
        brands.add(new Brand(10, "Asus"));
    }

    public static void listBrands() {
        addBrands();
        System.out.println("Markalar");
        System.out.println("--------");
        for (Brand brand : brands) {
            System.out.println(brand.name);
        }
        System.out.println("--------");
        main(null);
    }
}