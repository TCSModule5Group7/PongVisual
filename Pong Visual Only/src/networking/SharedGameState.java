package networking;

import org.newdawn.slick.SlickException;

import game.math.NotInRangeException;
import game.objects.Ball;
import game.objects.Paddle;

public class SharedGameState {
	private Paddle paddleL, paddleR;
	private Ball ball;
	private int scoreL, scoreR;

	public SharedGameState() throws SlickException {
		try {
			paddleL = new Paddle(Paddle.LEFT);
			paddleR = new Paddle(Paddle.RIGHT);
			ball = new Ball();
		} catch (NotInRangeException e) {
			// will never happen...
			e.printStackTrace();
		}
	}

	public void update(double lPaddlePos, double rPaddlePos, double ballPosX, double ballPosY, int lScore, int rScore) {
		paddleL.setPosition(lPaddlePos);
		paddleR.setPosition(rPaddlePos);
		ball.setPosition(ballPosX, ballPosY);
		scoreL = lScore;
		scoreR = rScore;
	}
	
	public Paddle getLeftPaddle() {
		return paddleL;
	}
	
	public Paddle getRightPaddle() {
		return paddleR;
	}
	
	public Ball getBall() {
		return ball;
	}
	
	public int getLeftScore() {
		return scoreL;
	}
	
	public int getRightScore() {
		return scoreR;
	}
}
