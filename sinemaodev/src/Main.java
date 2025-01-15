import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Filmler ve salonlar
        List<Film> filmler = new ArrayList<>();
        filmler.add(new Film("Joker", "2h 30m", "Drama", 1));
        filmler.add(new Film("Inception", "2h 28m", "Sci-Fi", 2));
        filmler.add(new Film("Interstellar", "2h 49m", "Sci-Fi", 3));
        filmler.add(new Film("The Dark Knight", "2h 32m", "Action", 4));
        filmler.add(new Film("Avatar", "2h 42m", "Action", 5));
        filmler.add(new Film("Titanic", "3h 14m", "Romance", 6));
        filmler.add(new Film("The Godfather", "2h 55m", "Crime", 7));
        filmler.add(new Film("The Matrix", "2h 16m", "Action", 8));
        filmler.add(new Film("Gladiator", "2h 35m", "Action", 9));
        filmler.add(new Film("The Shawshank Redemption", "2h 22m", "Drama", 10));

        List<Musteri> musteriler = new ArrayList<>();

        // Menü
        while (true) {
            System.out.println("\n--- Sinema Kayıt Sistemi ---");
            System.out.println("1. Filmleri Görüntüle");
            System.out.println("2. Müşteri Ekle");
            System.out.println("3. Kayıtlı Müşterileri Görüntüle");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // Boşluğu temizle

            switch (secim) {
                case 1:
                    // Filmleri ve salonları görüntüle
                    System.out.println("\nFilmler ve Salon Numaraları:");
                    for (Film film : filmler) {
                        System.out.println(film.getAd() + " - Salon " + film.getSalonNumarasi());
                    }
                    break;

                case 2:
                    // Müşteri ekle
                    System.out.print("\nMüşteri Adı: ");
                    String ad = scanner.nextLine();
                    System.out.print("Müşteri Soyadı: ");
                    String soyad = scanner.nextLine();
                    System.out.print("Müşteri Telefonu: ");
                    String telefon = scanner.nextLine();

                    // Filmlerden birini seç
                    System.out.println("\nFilmler:");
                    for (int i = 0; i < filmler.size(); i++) {
                        Film film = filmler.get(i);
                        System.out.println((i + 1) + ". " + film.getAd());
                    }
                    System.out.print("\nBir film seçin: ");
                    int filmSecim = scanner.nextInt();
                    Film secilenFilm = filmler.get(filmSecim - 1);

                    // Müşteri oluştur
                    Musteri yeniMusteri = new Musteri(ad, soyad, telefon, secilenFilm);
                    musteriler.add(yeniMusteri);
                    System.out.println("Müşteri başarıyla eklendi!");

                    // JSON'a kaydet
                    Musteri.saveToJson(musteriler);
                    break;

                case 3:
                    // Kayıtlı müşterileri görüntüle
                    System.out.println("\nKayıtlı Müşteriler:");
                    for (Musteri musteri : musteriler) {
                        System.out.println(musteri.getAd() + " " + musteri.getFilm().getAd() + " - Salon " + musteri.getFilm().getSalonNumarasi());
                    }
                    break;

                case 4:
                    // Çıkış
                    System.out.println("Çıkılıyor...");
                    return;

                default:
                    System.out.println("Geçersiz seçenek!");
            }
        }
    }
}
