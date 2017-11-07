package networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

public class ReceivingServer implements Runnable {

	public static final int PORT = 4200;

	private SharedGameState sharedGS;

	private ArrayList<String> commandQueue;

	public ReceivingServer(SharedGameState sgs) {
		sharedGS = sgs;
		commandQueue = new ArrayList<>();
	}

	public synchronized void sendCommand(String cmd) {
		System.out.println("send command executed");
		if (cmd.equals("start") || cmd.equals("stop") || cmd.equals("reset")) {
			commandQueue.add(cmd);
			System.out.println("command added to queue: " + cmd);
		}
	}

	public synchronized String getCommand() {
		String cmd = commandQueue.get(0);
		commandQueue.remove(0);
		return cmd;
	}

	@Override
	public void run() {
		DatagramSocket socket = null;
		boolean running = true;
		try {
			socket = new DatagramSocket(PORT);
		} catch (IOException e) {
			System.out.println("Could not start server at port " + PORT);
			running = false;
		}

		String str;
		byte[] receiveBuffer = new byte[53];
		DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

		while (running) {
			try {
				str = "";

				while (!str.equals("quit")) {
					try {
						socket.receive(receivePacket);
						str = new String(receivePacket.getData()).trim();
						if (str.contains("\n")) {
							str = str.substring(0, str.lastIndexOf("\n"));
						}

						// check if game state has been sent
						String[] split = str.split("/");
						if (split.length == 6) {
							try {
								sharedGS.update(Double.parseDouble(split[0]), Double.parseDouble(split[1]),
										Double.parseDouble(split[2]), Double.parseDouble(split[3]),
										Integer.parseInt(split[4]), Integer.parseInt(split[5]));
							} catch (NumberFormatException e) {
								// Ignore
							}
						}

						// check if there's a command in the queue to send
						if (!commandQueue.isEmpty()) {
							System.out.println("command ready to be sent");
							String cmd = getCommand() + "\r\n";
							System.out.println("command: " + cmd);
							socket.send(new DatagramPacket(cmd.getBytes(), cmd.getBytes().length,
									receivePacket.getAddress(), receivePacket.getPort()));
						}

						// print the received stuff
						System.out.println("length=" + receivePacket.getLength() + ", received: " + str);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (NullPointerException e) {
				System.out.println("An error occurred while communicating with client");
				System.out.println("Connection lost");
			}
		}

		// if it is null it could not been initialized, therefore no need to shut it
		// down
		if (socket != null) {
			socket.close();
		}
	}
}
