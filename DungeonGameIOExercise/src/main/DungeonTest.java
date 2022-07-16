package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DungeonTest {

	public static void main(String[] args) {
		DungeonGame d = new DungeonGame();
		System.out.println(d.getX()+d.getY()+d.getZ());
		try {
			FileOutputStream fos = new FileOutputStream("dg.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(d);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream("dg.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			d = (DungeonGame) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(d.getX()+d.getY()+d.getZ());
	}

}
class DungeonGame implements Serializable {

	public int x = 3;
	transient long y = 4;
	private short z = 5;
	
	int getX() {
		return x;
	}
	
	short getZ() {
		return z;
	}
	
	long getY() {
		return y;
	}
		
}