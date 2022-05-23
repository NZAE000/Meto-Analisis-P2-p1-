
public class PlayExtremeFighter {
	public static void main(String[] args) throws Exception{
		try {
			FightEngine m_engine;
			m_engine = new FightEngine();
			m_engine.run();
		}
		catch (Exception e) { e.printStackTrace(); }
	}
}
