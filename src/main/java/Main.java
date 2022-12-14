
public class Main {
    public static void main(String[] args) {
        Person mom = new Person.PersonBuilder().setName("Anna")
                .setSurName("Volf")
                .setAge(31)
                .setAddress("Sidnei")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Antoshca").build();
        System.out.printf("У %s есть сын, %s ", mom, son);

        try{
            new Person.PersonBuilder().build();
        }catch(IllegalStateException e) {
            e.printStackTrace();
        }

        try{
            new Person.PersonBuilder().setAge(-100).build();
        }catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
