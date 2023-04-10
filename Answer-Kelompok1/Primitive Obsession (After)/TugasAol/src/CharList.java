import java.util.ArrayList;

public class CharList {
    // Menjadikan charList private agar tidak dapat diakses langsung dari luar kelas ini
    private ArrayList<Character> charList = new ArrayList<>();

    public void addChar(Character newChar) {
        charList.add(newChar);
    }

    public void deleteChar(int idx) {
        charList.remove(idx);
    }

    public boolean isEmpty() {
        return charList.isEmpty();
    }

    public int getSize() {
        return charList.size();
    }

    // Mengembalikan objek karakter dari charList berdasarkan indeks sebagai ganti dari metode getter individu sebelumnya
    public Character getCharacter(int idx) {
        return charList.get(idx);
    }
}
