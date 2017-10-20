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
		try {
			ServerSocket ss = new ServerSocket(PORT);
			Socket soc;
			String str;
			BufferedReader in;

			while (true) {
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
						System.out.println(str);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				soc.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
