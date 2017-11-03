package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ReceivingServer implements Runnable {

	public static final int PORT = 420;

	private SharedGameState sharedGS;
	
	private ArrayList<String> commandQueue;

	public ReceivingServer(SharedGameState sgs) {
		sharedGS = sgs;
		commandQueue = new ArrayList<>();
	}
	
	public synchronized void sendCommand(String cmd) {
		if (cmd.equals("start") || cmd.equals("stop") || cmd.equals("reset")) {
		    commandQueue.add(cmd);
		}
	}
	
	public synchronized String getCommand() {
		String cmd = commandQueue.get(0);
		commandQueue.remove(0);
		return cmd;
	}

	@Override
	public void run() {
		ServerSocket ss = null;
		boolean running = true;
		try {
			ss = new ServerSocket(PORT);
		} catch (IOException e) {
			System.out.println("Could not start server at port " + PORT);
			running = false;
		}
		Socket soc;
		String str;
		BufferedReader in;
		PrintWriter out;

		while (running) {
			try {
				soc = ss.accept();

				str = "";
				in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				out = new PrintWriter(soc.getOutputStream());

				while (!str.equals("quit")) {
					try {
						str = in.readLine();
						
						// check if game state has been sent
						String[] split = str.split("/");
						if (split.length == 6) {
							sharedGS.update(Double.parseDouble(split[0]), Double.parseDouble(split[1]),
									Double.parseDouble(split[2]), Double.parseDouble(split[3]),
									Integer.parseInt(split[4]), Integer.parseInt(split[5]));
						}

						// check if there's a command in the queue to send
						if (!commandQueue.isEmpty()) {
							out.println(getCommand());
						}

						// print the received stuff
						System.out.println("received: " + str);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				soc.close();
			} catch (NullPointerException | IOException e) {
				System.out.println("An error occurred while communicating with client");
				System.out.println("Connection lost");
			}
		}

		// if it is null it could not been initialized, therefore no need to shut it down
		if (ss != null) {
			try {
				ss.close();
			} catch (IOException e) {
				System.out.println("An error occurred while trying to shutdown the server");
			}
		}
	}
}
