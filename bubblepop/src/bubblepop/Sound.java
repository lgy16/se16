package bubblepop;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

class Sound {
	//private String filename = "sound/Coin.wav";
	
	public Sound()
	{
		
	}

	public void startSound(String filename,int countNum){
		try	{
			java.net.URL url = getClass().getResource(filename);
			File file = new File(url.getPath());
			final Clip clip = AudioSystem.getClip();			
			clip.addLineListener(new LineListener()			{
				@Override
				public void update(LineEvent event)
				{
					//CLOSE, OPEN, START, STOP
					if(event.getType() == LineEvent.Type.STOP)
						clip.close();
				}
			});
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.start();
			clip.loop(countNum);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void stop_Main_Sound(){
		//clip.stop();
		//clip.close();

	}
}