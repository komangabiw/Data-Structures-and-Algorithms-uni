import java.util.*;
public class TeHaEr_1402022066 {
    public static void main(String[] args) {
        if (args.length == 2) {
            String[] listUang = args[0].split(","); //untuk menampung nilai sementara dari argumen lalu dipindah ke stack tumpukan uang
            String[] listNama = args[1].split(","); //untuk menampung nilai sementara dari argumen lalu dipindah ke queue antrian penerima
            Stack<Integer> tumpukanUang = new Stack<>();        //untuk memenuhi kebutuhan soal LIFO (last-in-first-out)
            Queue<String> antrianPenerima = new LinkedList<>(); //untuk memenuhi kebutuhan soal FIFO (first-in-first-out)
            for (String string : listUang)
                tumpukanUang.push(Integer.parseInt(string));
            for (String string : listNama)
                antrianPenerima.add(string);

            if (cekTumpukanUang(tumpukanUang)) {
                System.out.println("===================================================");
                System.out.println("==================PROGRAM TeHaEr===================");
                System.out.println("=====Dibuat oleh: I Komang Abimanyu/1402022066====="); // I Komang Abimanyu/1402022066
                System.out.println("===================================================");
                System.out.println("\nTumpukkan uang Pak John: " + tumpukanUang);
                System.out.println("Antrian penerima THR dari Pak John: " + antrianPenerima + "\n");
                while (!antrianPenerima.isEmpty() && !tumpukanUang.isEmpty()) {
                    int temp2 = tumpukanUang.pop();//untuk menarik dan menyimpan nilai uang sementara, untuk antisipasi jumlah data genap pada uang
                    if (cekNamaUnix(antrianPenerima.element()) && !tumpukanUang.isEmpty()) {
                        System.out.println("Selamat! Karena nama " + antrianPenerima.element() + " unik, dia mendapatkan THR lebih sebesar IDR " + temp2 + " dari Pak John");
                        System.out.println(antrianPenerima.poll() + " mendapatkan uang THR sebesar IDR " + (temp2 + tumpukanUang.pop()) + " dari Pak John");
                    } else 
                        System.out.println(antrianPenerima.poll() + " mendapatkan uang THR sebesar IDR " + temp2 + " dari Pak John");
                }
                System.out.println("\nSisa tumpukkan uang Pak John " + tumpukanUang);
                System.out.println("Sisa Antrian penerima THR " + antrianPenerima);
            } else
                System.out.println("Input tumpukkan uang tidak valid!\nProgram akan diberhentikan.");
        } else
            System.out.println("Input argumen tidak boleh kurang atau lebih dari 2");
    }

    static boolean cekTumpukanUang(Stack<Integer> uang) {
        int count = 0; //untuk menghitung jumlah uang yang valid
        for (int i = 0; i < uang.size(); i++) 
            if ((uang.get(i) == 20000) || (uang.get(i) == 50000) || (uang.get(i) == 100000))
                count++;        
        return count == uang.size();
    }
    static boolean cekNamaUnix(String nama) {
        int count = 0; //untuk menghitung ada berapa karakter vokal
        nama = nama.toLowerCase();
        for (int i = 0; i < nama.length(); i++)
            if (nama.charAt(i) == 'a' || nama.charAt(i) == 'e' || nama.charAt(i) == 'i' || nama.charAt(i) == 'o' || nama.charAt(i) == 'u')
                count++;
        return count > 2;
    }
}