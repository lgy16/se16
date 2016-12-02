package bubblepop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

class ShowRanking{
	String[][] rinfo = new String[30][4];
	public ShowRanking(String level) {
		try{		
			URL url = new URL("http://www.bublepop.esy.es/Show_Ranking/showRanking.php");
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setDefaultUseCaches(false);
            http.setDoInput(true);
            http.setDoOutput(true);
            http.setRequestMethod("POST");

            http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            StringBuffer buffer = new StringBuffer();
            buffer.append("?&level="+level);
            
            OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
            BufferedReader reader = new BufferedReader(tmp);
            StringBuilder builder = new StringBuilder();
            String str;
            while ((str = reader.readLine()) != null) {
                builder.append(str);
            }
            rinfo = Parsing(level, builder.toString(), "/");
            http.disconnect();
		}
		catch(Exception e){
			System.out.print("Fail : " + e + "\n");
		}
		finally {
			System.out.print("Finish\n");
		}
	}
	
	String[][] Parsing(String level, String text, String token){
		String [][] rankinginfo = new String[30][4];
		int i = 0;
		StringTokenizer str = new StringTokenizer(text, token);
		System.out.println("State : " + str.nextToken());
		System.out.println("----------------------------");
		while(str.hasMoreTokens()){
			rankinginfo[i][0]= String.valueOf(i+1);
			for(int j=1; j<4; j++){
				rankinginfo[i][j]= str.nextToken();
			}
			i++;
			//System.out.println("Name : " + str.nextToken());
			//System.out.println("Tiem : " + str.nextToken());
			//System.out.println("Score : " + str.nextToken());
			//System.out.println("----------------------------");
		}
		return rankinginfo;
	}	
	
	String[][] getRankingInfo(){
		return rinfo;
	}
}