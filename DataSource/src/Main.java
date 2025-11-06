public class Main {
    public static void main(String[] args) {

        DataSource ds =
                new CompressDecorator(
                        new EncryptionDecorator(
                                new StorageDataSource()
                        )
                );

        ds.Write("Testare Decorator");
        System.out.println("Citire rezultat: " + ds.Read());
    }
}
