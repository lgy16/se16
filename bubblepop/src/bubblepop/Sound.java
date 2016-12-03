package bubblepop;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class Sound {
	java.net.URL /*url,*/ bgmURL, moveSoundURL, cantMoveSoundURL, selectButtonSoundURL;
	File /*file,*/ bgmFile, moveSoundFile, cantMoveSoundFile, selectButtonSoundFile;
	Clip /*clip,*/ bgmClip, moveSoundClip, cantMoveSoundClip, selectuButtonClip;

	public Sound(){
		bgmURL = getClass().getResource("sound/Smario.wav");
		bgmFile = new File(bgmURL.getPath());
		moveSoundURL = getClass().getResource("sound/Up.wav");
		moveSoundFile = new File(moveSoundURL.getPath());
		cantMoveSoundURL = getClass().getResource("sound/Stun.wav");
		cantMoveSoundFile = new File(cantMoveSoundURL.getPath());
		selectButtonSoundURL = getClass().getResource("sound/Coin.wav");
		selectButtonSoundFile = new File(selectButtonSoundURL.getPath());
		
		try {
			bgmClip = AudioSystem.getClip();
			bgmClip.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event)
				{
					//CLOSE, OPEN, START, STOP
					if(event.getType() == LineEvent.Type.STOP)
						bgmClip.close();
				}
			});
			moveSoundClip = AudioSystem.getClip();
			moveSoundClip.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event) {
					//CLOSE, OPEN, START, STOP
					if(event.getType() == LineEvent.Type.STOP)
						moveSoundClip.close();
				}
			});
			cantMoveSoundClip = AudioSystem.getClip();
			cantMoveSoundClip.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event) {
					//CLOSE, OPEN, START, STOP
					if(event.getType() == LineEvent.Type.STOP)
						cantMoveSoundClip.close();
				}
			});
			selectuButtonClip = AudioSystem.getClip();
			selectuButtonClip.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event) {
					//CLOSE, OPEN, START, STOP
					if(event.getType() == LineEvent.Type.STOP)
						selectuButtonClip.close();
				}
			});
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void startSound(String call,int countNum){
		try{
			switch(call){
			case "bgm":
				bgmClip.open(AudioSystem.getAudioInputStream(bgmFile));
				bgmClip.start();
				bgmClip.loop(countNum);
				break;
			case "move":
				moveSoundClip.open(AudioSystem.getAudioInputStream(moveSoundFile));
				moveSoundClip.start();
				moveSoundClip.loop(countNum);
				break;
			case "click_error":
				cantMoveSoundClip.open(AudioSystem.getAudioInputStream(cantMoveSoundFile));
				cantMoveSoundClip.start();
				cantMoveSoundClip.loop(countNum);
				break;
			case "select":
				selectuButtonClip.open(AudioSystem.getAudioInputStream(selectButtonSoundFile));
				selectuButtonClip.start();
				selectuButtonClip.loop(countNum);
				break;
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void Close_All_Sound(){
		bgmClip.stop();
		bgmClip.close();
		
		moveSoundClip.stop();
		moveSoundClip.close();
		
		cantMoveSoundClip.stop();
		cantMoveSoundClip.close();
		
		selectuButtonClip.stop();
		selectuButtonClip.close();
	}
}