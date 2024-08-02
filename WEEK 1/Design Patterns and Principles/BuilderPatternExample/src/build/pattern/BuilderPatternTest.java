package build.pattern;

public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();

        System.out.println("Basic Computer: " + basicComputer);

        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setMotherboard("Asus ROG Maximus XIII")
                .setPowerSupply("750W")
                .setCaseType("Gaming Case")
                .build();

        System.out.println("Gaming Computer: " + gamingComputer);

        Computer workstationComputer = new Computer.Builder()
                .setCPU("AMD Ryzen 9")
                .setRAM("64GB")
                .setStorage("2TB SSD")
                .setGPU("NVIDIA Quadro RTX 5000")
                .setMotherboard("MSI Creator TRX40")
                .setPowerSupply("1000W")
                .setCaseType("Workstation Case")
                .build();

        System.out.println("Workstation Computer: " + workstationComputer);
    }
}
