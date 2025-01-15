import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Film {
    private String ad;
    private String sure;
    private String tur;
    private int salonNumarasi;

    // Constructor
    public Film(String ad, String sure, String tur, int salonNumarasi) {
        this.ad = ad;
        this.sure = sure;
        this.tur = tur;
        this.salonNumarasi = salonNumarasi;
    }

    // Getters
    public String getAd() {
        return ad;
    }

    public int getSalonNumarasi() {
        return salonNumarasi;
    }

    // JSON'a kaydetme fonksiyonu
    public static void saveToJson(List<Film> filmler) {
        try (FileWriter writer = new FileWriter("filmler.json")) {
            Gson gson = new Gson();
            gson.toJson(filmler, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
