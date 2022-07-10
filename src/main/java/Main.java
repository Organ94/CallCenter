public class Main {

    private static final int NUMBER_OF_SPECIALIST = 3;

    public static void main(String[] args) {

        new Thread(null, CallCenter::atc, "Новое обращение").start();

        for (int i = 0; i < NUMBER_OF_SPECIALIST; i++) {
            new Thread(null, CallCenter::callOperator, "Оператор").start();
        }
    }
}
