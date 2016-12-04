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
	java.net.URL /*url,*/ bgmURL, moveSoundURL, cantMoveSoundURL, selectButtonSoundURL, clickItemSoundURL, explodeSoundURL;
	File /*file,*/ bgmFile, moveSoundFile, cantMoveSoundFile, selectButtonSoundFile, clickItemSoundFile, explodeSoundFile;
	Clip /*clip,*/ bgmClip, moveSoundClip, cantMoveSoundClip, selectuButtonClip, clickItemSoundClip, explodeSoundClip;

	public Sound(){
		bgmURL = getClass().getResource("sound/Smario.wav");
		bgmFile = new File(bgmURL.getPath());
		moveSoundURL = getClass().getResource("sound/Up.wav");
		moveSoundFile = new File(moveSoundURL.getPath());
		cantMoveSoundURL = getClass().getResource("sound/Stun.wav");
		cantMoveSoundFile = new File(cantMoveSoundURL.getPath());
		selectButtonSoundURL = getClass().getResource("sound/Coin.wav");
		selectButtonSoundFile = new File(selectButtonSoundURL.getPath());
		clickItemSoundURL = getClass().getResource("sound/Click_Item.wav");
		clickItemSoundFile = new File(clickItemSoundURL.getPath());
		explodeSoundURL = getClass().getResource("sound/explode(short).wav");
		explodeSoundFile = new File(explodeSoundURL.getPath());
		
		
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
			clickItemSoundClip = AudioSystem.getClip();
			clickItemSoundClip.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event) {
					//CLOSE, OPEN, START, STOP
					if(event.getType() == LineEvent.Type.STOP)
						clickItemSoundClip.close();
				}
			});
			explodeSoundClip = AudioSystem.getClip();
			explodeSoundClip.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event) {
					//CLOSE, OPEN, START, STOP
					if(event.getType() == LineEvent.Type.STOP)
						explodeSoundClip.close();
				}
			});
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void startSound(String call){
		try{
			switch(call){
			case "bgm":
				bgmClip.open(AudioSystem.getAudioInputStream(bgmFile));
				bgmClip.start();
				bgmClip.loop(99);
				break;
			case "move":
				moveSoundClip.open(AudioSystem.getAudioInputStream(moveSoundFile));
				moveSoundClip.start();
				break;
			case "click_error":
				cantMoveSoundClip.open(AudioSystem.getAudioInputStream(cantMoveSoundFile));
				cantMoveSoundClip.start();
				break;
			case "select":
				selectuButtonClip.open(AudioSystem.getAudioInputStream(selectButtonSoundFile));
				selectuButtonClip.start();
				break;
			case "clickItem":
				clickItemSoundClip.open(AudioSystem.getAudioInputStream(clickItemSoundFile));
				clickItemSoundClip.start();
				break;
			case "explode":
				explodeSoundClip.open(AudioSystem.getAudioInputStream(explodeSoundFile));
				explodeSoundClip.start();
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
		
		clickItemSoundClip.stop();
		clickItemSoundClip.close();
		
		explodeSoundClip.stop();
		explodeSoundClip.close();
	}
}