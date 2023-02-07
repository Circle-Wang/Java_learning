package Chapter6.Object_;

public class HashCodeExercise {
    public static void main(String[] args) {
        AA aa = new AA();
        AA aa2 = new AA();
        System.out.println("aa的hashCode是: " + aa.hashCode());
        System.out.println("aa2的hashCode是: " + aa2.hashCode());

        AA aa3 = aa;
        System.out.println("aa3的hashCode是: " + aa3.hashCode()); // 与aa的hashcode相同
    }
}

class AA {

}