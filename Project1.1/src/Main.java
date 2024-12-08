import java.io.File;
import java.util.Scanner;

public class Main {
    static String returnType(File chemin){
        String type = "";
        if(chemin.canRead()){
            type = "r";
        }
        if (chemin.canWrite()){
            type += "w";
        }
        if (chemin.isHidden()){
            type += "h";
        }
        return type+"-";
    }
    static void traiterChemin(File chemin){
        if(chemin.isFile()){
            System.out.println(chemin.getAbsolutePath()+" <FICH> "+returnType(chemin));
        }
        else{
            System.out.println(chemin.getAbsolutePath()+" <DIR> "+returnType(chemin));
            File[] chemins = chemin.listFiles();
            for(File ch : chemins){
                traiterChemin(ch);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Preciser le lien de la repertoire");
        String s = sc.nextLine();
        File file = new File(s);
        if (file.exists()){
            traiterChemin(file);
        }
    }
}