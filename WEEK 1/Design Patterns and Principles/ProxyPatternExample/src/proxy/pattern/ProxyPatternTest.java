package proxy.pattern;

public class ProxyPatternTest {
	 public static void main(String[] args) {
	        Image image1 = new ProxyImage("test_image_1.jpg");
	        Image image2 = new ProxyImage("test_image_2.jpg");

	        image1.display();
	        System.out.println();

	        image1.display();
	        System.out.println();

	        image2.display();
	        System.out.println();

	        image2.display();
	 }
}
