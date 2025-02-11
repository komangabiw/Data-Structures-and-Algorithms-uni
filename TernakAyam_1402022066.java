import java.util.HashMap;
public class TernakAyam_1402022066 {
    public static void main(String[] args) {
        System.out.println("========================================================");
        System.out.println("==================PROGRAM Ternak Ayam===================");
        System.out.println("=======Dibuat oleh: I Komang Abimanyu/1402022066========"); // I Komang Abimanyu/1402022066
        System.out.println("========================================================");
        if (args.length == 3) {
            if (CekArgumen(args)) {
                if (Integer.parseInt(args[0]) > 0 && Integer.parseInt(args[0]) <= 1000) {
                    if ((Integer.parseInt(args[1]) + Integer.parseInt(args[2])) >= 0 && (Integer.parseInt(args[1]) + Integer.parseInt(args[2])) <= 3) {
                        HashMap<Integer, String> chiki = InputAyam(args, 2, 8); //untuk menampung chiki
                        HashMap<Integer, String> chiku = InputAyam(args, 6, 3); //untuk menampung chiku
                        CetakSummary(chiki, "Chiki");   
                        CetakSummary(chiku, "Chiku");
                        System.out.println("\nOmset Telur Chiki: " + TotalHargaTelur(chiki));
                        System.out.println("Omset Telur Chiku: " + TotalHargaTelur(chiku));
                    } else 
                        System.out.println("Input tidak valid! Jumlah pemberian pakan FoodA+FoodB tiap harinya tidak boleh melebihi 3!");
                } else 
                    System.out.println("Argumen pertama(jumlah hari berternak) tidak boleh lebih dari 1000");
            } else 
                System.out.println("Argumen harus berupa angka");
        } else 
            System.out.println("Argumen harus 3, tidak boleh kurang atau lebih");
    }

    static boolean CekArgumen(String[] args) {
        for (String string : args)
            for (char c : string.toCharArray())
                if (!Character.isDigit(c))
                    return false;
        return true;
    }

    static int TotalHargaTelur(HashMap<Integer, String> namaAyam) {
        int temp = 0; //untuk menampung jumlah harga total telur
        for (int i = 1; i <= namaAyam.size(); i++)
            temp += namaAyam.get(i).equals("gold") ? 6000 : namaAyam.get(i).equals("silver") ? 4000 : 2000;
        return temp;
    }

    static void CetakSummary(HashMap<Integer, String> mapAyam, String namaAyam) {
        System.out.println("\nSummary Telur" + namaAyam);
        System.out.println("ID,NamaAyam,Kategori,Harga");
        for (int i = 1; i <= mapAyam.size(); i++){
            int temp = mapAyam.get(i).equals("gold") ? 6000 : mapAyam.get(i).equals("silver") ? 4000 : 2000; //untuk menampung harga telur sementara
            System.out.println(i + "," + namaAyam + "," + mapAyam.get(i) + "," + temp);
        }
    }

    static HashMap<Integer, String> InputAyam(String[] args, int pakanA, int pakanB) {
        HashMap<Integer, String> ayam = new HashMap<>();  //membuat variabel ayam yang bisa diinput berapapun ayam nya
        int foodA = 0, foodB = 0; //nilai sementara untuk menampung pakan yang dimakan
        int countSilver = 0; //nilai untuk menghitung jumlah telur silver
        for (int i = 1, key = 1; i <= Integer.parseInt(args[0]); i++) {
            ayam.put(key++, "biasa");
            foodA += Integer.parseInt(args[1]);
            foodB += Integer.parseInt(args[2]);
            while (foodA >= pakanA || foodB >= pakanB) {
                countSilver++;
                ayam.put(key++, "silver");
                if (countSilver >= 5) {
                    ayam.put(key++, "gold");
                    countSilver -= 5; 
                }
                if (foodA >= pakanA) {
                    foodA -= pakanA;
                } else if (foodB >= pakanB)
                    foodB -= pakanB;
            }
        }
        return ayam;
    }
}