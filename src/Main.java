public class Main {
    public static void main(String[] args) {
        MyStringBuilder sb = new MyStringBuilder();

        sb.append("Hello");
        sb.append(" World");
        System.out.println(sb);

        sb.delete(5, 11);
        System.out.println(sb);

        sb.undo();
        System.out.println(sb);

        sb.undo();
        System.out.println(sb);
    }
}