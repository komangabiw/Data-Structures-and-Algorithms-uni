import java.util.*;

public class CariDigimon_1402022066 {
    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("============Program Mencari Digimon============");
        System.out.println("===Dibuat oleh: I Komang Abimanyu/1402022066===");    //I Komang Abimanyu/1402022066
        System.out.println("===============================================");

        LinkedList<String> sortir = sortir(args);       
        hasilSortir(sortir);
    }
    static LinkedList<String> sortir(String[] listDigimon){
        LinkedList<String> digimon = new LinkedList<String>();          //linked list untuk yang sudah terdaftar digimon dengan syarat -mon 
        LinkedList<String> bukanDigimon = new LinkedList<String>();     //linked list untuk yang tidak terdaftar digimon karena bukan akhiran -mon
        LinkedList<String> berubah = new LinkedList<String>();          //linked list untuk merubah bukan digimon menjadi digimon
        LinkedList<String> hasilDigimon = new LinkedList<String>();     //linked list untuk penggabungan digimon dan non-digimon yang sudah diubah ke digimon
        for (String sortir : listDigimon) {
            if (sortir.length() > 2) {
                if (sortir.substring(sortir.length() - 3).equalsIgnoreCase("mon")) {
                    digimon.add(sortir);
                } else {
                    bukanDigimon.add(sortir);
                    berubah.add(sortir + "mon");
                }
            } else {
                bukanDigimon.add(sortir);
                berubah.add(sortir + "mon");
            }
        }
        hasilDigimon.addAll(digimon);
        hasilDigimon.addAll(berubah);
        System.out.println("Nilai args: " + Arrays.toString(listDigimon));
        System.out.println("List Digimon: " + digimon);
        System.out.println("List Bukan Digimon: " + bukanDigimon);
        return hasilDigimon;
    }
    static void hasilSortir (LinkedList<String> hasilSortir){
        ArrayList<String> digimonDanKekuatan = new ArrayList<String>();             //array list untuk penggabungan semua element(digimon+weapon+damage)
        String[] weapon = { "Agu-Sword", "Gabu-Bow", "Guil-Dagger", "Biyo-Laser" }; //array of string untuk menyimpan nama weapon untuk digunakan sesuai nama digimon 
        int[] damage = { 8, 7, 9, 7 };                                              //array of integer untuk menyimpan kekuatan weapon untuk digimon
        
        for (String hasilAkhir : hasilSortir) {
            if (hasilAkhir.substring(0, 4).equalsIgnoreCase("gabu")) {
                digimonDanKekuatan.add(hasilAkhir + "+" + weapon[1] + "=" + (hasilAkhir.length() + damage[1]));
            } else if (hasilAkhir.substring(0, 4).equalsIgnoreCase("guil")) {
                digimonDanKekuatan.add(hasilAkhir + "+" + weapon[2] + "=" + (hasilAkhir.length() + damage[2]));
            } else if (hasilAkhir.substring(0, 4).equalsIgnoreCase("biyo")) {
                digimonDanKekuatan.add(hasilAkhir + "+" + weapon[3] + "=" + (hasilAkhir.length() + damage[3]));
            } else if (hasilAkhir.substring(0, 3).equalsIgnoreCase("agu")) {
                digimonDanKekuatan.add(hasilAkhir + "+" + weapon[0] + "=" + (hasilAkhir.length() + damage[0]));
            } else 
                digimonDanKekuatan.add(hasilAkhir + "+" + "Any-Weapon" + "=" + (hasilAkhir.length() + 6));
        }
        System.out.println("List Digimon Setelah Merubah Bukan Digimon: " + hasilSortir);
        System.out.println("List Digimon Dengan Kekuatannya: " + digimonDanKekuatan);
    }
}