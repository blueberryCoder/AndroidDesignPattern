
public class CameraImpl implements Camera{

	@Override
	public void takePicture() {
		System.out.println("Camera take picture.");
	}

	@Override
	public void close() {
		System.out.println("Camera close .");
	}

	@Override
	public void open() {
		System.out.println("Camera open.");
	}

}
