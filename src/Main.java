public class Main {
    public static void main(String[] args) {
        FamilyTree tree = mainTree();
        System.out.println(tree);


        save(tree);
    }


    private static FamilyTree read(){

        FileHandler fileHandler = new FileHandler();
        String filePath ="src/tr.txt";
        return (FamilyTree) fileHandler.read(filePath);
    }

    private static void save(FamilyTree tree){
        FileHandler fileHandler = new FileHandler();
        String filePath ="src/tr.txt";
        fileHandler.save(tree,filePath);
    }




    static FamilyTree mainTree(){
        FamilyTree tree = new FamilyTree();
        int i=0;
        Human vasya = new Human();

        Human masha = new Human();


        tree.add(vasya);
        tree.add(masha);


        tree.setWedding(vasya, masha);

        Human lena = new Human();

        Human ivan = new Human();

        tree.add (lena);
        tree.add (ivan);

        Human Inna = new Human();
        Inna.addChild(vasya);
        tree.add(Inna);


        return tree;
    }
}
