import java.util.ArrayList;
import java.util.List;

class Evolve{
    String digimon;    // Untuk menyimpan nama digimon
    String level;      // Untuk menyimpan level digimon
    List<Evolve> node; // Untuk menyimpan nodes 

    Evolve(String digimon, String level) {
        this.digimon = digimon;
        this.level = level;
        this.node = new ArrayList<>();
    }
}

public class DigimonEvolution_1402022066 {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("============ Program DigivolutionTree ===========");
        System.out.println("=== Dibuat oleh: I Komang Abimanyu/1402022066 ==="); // I Komang Abimanyu/1402022066
        System.out.println("=================================================");
        //listdown tree of DigimonEvolution       
        Evolve root = new Evolve("Agumon", "Rookie");
        Evolve greymon = new Evolve("Greymon", "Champion");
        Evolve tyranomon = new Evolve("Tyranomon", "Champion");
        Evolve geogreymon = new Evolve("GeoGreymon", "Champion");
        Evolve meramon = new Evolve("Meramon", "Champion");
        Evolve metalGreymon = new Evolve("MetalGreymon", "Ultimate");
        Evolve triceramon = new Evolve("Triceramon", "Ultimate");
        Evolve riseGreymon = new Evolve("RiseGreymon", "Ultimate");
        Evolve warGreymon = new Evolve("WarGreymon", "Mega");
        Evolve victoryGreymon = new Evolve("VictoryGreymon", "Mega");
        Evolve shineGreymon = new Evolve("ShineGreymon", "Mega");
        //listdown tree structure root and nodes of DigimonEvolution   
        root.node.add(greymon);
        root.node.add(tyranomon);
        root.node.add(geogreymon);
        root.node.add(meramon);
        greymon.node.add(metalGreymon);
        greymon.node.add(triceramon);
        tyranomon.node.add(triceramon);
        geogreymon.node.add(riseGreymon);
        metalGreymon.node.add(warGreymon);
        metalGreymon.node.add(victoryGreymon);
        riseGreymon.node.add(victoryGreymon);
        riseGreymon.node.add(shineGreymon);
        List<List<String>> evolutionPath = new  ArrayList<>(); // list of list Untuk menyimpan path evolusi
        findEvolutionPath(root, args[0], evolutionPath, new ArrayList<>());
        System.out.println("\nDigivolution path Agumon jika ingin digivolve menjadi " + args[0] + ":");
        if (evolutionPath.size()!= 0) {
            for (List<String> path : evolutionPath)
                System.out.println(String.join(" -> ", path));
            System.out.println(args[0] + " adalah Digimon dengan level " + findLevel(root, args[0]));
        } else     
            System.out.println(args[0] + " tidak ada di pohon Digivolution!");
    }

    static void findEvolutionPath(Evolve treeOfEvolve, String target, List<List<String>> allPath, List<String> currentPath) {
        currentPath.add(treeOfEvolve.digimon);
        if (treeOfEvolve.digimon.equalsIgnoreCase(target)) {
            allPath.add(new ArrayList<>(currentPath));
        } else
            for (Evolve child : treeOfEvolve.node)
                findEvolutionPath(child, target, allPath, currentPath);
        currentPath.remove(currentPath.size() - 1);
    }

    static String findLevel(Evolve treeOfEvolve, String target) {
        if (treeOfEvolve.digimon.equalsIgnoreCase(target))
            return treeOfEvolve.level;
        for (Evolve child : treeOfEvolve.node) {
            String level = findLevel(child, target);
            if (level != null)
                return level;
        }
        return null;
    }
}