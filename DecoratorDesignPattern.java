package programming;

interface Shape {
	public void draw();
}

class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Rectangle Shape Draw");
		
	}
	
}

class Triangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Triangle Shape Draw");
		
	}
	
}


abstract class ShapeDecorator implements Shape{
	protected Shape decoratedShape;
	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}
	public void draw() {
		decoratedShape.draw();
	}
}

class RedColorShapeDecorator extends ShapeDecorator{

	public RedColorShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}
	@Override
	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
		
	}
	private void setRedBorder(Shape shapeDecorated) {
		System.out.println("Red color border added...");
	}
	
}

public class DecoratorDesignPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape triangle = new Triangle();
		Shape redTriangle = new RedColorShapeDecorator(triangle);
		redTriangle.draw();

	}

}
