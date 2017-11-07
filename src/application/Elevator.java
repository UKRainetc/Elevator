package application;

import java.util.concurrent.TimeUnit;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class Elevator extends HBox {
	
	private int curentFloor;
	private int destinationFloor;
	private boolean isWey = false;
	private Label user;


	public Elevator(int curentFloor) {
		this.curentFloor = curentFloor;
		setId("elevator");
		setLayoutX(300.0);
		
	}
	
	
	public boolean isWey() {
		return isWey;
	}


	public void setWey(boolean isWey) {
		this.isWey = isWey;
	}


	public int getCurentFloor() {
		return curentFloor;
	}


	public void setCurentFloor(int curentFloor){
		this.curentFloor = curentFloor;
		switch (curentFloor) {
		case 1:
			setLayoutY(295.0);
			break;
		case 2:
			setLayoutY(246.0);
			break;
		case 3:
			setLayoutY(197.0);
			break;
		case 4:
			setLayoutY(148.0);
			break;
		case 5:
			setLayoutY(99.0);
			break;
		case 6:
			setLayoutY(50.0);
			break;
		case 7:
			setLayoutY(0.0);
			break;

		default:
			setLayoutY(345.0);
			break;
		}
	}
	
	public void startTask(int destinationFloor){
		this.destinationFloor=destinationFloor;
		Runnable task = new Runnable()
		{
			public void run()
			{
				runTask();
			}
		};


		Thread backgroundThread = new Thread(task);
		backgroundThread.setDaemon(true);
		backgroundThread.start();
	}
	
	public void runTask(){
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(!isWey){
			
			isWey=true;
			TranslateTransition move = new TranslateTransition();
			move.setNode(this);
			System.out.println(destinationFloor-curentFloor);
			switch (destinationFloor-curentFloor) {
			case 7:
				move.setDuration(Duration.millis(9000));
				move.setToY(-345);
				break;
			case 6:
				move.setDuration(Duration.millis(8000));
				move.setToY(-295);
				break;
			case 5:
				move.setDuration(Duration.millis(7000));
				move.setToY(-246);
				break;
			case 4:
				move.setDuration(Duration.millis(6000));
				move.setToY(-197);
				break;
			case 3:
				move.setDuration(Duration.millis(5000));
				move.setToY(-148);
				break;
			case 2:
				move.setDuration(Duration.millis(4500));
				move.setToY(-99);
				break;
			case 1:
				move.setDuration(Duration.millis(3000));
				move.setToY(-50);
				break;
			case -7:
				move.setDuration(Duration.millis(9000));
				move.setToY(345);
				break;
			case -6:
				move.setDuration(Duration.millis(8000));
				move.setToY(295);
				break;
			case -5:
				move.setDuration(Duration.millis(7000));
				move.setToY(246);
				break;
			case -4:
				move.setDuration(Duration.millis(6000));
				move.setToY(197);
				break;
			case -3:
				move.setDuration(Duration.millis(5000));
				move.setToY(148);
				break;
			case -2:
				move.setDuration(Duration.millis(4500));
				move.setToY(99);
				break;
			case -1:
				move.setDuration(Duration.millis(3000));
				move.setToY(50);
				break;

			default:
				move.setToY(0);
				break;
			}
			move.setToX(0);
			move.setCycleCount(1);
			move.play();
			move.setOnFinished((e)->{
			curentFloor=destinationFloor;
			isWey=false;
			System.out.println("move.setOnFinished isWey: "+isWey);
			});

		}
	
	}
}
		
