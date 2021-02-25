package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start
		
		// create a client object and use it to

		// - connect to the broker
		// - publish the temperature(s)
		// - disconnect from the broker
		Client client = new Client("Sensor", Common.BROKERHOST, Common.BROKERPORT);
		client.connect();
		for(int x = 0; x < COUNT; x++) {
			int output = sn.read();
			client.publish(Common.TEMPTOPIC, Integer.toString(output));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		// TODO - end

		System.out.println("Temperature device stopping ... ");


	}
}
