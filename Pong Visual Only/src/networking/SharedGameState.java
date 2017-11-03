package networking;

import org.newdawn.slick.SlickException;

import game.math.NotInRangeException;
import game.objects.Ball;
import game.objects.Paddle;
import game.objects.Score;

public class SharedGameState {
	private Paddle paddleL, paddleR;
	private Ball ball;
	private Score scoreL, scoreR;

	public SharedGameState() throws SlickException {
		try {
			paddleL = new Paddle(Paddle.LEFT);
			paddleR = new Paddle(Paddle.RIGHT);
			ball = new Ball();
			scoreL = new Score(Score.LEFT);
			scoreR = new Score(Score.RIGHT);
		} catch (NotInRangeException e) {
			// will never happen...
			e.printStackTrace();
		}
	}

	public void update(double lPaddlePos, double rPaddlePos, double ballPosX, double ballPosY, int lScore, int rScore) {
		paddleL.setPosition(lPaddlePos);
		paddleR.setPosition(rPaddlePos);
		ball.setPosition(ballPosX, ballPosY);
		scoreL.setScore(lScore);
		scoreR.setScore(rScore);
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
	
	public Score getLeftScore() {
		return scoreL;
	}
	
	public Score getRightScore() {
		return scoreR;
	}
}
