package driver;

import Adapter.*;
import model.*;
import util.*;

public class driver {
	public static void main(String [] args) {
		String file = "/Users/StevenH/Desktop/Coding/deAnza/kbb1/src/rowData.txt";
		BuildAuto FordZTW = new BuildAuto();
		FordZTW.BuildAuto(file);
		FordZTW.printAuto(null);
		FordZTW.updateOptionSetName("Ford Wagon ZTW", "Car1", "Ford Sedan");
		FordZTW.updateOptionPrice("Ford Wagon ZTW", "Transmission", null, -815);

		//		Automobile FordZTW = new Automobile;
//		FordZTW.print();
//		util.FileIO.Serialize(FordZTW);;
//		Automobile newFordZTW = util.FileIO.Deserialize("Ford.dat");
//		newFordZTW.print();
	}
}
