package version1;

import java.util.Scanner;

public class ClientPlayer extends Player {

	@Override
	public void initializeBoard() {
		System.out.println("Player "+this.name+" enter boat coordinates\n");
		for(int i=0;i<5;i++) {
			//get Boat coordinates
			System.out.println("Boat "+i);
			Scanner in=new Scanner(System.in);
			String pointString=in.nextLine();
			try {
				ships[i]=addAShip(pointString, i);
			} catch (CoordinateOutOfBonds | UnavailableShipException e) {
//				e.printStackTrace();
				System.out.println("try once more: "+e.getMessage());
				i--;
				continue;
			}
			
			System.out.println("Boat coord: "+ships[i]);
		}
	}
	
	public ClientPlayer(String name) {
		this.name=name;
		ships=new Ship[5]; 
	}
	public void addHitOnPlayer(Coordinate c) {
		for(int i=0;i<ships.length;i++) {
			if(ships[i].contains(c)==true) {
				ships[i].addHit(c);
				break;
			}
		}
	}
	
	@Override
	public Coordinate makeMove(){
		System.out.println("Player "+this.name+" make a move: ");
		Scanner in=new Scanner(System.in);
		Coordinate coord;
		try {
			coord = new Coordinate(in.nextLine());
			return coord;
		} catch (CoordinateOutOfBonds e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
