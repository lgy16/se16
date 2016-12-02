package bubblepop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import sun.audio.*;

public class Sound {
	File fio;
	public Sound(String dir){
		fio = new File(dir);
		this.start();
	}
	public void start(){
		try{
		    //File wf = new File("c:/Coin.wav");
			FileInputStream fis = new FileInputStream(fio);
			AudioStream as = new AudioStream(fis);
			AudioPlayer.player.start(as);
			System.out.print("소리 출력");
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.println("파일 찾기 실패");
		}catch(IOException e){
			System.out.println("오디오스트림에서 실패");
			e.printStackTrace();
		}
	}
}