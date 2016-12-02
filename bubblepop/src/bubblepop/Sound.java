package bubblepop;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class Sound {
	File sound_Click;
	AudioInputStream audioInputStream;
	Clip clip;
	
	public Sound(){
		sound_Click = new File("bin/sound/Coin.wav");
	}
	
	public void ClickSound(){
		try {
			audioInputStream = AudioSystem.getAudioInputStream(sound_Click.getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (LineUnavailableException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();
		System.out.print("클릭 소리 출력");
	}
}