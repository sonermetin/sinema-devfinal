import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Musteri {
    private String ad;
    private String soyad;
    private String telefon;
    private Film film; // Hangi filme kayıtlı olduğunu gösterecek

    // Constructor
    public Musteri(String ad, String soyad, String telefon, Film film) {
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.film = film;
    }

    // Getters
    public String getAd() {
        return ad;
    }

    public Film getFilm() {
        return film;
    }

    // JSON'a kaydetme fonksiyonu
    public static void saveToJson(List<Musteri> musteriler) {
        try (FileWriter writer = new FileWriter("musteriler.json")) {
            Gson gson = new Gson();
            gson.toJson(musteriler, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
