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
			System.out.print("�Ҹ� ���");
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.println("���� ã�� ����");
		}catch(IOException e){
			System.out.println("�������Ʈ������ ����");
			e.printStackTrace();
		}
	}
}