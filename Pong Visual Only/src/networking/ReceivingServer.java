package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceivingServer implements Runnable {

	public static final int PORT = 420;

	private SharedGameState sharedGS;

	public ReceivingServer(SharedGameState sgs) {
		sharedGS = sgs;
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

		while (running) {
			try {
				soc = ss.accept();

				str = "";
				in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

				while (!str.equals("quit")) {
					try {
						str = in.readLine();
						String[] split = str.split("/");
						if (split.length == 6) {
							sharedGS.update(Double.parseDouble(split[0]), Double.parseDouble(split[1]),
									Double.parseDouble(split[2]), Double.parseDouble(split[3]),
									Integer.parseInt(split[4]), Integer.parseInt(split[5]));
						}

						if (str.equals("shutdown")) {
							running = false;
						}

						System.out.println(str);
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
