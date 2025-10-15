interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Desenez un cerc");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Desenez un pătrat");
    }
}

abstract class ShapeFactory {
    public abstract Shape createShape();
}

class CircleFactory extends ShapeFactory {
    public Shape createShape() {
        return new Circle();
    }
}

class SquareFactory extends ShapeFactory {
    public Shape createShape() {
        return new Square();
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();

        ShapeFactory squareFactory = new SquareFactory();
        Shape square = squareFactory.createShape();
        square.draw();
    }
}
