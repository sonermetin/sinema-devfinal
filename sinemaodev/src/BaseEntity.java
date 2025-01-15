public class BaseEntity {
    private static int idCounter = 1; // ID sayacı
    private int id;

    public BaseEntity() {
        this.id = idCounter++; // Her yeni nesneye benzersiz bir ID verilir.
    }

    public int getId() {
        return id;
    }
}
