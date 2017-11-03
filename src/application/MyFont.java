package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.text.Font;

public class MyFont {
	private Font fontAwesome;
	
	public MyFont() {
		File i = new File("C:/Users/Администратор/workspace/Elevator/src/main/resources/fontawesome-webfont.ttf");
		FileInputStream font = null;
		try {
			font = new FileInputStream(i);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Font fontAwesome = Font.loadFont(font, 16);
	}
	
	public Font getfontAwesome(){
		return fontAwesome;
		
	}

}
